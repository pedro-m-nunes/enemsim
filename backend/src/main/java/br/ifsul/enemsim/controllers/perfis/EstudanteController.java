package br.ifsul.enemsim.controllers.perfis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifsul.enemsim.entidades.perfis.Estudante;
import br.ifsul.enemsim.repositories.perfis.EstudanteRepository;

@RestController
@RequestMapping("/estudante")
public class EstudanteController {

	@Autowired
	private EstudanteRepository estudanteRepository;
	
	@GetMapping
	public List<Estudante> findAll() {
		return estudanteRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Estudante findById(@PathVariable Integer id) {
		return estudanteRepository.findById(id).get();
	}
	
}
