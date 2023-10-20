package br.ifsul.enemsim.services.domain.relacionais;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifsul.enemsim.domain.relacionais.EstudanteHabilidade;
import br.ifsul.enemsim.domain.relacionais.auxiliar.EstudanteHabilidadeId;
import br.ifsul.enemsim.repositories.relacionais.EstudanteHabilidadeRepository;
import br.ifsul.enemsim.services.domain.interfaces.ReadService;

@Service
public class EstudanteHabilidadeReadService implements ReadService<EstudanteHabilidade, EstudanteHabilidadeId> {

	@Autowired
	private EstudanteHabilidadeRepository estudanteHabilidadeRepository;

	@Override
	public List<EstudanteHabilidade> listar() {
		return estudanteHabilidadeRepository.findAll();
	}

	@Override
	public Optional<EstudanteHabilidade> buscarPorId(EstudanteHabilidadeId id) {
		return estudanteHabilidadeRepository.findById(id);
	}
	
	public boolean existePorId(EstudanteHabilidadeId id) {
		return estudanteHabilidadeRepository.existsById(id);
	}
	
}
