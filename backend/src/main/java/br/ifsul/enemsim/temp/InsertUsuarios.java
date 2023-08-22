package br.ifsul.enemsim.temp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ifsul.enemsim.entidades.Usuario;
import br.ifsul.enemsim.entidades.perfis.Estudante;
import br.ifsul.enemsim.repositories.UsuarioRepository;
import jakarta.annotation.PostConstruct;

@Component
public class InsertUsuarios {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PostConstruct
	public void run() {
		usuarioRepository.save(new Usuario("pedromn", "123", "Pedro", new Estudante()));
		usuarioRepository.save(new Usuario("joaoguiss", "123", "João", new Estudante()));
		usuarioRepository.save(new Usuario("MonicaPy", "123", "Mônica", null));
		usuarioRepository.save(new Usuario("Ping Pong Robert", "123", "Roberto", null));
	}
	
}
