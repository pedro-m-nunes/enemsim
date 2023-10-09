package br.ifsul.enemsim.services.entidades;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifsul.enemsim.entidades.Simulado;
import br.ifsul.enemsim.repositories.SimuladoRepository;
import br.ifsul.enemsim.services.entidades.interfaces.CreateAndUpdateService;

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
	
	// salvar(SimuladoGerado simuladoGerado)
	
}
