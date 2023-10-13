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
import br.ifsul.enemsim.entidades.auxiliar.Adaptacao;
import br.ifsul.enemsim.entidades.relacionais.SimuladoItem;
import br.ifsul.enemsim.exceptions.DadosInsuficientesException;
import br.ifsul.enemsim.exceptions.GerarSimuladoException;
import br.ifsul.enemsim.exceptions.ResponderSimuladoException;
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
	
//	@GetMapping("/teste")
//	private boolean teste() { // erro: simuladoReadService é null (?)
//		return simuladoReadService.estudantePossuiSimuladoNaoFinalizado(1);
//	}
	
	@Autowired
	private SimuladoCreateAndUpdateService simuladoCreateAndUpdateService;
	
	// save, saveAll?
	
	@Autowired
	private GerarSimuladoService gerarSimuladoService;
	
	private static final int MINIMO_SIMULADOS_DE_NIVELAMENTO = 3;

	@GetMapping("/gerar/nivelamento/estudante={estudanteId}") // ""? // Post?
	public SimuladoGerado gerarSimuladoDeNivelamento(@PathVariable Integer estudanteId) throws DadosInsuficientesException { // tratar exceção aqui?
		// if !simuladoAberto
		return simuladoCreateAndUpdateService.salvarSimuladoGerado(gerarSimuladoService.gerarSimuladoDeNivelamento(estudanteId));
	}

	@GetMapping("/gerar/desempenho/estudante={estudanteId}") // ""? // Post?
	public SimuladoGerado gerarSimuladoPorDesempenho(@PathVariable Integer estudanteId) throws DadosInsuficientesException, GerarSimuladoException {
		// if !simuladoAberto
		
		int simuladosDeNivelamentoRealizadosPeloEstudante = simuladoReadService.quantidadeSimuladosDeNivelamentoFinalizados(estudanteId);
		
		if(simuladosDeNivelamentoRealizadosPeloEstudante < MINIMO_SIMULADOS_DE_NIVELAMENTO)
			throw new GerarSimuladoException("É preciso realizar " + MINIMO_SIMULADOS_DE_NIVELAMENTO + " simulados de nivelamento antes de poder gerar simulados adaptados. " + simuladosDeNivelamentoRealizadosPeloEstudante + " simulado(s) realizado(s)."); // ?
		
		return simuladoCreateAndUpdateService.salvarSimuladoGerado(gerarSimuladoService.gerarSimuladoAdaptado(estudanteId, Adaptacao.DESEMPENHO));
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
