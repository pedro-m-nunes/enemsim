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
	
	public void finalizarSimulado(List<SimuladoItem> itensRespondidos) throws ResponderSimuladoException { // fazer métodos próprios para as ações?
		// checar se todos os itens pertencem ao mesmo simulado
		int ultimoSimuladoId = -1;
		
		for(SimuladoItem itemRespondido : itensRespondidos) {
			int simuladoId = itemRespondido.getId().getSimuladoId();
			
			if(ultimoSimuladoId != -1 && ultimoSimuladoId != simuladoId)
				throw new ResponderSimuladoException("Os itens informados não pertencem ao mesmo simulado.");
			
			ultimoSimuladoId = simuladoId;
		}
		
		Simulado simulado = simuladoReadService.buscarPorId(itensRespondidos.get(0).getId().getSimuladoId()).get();
		
		if(simulado == null)
			throw new ResponderSimuladoException("O simulado informado é nulo.");
		
		if(simulado.getFinalizado())
			throw new ResponderSimuladoException("O simulado informado (id = " + simulado.getId() + ") já foi entregue e não aceita mais respostas.");
		
		// salvar respostas aos itens
		for(SimuladoItem itemRespondido : itensRespondidos) {
			if(!simuladoReadService.simuladoPossuiItem(simulado.getId(), itemRespondido.getId().getItemId())) // se id é null...
				throw new ResponderSimuladoException("O item informado (id = " + itemRespondido.getId().getItemId() + ") não aparece no simulado.");
			
			simuladoItemCreateAndUpdateService.salvarResposta(itemRespondido.getId(), itemRespondido.getResposta());
		}
		
		// marcar como finalizado
		simuladoCreateAndUpdateService.finalizarSimulado(simulado.getId());
		
		// contabilizar acertos e erros
		for(SimuladoItem simuladoItem : itensRespondidos) {
			Item item = itemReadService.buscarPorId(simuladoItem.getId().getItemId()).get();
			
			EstudanteHabilidadeId estudanteHabilidadeId = new EstudanteHabilidadeId(simulado.getEstudante().getId(), item.getHabilidade().getId());
			
			estudanteHabilidadeCreateAndUpdateService.adicionarTentativa(estudanteHabilidadeId);
			
			if(simuladoItem.getResposta() == item.getRespostaCerta())
				estudanteHabilidadeCreateAndUpdateService.adicionarTentativaCerta(estudanteHabilidadeId);
		}
	}
	
}
