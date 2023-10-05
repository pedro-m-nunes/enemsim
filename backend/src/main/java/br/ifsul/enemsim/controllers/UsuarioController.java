package br.ifsul.enemsim.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifsul.enemsim.entidades.Usuario;
import br.ifsul.enemsim.services.UsuarioReadService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {

	@Autowired
	private UsuarioReadService usuarioReadService;
	
	@GetMapping
	public List<Usuario> listar() {
		return usuarioReadService.listar();
	}
	
	@GetMapping("/{id}")
	public Usuario buscarPorId(@PathVariable Integer id) {
		return usuarioReadService.buscarPorId(id).get();
	}
	
	// autenticar, registrar... (?)
	
}
