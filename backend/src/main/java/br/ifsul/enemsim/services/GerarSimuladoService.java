package br.ifsul.enemsim.services;

import java.math.BigDecimal;
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
import br.ifsul.enemsim.services.entidades.usuarios.EstudanteReadService;

@Service
public class GerarSimuladoService {
	
	@Autowired
	private ItemReadService itemReadService;
	
	@Autowired
	private HabilidadeReadService habilidadeReadService;
	
	@Autowired
	private EstudanteReadService estudanteReadService;
	
	@Autowired
	private EstudanteHabilidadeReadService estudanteHabilidadeReadService;

	public SimuladoGerado gerarSimuladoDeNivelamento(Integer estudanteId) throws DadosInsuficientesException {
		Estudante estudante = estudanteReadService.buscarPorId(estudanteId).get();
		
		Set<Item> itensSimulado = new LinkedHashSet<>();
		
		for(Habilidade habilidade : habilidadeReadService.listar())
			itensSimulado.addAll(selecionarItensAleatoriamente(estudante, 1, pegarOsTresItensAoRedorDaDificuldadeMediana(itemReadService.pegarItensOrdenadosPorDificuldade(habilidade))));
		
		return instanciarSimulado(estudante, itensSimulado);
	}
	
	// Simulados adaptados: só um por vez (não deixar o estudante gerar se houver um não finalizado).
	
	public SimuladoGerado gerarSimuladoAdaptado(Integer estudanteId, Adaptacao adaptacao) throws UnsupportedOperationException, DadosInsuficientesException {
		// se não fez (respondeu) todos os de nivelamento, não deixar gerar
		
		// if tem um não finalizado, não deixar gerar (throw ...)
		
		switch(adaptacao) {
		case DESEMPENHO: return gerarSimuladoPorDesempenho(estudanteId);
		case PONTOS_FORTES: throw new UnsupportedOperationException("Tipo de geração de simulado ainda não implementado.");
		case PONTOS_FRACOS: throw new UnsupportedOperationException("Tipo de geração de simulado ainda não implementado.");
		default: return null; // exception própria? // se adaptacao for null, gerar por desempenho ou jogar exceção?
		}
	}
	
	// testar
	private SimuladoGerado gerarSimuladoPorDesempenho(Integer estudanteId) throws DadosInsuficientesException { // usar Distribuicao? // testar
		Estudante estudante = estudanteReadService.buscarPorId(estudanteId).get();
		
		Set<Item> itensSimulado = new LinkedHashSet<>();

		for(Habilidade habilidade : habilidadeReadService.listar()) {
			List<Item> itensHabilidade = itemReadService.pegarItensOrdenadosPorDificuldade(habilidade); // Set?

			List<Item> itensPossiveisPorDesempenho;

			// se não existir estudanteHabilidadeService...
			if(estudanteHabilidadeReadService.buscarPorId(new EstudanteHabilidadeId(estudante.getId(), habilidade.getId())).get().getAproveitamento().compareTo(BigDecimal.valueOf(0.5)) >= 0) // encurtar? // erro aqui - talvez porque não tem de todas as habilidades...
				itensPossiveisPorDesempenho = pegarOsItensAcimaDosTresMedianos(itensHabilidade);
			else
				itensPossiveisPorDesempenho = pegarOsItensAbaixoDosTresMedianos(itensHabilidade);

			Set<Item> itensSelecionados = selecionarItensAleatoriamente(estudante, 1, itensPossiveisPorDesempenho);
			
			itensSimulado.addAll(itensSelecionados);
		}

		return instanciarSimulado(estudante, itensSimulado);
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
		throw new DadosInsuficientesException("Não é possível selecionar os itens com as condições informadas."); // ""? "O estudante já gerou os simulados de nivelamento disponíveis."?
		
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
	
	private List<Item> pegarOsItensAbaixoDosTresMedianos(List<Item> itens) {
		return itens.subList(0, posicaoMedianaDosItens(itens) - 1);
	}
	
	private List<Item> pegarOsItensAcimaDosTresMedianos(List<Item> itens) {
		return itens.subList(posicaoMedianaDosItens(itens) + 2, itens.size());
	}
	
	private int posicaoMedianaDosItens(List<Item> itens) { // conforme padrão // ?
		return posicaoMedianaArredondandoParaCima(itens.size());
	}
	
	private int posicaoMedianaArredondandoParaCima(int tamanhoLista) {
		return tamanhoLista / 2;
	}
	
	private int posicaoMedianaArredondandoParaBaixo(int tamanhoLista) { // ?
		return tamanhoLista / 2 - (1 - tamanhoLista % 2);
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
