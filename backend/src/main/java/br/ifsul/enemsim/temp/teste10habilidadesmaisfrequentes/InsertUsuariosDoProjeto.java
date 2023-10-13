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
//		// if administradorReadService.count() == 0 ... ?
//		usuarioRepository.save(new Administrador("pedro", SENHA, "Pedro Müller Nunes"));
//		usuarioRepository.save(new Administrador("joao", SENHA, "João Guilherme Severo Schröer"));
//		
//		// se não existem estudantes com esse nome?
//		usuarioRepository.save(new Estudante("080250infq", SENHA, "Pedro Müller Nunes"));
//		usuarioRepository.save(new Estudante(MATRICULA, SENHA, "João Guilherme Severo Schröer"));
//		
//		// if professorReadService.count() == 0 ... ?
//		usuarioRepository.save(new Professor("roberto", SENHA, "Roberto Maurício Bokowski Sobrinho"));
//		usuarioRepository.save(new Professor("monica", SENHA, "Mônica Xavier Py"));
//	}
//
//}
