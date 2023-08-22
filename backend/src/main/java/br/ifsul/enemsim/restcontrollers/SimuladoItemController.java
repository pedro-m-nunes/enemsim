package br.ifsul.enemsim.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifsul.enemsim.entidades.SimuladoItem;
import br.ifsul.enemsim.repositories.SimuladoItemRepository;

@RestController
@RequestMapping("/simuladoitem")
public class SimuladoItemController {

	@Autowired
	private SimuladoItemRepository simuladoItemRepository;
	
	@GetMapping
	public List<SimuladoItem> findAll() {
		return simuladoItemRepository.findAll();
	}
	
	@GetMapping("/{simuladoId}")
	public List<SimuladoItem> findByIdSimuladoId(@PathVariable Integer simuladoId) {
		return simuladoItemRepository.findByIdSimuladoId(simuladoId);
	}
	
}
