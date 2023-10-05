package br.ifsul.enemsim.services.entidades;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifsul.enemsim.entidades.Usuario;
import br.ifsul.enemsim.repositories.UsuarioRepository;
import br.ifsul.enemsim.services.entidades.interfaces.ReadService;
	
@Service
public class UsuarioReadService implements ReadService<Usuario, Integer> {

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
	
}
