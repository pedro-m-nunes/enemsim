package br.ifsul.enemsim.services.domain.usuarios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifsul.enemsim.domain.usuarios.Usuario;
import br.ifsul.enemsim.repositories.usuarios.UsuarioRepository;
import br.ifsul.enemsim.services.domain.interfaces.ReadService;
import br.ifsul.enemsim.services.domain.interfaces.UsuariosReadService;
	
@Service
public class UsuarioReadService implements ReadService<Usuario, Integer>, UsuariosReadService<Usuario> {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> listar() {
		return usuarioRepository.findAll();
	}

	@Override
	public Optional<Usuario> buscarPorId(Integer id) {
		return usuarioRepository.findById(id);
	}

	@Override
	public boolean existePorUsername(String username) {
		return usuarioRepository.existsByUsername(username);
	}

	@Override
	public Optional<Usuario> buscarPorUsername(String username) {
		return usuarioRepository.findByUsername(username);
	}
	
}
