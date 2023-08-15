package br.ifsul.enemsim.gerador;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ifsul.enemsim.entidades.Item;
import br.ifsul.enemsim.entidades.Simulado;
import br.ifsul.enemsim.entidades.SimuladoItem;
import br.ifsul.enemsim.exceptions.DadosInsuficientesException;
import br.ifsul.enemsim.repositories.ItemRepository;

@Component
public class GeradorSimulados { // ""? "Gerador"? // testar
	
	@Autowired
	private ItemRepository itemRepository;

	private Set<Item> selecionarItens(int quantidade, List<Item> /*Set?*/ itens) throws DadosInsuficientesException {
		if(quantidade > itens.size())
			throw new DadosInsuficientesException("O banco de dados não possui itens o suficiente para selecionar a quantidade especificada.");
			// ou fazer outra coisa
		
		Set<Item> itensSelecionados = new HashSet<>();
		
		Random random = new Random();
		
		while(itensSelecionados.size() < quantidade) { // pode rodar pra sempre? se não houverem questões diferentes o suficiente no banco...
			itensSelecionados.add(itens.get(random.nextInt(itens.size())));
		}
		
		return itensSelecionados;
	}
	
	private Set<Item> selecionarItensPorQuantidadeOuMaximo(int quantidade, List<Item> itens) { // não oficial (na aplicação, ter algo que trate melhor as exceções, que dê opções ao usuário)
		try {
			if(quantidade <= itens.size())
				return selecionarItens(quantidade, itens);
			else
				return selecionarItens(quantidade, itens);
		} catch (DadosInsuficientesException e) {
			try {
				return selecionarItens(itens.size(), itens);
			} catch (DadosInsuficientesException e1) {
				e1.printStackTrace();
				return null;
			}
		}
	}
	
	private Set<SimuladoItem> relacionarSimuladoItem(Simulado simulado, Set<Item> itens) {
		Set<SimuladoItem> itensSimulado = new HashSet<>(); // ""?
		
		for(Item item : itens)
			itensSimulado.add(SimuladoItem.builder().simulado(simulado).item(item).build());
		
		return itensSimulado;
	}
	
	private Simulado gerarSimulado(Set<Item> itens) { // ""?
		Simulado simulado = new Simulado();
		
		Set<SimuladoItem> itensSimulado = relacionarSimuladoItem(simulado, itens);
		
		return Simulado.builder().itens(itensSimulado).build();
	}
	
	// save já nos gerar? não sei...
	
	// passando o estudante
	
	public Simulado gerar/*Simulado?*/(int quantidade) { // retornar somente o set de questões? para poder juntar diferentes gerações
		List<Item> itensBD = itemRepository.findAll(); // ""?
		
		return gerarSimulado(selecionarItensPorQuantidadeOuMaximo(quantidade, itensBD));
	}
	
}
