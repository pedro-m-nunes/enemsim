package br.ifsul.enemsim.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifsul.enemsim.entidades.Habilidade;
import br.ifsul.enemsim.entidades.Item;
import br.ifsul.enemsim.entidades.Simulado;
import br.ifsul.enemsim.entidades.auxiliar.Resposta;
import br.ifsul.enemsim.entidades.relacionais.EstudanteHabilidade;
import br.ifsul.enemsim.entidades.relacionais.SimuladoItem;
import br.ifsul.enemsim.entidades.relacionais.auxiliar.EstudanteHabilidadeId;
import br.ifsul.enemsim.entidades.relacionais.auxiliar.SimuladoItemId;
import br.ifsul.enemsim.entidades.usuarios.Estudante;
import br.ifsul.enemsim.exceptions.DadosInsuficientesException;
import br.ifsul.enemsim.exceptions.RespostaAoSimuladoException;
import br.ifsul.enemsim.gerador.GerSim;
import br.ifsul.enemsim.repositories.ItemRepository;
import br.ifsul.enemsim.repositories.SimuladoRepository;
import br.ifsul.enemsim.repositories.relacionais.EstudanteHabilidadeRepository;
import br.ifsul.enemsim.repositories.relacionais.SimuladoItemRepository;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/simulado")
@CrossOrigin(origins = "*")
public class SimuladoController {

	@Autowired
	private SimuladoRepository simuladoRepository;
	
	@Autowired
	private SimuladoItemRepository simuladoItemRepository;
	
	@GetMapping
	public List<Simulado> findAll() {
		return simuladoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Simulado findById(@PathVariable Integer id) {
		return simuladoRepository.findById(id).get();
	}
	
	@GetMapping("/{id}/itens")
	public List<Item> getItensDoSimulado(@PathVariable Integer id) {
		return simuladoRepository.getItens(id);
	}
	
	@GetMapping("/estudante/{estudanteId}")
	public List<Simulado> findByEstudanteId(@PathVariable Integer estudanteId) {
		return simuladoRepository.findByEstudanteId(estudanteId);
	}
	
	// save, saveAll?
	
	// gerarSimulado (?)
	
	@Autowired
	private GerSim gerSim;

	// gerarSimuladoDeNivelamento
	@GetMapping("/gerar/nivelamento/estudante={estudanteId}") // ""? // Get?
	public Object gerarSimuladoDeNivelamento(@PathVariable Integer estudanteId) { // Object? SimuladoGerado?
		try {
			return gerSim.gerarSimuladoDeNivelamento(new Estudante(estudanteId)).save(simuladoRepository, simuladoItemRepository);
		} catch (DadosInsuficientesException e) {
			return e.getMessage();
		}
	}

	// gerarSimuladoAdaptado
	
	// salvarResposta (só alterar o simulado se ele não tiver sido entregue!) // Post?
	// entregarSimulado -> salvar respostas, marcar como finalizado, contabilizar acertos e erros // Post?
	
	@Deprecated
	@Transactional
	@GetMapping("/{simuladoId}/responder/{itemId}={resposta}") // ""?
	public int salvarResposta(@PathVariable Integer simuladoId, @PathVariable Integer itemId, @PathVariable Resposta resposta) { // temp?
		return simuladoItemRepository.salvarResposta(new SimuladoItemId(simuladoId, itemId), resposta);
	}
	
	@Autowired
	private EstudanteHabilidadeRepository estudanteHabilidadeRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	// testar tudo isso aqui...
	@Transactional
	@PostMapping("/finalizar") // Post // ""?
	public int finalizarSimulado(@RequestBody List<SimuladoItem> itensRespondidos) throws RespostaAoSimuladoException { // void?
		Simulado simulado = simuladoRepository.findById(itensRespondidos.get(0).getId().getSimuladoId()).get(); // ?
		
		// if simulado == null ...?
		
		if(simulado.getFinalizado()) // simuladoRepository.finalizado(id) ??
			throw new RespostaAoSimuladoException("O simulado informado (id = " + simulado.getId() + ") já foi entregue e não aceita mais respostas.");
		
		// salvar respostas aos itens
		for(SimuladoItem simuladoItem : itensRespondidos) {
			if(!simuladoRepository.simuladoPossuiItem(simulado, simuladoItem.getId().getItemId()))
				throw new RespostaAoSimuladoException("O item informado (id = " + simuladoItem.getId().getItemId() + ") não aparece no simulado.");
			
			simuladoItemRepository.salvarResposta(simuladoItem.getId(), simuladoItem.getResposta());
		}
		
		// marcar como finalizado
		simuladoRepository.setFinalizado(simulado.getId());
		
		// contabilizar acertos e erros
		for(SimuladoItem simuladoItem : itensRespondidos) {
			Item item = itemRepository.findById(simuladoItem.getId().getItemId()).get();
			
			// estudanteHabilidade.adicionarTentativa(simulado.estudante, item.habilidade)
			EstudanteHabilidadeId estudanteHabilidadeId = new EstudanteHabilidadeId(simulado.getEstudante().getId(), item.getHabilidade().getId());
			
			if(!estudanteHabilidadeRepository.existsById(estudanteHabilidadeId))
				estudanteHabilidadeRepository.save(new EstudanteHabilidade(new Estudante(estudanteHabilidadeId.getEstudanteId()), new Habilidade(estudanteHabilidadeId.getHabilidadeId())));
			
			estudanteHabilidadeRepository.adicionarTentativa(estudanteHabilidadeId);
			
			if(simuladoItem.getResposta() == item.getRespostaCerta()) // método próprio?
				estudanteHabilidadeRepository.adicionarTentativaCerta(estudanteHabilidadeId);
		}
		
		return 1; // ?
	}
	
//	@GetMapping("/s={sId}/i={iId}")
//	public Object teste(@PathVariable int sId, @PathVariable int iId) { // temp
//		return simuladoRepository.simuladoPossuiItem(simuladoRepository.findById(sId).get(), itemRepository.findById(iId).get());
//	}
	
	// delete, deleteAll
//	@DeleteMapping("/delete/{id}/{confirmation}")
//	public boolean deleteById(@PathVariable Integer id, @PathVariable String confirmation) { // ?
//		if(confirmation.equals("aham"))
//			simuladoRepository.deleteById(id);
//		return true;
//	}
	
}
