package br.ifsul.enemsim.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifsul.enemsim.entidades.Habilidade;
import br.ifsul.enemsim.repositories.HabilidadeRepository;
import br.ifsul.enemsim.services.interfaces.ReadService;

@Service
public class HabilidadeReadService implements ReadService<Habilidade, Byte> {
	
	@Autowired
	private HabilidadeRepository habilidadeRepository;

	@Override
	public List<Habilidade> listar() {
		return habilidadeRepository.findAll();
	}

	@Override
	public Optional<Habilidade> buscarPorId(Byte id) {
		return habilidadeRepository.findById(id);
	}
	
}
