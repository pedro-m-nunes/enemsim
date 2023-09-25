package br.ifsul.enemsim.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifsul.enemsim.entidades.Item;
import br.ifsul.enemsim.entidades.Simulado;
import br.ifsul.enemsim.entidades.usuarios.Estudante;
import br.ifsul.enemsim.exceptions.DadosInsuficientesException;
import br.ifsul.enemsim.gerador.GerSim;
import br.ifsul.enemsim.repositories.SimuladoRepository;
import br.ifsul.enemsim.repositories.entidadesrelacionais.SimuladoItemRepository;

@RestController
@RequestMapping("/simulado")
@CrossOrigin(origins = "*")
public class SimuladoController {

	@Autowired
	private SimuladoRepository simuladoRepository;
	
	@Autowired
	private SimuladoItemRepository simuladoItemRepository;
	
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
	
	// save, saveAll?
	
	// gerarSimulado (?)
	
	@Autowired
	private GerSim gerSim;

	// gerarSimuladoDeNivelamento
	@GetMapping("/gerar/nivelamento/estudante={estudanteId}") // ""? // Get?
	public Object gerarSimuladoDeNivelamento(@PathVariable Integer estudanteId) { // Object? SimuladoGerado?
		try {
			return gerSim.gerarSimuladoDeNivelamento(new Estudante(estudanteId)).save(simuladoRepository, simuladoItemRepository);
		} catch (DadosInsuficientesException e) {
			return e.getMessage();
		}
	}

	// gerarSimuladoAdaptado
	
	// delete, deleteAll
//	@DeleteMapping("/delete/{id}/{confirmation}")
//	public boolean deleteById(@PathVariable Integer id, @PathVariable String confirmation) { // ?
//		if(confirmation.equals("aham"))
//			simuladoRepository.deleteById(id);
//		return true;
//	}
	
}
