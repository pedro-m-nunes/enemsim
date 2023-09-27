//package br.ifsul.enemsim.temp.teste10habilidadesmaisfrequentes;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import br.ifsul.enemsim.entidades.usuarios.Administrador;
//import br.ifsul.enemsim.entidades.usuarios.Estudante;
//import br.ifsul.enemsim.entidades.usuarios.Professor;
//import br.ifsul.enemsim.repositories.UsuarioRepository;
//import jakarta.annotation.PostConstruct;
//
//@Component
//public class InsertUsuariosDoProjeto {
//
//	@Autowired
//	private UsuarioRepository usuarioRepository;
//
//	@PostConstruct
//	public void run() {
//		// if administradorRepository.count() == 0 ... ? // se não existem esses usuários...?
//		usuarioRepository.save(new Administrador(USUARIO, SENHA, "Pedro Müller Nunes"));
//		usuarioRepository.save(new Administrador(USUARIO, SENHA, "João Guilherme Severo Schröer"));
//		
//		usuarioRepository.save(new Estudante(USUARIO, SENHA, "Pedro Müller Nunes"));
//		usuarioRepository.save(new Estudante(USUARIO, SENHA, "João Guilherme Severo Schröer"));
//		
//		usuarioRepository.save(new Professor(USUARIO, SENHA, "Roberto Maurício Bokowski Sobrinho"));
//		usuarioRepository.save(new Professor(USUARIO, SENHA, "Mônica Xavier Py"));
//	}
//
//}
