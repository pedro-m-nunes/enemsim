package br.ifsul.enemsim.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifsul.enemsim.entidades.Usuario;
import br.ifsul.enemsim.entidades.usuarios.Administrador;
import br.ifsul.enemsim.entidades.usuarios.Estudante;
import br.ifsul.enemsim.entidades.usuarios.Professor;
import br.ifsul.enemsim.repositories.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Usuario findById(@PathVariable Integer id) {
		return usuarioRepository.findById(id).get();
	}
	
//	@GetMapping("/teste")
//	public Object teste() {
//		Estudante e1 = new Estudante("Estudador", "123", "E");
//		Estudante e2 = new Estudante("Estudador", "123", "E");
//		
//		Administrador a1 = new Administrador("Estudador", "123", "E");
//		Administrador a2 = new Administrador("Estudador", "123", "E");
//		
//		Professor p1 = new Professor("Estudador", "123", "E");
//		Professor p2 = new Professor("Estudador", "123", "E");
//		
//		return new boolean[] {
//				p1.equals(e2), p1.equals(a2), p1.equals(p2)
//		};
//	}
	
	// autenticar, registrar...
	
}
