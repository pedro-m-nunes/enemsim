package br.ifsul.enemsim.services.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifsul.enemsim.domain.Item;
import br.ifsul.enemsim.domain.Simulado;
import br.ifsul.enemsim.domain.relacionais.SimuladoItem;
import br.ifsul.enemsim.repositories.SimuladoRepository;
import br.ifsul.enemsim.services.domain.auxiliar.TaxaAcertos;
import br.ifsul.enemsim.services.domain.interfaces.ReadService;

@Service
public class SimuladoReadService implements ReadService<Simulado, Integer> {

	@Autowired
	private SimuladoRepository simuladoRepository;

	@Override
	public List<Simulado> listar() {
		return simuladoRepository.findAll();
	}

	@Override
	public Optional<Simulado> buscarPorId(Integer id) {
		return simuladoRepository.findById(id);
	}
	
	public List<Item> itensDoSimulado(Integer simuladoId) {
		return simuladoRepository.getItens(simuladoId);
	}
	
	public List<SimuladoItem> respostasAoSimulado(Integer simuladoId) {
		return simuladoRepository.getRespostas(simuladoId);
	}
	
	public List<Simulado> simuladosDoEstudante(Integer estudanteId) {
		return simuladoRepository.findByEstudanteId(estudanteId);
	}
	
	public boolean simuladoPossuiItem(Integer simuladoId, Integer itemId) {
		return simuladoRepository.simuladoPossuiItem(simuladoId, itemId);
	}
	
	public int quantidadeSimuladosDeNivelamentoFinalizados(Integer estudanteId) {
		return simuladoRepository.countByEstudanteIdAndAdaptacaoIsNullAndFinalizadoIsTrue(estudanteId);
	}
	
	public boolean estudantePossuiSimuladoNaoFinalizado(Integer estudanteId) {
		return simuladoRepository.existsByEstudanteIdAndFinalizadoIsFalse(estudanteId);
	}
	
	public TaxaAcertos quantidadeDeAcertosEItens(Integer simuladoId) { // record?
		if(!simuladoRepository.isFinalizado(simuladoId))
			throw new IllegalArgumentException("Só se pode ver os acertos em simulados finalizados."); // ""? // exception própria?
		
		return new TaxaAcertos(simuladoRepository.getItensAcertados(simuladoId).size(), simuladoRepository.getItens(simuladoId).size());
	}
	
}
