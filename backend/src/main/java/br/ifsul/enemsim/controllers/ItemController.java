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
import br.ifsul.enemsim.entidades.perfis.Estudante;
import br.ifsul.enemsim.repositories.ItemRepository;

@RestController
@RequestMapping("/item")
@CrossOrigin(origins = "*")
public class ItemController {
	
	@Autowired
	private ItemRepository itemRepository;
	
	@GetMapping
	public List<Item> findAll() {
		return itemRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Item findById(@PathVariable Integer id) {
		return itemRepository.findById(id).get();
	}
	
	@PostMapping("/save") // ""?
	public Item save(@RequestBody Item item) {
		return itemRepository.save(item);
	}
	
	// saveAll
	
	@GetMapping("/itens-nao-acertados/{estudanteId}")
	public int getItensNaoAcertadosPorEstudante(@PathVariable Integer estudanteId) {
		return itemRepository.getItensNaoAcertadosPorEstudante(new Estudante(estudanteId)).size();
	}
	
}