package br.ifsul.enemsim.services.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifsul.enemsim.domain.Prova;
import br.ifsul.enemsim.repositories.ProvaRepository;
import br.ifsul.enemsim.services.domain.interfaces.ReadService;

@Service
public class ProvaReadService implements ReadService<Prova, Integer> {

	@Autowired
	private ProvaRepository provaRepository;

	@Override
	public List<Prova> listar() {
		return provaRepository.findAll();
	}

	@Override
	public Optional<Prova> buscarPorId(Integer id) {
		return provaRepository.findById(id);
	}
	
}
