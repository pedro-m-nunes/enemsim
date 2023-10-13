package br.ifsul.enemsim.services.entidades;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifsul.enemsim.entidades.Item;
import br.ifsul.enemsim.entidades.Simulado;
import br.ifsul.enemsim.entidades.relacionais.EstudanteHabilidade;
import br.ifsul.enemsim.entidades.relacionais.SimuladoItem;
import br.ifsul.enemsim.entidades.relacionais.auxiliar.EstudanteHabilidadeId;
import br.ifsul.enemsim.repositories.SimuladoRepository;
import br.ifsul.enemsim.services.auxiliar.SimuladoGerado;
import br.ifsul.enemsim.services.entidades.interfaces.CreateAndUpdateService;
import br.ifsul.enemsim.services.entidades.relacionais.EstudanteHabilidadeCreateAndUpdateService;
import br.ifsul.enemsim.services.entidades.relacionais.EstudanteHabilidadeReadService;
import br.ifsul.enemsim.services.entidades.relacionais.SimuladoItemCreateAndUpdateService;

@Service
public class SimuladoCreateAndUpdateService implements CreateAndUpdateService<Simulado, Integer> {

	@Autowired
	private SimuladoRepository simuladoRepository;

	@Override
	public Simulado salvarOuAtualizar(Simulado entidade) {
		return simuladoRepository.save(entidade);
	}

	@Override
	public List<Simulado> salvarOuAtualizarTodos(Iterable<Simulado> entidades) {
		return simuladoRepository.saveAll(entidades);
	}
	
	public int finalizarSimulado(Integer simuladoId) { // ""?
		return simuladoRepository.setFinalizado(simuladoId);
	}
	
	@Autowired
	private SimuladoItemCreateAndUpdateService simuladoItemCreateAndUpdateService;
	
	@Autowired
	private EstudanteHabilidadeCreateAndUpdateService estudanteHabilidadeCreateAndUpdateService;
	
	@Autowired
	private EstudanteHabilidadeReadService estudanteHabilidadeReadService;
	
	public SimuladoGerado salvarSimuladoGerado(SimuladoGerado simuladoGerado) {
		simuladoGerado.setSimulado(this.salvarOuAtualizar(simuladoGerado.getSimulado()));
		
		Set<SimuladoItem> simuladoItens = new LinkedHashSet<>();
		Set<EstudanteHabilidade> estudanteHabilidades = new LinkedHashSet<>();
		
		for(Item item : simuladoGerado.getItens()) {
			simuladoItens.add(new SimuladoItem(simuladoGerado.getSimulado(), item));
		}
		
		simuladoItemCreateAndUpdateService.salvarOuAtualizarTodos(simuladoItens);
		
		for(Item item : simuladoGerado.getItens()) {
			EstudanteHabilidadeId estudanteHabilidadeId = new EstudanteHabilidadeId(simuladoGerado.getSimulado().getEstudante().getId(), item.getHabilidade().getId()); // ?
			
			if(!estudanteHabilidadeReadService.existePorId(estudanteHabilidadeId))
				estudanteHabilidades.add(new EstudanteHabilidade(simuladoGerado.getSimulado().getEstudante(), item.getHabilidade()));
		}
		
		estudanteHabilidadeCreateAndUpdateService.salvarOuAtualizarTodos(estudanteHabilidades);
		
		return simuladoGerado;
	}
	
}
