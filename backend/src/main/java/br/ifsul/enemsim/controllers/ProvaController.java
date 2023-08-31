package br.ifsul.enemsim.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifsul.enemsim.entidades.Prova;
import br.ifsul.enemsim.repositories.ProvaRepository;

@RestController
@RequestMapping("/prova")
public class ProvaController {

	@Autowired
	private ProvaRepository provaRepository;
	
	@GetMapping
	public List<Prova> findAll() {
		return provaRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Prova findById(@PathVariable Integer id) {
		return provaRepository.findById(id).get();
	}
	
}
