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
import br.ifsul.enemsim.services.domain.auxiliar.TaxaAcertos;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;

@Tag(name = "Simulado", description = "Métodos ligados aos simulados do sistema e aos itens desses simulados.")
@RestController
@RequestMapping("/simulado")
@CrossOrigin(origins = "*")
public class SimuladoController {

	@Autowired
	private SimuladoReadService simuladoReadService;
	
	@Operation(summary = "Retorna uma lista com os simulados.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Retorna um array com os simulados encontrados.", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Simulado.class)))
			})
	})
	@GetMapping
	public List<Simulado> listar() {
		return simuladoReadService.listar();
	}
	
	@Operation(summary = "Retorna o simulado pelo id informado.", parameters = {
			@Parameter(name = "id", description = "O id do simulado no banco de dados.", schema = @Schema(implementation = Integer.class))
	})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Retorna um objeto com o simulado encontrado.", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Simulado.class))
			})
	})
	@GetMapping("/{id}")
	public Simulado buscarPorId(@PathVariable Integer id) {
		return simuladoReadService.buscarPorId(id).get();
	}
	
	@Operation(summary = "Retorna uma lista com os itens de um simulado.", parameters = {
			@Parameter(name = "id", description = "O id do simulado no banco de dados.", schema = @Schema(implementation = Integer.class))
	})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Retorna um array com os itens encontrados.", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Item.class)))
			})
	})
	@GetMapping("/{id}/itens")
	public List<Item> itensDoSimulado(@PathVariable Integer id) {
		return simuladoReadService.itensDoSimulado(id);
	}
	
	@Operation(summary = "Retorna uma lista com os simulados de um estudante.", parameters = {
			@Parameter(name = "estudanteId", description = "O id do estudante no banco de dados.", schema = @Schema(implementation = Integer.class))
	})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Retorna um array com os simulados encontrados.", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Simulado.class)))
			})
	})
	@GetMapping("/estudante/{estudanteId}")
	public List<Simulado> simuladosDoEstudante(@PathVariable Integer estudanteId) {
		return simuladoReadService.simuladosDoEstudante(estudanteId);
	}
	
	@Operation(summary = "Retorna a quantidade de acertos e itens de um simulado.", parameters = {
			@Parameter(name = "id", description = "O id do simulado no banco de dados.", schema = @Schema(implementation = Integer.class))
	})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Retorna um objeto com a quantidade de acertos e a quantidade de itens do simulado.", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = TaxaAcertos.class))
			})
	})
	@GetMapping("/{id}/taxa-de-acertos")
	public TaxaAcertos buscarQuantidadeDeAcertosEItens(@PathVariable Integer id) {
		return simuladoReadService.quantidadeDeAcertosEItens(id);
	}
	
	@Operation(summary = "Retorna uma lista com as respostas de um simulado.", parameters = {
			@Parameter(name = "id", description = "O id do simulado no banco de dados.", schema = @Schema(implementation = Integer.class))
	})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Retorna um array com as respostas dadas ao simulado.", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = SimuladoItem.class)))
			})
	})
	@GetMapping("{id}/respostas")
	public List<SimuladoItem> buscarRespostasASimulado(@PathVariable Integer id) { // testar
		return simuladoReadService.respostasAoSimulado(id);
	}
	
	@Autowired
	private SimuladoCreateAndUpdateService simuladoCreateAndUpdateService;
	
	// save, saveAll?
	
	@Autowired
	private GerarSimuladoService gerarSimuladoService;

	@Operation(summary = "Gera um simulado de nivelamento.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Retorna um objeto com o simulado gerado.", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = SimuladoGerado.class))
			})
	})
	@PostMapping("/gerar/nivelamento")
	public SimuladoGerado gerarSimuladoDeNivelamento(@RequestBody Estudante estudante) throws DadosInsuficientesException, GerarSimuladoException {
		return simuladoCreateAndUpdateService.salvarSimuladoGerado(gerarSimuladoService.gerarSimulado(estudante.getId(), null));
	}

	@Operation(summary = "Gera um simulado por desempenho.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Retorna um objeto com o simulado gerado.", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = SimuladoGerado.class))
			})
	})
	@PostMapping("/gerar/desempenho")
	public SimuladoGerado gerarSimuladoPorDesempenho(@RequestBody Estudante estudante) throws DadosInsuficientesException, GerarSimuladoException {
		return simuladoCreateAndUpdateService.salvarSimuladoGerado(gerarSimuladoService.gerarSimulado(estudante.getId(), Adaptacao.DESEMPENHO));
	}
	
	// pontos fortes, pontos fracos...
	
	@Autowired
	private ResponderSimuladoService responderSimuladoService;
	
	@Operation(summary = "Salva as respostas a um simulado.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Retorna um objeto com o simulado gerado.")
	})
	@Transactional
	@PostMapping("/finalizar")
	public void finalizarSimulado(@RequestBody List<SimuladoItem> itensRespondidos) throws ResponderSimuladoException { // void?
		responderSimuladoService.finalizarSimulado(itensRespondidos);
	}
	
	// delete, deleteAll?
	
}
