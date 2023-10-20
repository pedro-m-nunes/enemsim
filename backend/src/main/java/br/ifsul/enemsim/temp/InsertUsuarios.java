package br.ifsul.enemsim.temp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ifsul.enemsim.domain.usuarios.Administrador;
import br.ifsul.enemsim.domain.usuarios.Estudante;
import br.ifsul.enemsim.domain.usuarios.Professor;
import br.ifsul.enemsim.repositories.UsuarioRepository;
import jakarta.annotation.PostConstruct;

@Component
public class InsertUsuarios {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@PostConstruct
	public void run() { // tirar quando teste10habilidadesmaisfrequentes tiver insertUsuarios...
		usuarioRepository.save(new Estudante("pedromn", "123456", "Pedro"));
		usuarioRepository.save(new Administrador("ademirP", "654321", "Pedro"));
		usuarioRepository.save(new Estudante("joaoguiss", "123456", "João"));
		usuarioRepository.save(new Administrador("ademirJ", "654321", "João"));
		usuarioRepository.save(new Professor("MonicaPy", "123456", "Mônica"));
		usuarioRepository.save(new Professor("Ping Pong Robert", "123456", "Roberto"));
	}

}
