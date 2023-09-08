package br.ifsul.enemsim.controllers.entidadesrelacionais;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifsul.enemsim.entidades.Simulado;
import br.ifsul.enemsim.entidades.perfis.Estudante;
import br.ifsul.enemsim.entidades.relacionais.SimuladoItem;
import br.ifsul.enemsim.repositories.entidadesrelacionais.SimuladoItemRepository;

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
	public List<SimuladoItem> findBySimulado(@PathVariable Integer simuladoId) {
		return simuladoItemRepository.findBySimulado(new Simulado(simuladoId));
	}
	
}
