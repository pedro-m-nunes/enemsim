package br.ifsul.enemsim.services.entidades;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifsul.enemsim.entidades.Item;
import br.ifsul.enemsim.repositories.ItemRepository;
import br.ifsul.enemsim.services.entidades.interfaces.CreateAndUpdateService;

@Service
public class ItemCreateAndUpdateService implements CreateAndUpdateService<Item, Integer> {

	@Autowired
	private ItemRepository itemRepository;
	
	@Override
	public Item salvarOuAtualizar(Item entidade) {
		return itemRepository.save(entidade);
	}

	@Override
	public List<Item> salvarOuAtualizarTodos(Iterable<Item> entidades) {
		return itemRepository.saveAll(entidades);
	}

}
