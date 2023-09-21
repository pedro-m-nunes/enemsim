package br.ifsul.enemsim.gerador;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ifsul.enemsim.entidades.Habilidade;
import br.ifsul.enemsim.entidades.Item;
import br.ifsul.enemsim.entidades.Simulado;
import br.ifsul.enemsim.entidades.usuarios.Estudante;
import br.ifsul.enemsim.exceptions.DadosInsuficientesException;
import br.ifsul.enemsim.repositories.ItemRepository;

@Component
@Deprecated
public class GerSimAntigo { // ""?
	
	// boolean usaItensFeitos?
	
	// como atributos do gerador ou parâmetros dos métodos?
	// usarItensAnulados = false => findByRespostaNotNull()
	// usarItensJaRespondidos = false => findByIdNotIn(jaRespondidos)
	
	@Autowired // ?
	private ItemRepository itemRepository; // controller?
	
	// Método que gera o Simulado, chamando os demais métodos.
	public SimuladoGerado gerarSimulado(Estudante estudante, Distribuicao distribuicao) throws DadosInsuficientesException { // ? // (estudante, adaptacao)
		return distribuirItens(estudante, distribuicao);
	}
	
	// Seleciona todos os itens, com base na Distribuicao informada.
	private SimuladoGerado distribuirItens(Estudante estudante, Distribuicao distribuicao) throws DadosInsuficientesException {
		if(distribuicao == null)
			throw new IllegalArgumentException("Uma distribuição nula não pode ser usada para gerar um simulado."); // exception própria?
		
		Set<Item> itensSelecionados = new LinkedHashSet<>();
		
		for(int i = 0; i < distribuicao.size(); i++) {
			itensSelecionados.addAll(filtrarItens(estudante, distribuicao.getQuantidades()[i], distribuicao.getFiltros()[i]));
		}
		
		return instanciarSimulado(estudante, itensSelecionados);
	}
	
	// Seleciona o banco de itens a partir de um Filtro.
	private Set<Item> filtrarItens(Estudante estudante, int quantidade, Filtro filtro) throws DadosInsuficientesException {
		if(filtro == null)
			return selecionarItens(quantidade, new LinkedHashSet<>(itemRepository.findAll()));
		
		List<Item> itensBanco;
		
		Habilidade habilidade = filtro.getHabilidade();
		BigDecimal dificuldadeMin = filtro.getDificuldadeMin();
		BigDecimal dificuldadeMax = filtro.getDificuldadeMax();
		
		// usar estudante em todos!
		
		// que horror... (mas não sei como fazer de outra forma)
		if(habilidade != null) // Vxx
			if(dificuldadeMin != null) // VVx
				if(dificuldadeMax != null) // VVV
					itensBanco = itemRepository.findByHabilidadeAndDificuldadeBetween(habilidade, dificuldadeMin, dificuldadeMax);
				else // VVF
					itensBanco = itemRepository.findByHabilidadeAndDificuldadeGreaterThanEqual(habilidade, dificuldadeMin);
			else // VFx
				if(dificuldadeMax != null) // VFV
					itensBanco = itemRepository.findByHabilidadeAndDificuldadeLessThanEqual(habilidade, dificuldadeMax);
				else // VFF
					itensBanco = itemRepository.findByHabilidade(habilidade);
		else // Fxx
			if(dificuldadeMin != null) // FVx
				if(dificuldadeMax != null) // FVV
					itensBanco = itemRepository.findByDificuldadeBetween(dificuldadeMin, dificuldadeMax);
				else // FVF
					itensBanco = itemRepository.findByDificuldadeGreaterThanEqual(dificuldadeMin);
			else // FFx
				if(dificuldadeMax != null) // FFV
					itensBanco = itemRepository.findByDificuldadeLessThanEqual(dificuldadeMax);
				else // FFF
					itensBanco = itemRepository.findAll();
		
		// itens válidos
		// itens já/não feitos
		
		return selecionarItens(quantidade, new LinkedHashSet<>(itensBanco));
	}

	// Seleciona aleatoriamente os itens que irão para o Simulado, a partir de um conjunto informado.
	private Set<Item> selecionarItens(int quantidade, Set<Item> itens) throws DadosInsuficientesException {
		if(quantidade <= 0)
			throw new IllegalArgumentException("Não se pode gerar um simulado com menos de um item."); // exception própria?
		
		if(itens == null)
			throw new IllegalArgumentException("Não há como selecionar itens de uma lista nula."); // exception própria?
		
		// itens not in estudante.feitos?
		
		if(quantidade > itens.size())
			throw new DadosInsuficientesException("O banco de dados não possui itens o suficiente para selecionar a quantidade especificada.");
		
		Set<Item> itensSelecionados = new LinkedHashSet<>();
		
		List<Item> itensList = new ArrayList<>(itens);
		
		Random random = new Random();
		
		while(itensSelecionados.size() < quantidade) { // pode rodar pra sempre? se não houverem questões diferentes o suficiente no banco... (Set como parâmetro resolve?)
			itensSelecionados.add(itensList.get(random.nextInt(itens.size())));
		}
		
		return itensSelecionados;
	}
	
	// Instancia o simulado gerado, em uma classe própria com o simulado e seus itens.
	private SimuladoGerado instanciarSimulado(Estudante estudante, Set<Item> itensSelecionados) { // "instanciar"?
		Simulado simulado = new Simulado(estudante); /*coisas para instanciar simulado, ou o próprio simulado*/ // parâmetros/atributos
		
		return new SimuladoGerado(simulado, itensSelecionados);
	}
		
//	public SimuladoGerado gerarSimuladoPadronizado(/*Estudante estudante*/) {
//		// selecionar um item aleatório entre os três mais próximos da mediana da dificuldade, de cada uma das 10 habilidades mais frequentes, que o estudante não tenha feito ainda.
//		// eventualmente, todos os estudante irão responder a estes três itens, a aleatorização é para que os simulados não sejam iguais.
//		
//		// pegar os itens por habilidade, calcular a mediana, pegar os três itens mais próximos (com um arredondamento padrão)
//		// vetor com os três itens selecionados de cada habilidade : List<Item>[] itensHabilidade
//		
//		// for(itens : itensHabilidade) itensSelecionados.add(itens.get(random.nextInt))
//		// return new SimuladoGerado()
//	}
	
}
//private Set<Item> selecionarItensPorQuantidadeOuMaximo(int quantidade, List<Item> itens) { // não oficial (na aplicação, ter algo que trate melhor as exceções, que dê opções ao usuário)
//try {
//	if(quantidade <= itens.size())
//		return selecionarItens(quantidade, itens);
//	else
//		return selecionarItens(quantidade, itens);
//} catch (DadosInsuficientesException e) {
//	try {
//		return selecionarItens(itens.size(), itens);
//	} catch (DadosInsuficientesException e1) {
//		e1.printStackTrace();
//		return null;
//	}
//}
//}
