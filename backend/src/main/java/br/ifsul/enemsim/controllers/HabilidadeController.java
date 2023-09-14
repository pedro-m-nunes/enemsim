package br.ifsul.enemsim.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifsul.enemsim.entidades.Habilidade;
import br.ifsul.enemsim.repositories.HabilidadeRepository;

@RestController
@RequestMapping("/habilidade")
@CrossOrigin(origins = "*")
public class HabilidadeController {

	@Autowired
	private HabilidadeRepository habilidadeRepository;
	
	@GetMapping
	public List<Habilidade> findAll() {
		return habilidadeRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Habilidade findById(@PathVariable Byte id) {
		return habilidadeRepository.findById(id).get();
	}
	
}
