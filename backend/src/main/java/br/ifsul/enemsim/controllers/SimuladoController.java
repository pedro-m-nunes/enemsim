package br.ifsul.enemsim.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifsul.enemsim.entidades.Item;
import br.ifsul.enemsim.entidades.Simulado;
import br.ifsul.enemsim.entidades.relacionais.SimuladoItem;
import br.ifsul.enemsim.entidades.usuarios.Estudante;
import br.ifsul.enemsim.exceptions.DadosInsuficientesException;
import br.ifsul.enemsim.exceptions.RespostaAoSimuladoException;
import br.ifsul.enemsim.services.GerarSimuladoService;
import br.ifsul.enemsim.services.ResponderSimuladoService;
import br.ifsul.enemsim.services.auxiliar.SimuladoGerado;
import br.ifsul.enemsim.services.entidades.SimuladoCreateAndUpdateService;
import br.ifsul.enemsim.services.entidades.SimuladoReadService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/simulado")
@CrossOrigin(origins = "*")
public class SimuladoController {

	@Autowired
	private SimuladoReadService simuladoReadService;
	
	@GetMapping
	public List<Simulado> listar() {
		return simuladoReadService.listar();
	}
	
	@GetMapping("/{id}")
	public Simulado buscarPorId(@PathVariable Integer id) {
		return simuladoReadService.buscarPorId(id).get();
	}
	
	@GetMapping("/{simuladoId}/itens")
	public List<Item> itensDoSimulado(@PathVariable Integer simuladoId) {
		return simuladoReadService.itensDoSimulado(simuladoId);
	}
	
	@GetMapping("/estudante/{estudanteId}")
	public List<Simulado> simuladosDoEstudante(@PathVariable Integer estudanteId) {
		return simuladoReadService.simuladosDoEstudante(estudanteId);
	}
	
	@Autowired
	private SimuladoCreateAndUpdateService simuladoCreateAndUpdateService;
	
	// save, saveAll?
	
	@Autowired
	private GerarSimuladoService gerarSimuladoService;

	@GetMapping("/gerar/nivelamento/estudante={estudanteId}") // ""? // Post?
	public SimuladoGerado gerarSimuladoDeNivelamento(@PathVariable Integer estudanteId) throws DadosInsuficientesException { // tratar exceção aqui?
		return simuladoCreateAndUpdateService.salvarSimuladoGerado(gerarSimuladoService.gerarSimuladoDeNivelamento(new Estudante(estudanteId)));
	}

	// gerarSimuladoAdaptado
	
	@Autowired
	private ResponderSimuladoService responderSimuladoService;
	
	@Transactional // ?
	@PostMapping("/finalizar") // ""?
	public int finalizarSimulado(@RequestBody List<SimuladoItem> itensRespondidos) throws RespostaAoSimuladoException { // void?
		return responderSimuladoService.finalizarSimulado(itensRespondidos);
	}
	
//	@GetMapping("/s={sId}/i={iId}")
//	public Object teste(@PathVariable int sId, @PathVariable int iId) { // temp
//		return simuladoRepository.simuladoPossuiItem(simuladoRepository.findById(sId).get(), itemRepository.findById(iId).get());
//	}
	
	// delete, deleteAll?
	
}
