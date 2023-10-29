package br.ifsul.enemsim.controllers.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifsul.enemsim.domain.Item;
import br.ifsul.enemsim.services.domain.ItemReadService;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Item", description = "Métodos ligados aos itens (questões) do Enem.", externalDocs = @ExternalDocumentation(url = "https://www.gov.br/inep/pt-br/acesso-a-informacao/dados-abertos/microdados/enem"))
@RestController
@RequestMapping("/item")
@CrossOrigin(origins = "*")
public class ItemController {
	
	@Autowired
	private ItemReadService itemReadService;
	
	@Operation(summary = "Retorna uma lista com os itens.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Retorna um array com os itens encontrados.", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Item.class)))
			})
	})
	@GetMapping
	public List<Item> listar() {
		return itemReadService.listar();
	}
	
	@Operation(summary = "Retorna o item pelo id informado.", parameters = {
			@Parameter(name = "id", description = "O id do item no banco de dados.", schema = @Schema(implementation = Integer.class))
	})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Retorna um objeto com o item encontrado.", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Item.class))
			})
	})
	@GetMapping("/{id}")
	public Item buscarPorId(@PathVariable Integer id) {
		return itemReadService.buscarPorId(id).get();
	}
	
	// saveAll
	
}
