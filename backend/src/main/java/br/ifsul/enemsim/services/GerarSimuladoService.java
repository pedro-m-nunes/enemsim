package br.ifsul.enemsim.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifsul.enemsim.entidades.Habilidade;
import br.ifsul.enemsim.entidades.Item;
import br.ifsul.enemsim.entidades.Simulado;
import br.ifsul.enemsim.entidades.auxiliar.Adaptacao;
import br.ifsul.enemsim.entidades.relacionais.auxiliar.EstudanteHabilidadeId;
import br.ifsul.enemsim.entidades.usuarios.Estudante;
import br.ifsul.enemsim.exceptions.DadosInsuficientesException;
import br.ifsul.enemsim.services.auxiliar.SimuladoGerado;
import br.ifsul.enemsim.services.entidades.HabilidadeReadService;
import br.ifsul.enemsim.services.entidades.ItemReadService;
import br.ifsul.enemsim.services.entidades.relacionais.EstudanteHabilidadeReadService;

@Service
public class GerarSimuladoService {
	
	@Autowired
	private ItemReadService itemReadService;
	
	@Autowired
	private HabilidadeReadService habilidadeReadService;
	
	@Autowired
	private EstudanteHabilidadeReadService estudanteHabilidadeReadService;

	public SimuladoGerado gerarSimuladoDeNivelamento(Estudante estudante) throws DadosInsuficientesException {
		List<Item> itensSimulado = new ArrayList<>();
		
		for(Habilidade habilidade : habilidadeReadService.listar())
			itensSimulado.addAll(selecionarItensAleatoriamente(estudante, 1, pegarOsTresItensAoRedorDaDificuldadeMediana(itemReadService.pegarItensOrdenadosPorDificuldade(habilidade))));
		
		return instanciarSimulado(estudante, new LinkedHashSet<>(itensSimulado));
	}
	
	private SimuladoGerado instanciarSimulado(Estudante estudante, Set<Item> itensSelecionados) {
		Simulado simulado = new Simulado(estudante);
		
		return new SimuladoGerado(simulado, itensSelecionados);
	}
	
	private Set<Item> selecionarItensAleatoriamente(Estudante estudante, int quantidade, List<Item> itens) throws DadosInsuficientesException {
		if(quantidade <= 0)
			throw new IllegalArgumentException("Não se pode gerar um simulado com menos de um item."); // exception própria?
		
		if(itens == null)
			throw new IllegalArgumentException("Não há como selecionar itens de uma lista nula."); // exception própria?
		
		List<Item> itensPossiveis = itemReadService.pegarItensDoConjuntoAusentesEmOutrosSimuladosDoEstudante(itens, estudante);
		
		if(quantidade > itensPossiveis.size())
			throw new DadosInsuficientesException("O estudante já gerou os simulados de nivelamento disponíveis."); // ""? geral?
		
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
	
//	private int posicaoMedianaArredondandoParaBaixo(int tamanhoLista) { // ?
//		return tamanhoLista / 2 - (1 - tamanhoLista % 2);
//	}
	
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
	
	/* Itens por desempenho - primeiro simulado adaptado
	 * 
	 * adaptacao = Adaptacao.DESEMPENHO;
	 * 
	 * Aproveitamento ou rendimento
	 * x <  0.5 : i(x) = random(abaixo)
	 * x >= 0.5 : i(x) = random(acima)
	 */
	
	// Simulados adaptados: só um por vez (não deixar o estudante gerar se houver um não finalizado).
	
	public SimuladoGerado gerarSimuladoAdaptado(Estudante estudante, Adaptacao adaptacao) throws UnsupportedOperationException {
		switch(adaptacao) {
		case DESEMPENHO: return gerarSimuladoPorDesempenho(estudante);
		case PONTOS_FORTES: throw new UnsupportedOperationException("Tipo de geração de simulado ainda não implementado.");
		case PONTOS_FRACOS: throw new UnsupportedOperationException("Tipo de geração de simulado ainda não implementado.");
		default: return null; // exception própria? // se adaptacao for null...
		}
	}
	
	// testar
	private SimuladoGerado gerarSimuladoPorDesempenho(Estudante estudante) { // usar Distribuicao? // testar
		// exceptions?
		
		Simulado simulado = new Simulado(estudante);
		
		Set<Item> itens = new LinkedHashSet<>();
		
		// para cada habilidade, buscar os itens abaixo/acima dos medianos, e pegar um aleatório
		for(Habilidade habilidade : habilidadeReadService.listar()) { // selecionarItensAleatoriamente()
			List<Item> itensHabilidade = itemReadService.pegarItensOrdenadosPorDificuldade(habilidade); // Set?
			
			List<Item> itensPossiveisPorDesempenho; // Set?
			
			if(estudanteHabilidadeReadService.buscarPorId(new EstudanteHabilidadeId(estudante.getId(), habilidade.getId())).get().getAproveitamento().compareTo(BigDecimal.valueOf(0.5)) >= 0) // encurtar?
				itensPossiveisPorDesempenho = pegarOsItensAcimaDosTresMedianos(itensHabilidade);
			else
				itensPossiveisPorDesempenho = pegarOsItensAbaixoDosTresMedianos(itensHabilidade);
			
			// desconsiderar os já feitos/apresentados/acertados
			List<Item> itensPossiveis = itemReadService.pegarItensDoConjuntoAusentesEmOutrosSimuladosDoEstudante(itensPossiveisPorDesempenho, estudante);
			
			// se todos já forem feitos...
			// apresentados >= feitos >= acertados
			// tentar por (em ordem): não apresentados, não feitos, não acertados.
			
			// selecionar aleatório
			Random random = new Random();
			
			itens.add(itensPossiveis.get(random.nextInt(itensPossiveis.size())));
		}
		
		return new SimuladoGerado(simulado, itens);
	}
	
//	@Deprecated
//	@GetMapping("/itens")
//	private Object itens() { // temp
//		Map<Byte, Map<String, List<Integer>>> habilidadesMap = new LinkedHashMap<>();
//		
//		for(Habilidade habilidade : db.HABILIDADES_DO_TESTE) {
//			List<Item> itens = db.pegarItensOrdenadosPorDificuldade(habilidade);
//			
//			Map<String, List<Integer>> itensMap = new LinkedHashMap<>();
//			
//			itensMap.put("Abaixo", itensIds(pegarOsItensAbaixoDosTresMedianos(itens)));
//			itensMap.put("Medianos", itensIds(pegarOsTresItensAoRedorDaDificuldadeMediana(itens)));
//			itensMap.put("Acima", itensIds(pegarOsItensAcimaDosTresMedianos(itens)));
//			
//			habilidadesMap.put(habilidade.getId(), itensMap);
//		}
//		
//		return habilidadesMap;
//	}
	
//	@Deprecated
//	private List<Integer> itensIds(List<Item> itens) { // temp
//		List<Integer> itensIds = new ArrayList<>();
//		
//		for(Item item : itens)
//			itensIds.add(item.getId());
//		
//		return itensIds;
//	}
	
}
