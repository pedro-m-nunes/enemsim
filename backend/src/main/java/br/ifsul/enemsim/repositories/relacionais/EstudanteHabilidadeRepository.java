package br.ifsul.enemsim.repositories.relacionais;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import br.ifsul.enemsim.domain.relacionais.EstudanteHabilidade;
import br.ifsul.enemsim.domain.relacionais.auxiliar.EstudanteHabilidadeId;

public interface EstudanteHabilidadeRepository extends JpaRepository<EstudanteHabilidade, EstudanteHabilidadeId> {

	@Modifying
	@Query("UPDATE EstudanteHabilidade eh SET eh.tentativas = eh.tentativas + 1 WHERE eh.id = ?1")
	public int adicionarTentativa(EstudanteHabilidadeId id);
	
	@Modifying
	@Query("UPDATE EstudanteHabilidade eh SET eh.tentativasCertas = eh.tentativasCertas + 1 WHERE eh.id = ?1")
	public int adicionarTentativaCerta(EstudanteHabilidadeId id);
	
}
