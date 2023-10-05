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
import br.ifsul.enemsim.entidades.relacionais.EstudanteHabilidade;
import br.ifsul.enemsim.entidades.relacionais.SimuladoItem;
import br.ifsul.enemsim.entidades.relacionais.auxiliar.EstudanteHabilidadeId;
import br.ifsul.enemsim.entidades.usuarios.Estudante;
import br.ifsul.enemsim.exceptions.DadosInsuficientesException;
import br.ifsul.enemsim.exceptions.RespostaAoSimuladoException;
import br.ifsul.enemsim.gerador.GerSim;
import br.ifsul.enemsim.gerador.SimuladoGerado;
import br.ifsul.enemsim.repositories.relacionais.EstudanteHabilidadeRepository;
import br.ifsul.enemsim.services.entidades.ItemReadService;
import br.ifsul.enemsim.services.entidades.SimuladoCreateAndUpdateService;
import br.ifsul.enemsim.services.entidades.SimuladoReadService;
import br.ifsul.enemsim.services.entidades.relacionais.SimuladoItemCreateAndUpdateService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/simulado")
@CrossOrigin(origins = "*")
public class SimuladoController {

	@Autowired
	private SimuladoReadService simuladoReadService;
	
	@GetMapping
	public List<Simulado> listar() {
		return simuladoReadService.listar();
	}
	
	@GetMapping("/{id}")
	public Simulado buscarPorId(@PathVariable Integer id) {
		return simuladoReadService.buscarPorId(id).get();
	}
	
	@GetMapping("/{simuladoId}/itens")
	public List<Item> itensDoSimulado(@PathVariable Integer simuladoId) {
		return simuladoReadService.itensDoSimulado(simuladoId);
	}
	
	@GetMapping("/estudante/{estudanteId}")
	public List<Simulado> simuladosDoEstudante(@PathVariable Integer estudanteId) {
		return simuladoReadService.simuladosDoEstudante(estudanteId);
	}
	
	// save, saveAll?
	
	// GerarSimuladoService?
	
	@Autowired
	private SimuladoCreateAndUpdateService simuladoCreateAndUpdateService;
	
	@Autowired
	private SimuladoItemCreateAndUpdateService simuladoItemCreateAndUpdateService;
	
	@Autowired
	private GerSim gerSim;

	@GetMapping("/gerar/nivelamento/estudante={estudanteId}") // ""? // Get?
	public SimuladoGerado gerarSimuladoDeNivelamento(@PathVariable Integer estudanteId) throws DadosInsuficientesException { // tratar exceção aqui?
		return gerSim.gerarSimuladoDeNivelamento(new Estudante(estudanteId)).salvar(simuladoCreateAndUpdateService, simuladoItemCreateAndUpdateService);
	}

	// gerarSimuladoAdaptado
	
	// salvarResposta?
	// EntregarSimuladoService?
	
	@Autowired
	private ItemReadService itemReadService;
	
	@Autowired
	private EstudanteHabilidadeRepository estudanteHabilidadeRepository; // ...
	
	// testar tudo isso aqui...
	@Transactional
	@PostMapping("/finalizar") // Post // ""?
	public int finalizarSimulado(@RequestBody List<SimuladoItem> itensRespondidos) throws RespostaAoSimuladoException { // void?
		Simulado simulado = simuladoReadService.buscarPorId(itensRespondidos.get(0).getId().getSimuladoId()).get(); // ?
		
		// if simulado == null ...?
		
		if(simulado.getFinalizado()) // simuladoRepository.finalizado(id) ??
			throw new RespostaAoSimuladoException("O simulado informado (id = " + simulado.getId() + ") já foi entregue e não aceita mais respostas.");
		
		// salvar respostas aos itens
		for(SimuladoItem simuladoItem : itensRespondidos) {
			if(!simuladoReadService.simuladoPossuiItem(simulado.getId(), simuladoItem.getId().getItemId()))
				throw new RespostaAoSimuladoException("O item informado (id = " + simuladoItem.getId().getItemId() + ") não aparece no simulado.");
			
			simuladoItemCreateAndUpdateService.salvarResposta(simuladoItem.getId(), simuladoItem.getResposta());
		}
		
		// marcar como finalizado
		simuladoCreateAndUpdateService.finalizarSimulado(simulado.getId());
		
		// contabilizar acertos e erros
		for(SimuladoItem simuladoItem : itensRespondidos) {
			Item item = itemReadService.buscarPorId(simuladoItem.getId().getItemId()).get();
			
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
	
	// delete, deleteAll?
	
}
