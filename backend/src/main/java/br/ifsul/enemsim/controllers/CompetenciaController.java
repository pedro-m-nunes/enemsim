package br.ifsul.enemsim.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifsul.enemsim.entidades.Competencia;
import br.ifsul.enemsim.services.ReadCompetenciaService;

@RestController
@RequestMapping("/competencia")
@CrossOrigin(origins = "*")
public class CompetenciaController { // service?

	@Autowired // ?
	private ReadCompetenciaService readCompetenciaService;
	
	@GetMapping
	public List<Competencia> findAll() {
		return readCompetenciaService.listar();
	}
	
	@GetMapping("/{id}")
	public Competencia findById(@PathVariable Byte id) {
		return readCompetenciaService.get(id);
	}
	
}
