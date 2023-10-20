package br.ifsul.enemsim.controllers.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifsul.enemsim.domain.Item;
import br.ifsul.enemsim.services.domain.ItemCreateAndUpdateService;
import br.ifsul.enemsim.services.domain.ItemReadService;

@RestController
@RequestMapping("/item")
@CrossOrigin(origins = "*")
public class ItemController {
	
	@Autowired
	private ItemReadService itemReadService;
	
	@GetMapping
	public List<Item> listar() {
		return itemReadService.listar();
	}
	
	@GetMapping("/{id}")
	public Item buscarPorId(@PathVariable Integer id) {
		return itemReadService.buscarPorId(id).get();
	}
	
//	@GetMapping("/separados")
//	public List<List<List<Integer>>> itensSeparados() { // temp
//		List<List<List<Integer>>> retorno = new ArrayList<>();
//		
//		for(byte i = 1; i <= 10; i++) {
//			List<List<Item>> itensDivididos = itemReadService.itensDivididosPelosMedianos(new Habilidade(i));
//			
//			List<List<Integer>> itensDivididosIds = new ArrayList<>();
//			
//			for(List<Item> itensDivisao : itensDivididos) {
//				List<Integer> itensDivisaoIds = new ArrayList<>();
//				
//				for(Item item : itensDivisao) {
//					itensDivisaoIds.add(item.getId());
//				}
//				
//				itensDivididosIds.add(itensDivisaoIds);
//			}
//			
//			retorno.add(itensDivididosIds);
//		}
//		
//		return retorno;
//	}
	
	@Autowired
	private ItemCreateAndUpdateService itemCreateAndUpdateService;
	
	@PostMapping("/save") // ""?
	public Item salvarOuAtualizar(@RequestBody Item item) {
		return itemCreateAndUpdateService.salvarOuAtualizar(item);
	}
	
	// saveAll
	
}
