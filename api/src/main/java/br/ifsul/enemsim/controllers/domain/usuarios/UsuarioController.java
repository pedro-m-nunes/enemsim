package br.ifsul.enemsim.controllers.domain.usuarios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifsul.enemsim.domain.usuarios.Usuario;
import br.ifsul.enemsim.services.domain.usuarios.UsuarioReadService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Usuário", description = "Métodos ligados aos usuários do sistema.")
@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {

	@Autowired
	private UsuarioReadService usuarioReadService;
	
	@Operation(summary = "Retorna uma lista com os usuários.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Retorna um array com os usuários encontrados.", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Usuario.class)))
			})
	})
	@GetMapping
	public List<Usuario> listar() {
		return usuarioReadService.listar();
	}
	
	@Operation(summary = "Retorna o usuário pelo id informado.", parameters = {
			@Parameter(name = "id", description = "O id do usuário no banco de dados.", schema = @Schema(implementation = Integer.class))
	})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Retorna um objeto com o usuário encontrado.", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Usuario.class))
			})
	})
	@GetMapping("/{id}")
	public Usuario buscarPorId(@PathVariable Integer id) {
		return usuarioReadService.buscarPorId(id).get();
	}
	
	// autenticar, registrar... (?)
	
	// tipos de usuário...
	
}
