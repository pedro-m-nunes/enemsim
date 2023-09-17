package br.ifsul.enemsim.gerador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifsul.enemsim.entidades.Habilidade;
import br.ifsul.enemsim.entidades.Item;
import br.ifsul.enemsim.entidades.Simulado;
import br.ifsul.enemsim.entidades.perfis.Estudante;
import br.ifsul.enemsim.exceptions.DadosInsuficientesException;
import br.ifsul.enemsim.repositories.HabilidadeRepository;
import br.ifsul.enemsim.repositories.ItemRepository;
import br.ifsul.enemsim.repositories.SimuladoRepository;
import br.ifsul.enemsim.repositories.entidadesrelacionais.SimuladoItemRepository;

//@Component
@RestController // temp
@RequestMapping("/gersim")
public class GerSim2 {

	@Autowired // ?
	private ItemRepository itemRepository; // controller?
	
	/* SIMULADO ADAPTADO
	 * Pegar desempenho do estudante (inclui dados sobre itens já respondidos/acertados).
	 * Gerar uma distribuição adequada ao desempenho, com base também no tipo de adaptação.
	 * Selecionar os "bancos" de itens com base nos filtros da distribuição gerada.
	 * Selecionar os itens de cada "banco" aleatoriamente.
	 * Instanciar simulado.
	 */
	
	/* SIMULADO "PADRONIZADO" (DO TESTE) - padrão na distribuição ou lista de itens.
	 * Selecionar os "bancos" de itens com base no padrão.
	 * Selecionar os itens de cada "banco" aleatoriamente, desconsiderando os já feitos pelo estudante.
	 * Instanciar simulado, com dados do estudante.
	 */	
	
	// GERAR 3 SIMULADOS DE NIVELAMENTO PARA O TESTE
	
	@Autowired
	private SimuladoRepository simuladoRepository;
	
	@Autowired
	private SimuladoItemRepository simuladoItemRepository;
	
	@GetMapping("/{estudanteId}")
	public SimuladoGerado teste(@PathVariable int estudanteId) throws DadosInsuficientesException {
		SimuladoGerado simulado = gerarSimuladoDeNivelamento(new Estudante(estudanteId));
		
		simulado.save(simuladoRepository, simuladoItemRepository);
		
		return simulado;
	}
	
	@Autowired
	private HabilidadeRepository habilidadeRepository;
	
	private static final List<Byte> HABILIDADE_IDS = Arrays.asList(new Byte[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}); // ?
	
	public SimuladoGerado gerarSimuladoDeNivelamento(Estudante estudante) throws DadosInsuficientesException {
		List<Item> itensSimulado = new ArrayList<>();
		
		for(Habilidade habilidade : habilidadeRepository.findByIdIn(HABILIDADE_IDS))
			itensSimulado.addAll(selecionarItensAleatoriamente(estudante, 1, pegarOsTresItensAoRedorDaDificuldadeMediana(habilidade)));
		
		return instanciarSimulado(estudante, new LinkedHashSet<>(itensSimulado));
	}
	
	private SimuladoGerado instanciarSimulado(Estudante estudante, Set<Item> itensSelecionados) { // "instanciar"?
		Simulado simulado = new Simulado(estudante); /*coisas para instanciar simulado, ou o próprio simulado*/ // parâmetros/atributos
		
		return new SimuladoGerado(simulado, itensSelecionados);
	}
	
	private Set<Item> selecionarItensAleatoriamente(Estudante estudante, int quantidade, Item[] itens) throws DadosInsuficientesException {
		// usar somente itens válidos...
		
		if(quantidade <= 0)
			throw new IllegalArgumentException("Não se pode gerar um simulado com menos de um item."); // exception própria?
		
		if(itens == null)
			throw new IllegalArgumentException("Não há como selecionar itens de uma lista nula."); // exception própria?
		
		// itens not in estudante.feitos?
		
		if(quantidade > itens.length)
			throw new DadosInsuficientesException("O banco de dados não possui itens o suficiente para selecionar a quantidade especificada.");
		
		Set<Item> itensSelecionados = new LinkedHashSet<>();
		
		Random random = new Random();
		
		while(itensSelecionados.size() < quantidade) { // pode rodar pra sempre? se não houverem questões diferentes o suficiente no banco... (Set como parâmetro resolve?)
			itensSelecionados.add(itens[random.nextInt(itens.length)]);
		}
		
		return itensSelecionados;
	}
	
	private Item[] pegarOsTresItensAoRedorDaDificuldadeMediana(Habilidade habilidade) { // ""?
		List<Item> itens = itemRepository.findByHabilidadeOrderByDificuldade(habilidade);
		
		int posicaoMediana = itens.size() / 2; // itens.size() / 2 - (1 - itens.size() % 2) // usar o valor da mediana para determinar se vai pegar o de cima ou de baixo?
		
		// se size < 3... (por enquanto ok)
		
		return new Item[] {itens.get(posicaoMediana - 1), itens.get(posicaoMediana), itens.get(posicaoMediana + 1)};
	}
	
	// for(all hab) pegarOs3 // List<Item[]>
	// simulado.itens.add 1 not in estudante.feitos
	
	/* SIMULADO PADRONIZADO (GERAL)
	 * ...
	 */
	
}
