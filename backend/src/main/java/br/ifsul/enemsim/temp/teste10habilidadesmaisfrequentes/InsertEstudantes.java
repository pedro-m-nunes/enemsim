//package br.ifsul.enemsim.temp.teste10habilidadesmaisfrequentes;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import br.ifsul.enemsim.entidades.usuarios.Estudante;
//import br.ifsul.enemsim.repositories.UsuarioRepository;
//import br.ifsul.enemsim.repositories.usuarios.EstudanteRepository;
//import jakarta.annotation.PostConstruct;
//
//@Component
//public class InsertEstudantes {
//
//	@Autowired
//	private UsuarioRepository usuarioRepository;
//
//	@Autowired
//	private EstudanteRepository estudanteRepository;
//	
//	@PostConstruct
//	public void run() {
//		if(estudanteRepository.count() == 0) {
//			usuarioRepository.save(new Estudante(MATRICULA, SENHA, NOME));
//			// ...
//		}
//	}
//
//}
