package br.ifsul.enemsim.autenticacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifsul.enemsim.domain.usuarios.Usuario;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Autenticação", description = "Métodos ligados à autenticação de usuários.")
@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AutenticacaoController {
	
	@Autowired
	private AutenticacaoService autenticacaoService;
	
	@Operation(summary = "Faz a autenticação do usuário informado.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Retorna um objeto com o usuário encontrado.", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Usuario.class))
			})
	})
	@PostMapping("/login")
	public Usuario login(@RequestBody UsuarioLogin possivelUsuario) throws AutenticacaoException {
		return autenticacaoService.loginEstudante(possivelUsuario);
	}
	
	@Operation(summary = "Faz o cadastro do usuário informado.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Retorna um objeto com o usuário cadastrado.", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Usuario.class))
			})
	})
	@PostMapping("/cadastrar")
	public Usuario cadastrarEstudante(@RequestBody UsuarioCadastro possivelUsuario) throws AutenticacaoException {
		return autenticacaoService.cadastrarEstudante(possivelUsuario);
	}
	
}
