package br.ifsul.enemsim.temp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifsul.enemsim.entidades.Habilidade;
import br.ifsul.enemsim.entidades.Item;
import br.ifsul.enemsim.entidades.Simulado;
import br.ifsul.enemsim.entidades.SimuladoItem;
import br.ifsul.enemsim.repositories.HabilidadeRepository;
import br.ifsul.enemsim.repositories.ItemRepository;
import br.ifsul.enemsim.repositories.SimuladoItemRepository;
import br.ifsul.enemsim.repositories.SimuladoRepository;

@RestController
@RequestMapping("/select")
public class Select {

	@Autowired
	private HabilidadeRepository habilidadeRepository;
	
	@GetMapping("/habilidades")
	public List<Habilidade> habilidades() {
		return habilidadeRepository.findAll();
	}
	
	@GetMapping("/habilidade={id}")
	public Habilidade habilidade(@PathVariable Integer id) {
		return habilidadeRepository.findById(id).get();
	}
	
	@Autowired
	private ItemRepository itemRepository;
	
	@GetMapping("/itens")
	public List<Item> itens() {
		return itemRepository.findAll();
	}
	
	@GetMapping("/item={id}")
	public Item item(@PathVariable Integer id) {
		return itemRepository.findById(id).get();
	}
	
	@Autowired
	private SimuladoRepository simuladoRepository;
	
	@GetMapping("/simulados")
	public List<Simulado> simulados() {
		return simuladoRepository.findAll();
	}
	
	@GetMapping("/simulado={id}")
	public Simulado simulado(@PathVariable Integer id) {
		return simuladoRepository.findById(id).get();
	}
	
	@Autowired
	private SimuladoItemRepository simuladoItemRepository;
	
	@GetMapping("/simuladoitens")
	public List<SimuladoItem> simuladoItens() {
		return simuladoItemRepository.findAll();
	}
	
	// SimuladoItem byId
	
}
