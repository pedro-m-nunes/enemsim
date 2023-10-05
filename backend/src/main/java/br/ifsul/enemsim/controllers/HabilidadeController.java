package br.ifsul.enemsim.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifsul.enemsim.entidades.Habilidade;
import br.ifsul.enemsim.services.HabilidadeReadService;

@RestController
@RequestMapping("/habilidade")
@CrossOrigin(origins = "*")
public class HabilidadeController {

	@Autowired
	private HabilidadeReadService habilidadeReadService;
	
	@GetMapping
	public List<Habilidade> listar() {
		return habilidadeReadService.listar();
	}
	
	@GetMapping("/{id}")
	public Habilidade buscarPorId(@PathVariable Byte id) {
		return habilidadeReadService.buscarPorId(id).get();
	}
	
}
