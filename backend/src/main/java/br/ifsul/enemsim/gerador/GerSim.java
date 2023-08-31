package br.ifsul.enemsim.gerador;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ifsul.enemsim.entidades.Item;
import br.ifsul.enemsim.entidades.Simulado;
import br.ifsul.enemsim.entidades.relacionais.SimuladoItem;
import br.ifsul.enemsim.exceptions.DadosInsuficientesException;
import br.ifsul.enemsim.repositories.ItemRepository;
import br.ifsul.enemsim.repositories.SimuladoRepository;
import br.ifsul.enemsim.repositories.entidadesrelacionais.SimuladoItemRepository;

@Component
// ao invés de inserir no banco, retornar Map (ou classe própria)? (para inserir em um service/controller)
// acho que precisa de ajustes...
public class GerSim { // ""?
	
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
		
		// transformar List em Set?
		
		Set<Item> itensSelecionados = new LinkedHashSet<>();
		
		Random random = new Random();
		
		while(itensSelecionados.size() < quantidade) { // pode rodar pra sempre? se não houverem questões diferentes o suficiente no banco... (Set como parâmetro resolveria?)
			itensSelecionados.add(itens.get(random.nextInt(itens.size())));
		}
		
		return itensSelecionados;
	}
	
//	private Set<Item> selecionarItensPorQuantidadeOuMaximo(int quantidade, List<Item> itens) { // não oficial (na aplicação, ter algo que trate melhor as exceções, que dê opções ao usuário)
//		try {
//			if(quantidade <= itens.size())
//				return selecionarItens(quantidade, itens);
//			else
//				return selecionarItens(quantidade, itens);
//		} catch (DadosInsuficientesException e) {
//			try {
//				return selecionarItens(itens.size(), itens);
//			} catch (DadosInsuficientesException e1) {
//				e1.printStackTrace();
//				return null;
//			}
//		}
//	}
	
	// GERAÇÃO
	
	private List<SimuladoItem> gerarSimulado(/*coisas para instanciar simulado, ou o próprio simulado*/ Set<Item> itensSelecionados) {
		Simulado simulado = simuladoRepository.save(new Simulado()); // parâmetros/atributos
		
		Set<SimuladoItem> simuladoItens = new LinkedHashSet<>();
		
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
		
		if(filtro.getHabilidade() == null) // considerar os casos de dificuldade null ao invés de atribuir um valor padrão? (baixa prioridade, funciona assim)
			itensBanco = itemRepository.findByDificuldadeBetween(filtro.getDificuldadeMin(), filtro.getDificuldadeMax());
		else
			itensBanco = itemRepository.findByHabilidadeAndDificuldadeBetween(filtro.getHabilidade(), filtro.getDificuldadeMin(), filtro.getDificuldadeMax());
		
		return selecionarItens(quantidade, itensBanco);
	}
	
	public List<SimuladoItem> gerarSimulado(Distribuicao distribuicao) throws DadosInsuficientesException {
		if(distribuicao == null)
			throw new IllegalArgumentException("Uma distribuição nula não pode ser usada para gerar um simulado."); // exception própria?
		
		Set<Item> itensSelecionados = new LinkedHashSet<>();
		
		for(int i = 0; i < distribuicao.size(); i++) {
			itensSelecionados.addAll(selecionarItens(distribuicao.getQuantidades()[i], distribuicao.getFiltros()[i]));
		}
		
		return gerarSimulado(itensSelecionados);
	}
	
	// passando filtro(s) e quantidade(s)?
	
	// passando o estudante
	
	// como atributos do gerador ou parâmetros dos métodos?
	// usarItensAnulados = false => findByRespostaNotNull()
	// usarItensJaRespondidos = false => findByIdNotIn(jaRespondidos)
	
}
