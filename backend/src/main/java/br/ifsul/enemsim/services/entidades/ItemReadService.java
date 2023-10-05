package br.ifsul.enemsim.services.entidades;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifsul.enemsim.entidades.Item;
import br.ifsul.enemsim.repositories.ItemRepository;
import br.ifsul.enemsim.services.entidades.interfaces.ReadService;

@Service
public class ItemReadService implements ReadService<Item, Integer> {

	@Autowired
	private ItemRepository itemRepository;
	
	@Override
	public List<Item> listar() {
		return itemRepository.findAll();
	}

	@Override
	public Optional<Item> buscarPorId(Integer id) {
		return itemRepository.findById(id);
	}

}
