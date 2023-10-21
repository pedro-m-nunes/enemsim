package br.ifsul.enemsim.services.domain.usuarios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifsul.enemsim.domain.usuarios.Estudante;
import br.ifsul.enemsim.repositories.usuarios.EstudanteRepository;
import br.ifsul.enemsim.services.domain.interfaces.CreateAndUpdateService;

@Service
public class EstudanteCreateAndUpdateService implements CreateAndUpdateService<Estudante, Integer> {

	@Autowired
	private EstudanteRepository estudanteRepository;
	
	@Override
	public Estudante salvarOuAtualizar(Estudante entidade) {
		return estudanteRepository.save(entidade);
	}

	@Override
	public List<Estudante> salvarOuAtualizarTodos(Iterable<Estudante> entidades) {
		return estudanteRepository.saveAll(entidades);
	}

}
