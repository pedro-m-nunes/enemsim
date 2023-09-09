//package br.ifsul.enemsim.tempnot;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import br.ifsul.enemsim.entidades.relacionais.ProvaItem;
//import br.ifsul.enemsim.repositories.entidadesrelacionais.ProvaItemRepository;
//
//@RestController
//@RequestMapping("/provaitem")
//public class ProvaItemController {
//
//	@Autowired
//	private ProvaItemRepository provaItemRepository;
//	
//	@GetMapping
//	public List<ProvaItem> findAll() {
//		return provaItemRepository.findAll();
//	}
//	
//	@GetMapping("/{id}")
//	public ProvaItem findById(@PathVariable Integer id) {
//		return provaItemRepository.findById(id).get();
//	}
//	
//	@PostMapping("/save") // ""?
//	public ProvaItem save(@RequestBody ProvaItem provaItem) {
//		return provaItemRepository.save(provaItem);
//	}
//	
//	// saveAll
//	
//}
