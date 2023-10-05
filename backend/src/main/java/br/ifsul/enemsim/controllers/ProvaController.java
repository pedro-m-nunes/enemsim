package br.ifsul.enemsim.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifsul.enemsim.entidades.Prova;
import br.ifsul.enemsim.services.entidades.ProvaReadService;

@RestController
@RequestMapping("/prova")
@CrossOrigin(origins = "*")
public class ProvaController {

	@Autowired
	private ProvaReadService provaReadService;
	
	@GetMapping
	public List<Prova> listar() {
		return provaReadService.listar();
	}
	
	@GetMapping("/{id}")
	public Prova buscarPorId(@PathVariable Integer id) {
		return provaReadService.buscarPorId(id).get();
	}
	
}
