package br.ifsul.enemsim.controllers.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifsul.enemsim.domain.Item;
import br.ifsul.enemsim.domain.Simulado;
import br.ifsul.enemsim.domain.auxiliar.Adaptacao;
import br.ifsul.enemsim.domain.relacionais.SimuladoItem;
import br.ifsul.enemsim.domain.usuarios.Estudante;
import br.ifsul.enemsim.exceptions.DadosInsuficientesException;
import br.ifsul.enemsim.exceptions.GerarSimuladoException;
import br.ifsul.enemsim.exceptions.ResponderSimuladoException;
import br.ifsul.enemsim.services.GerarSimuladoService;
import br.ifsul.enemsim.services.ResponderSimuladoService;
import br.ifsul.enemsim.services.auxiliar.SimuladoGerado;
import br.ifsul.enemsim.services.domain.SimuladoCreateAndUpdateService;
import br.ifsul.enemsim.services.domain.SimuladoReadService;
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
		
	// gerarSimulado?

	@PostMapping("/gerar/nivelamento")
	public SimuladoGerado gerarSimuladoDeNivelamento(@RequestBody Estudante estudante) throws DadosInsuficientesException, GerarSimuladoException {
		return simuladoCreateAndUpdateService.salvarSimuladoGerado(gerarSimuladoService.gerarSimulado(estudante.getId(), null));
	}

	@PostMapping("/gerar/desempenho")
	public SimuladoGerado gerarSimuladoPorDesempenho(@RequestBody Estudante estudante) throws DadosInsuficientesException, GerarSimuladoException {
		return simuladoCreateAndUpdateService.salvarSimuladoGerado(gerarSimuladoService.gerarSimulado(estudante.getId(), Adaptacao.DESEMPENHO));
	}
	
	// pontos fortes, pontos fracos...
	
	@Autowired
	private ResponderSimuladoService responderSimuladoService;
	
	@Transactional // ?
	@PostMapping("/finalizar") // ""?
	public void finalizarSimulado(@RequestBody List<SimuladoItem> itensRespondidos) throws ResponderSimuladoException { // void?
		responderSimuladoService.finalizarSimulado(itensRespondidos);
	}
	
	// delete, deleteAll?
	
}
