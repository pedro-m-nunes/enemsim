package br.ifsul.enemsim.services.entidades;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifsul.enemsim.entidades.Item;
import br.ifsul.enemsim.entidades.Simulado;
import br.ifsul.enemsim.repositories.SimuladoRepository;
import br.ifsul.enemsim.services.entidades.interfaces.ReadService;

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
	
	public List<Simulado> simuladosDoEstudante(Integer estudanteId) {
		return simuladoRepository.findByEstudanteId(estudanteId);
	}
	
	public boolean simuladoPossuiItem(Integer simuladoId, Integer itemId) {
		return simuladoRepository.simuladoPossuiItem(simuladoId, itemId);
	}
	
}
