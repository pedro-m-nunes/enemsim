package br.ifsul.enemsim.autenticacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifsul.enemsim.domain.usuarios.Estudante;
import br.ifsul.enemsim.domain.usuarios.Usuario;
import br.ifsul.enemsim.services.domain.usuarios.EstudanteCreateAndUpdateService;
import br.ifsul.enemsim.services.domain.usuarios.EstudanteReadService;
import br.ifsul.enemsim.services.domain.usuarios.UsuarioReadService;

@Service
public class AutenticacaoService {
	
	@Autowired
	private UsuarioReadService usuarioReadService;
	
	@Autowired
	private EstudanteReadService estudanteReadService;
	
	@Autowired
	private EstudanteCreateAndUpdateService estudanteCreateAndUpdateService;

//	public Usuario login(UsuarioLogin possivelUsuario) throws AutenticacaoException { // ?
//		if(!usuarioReadService.existePorUsername(possivelUsuario.username()))
//			throw new AutenticacaoException("Usuário não encontrado (username = " + possivelUsuario.username() + ").");
//		
//		Usuario usuario = usuarioReadService.buscarPorUsername(possivelUsuario.username()).get();
//		
//		if(possivelUsuario.senha().equals(usuario.getSenha()))
//			return usuario;
//		else
//			throw new AutenticacaoException("Senha incorreta (username = " + usuario.getUsername() + ").");
//	}
	
	private boolean usuarioExisteComUsername(String username) {
		return usuarioReadService.existePorUsername(username);
	}
	
	public Usuario loginEstudante(UsuarioLogin possivelUsuario) throws AutenticacaoException { // ?
		if(!usuarioExisteComUsername(possivelUsuario.username()))
			throw new AutenticacaoException("Usuário não encontrado (username = " + possivelUsuario.username() + ").");
		
		Estudante estudante = estudanteReadService.buscarPorUsername(possivelUsuario.username()).get();
		
		if(possivelUsuario.senha().equals(estudante.getSenha()))
			return estudante;
		else
			throw new AutenticacaoException("Senha incorreta (username = " + estudante.getUsername() + ").");
	}
	
	public Usuario cadastrarEstudante(UsuarioCadastro possivelUsuario) throws AutenticacaoException {
		if(usuarioExisteComUsername(possivelUsuario.username()))
			throw new AutenticacaoException("O nome de usuário \"" + possivelUsuario.username() + "\" já é usado.");
		
		if(!possivelUsuario.senha().equals(possivelUsuario.senhaConfirmada())) // só no front?
			throw new AutenticacaoException("A senha não foi confirmada corretamente (username = " + possivelUsuario.username() + ").");
		
		String nomeValidado = possivelUsuario.nome() == null ? null : (possivelUsuario.nome().isBlank() ? null : possivelUsuario.nome());
		
		Estudante novoEstudante = new Estudante(possivelUsuario.username(), possivelUsuario.senha(), nomeValidado);
		
		return estudanteCreateAndUpdateService.salvarOuAtualizar(novoEstudante);
	}
	
}
