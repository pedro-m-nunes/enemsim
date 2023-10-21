package br.ifsul.enemsim.services.domain.interfaces;

import java.util.Optional;

import br.ifsul.enemsim.domain.usuarios.Usuario;

public interface UsuariosReadService<T extends Usuario> {

	public boolean existePorUsername(String username);
	
	public Optional<T> buscarPorUsername(String username);
	
}
