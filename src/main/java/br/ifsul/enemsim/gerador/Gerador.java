package br.ifsul.enemsim.gerador;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ifsul.enemsim.entidades.Habilidade;
import br.ifsul.enemsim.entidades.Item;
import br.ifsul.enemsim.entidades.Simulado;
import br.ifsul.enemsim.entidades.SimuladoItem;
import br.ifsul.enemsim.exceptions.DadosInsuficientesException;
import br.ifsul.enemsim.repositories.ItemRepository;
import br.ifsul.enemsim.repositories.SimuladoItemRepository;
import br.ifsul.enemsim.repositories.SimuladoRepository;

@Component
public class Gerador { // ""?
	
	// boolean usaItemAnulado, boolean usaItemJaRespondido (por estudante)
	
	@Autowired
	private SimuladoRepository simuladoRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private SimuladoItemRepository simuladoItemRepository;

	private Set<Item> selecionarItens(int quantidade, List<Item> /*Set?*/ itens) throws DadosInsuficientesException {
		if(quantidade <= 0)
			throw new IllegalArgumentException("Não se pode gerar um simulado com menos de um item."); // exception própria?
		
		if(itens == null)
			throw new IllegalArgumentException("Não há como selecionar itens de uma lista nula."); // exception própria?
		
		if(quantidade > itens.size())
			throw new DadosInsuficientesException("O banco de dados não possui itens o suficiente para selecionar a quantidade especificada.");
			// ou fazer outra coisa
		
		Set<Item> itensSelecionados = new HashSet<>();
		
		Random random = new Random();
		
		while(itensSelecionados.size() < quantidade) { // pode rodar pra sempre? se não houverem questões diferentes o suficiente no banco... (Set como parâmetro resolveria?)
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
	
	// GERAÇÃO
	
	private List<SimuladoItem> gerarSimulado(/*para instanciar simulado, ou o próprio simulado*/ Set<Item> itensSelecionados) {
		Simulado simulado = simuladoRepository.save(new Simulado()); // parâmetros/atributos
		
		Set<SimuladoItem> simuladoItens = new HashSet<>(); // Set? List?
		
		for(Item item : itensSelecionados)
			simuladoItens.add(new SimuladoItem(simulado, item));
		
		return simuladoItemRepository.saveAll(simuladoItens);
	}
	
	public List<SimuladoItem> gerarSimulado(int quantidade) throws DadosInsuficientesException {
		return gerarSimulado(selecionarItens(quantidade, itemRepository.findAll()));
	}
	
	// USANDO FILTROS
	
	private Set<Item> selecionarItens(int quantidade, Filtro filtro) throws DadosInsuficientesException {
		List<Item> itensBanco;
		
		Habilidade habilidade = filtro.getHabilidade();
		BigDecimal dificuldadeMinima = filtro.getDificuldadeMinima() != null ? filtro.getDificuldadeMinima() : BigDecimal.valueOf(-Double.MAX_VALUE); // desempenho?
		BigDecimal dificuldadeMaxima = filtro.getDificuldadeMaxima() != null ? filtro.getDificuldadeMaxima() : BigDecimal.valueOf(Double.MAX_VALUE); // desempenho?
		
		// dá pra mehorar...
		if(filtro.isNull())
			throw new IllegalArgumentException("Um filtro totalmente nulo não pode ser usado para selecionar itens.");
		else
			itensBanco = itemRepository.findByHabilidadeAndDificuldadeBetween(habilidade, dificuldadeMinima, dificuldadeMaxima);
		
		return selecionarItens(quantidade, itensBanco);
	}
	
	public List<SimuladoItem> gerarSimulado(Distribuicao distribuicao) throws DadosInsuficientesException {
		Set<Item> itensSelecionados = new HashSet<>();
		
		for(int i = 0; i < distribuicao.size(); i++) {
			itensSelecionados.addAll(selecionarItens(distribuicao.getQuantidades()[i], distribuicao.getFiltros()[i]));
		}
		
		// embaralhar? aparentemente não precisa
		
		return gerarSimulado(itensSelecionados);
	}
	
	// passando o estudante
	
}
