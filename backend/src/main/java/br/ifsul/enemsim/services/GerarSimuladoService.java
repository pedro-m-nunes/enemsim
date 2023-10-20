package br.ifsul.enemsim.services;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifsul.enemsim.domain.Habilidade;
import br.ifsul.enemsim.domain.Item;
import br.ifsul.enemsim.domain.Simulado;
import br.ifsul.enemsim.domain.auxiliar.Adaptacao;
import br.ifsul.enemsim.domain.relacionais.auxiliar.EstudanteHabilidadeId;
import br.ifsul.enemsim.domain.usuarios.Estudante;
import br.ifsul.enemsim.exceptions.DadosInsuficientesException;
import br.ifsul.enemsim.exceptions.GerarSimuladoException;
import br.ifsul.enemsim.services.auxiliar.SimuladoGerado;
import br.ifsul.enemsim.services.domain.HabilidadeReadService;
import br.ifsul.enemsim.services.domain.ItemReadService;
import br.ifsul.enemsim.services.domain.SimuladoReadService;
import br.ifsul.enemsim.services.domain.relacionais.EstudanteHabilidadeReadService;
import br.ifsul.enemsim.services.domain.usuarios.EstudanteReadService;

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
	
	@Autowired
	private SimuladoReadService simuladoReadService;
	
	private static final int MINIMO_SIMULADOS_DE_NIVELAMENTO = 3;
	
	public SimuladoGerado gerarSimulado(Integer estudanteId, Adaptacao adaptacao) throws DadosInsuficientesException, GerarSimuladoException {
		Estudante estudante = estudanteReadService.buscarPorId(estudanteId).get(); // exception própria?
		
		if(simuladoReadService.estudantePossuiSimuladoNaoFinalizado(estudanteId))
			throw new GerarSimuladoException("Um estudante não pode gerar um novo simulado enquanto tiver um simulado não finalizado (estudante.id = " + estudanteId + ").");
		
		int simuladosDeNivelamentoRealizadosPeloEstudante = simuladoReadService.quantidadeSimuladosDeNivelamentoFinalizados(estudante.getId());
		
		if(adaptacao == null)
			if(simuladosDeNivelamentoRealizadosPeloEstudante >= MINIMO_SIMULADOS_DE_NIVELAMENTO)
				throw new GerarSimuladoException("Todos os simulados de nivelamento disponíveis já foram gerados (estudante.id = " + estudante.getId() + ").");
			else
				return gerarSimuladoDeNivelamento(estudante);
		else
			if(simuladosDeNivelamentoRealizadosPeloEstudante < MINIMO_SIMULADOS_DE_NIVELAMENTO)
				throw new GerarSimuladoException("É preciso realizar " + MINIMO_SIMULADOS_DE_NIVELAMENTO + " simulados de nivelamento antes de poder gerar simulados adaptados. " + simuladosDeNivelamentoRealizadosPeloEstudante + " simulado(s) realizado(s) (estudante.id = " + estudante.getId() + ").");
			else
				return gerarSimuladoAdaptado(estudante, adaptacao);
	}

	private SimuladoGerado gerarSimuladoDeNivelamento(Estudante estudante) throws DadosInsuficientesException {
		Set<Item> itensSimulado = new LinkedHashSet<>();
		
		final int ITENS_POR_HABILIDADE = 1;
		
		for(Habilidade habilidade : habilidadeReadService.listar())
			itensSimulado.addAll(selecionarItensAleatoriamente(estudante, ITENS_POR_HABILIDADE, itemReadService.itensMedianos(habilidade)));
		
		return instanciarSimulado(estudante, itensSimulado, null);
	}
	
	private SimuladoGerado gerarSimuladoAdaptado(Estudante estudante, Adaptacao adaptacao) throws UnsupportedOperationException, DadosInsuficientesException {
		switch(adaptacao) {
		case DESEMPENHO: return gerarSimuladoPorDesempenho(estudante);
		case PONTOS_FORTES: throw new UnsupportedOperationException("Tipo de geração de simulado ainda não implementado.");
		case PONTOS_FRACOS: throw new UnsupportedOperationException("Tipo de geração de simulado ainda não implementado.");
		default: return null; // exception própria? // se adaptacao for null, gerar por desempenho ou jogar exceção?
		}
	}
	
	private SimuladoGerado gerarSimuladoPorDesempenho(Estudante estudante) throws DadosInsuficientesException { // usar Distribuicao?
		Set<Item> itensSimulado = new LinkedHashSet<>();

		for(Habilidade habilidade : habilidadeReadService.listar()) {
			Set<Item> itensSelecionados;

			final int ITENS_POR_HABILIDADE = 1;
			
			try {
				boolean desempenhoDoEstudante50PorCentoOuMais = estudanteHabilidadeReadService.buscarPorId(new EstudanteHabilidadeId(estudante.getId(), habilidade.getId())).get().getAproveitamento().compareTo(BigDecimal.valueOf(0.5)) >= 0;
				
				if(desempenhoDoEstudante50PorCentoOuMais) // encurtar?
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
