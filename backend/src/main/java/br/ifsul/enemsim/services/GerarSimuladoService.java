package br.ifsul.enemsim.services;

import java.math.BigDecimal;
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
		Estudante estudante = estudanteReadService.buscarPorId(estudanteId).get(); // exception própria?
		
		Set<Item> itensSimulado = new LinkedHashSet<>();
		
		for(Habilidade habilidade : habilidadeReadService.listar())
			itensSimulado.addAll(selecionarItensAleatoriamente(estudante, 1, itemReadService.itensMedianos(habilidade)));
		
		return instanciarSimulado(estudante, itensSimulado, null);
	}
	
	public SimuladoGerado gerarSimuladoAdaptado(Integer estudanteId, Adaptacao adaptacao) throws UnsupportedOperationException, DadosInsuficientesException {
		switch(adaptacao) {
		case DESEMPENHO: return gerarSimuladoPorDesempenho(estudanteId);
		case PONTOS_FORTES: throw new UnsupportedOperationException("Tipo de geração de simulado ainda não implementado.");
		case PONTOS_FRACOS: throw new UnsupportedOperationException("Tipo de geração de simulado ainda não implementado.");
		default: return null; // exception própria? // se adaptacao for null, gerar por desempenho ou jogar exceção?
		}
	}
	
	private SimuladoGerado gerarSimuladoPorDesempenho(Integer estudanteId) throws DadosInsuficientesException { // usar Distribuicao?
		Estudante estudante = estudanteReadService.buscarPorId(estudanteId).get(); // exception própria?
		
		Set<Item> itensSimulado = new LinkedHashSet<>();

		for(Habilidade habilidade : habilidadeReadService.listar()) {
			Set<Item> itensSelecionados;

			final int ITENS_POR_HABILIDADE = 1;
			
			try {
				if(estudanteHabilidadeReadService.buscarPorId(new EstudanteHabilidadeId(estudante.getId(), habilidade.getId())).get().getAproveitamento().compareTo(BigDecimal.valueOf(0.5)) >= 0) // encurtar?
					itensSelecionados = selecionarItensAleatoriamente(estudante, ITENS_POR_HABILIDADE, itemReadService.itensAcimaDosMedianos(habilidade));
				else
					itensSelecionados = selecionarItensAleatoriamente(estudante, ITENS_POR_HABILIDADE, itemReadService.itensAbaixoDosMedianos(habilidade));
			} catch(DadosInsuficientesException e) {
				itensSelecionados = selecionarItensAleatoriamente(estudante, ITENS_POR_HABILIDADE, itemReadService.pegarItensPorHabilidade(habilidade));
				// catch { continue; } // gera simulados sem itens (?)
			}
			
			itensSimulado.addAll(itensSelecionados);
		}

		return instanciarSimulado(estudante, itensSimulado, Adaptacao.DESEMPENHO);
	}
	
	private SimuladoGerado instanciarSimulado(Estudante estudante, Set<Item> itensSelecionados, Adaptacao adaptacao) {
		Simulado simulado = new Simulado(estudante, adaptacao);
		
		return new SimuladoGerado(simulado, itensSelecionados);
	}
	
	private Set<Item> selecionarItensAleatoriamente(Estudante estudante, int quantidade, List<Item> itens) throws DadosInsuficientesException {
		if(quantidade <= 0)
			throw new IllegalArgumentException("Não se pode gerar um simulado com menos de um item."); // exception própria?
		
		if(itens == null)
			throw new IllegalArgumentException("Não há como selecionar itens de uma lista nula."); // exception própria?
		
		List<Item> itensPossiveis = itemReadService.pegarItensDoConjuntoAusentesEmOutrosSimuladosDoEstudante(itens, estudante);
		
		if(quantidade > itensPossiveis.size())
			throw new DadosInsuficientesException("Não há itens o suficiente para selecionar a quantidade informada (habilidade.id = " + itens.get(0).getHabilidade().getId() + ")."); // ""? "O estudante já gerou os simulados de nivelamento disponíveis."?
		
		Set<Item> itensSelecionados = new LinkedHashSet<>();
		
		Random random = new Random();
		
		while(itensSelecionados.size() < quantidade) { // pode rodar pra sempre? se não houverem questões diferentes o suficiente no banco... (acho que com Set não...)
			itensSelecionados.add(itensPossiveis.get(random.nextInt(itensPossiveis.size())));
		}
		
		return itensSelecionados;
	}

}
