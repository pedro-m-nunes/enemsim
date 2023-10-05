package br.ifsul.enemsim.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifsul.enemsim.entidades.Item;
import br.ifsul.enemsim.services.entidades.ItemCreateAndUpdateService;
import br.ifsul.enemsim.services.entidades.ItemReadService;

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
	
	@Autowired
	private ItemCreateAndUpdateService itemCreateAndUpdateService;
	
	@PostMapping("/save") // ""?
	public Item salvarOuAtualizar(@RequestBody Item item) {
		return itemCreateAndUpdateService.salvarOuAtualizar(item);
	}
	
	// saveAll
	
}
