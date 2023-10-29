package br.ifsul.enemsim.controllers.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifsul.enemsim.domain.Prova;
import br.ifsul.enemsim.services.domain.ProvaReadService;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Prova", description = "Métodos ligados às provas do Enem.", externalDocs = @ExternalDocumentation(url = "https://www.gov.br/inep/pt-br/areas-de-atuacao/avaliacao-e-exames-educacionais/enem/provas-e-gabaritos"))
@RestController
@RequestMapping("/prova")
@CrossOrigin(origins = "*")
public class ProvaController {

	@Autowired
	private ProvaReadService provaReadService;
	
	@Operation(summary = "Retorna uma lista com as provas.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Retorna um array com as provas encontradas.", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Prova.class)))
			})
	})
	@GetMapping
	public List<Prova> listar() {
		return provaReadService.listar();
	}
	
	@Operation(summary = "Retorna a prova pelo id informado.", parameters = {
			@Parameter(name = "id", description = "O id da prova no banco de dados.", schema = @Schema(implementation = Integer.class))
	})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Retorna um objeto com a prova encontrada.", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Prova.class))
			})
	})
	@GetMapping("/{id}")
	public Prova buscarPorId(@PathVariable Integer id) {
		return provaReadService.buscarPorId(id).get();
	}
	
}
