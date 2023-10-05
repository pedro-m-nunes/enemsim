package br.ifsul.enemsim.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifsul.enemsim.entidades.Competencia;
import br.ifsul.enemsim.repositories.CompetenciaRepository;
import br.ifsul.enemsim.services.interfaces.ReadService;

@Service
public class ReadCompetenciaService implements ReadService<Competencia, Byte> {
	
	@Autowired
	private CompetenciaRepository competenciaRepository;

	@Override
	public List<Competencia> listar() {
		return competenciaRepository.findAll();
	}

	@Override
	public Competencia get(Byte id) {
		return competenciaRepository.findById(id).get();
	}

}
