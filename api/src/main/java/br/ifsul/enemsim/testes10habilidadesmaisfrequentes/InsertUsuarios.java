package br.ifsul.enemsim.testes10habilidadesmaisfrequentes;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ifsul.enemsim.domain.usuarios.Estudante;
import br.ifsul.enemsim.repositories.usuarios.UsuarioRepository;
import jakarta.annotation.PostConstruct;

@Component
public class InsertUsuarios {

	@Autowired
	private UsuarioRepository usuarioRepository;
		
	@PostConstruct
	public void run() {
		if(usuarioRepository.count() == 0) {
			
			Set<Estudante> projetistas = new LinkedHashSet<>();
			projetistas.add(new Estudante("joaoguiss", "enemsimjoao", "João Guilherme Severo Schröer"));
			projetistas.add(new Estudante("pedromn", "pedrok", "Pedro Müller Nunes"));
			projetistas.add(new Estudante("roberto", "roberto", "Roberto Maurício Bokowski Sobrinho"));
			projetistas.add(new Estudante("monica", "monica", "Mônica Xavier Py"));

			Set<Estudante> outros = new LinkedHashSet<>();
			outros.add(new Estudante("user01", "111111", null));
			
			usuarioRepository.saveAll(projetistas);
			usuarioRepository.saveAll(outros);
			
		}
	}

}
