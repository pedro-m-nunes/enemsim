package br.ifsul.enemsim.gerador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifsul.enemsim.entidades.Habilidade;
import br.ifsul.enemsim.entidades.Item;
import br.ifsul.enemsim.entidades.Simulado;
import br.ifsul.enemsim.entidades.usuarios.Estudante;
import br.ifsul.enemsim.exceptions.DadosInsuficientesException;
import br.ifsul.enemsim.repositories.HabilidadeRepository;
import br.ifsul.enemsim.repositories.ItemRepository;

//@Component
@RestController // temp
@RequestMapping("/gersim")
//@CrossOrigin(origins = "*")
public class GerSim {
	
	// Usar somente os itens que tem id do Drive cadastrado. Se imagemDriveId nullable = false, não precisa se preocupar.

	@Autowired // ?
	private ItemRepository itemRepository; // controller?
	
	@Autowired
	private HabilidadeRepository habilidadeRepository; // controller?
	
	public SimuladoGerado gerarSimuladoDeNivelamento(Estudante estudante) throws DadosInsuficientesException {
		List<Item> itensSimulado = new ArrayList<>();
		
		for(Habilidade habilidade : habilidadeRepository.findAll()) // findAll por enquanto ok // findByIdIn...
			itensSimulado.addAll(selecionarItensAleatoriamente(estudante, 1, pegarOsTresItensAoRedorDaDificuldadeMediana(itemRepository.findByHabilidadeOrderByDificuldade(habilidade))));
		
		return instanciarSimulado(estudante, new LinkedHashSet<>(itensSimulado));
	}
	
	private SimuladoGerado instanciarSimulado(Estudante estudante, Set<Item> itensSelecionados) {
		Simulado simulado = new Simulado(estudante);
		
		return new SimuladoGerado(simulado, itensSelecionados);
	}
	
	private Set<Item> selecionarItensAleatoriamente(Estudante estudante, int quantidade, List<Item> itens) throws DadosInsuficientesException {
		// usar somente itens válidos... (?)
		
		if(quantidade <= 0)
			throw new IllegalArgumentException("Não se pode gerar um simulado com menos de um item."); // exception própria?
		
		if(itens == null)
			throw new IllegalArgumentException("Não há como selecionar itens de uma lista nula."); // exception própria?
		
		List<Item> itensPossiveis = new ArrayList<>(new LinkedHashSet<>(itemRepository.getItensDoConjuntoNaoPresentesEmOutrosSimuladosDoEstudante(itens, estudante)));
		
		if(quantidade > itensPossiveis.size())
			throw new DadosInsuficientesException("O estudante já gerou os simulados de nivelamento disponíveis.");
		
		Set<Item> itensSelecionados = new LinkedHashSet<>();
		
		Random random = new Random();
		
		while(itensSelecionados.size() < quantidade) { // pode rodar pra sempre? se não houverem questões diferentes o suficiente no banco... (acho que com Set não...)
			itensSelecionados.add(itensPossiveis.get(random.nextInt(itensPossiveis.size())));
		}
		
		return itensSelecionados;
	}
	
	private List<Item> pegarOsTresItensAoRedorDaDificuldadeMediana(List<Item> itens) {
		int posicaoMediana = posicaoMedianaDosItens(itens);
		
		// se size < 3... (por enquanto ok)
		
		return Arrays.asList(new Item[] {itens.get(posicaoMediana - 1), itens.get(posicaoMediana), itens.get(posicaoMediana + 1)});
	}
	
	private int posicaoMedianaDosItens(List<Item> itens) { // conforme padrão
		return posicaoMedianaArredondandoParaCima(itens.size());
	}
	
	private int posicaoMedianaArredondandoParaCima(int tamanhoLista) { // List<Object>? Funciona, mas precisa?
		return tamanhoLista / 2;
	}
	
	private int posicaoMedianaArredondandoParaBaixo(int tamanhoLista) {
		return tamanhoLista / 2 - (1 - tamanhoLista % 2);
	}
	
	/* SIMULADO ADAPTADO
	 * Pegar desempenho do estudante (inclui dados sobre itens já respondidos/acertados).
	 * Gerar uma distribuição adequada ao desempenho, com base também no tipo de adaptação.
	 * Selecionar os "bancos" de itens com base nos filtros da distribuição gerada.
	 * Selecionar os itens de cada "banco" aleatoriamente.
	 * Instanciar simulado.
	 */
	
	private List<Item> pegarOsItensAbaixoDosTresMedianos(List<Item> itens) {
		return itens.subList(0, posicaoMedianaDosItens(itens) - 1);
	}
	
	private List<Item> pegarOsItensAcimaDosTresMedianos(List<Item> itens) {
		return itens.subList(posicaoMedianaDosItens(itens) + 2, itens.size());
	}
	
	/* Itens por desempenho - primeiro simulado adaptado (a princípio)
	 * 
	 * adaptacao = Adaptacao.DESEMPENHO;
	 * 
	 * Aproveitamento ou rendimento
	 * 0.00 <= x <  0.25 : i(x) = posicaoMedianaArredondandoParaCima(pegarOsItensAbaixoDosTresMedianos(ITENS_DA_HABILIDADE));
	 * 0.25 <= x <  0.50 : i(x) = i(0) + 1;
	 * 0.50 <= x <  0.75 : i(x) = i(1) - 1;
	 * 0.75 <= x <= 1.00 : i(x) = posicaoMedianaArredondandoParaBaixo(pegarOsItensAcimaDosTresMedianos(ITENS_DA_HABILIDADE));
	 */
	
	// Simulados adaptados: só um por vez (não deixar o estudante gerar se houver um não finalizado).
	
	@Deprecated
	@GetMapping("/itens")
	private Object itens() { // temp
		Map<Byte, Map<String, List<Integer>>> habilidadesMap = new LinkedHashMap<>();
		
		for(Habilidade habilidade : habilidadeRepository.findAll()) {
			List<Item> itens = itemRepository.findByHabilidadeOrderByDificuldade(habilidade);
			
			Map<String, List<Integer>> itensMap = new LinkedHashMap<>();
			
			itensMap.put("Abaixo", itensIds(pegarOsItensAbaixoDosTresMedianos(itens)));
			itensMap.put("Medianos", itensIds(pegarOsTresItensAoRedorDaDificuldadeMediana(itens)));
			itensMap.put("Acima", itensIds(pegarOsItensAcimaDosTresMedianos(itens)));
			
			habilidadesMap.put(habilidade.getId(), itensMap);
		}
		
		return habilidadesMap;
	}
	
	@Deprecated
	private List<Integer> itensIds(List<Item> itens) { // temp
		List<Integer> itensIds = new ArrayList<>();
		
		for(Item item : itens)
			itensIds.add(item.getId());
		
		return itensIds;
	}
	
}
