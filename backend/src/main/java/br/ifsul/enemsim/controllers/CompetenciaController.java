package br.ifsul.enemsim.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifsul.enemsim.entidades.Competencia;
import br.ifsul.enemsim.services.CompetenciaReadService;

@RestController
@RequestMapping("/competencia")
@CrossOrigin(origins = "*")
public class CompetenciaController { // service?

	@Autowired
	private CompetenciaReadService competenciaReadService;
	
	@GetMapping
	public List<Competencia> listar() {
		return competenciaReadService.listar();
	}
	
	@GetMapping("/{id}")
	public Competencia buscarPorId(@PathVariable Byte id) {
		return competenciaReadService.buscarPorId(id).get();
	}
	
}
