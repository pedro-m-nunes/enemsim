package br.ifsul.enemsim.autenticacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifsul.enemsim.domain.usuarios.Usuario;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {
	
	@Autowired
	private AutenticacaoService autenticacaoService;
	
	@PostMapping("/login")
	public Usuario login(@RequestBody UsuarioLogin possivelUsuario) throws AutenticacaoException {
		return autenticacaoService.loginEstudante(possivelUsuario);
	}
	
	@PostMapping("/cadastrar")
	public Usuario cadastrarEstudante(@RequestBody UsuarioCadastro possivelUsuario) throws AutenticacaoException {
		return autenticacaoService.cadastrarEstudante(possivelUsuario);
	}
	
}
