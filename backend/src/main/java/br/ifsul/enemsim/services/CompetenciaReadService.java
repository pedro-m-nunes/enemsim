package br.ifsul.enemsim.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifsul.enemsim.entidades.Competencia;
import br.ifsul.enemsim.repositories.CompetenciaRepository;
import br.ifsul.enemsim.services.interfaces.ReadService;

@Service
public class CompetenciaReadService implements ReadService<Competencia, Byte> {
	
	@Autowired
	private CompetenciaRepository competenciaRepository;

	@Override
	public List<Competencia> listar() {
		return competenciaRepository.findAll();
	}

	@Override
	public Optional<Competencia> buscarPorId(Byte id) {
		return competenciaRepository.findById(id); // não é recomendado retornar o objeto... retornar ma cópia? (DTO)
	}

}
