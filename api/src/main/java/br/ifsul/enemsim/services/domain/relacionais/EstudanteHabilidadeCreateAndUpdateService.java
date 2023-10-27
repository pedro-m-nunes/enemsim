package br.ifsul.enemsim.services.domain.relacionais;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifsul.enemsim.domain.relacionais.EstudanteHabilidade;
import br.ifsul.enemsim.domain.relacionais.auxiliar.EstudanteHabilidadeId;
import br.ifsul.enemsim.repositories.relacionais.EstudanteHabilidadeRepository;
import br.ifsul.enemsim.services.domain.interfaces.CreateAndUpdateService;

@Service
public class EstudanteHabilidadeCreateAndUpdateService implements CreateAndUpdateService<EstudanteHabilidade, EstudanteHabilidadeId> {

	@Autowired
	private EstudanteHabilidadeRepository estudanteHabilidadeRepository;

	@Override
	public EstudanteHabilidade salvarOuAtualizar(EstudanteHabilidade entidade) {
		return estudanteHabilidadeRepository.save(entidade);
	}

	@Override
	public List<EstudanteHabilidade> salvarOuAtualizarTodos(Iterable<EstudanteHabilidade> entidades) {
		return estudanteHabilidadeRepository.saveAll(entidades);
	}
	
	public int adicionarTentativa(EstudanteHabilidadeId id) {
		return estudanteHabilidadeRepository.adicionarTentativa(id);
	}
	
	public int adicionarTentativaCerta(EstudanteHabilidadeId id) {
		return estudanteHabilidadeRepository.adicionarTentativaCerta(id);
	}
	
}
