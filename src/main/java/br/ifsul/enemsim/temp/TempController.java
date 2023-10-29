//package br.ifsul.enemsim.temp;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import br.ifsul.enemsim.repositories.SimuladoRepository;
//import br.ifsul.enemsim.repositories.usuarios.UsuarioRepository;
//
//@RestController
//@RequestMapping("/temp")
//public class TempController {
//
//	@Autowired
//	private UsuarioRepository usuarioRepository;
//	
//	@Autowired
//	private SimuladoRepository simuladoRepository;
//	
//	@GetMapping("/{id}")
//	public Object teste(@PathVariable int id) {
//		return simuladoRepository.getItensAcertados(id);
//	}
//	
//}
