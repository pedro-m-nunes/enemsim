package br.ifsul.enemsim.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifsul.enemsim.entidades.Habilidade;
import br.ifsul.enemsim.entidades.Item;
import br.ifsul.enemsim.entidades.Simulado;
import br.ifsul.enemsim.entidades.relacionais.EstudanteHabilidade;
import br.ifsul.enemsim.entidades.relacionais.SimuladoItem;
import br.ifsul.enemsim.entidades.relacionais.auxiliar.EstudanteHabilidadeId;
import br.ifsul.enemsim.entidades.usuarios.Estudante;
import br.ifsul.enemsim.exceptions.ResponderSimuladoException;
import br.ifsul.enemsim.services.entidades.ItemReadService;
import br.ifsul.enemsim.services.entidades.SimuladoCreateAndUpdateService;
import br.ifsul.enemsim.services.entidades.SimuladoReadService;
import br.ifsul.enemsim.services.entidades.relacionais.EstudanteHabilidadeCreateAndUpdateService;
import br.ifsul.enemsim.services.entidades.relacionais.EstudanteHabilidadeReadService;
import br.ifsul.enemsim.services.entidades.relacionais.SimuladoItemCreateAndUpdateService;

@Service
public class ResponderSimuladoService {
	
	@Autowired
	private SimuladoReadService simuladoReadService;
	
	@Autowired
	private SimuladoCreateAndUpdateService simuladoCreateAndUpdateService;
	
	@Autowired
	private SimuladoItemCreateAndUpdateService simuladoItemCreateAndUpdateService;
	
	@Autowired
	private ItemReadService itemReadService;
	
	@Autowired
	private EstudanteHabilidadeReadService estudanteHabilidadeReadService;
	
	// salvarResposta()?
	
	@Autowired
	private EstudanteHabilidadeCreateAndUpdateService estudanteHabilidadeCreateAndUpdateService;
	
	// testar tudo isso aqui...
//	@Transactional // ?
	public int finalizarSimulado(List<SimuladoItem> itensRespondidos) throws ResponderSimuladoException {
		Simulado simulado = simuladoReadService.buscarPorId(itensRespondidos.get(0).getId().getSimuladoId()).get(); // ?
		
		// if simulado == null ...?
		
		if(simulado.getFinalizado())
			throw new ResponderSimuladoException("O simulado informado (id = " + simulado.getId() + ") já foi entregue e não aceita mais respostas.");
		
		// salvar respostas aos itens
		for(SimuladoItem simuladoItem : itensRespondidos) {
			// if simuladoDoItemN != simuladoDoItemM...
			
			if(!simuladoReadService.simuladoPossuiItem(simulado.getId(), simuladoItem.getId().getItemId()))
				throw new ResponderSimuladoException("O item informado (id = " + simuladoItem.getId().getItemId() + ") não aparece no simulado.");
			
			simuladoItemCreateAndUpdateService.salvarResposta(simuladoItem.getId(), simuladoItem.getResposta());
		}
		
		// marcar como finalizado
		simuladoCreateAndUpdateService.finalizarSimulado(simulado.getId());
		
		// contabilizar acertos e erros
		for(SimuladoItem simuladoItem : itensRespondidos) {
			Item item = itemReadService.buscarPorId(simuladoItem.getId().getItemId()).get();
			
			EstudanteHabilidadeId estudanteHabilidadeId = new EstudanteHabilidadeId(simulado.getEstudante().getId(), item.getHabilidade().getId());
			
			if(!estudanteHabilidadeReadService.existePorId(estudanteHabilidadeId))
				estudanteHabilidadeCreateAndUpdateService.salvarOuAtualizar(new EstudanteHabilidade(new Estudante(estudanteHabilidadeId.getEstudanteId()), new Habilidade(estudanteHabilidadeId.getHabilidadeId()))); // new EstudanteHabilidade(estudanteHabilidadeId)?
			
			estudanteHabilidadeCreateAndUpdateService.adicionarTentativa(estudanteHabilidadeId);
			
			if(simuladoItem.getResposta() == item.getRespostaCerta()) // método próprio?
				estudanteHabilidadeCreateAndUpdateService.adicionarTentativaCerta(estudanteHabilidadeId);
		}
		
		return 1; // ?
	}
	
}
