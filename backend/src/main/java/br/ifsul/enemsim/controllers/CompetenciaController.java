package br.ifsul.enemsim.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifsul.enemsim.entidades.Competencia;
import br.ifsul.enemsim.repositories.CompetenciaRepository;

@RestController
@RequestMapping("/competencia")
public class CompetenciaController { // service?

	@Autowired // ?
	private CompetenciaRepository competenciaRepository;
	
	@GetMapping
	public List<Competencia> findAll() {
		return competenciaRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Competencia findById(@PathVariable Byte id) {
		return competenciaRepository.findById(id).get();
	}
	
}
