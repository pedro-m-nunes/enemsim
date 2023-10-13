package br.ifsul.enemsim.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifsul.enemsim.entidades.Item;
import br.ifsul.enemsim.entidades.Simulado;
import br.ifsul.enemsim.entidades.relacionais.SimuladoItem;
import br.ifsul.enemsim.entidades.relacionais.auxiliar.EstudanteHabilidadeId;
import br.ifsul.enemsim.exceptions.ResponderSimuladoException;
import br.ifsul.enemsim.services.entidades.ItemReadService;
import br.ifsul.enemsim.services.entidades.SimuladoCreateAndUpdateService;
import br.ifsul.enemsim.services.entidades.SimuladoReadService;
import br.ifsul.enemsim.services.entidades.relacionais.EstudanteHabilidadeCreateAndUpdateService;
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
		
	// salvarResposta()? // sem necessariamente entregar...
	
	@Autowired
	private EstudanteHabilidadeCreateAndUpdateService estudanteHabilidadeCreateAndUpdateService;
	
	public void finalizarSimulado(List<SimuladoItem> itensRespondidos) throws ResponderSimuladoException {
		// if simuladoDoItemN != simuladoDoItemM...
		// if simulado == null ...?
		Simulado simulado = simuladoReadService.buscarPorId(itensRespondidos.get(0).getId().getSimuladoId()).get(); // get 0?
		
		if(simulado.getFinalizado())
			throw new ResponderSimuladoException("O simulado informado (id = " + simulado.getId() + ") já foi entregue e não aceita mais respostas.");
		
		// salvar respostas aos itens
		for(SimuladoItem simuladoItem : itensRespondidos) {
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
			
			// antigo: se não tiver EH, criar (não precisa mais)
			
			estudanteHabilidadeCreateAndUpdateService.adicionarTentativa(estudanteHabilidadeId);
			
			if(simuladoItem.getResposta() == item.getRespostaCerta()) // método próprio?
				estudanteHabilidadeCreateAndUpdateService.adicionarTentativaCerta(estudanteHabilidadeId);
		}
	}
	
}
