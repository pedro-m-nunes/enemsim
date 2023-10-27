package br.ifsul.enemsim.controllers.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifsul.enemsim.domain.Habilidade;
import br.ifsul.enemsim.services.domain.HabilidadeReadService;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Habilidade", description = "Métodos ligados às habilidades do Enem.", externalDocs = @ExternalDocumentation(url = "https://download.inep.gov.br/download/enem/matriz_referencia.pdf"))
@RestController
@RequestMapping("/habilidade")
@CrossOrigin(origins = "*")
public class HabilidadeController {

	@Autowired
	private HabilidadeReadService habilidadeReadService;
	
	@Operation(summary = "Retorna uma lista com as habilidades.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Retorna um array com as habilidades encontradas.", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Habilidade.class)))
			})
	})
	@GetMapping
	public List<Habilidade> listar() {
		return habilidadeReadService.listar();
	}
	
	@Operation(summary = "Retorna a habilidade pelo id informado.", parameters = {
			@Parameter(name = "id", description = "O id da habilidade no banco de dados.", schema = @Schema(implementation = Byte.class))
	})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Retorna um objeto com a habilidade encontrada.", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Habilidade.class))
			})
	})
	@GetMapping("/{id}")
	public Habilidade buscarPorId(@PathVariable Byte id) {
		return habilidadeReadService.buscarPorId(id).get();
	}
	
}
