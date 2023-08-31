package br.ifsul.enemsim.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifsul.enemsim.entidades.Item;
import br.ifsul.enemsim.repositories.ItemRepository;

@RestController
@RequestMapping("/item")
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
	
}
