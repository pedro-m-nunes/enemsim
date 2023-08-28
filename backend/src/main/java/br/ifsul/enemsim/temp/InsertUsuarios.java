package br.ifsul.enemsim.temp;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ifsul.enemsim.entidades.Usuario;
import br.ifsul.enemsim.entidades.perfis.Estudante;
import br.ifsul.enemsim.repositories.UsuarioRepository;
import jakarta.annotation.PostConstruct;

@Component
public class InsertUsuarios { // mover para test?

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PostConstruct
	public void run() {
		Set<Usuario> usuarios = new LinkedHashSet<>();
		
		usuarios.add(new Usuario("pedromn", "123", "Pedro", new Estudante()));
		usuarios.add(new Usuario("joaoguiss", "123", "João", new Estudante()));
		usuarios.add(new Usuario("MonicaPy", "123", "Mônica", null));
		usuarios.add(new Usuario("Ping Pong Robert", "123", "Roberto", null));
		
		usuarioRepository.saveAll(usuarios);
	}
	
}
