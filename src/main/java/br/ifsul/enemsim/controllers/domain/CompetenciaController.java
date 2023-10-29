package br.ifsul.enemsim.controllers.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifsul.enemsim.domain.Competencia;
import br.ifsul.enemsim.services.domain.CompetenciaReadService;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Competência", description = "Métodos ligados às competências do Enem.", externalDocs = @ExternalDocumentation(url = "https://download.inep.gov.br/download/enem/matriz_referencia.pdf"))
@RestController
@RequestMapping("/competencia")
@CrossOrigin(origins = "*")
public class CompetenciaController {

	@Autowired
	private CompetenciaReadService competenciaReadService;
	
	@Operation(summary = "Retorna uma lista com as competências.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Retorna um array com as competências encontradas.", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Competencia.class)))
			})
	})
	@GetMapping
	public List<Competencia> listar() {
		return competenciaReadService.listar();
	}
	
	@Operation(summary = "Retorna a competência pelo id informado.", parameters = {
			@Parameter(name = "id", description = "O id da competência no banco de dados.", schema = @Schema(implementation = Byte.class))
	})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Retorna um objeto com a competência encontrada.", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Competencia.class))
			})
	})
	@GetMapping("/{id}")
	public Competencia buscarPorId(@PathVariable Byte id) {
		return competenciaReadService.buscarPorId(id).get();
	}
	
}
