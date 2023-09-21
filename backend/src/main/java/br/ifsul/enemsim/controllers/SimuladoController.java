package br.ifsul.enemsim.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifsul.enemsim.entidades.Item;
import br.ifsul.enemsim.entidades.Simulado;
import br.ifsul.enemsim.repositories.SimuladoRepository;

@RestController
@RequestMapping("/simulado")
@CrossOrigin(origins = "*")
public class SimuladoController {

	@Autowired
	private SimuladoRepository simuladoRepository;
	
	@GetMapping
	public List<Simulado> findAll() {
		return simuladoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Simulado findById(@PathVariable Integer id) {
		return simuladoRepository.findById(id).get();
	}
	
	@GetMapping("/{id}/itens")
	public List<Item> getItensDoSimulado(@PathVariable Integer id) {
		return simuladoRepository.getItensDoSimulado(id);
	}
	
	@GetMapping("/estudante/{estudanteId}")
	public List<Simulado> findByEstudanteId(@PathVariable Integer estudanteId) {
		return simuladoRepository.findByEstudanteId(estudanteId);
	}
	
	// gerarSimulado
	// gerarSimuladoDeNivelamento
	// gerarSimuladoAdaptado
	
}
