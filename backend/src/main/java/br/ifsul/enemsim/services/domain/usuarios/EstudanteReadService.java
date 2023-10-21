package br.ifsul.enemsim.services.domain.usuarios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifsul.enemsim.domain.usuarios.Estudante;
import br.ifsul.enemsim.repositories.usuarios.EstudanteRepository;
import br.ifsul.enemsim.services.domain.interfaces.ReadService;
import br.ifsul.enemsim.services.domain.interfaces.UsuariosReadService;

@Service
public class EstudanteReadService implements ReadService<Estudante, Integer>, UsuariosReadService<Estudante> {

	@Autowired
	private EstudanteRepository estudanteRepository;

	@Override
	public List<Estudante> listar() {
		return estudanteRepository.findAll();
	}

	@Override
	public Optional<Estudante> buscarPorId(Integer id) {
		return estudanteRepository.findById(id);
	}

	@Override
	public boolean existePorUsername(String username) {
		return estudanteRepository.existsByUsername(username);
	}

	@Override
	public Optional<Estudante> buscarPorUsername(String username) {
		return estudanteRepository.findByUsername(username);
	}
	
}
