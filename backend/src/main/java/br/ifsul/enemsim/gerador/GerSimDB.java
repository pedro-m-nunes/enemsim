package br.ifsul.enemsim.gerador;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ifsul.enemsim.entidades.Habilidade;
import br.ifsul.enemsim.entidades.Item;
import br.ifsul.enemsim.entidades.relacionais.EstudanteHabilidade;
import br.ifsul.enemsim.entidades.usuarios.Estudante;
import br.ifsul.enemsim.repositories.HabilidadeRepository;
import br.ifsul.enemsim.repositories.ItemRepository;
import br.ifsul.enemsim.repositories.relacionais.EstudanteHabilidadeRepository;

@Component
public class GerSimDB {

	@Autowired // ?
	private ItemRepository itemRepository; // controller? service?
	
	@Autowired
	private HabilidadeRepository habilidadeRepository; // controller? service?
	
	@Autowired
	private EstudanteHabilidadeRepository estudanteHabilidadeRepository; // controller? service?
	
	List<Habilidade> habilidades() {
		return habilidadeRepository.findAll(); // findAll por enquanto ok // findByIdIn...
	}
	
	List<Item> pegarItensOrdenadosPorDificuldade(Habilidade habilidade) {
		return itemRepository.findByHabilidadeOrderByDificuldade(habilidade);
	}
	
	List<Item> retirarItensJaPresentesEmOutrosSimulados(Iterable<Item> conjuntoItens, Estudante estudante) { // ""?
		return new ArrayList<>(new LinkedHashSet<>(itemRepository.getItensDoConjuntoNaoPresentesEmOutrosSimuladosDoEstudante(conjuntoItens, estudante)));
	}
	
	EstudanteHabilidade getEstudanteHabilidade(Estudante estudante, Habilidade habilidade) { // ""? // talvez de outro jeito, outros parâmetros...
		return estudanteHabilidadeRepository.findByEstudanteAndHabilidade(estudante, habilidade).get();
	}
	
}
