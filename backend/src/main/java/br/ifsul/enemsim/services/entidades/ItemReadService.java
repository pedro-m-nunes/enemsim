package br.ifsul.enemsim.services.entidades;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifsul.enemsim.entidades.Habilidade;
import br.ifsul.enemsim.entidades.Item;
import br.ifsul.enemsim.entidades.usuarios.Estudante;
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
	
	public List<Item> pegarItensPorHabilidade(Habilidade habilidade) {
		return itemRepository.findByHabilidade(habilidade);
	}
	
	public List<Item> pegarItensOrdenadosPorDificuldade(Habilidade habilidade) {
		return itemRepository.findByHabilidadeOrderByDificuldade(habilidade);
	}
	
	public List<Item> pegarItensDoConjuntoAusentesEmOutrosSimuladosDoEstudante(Iterable<Item> conjuntoItens, Estudante estudante) { // ""?
		return new ArrayList<>(new LinkedHashSet<>(itemRepository.getItensDoConjuntoNaoPresentesEmOutrosSimuladosDoEstudante(conjuntoItens, estudante)));
	}
	
	private List<List<Item>> itensDivididosPelosMedianos(Habilidade habilidade) { // private?
		List<Item> itens = pegarItensOrdenadosPorDificuldade(habilidade);
		
		int posicaoMediana = itens.size() / 2; // Arredondando para cima. Para baixo: tamanhoLista / 2 - (1 - tamanhoLista % 2).
		
		List<Item> itensAbaixo = itens.subList(0, posicaoMediana - 1);
		List<Item> itensMedianos = Arrays.asList(new Item[] {itens.get(posicaoMediana - 1), itens.get(posicaoMediana), itens.get(posicaoMediana + 1)});
		List<Item> itensAcima = itens.subList(posicaoMediana + 2, itens.size());
		
		List<List<Item>> itensSeparados = new ArrayList<>();
		
		itensSeparados.add(itensAbaixo);
		itensSeparados.add(itensMedianos);
		itensSeparados.add(itensAcima);
		
		return itensSeparados;
	}
	
	public List<Item> itensAbaixoDosMedianos(Habilidade habilidade) {
		return itensDivididosPelosMedianos(habilidade).get(0);
	}
	
	public List<Item> itensMedianos(Habilidade habilidade) {
		return itensDivididosPelosMedianos(habilidade).get(1);
	}
	
	public List<Item> itensAcimaDosMedianos(Habilidade habilidade) {
		return itensDivididosPelosMedianos(habilidade).get(2);
	}

}
