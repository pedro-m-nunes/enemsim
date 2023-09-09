package br.ifsul.enemsim.temp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifsul.enemsim.entidades.perfis.Estudante;
import br.ifsul.enemsim.repositories.ItemRepository;

@RestController
@RequestMapping("/temp")
public class TempController {
	
	@Autowired
	private ItemRepository itemRepository;
	
	@GetMapping("/itensnaoacertados/estudante={id}")
	public int getItensNaoAcertadosPorEstudante(@PathVariable Integer id) {
		return itemRepository.getItensNaoAcertadosPorEstudante(new Estudante(id)).size();
	}

}
