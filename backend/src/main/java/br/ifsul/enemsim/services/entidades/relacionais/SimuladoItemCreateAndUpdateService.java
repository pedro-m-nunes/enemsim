package br.ifsul.enemsim.services.entidades.relacionais;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifsul.enemsim.entidades.auxiliar.Resposta;
import br.ifsul.enemsim.entidades.relacionais.SimuladoItem;
import br.ifsul.enemsim.entidades.relacionais.auxiliar.SimuladoItemId;
import br.ifsul.enemsim.repositories.relacionais.SimuladoItemRepository;
import br.ifsul.enemsim.services.entidades.interfaces.CreateAndUpdateService;

@Service
public class SimuladoItemCreateAndUpdateService implements CreateAndUpdateService<SimuladoItem, SimuladoItemId> {

	@Autowired
	private SimuladoItemRepository simuladoItemRepository;
	
	@Override
	public SimuladoItem salvarOuAtualizar(SimuladoItem entidade) {
		return simuladoItemRepository.save(entidade);
	}

	@Override
	public List<SimuladoItem> salvarOuAtualizarTodos(Iterable<SimuladoItem> entidades) {
		return simuladoItemRepository.saveAll(entidades);
	}
	
	public int salvarResposta(SimuladoItemId simuladoItemId, Resposta resposta) {
		return simuladoItemRepository.salvarResposta(simuladoItemId, resposta);
	}

}
