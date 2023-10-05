package br.ifsul.enemsim.repositories.relacionais;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import br.ifsul.enemsim.entidades.Habilidade;
import br.ifsul.enemsim.entidades.relacionais.EstudanteHabilidade;
import br.ifsul.enemsim.entidades.relacionais.auxiliar.EstudanteHabilidadeId;
import br.ifsul.enemsim.entidades.usuarios.Estudante;

public interface EstudanteHabilidadeRepository extends JpaRepository<EstudanteHabilidade, EstudanteHabilidadeId> {

	@Modifying
	@Query("UPDATE EstudanteHabilidade eh SET eh.tentativas = eh.tentativas + 1 WHERE eh.id = ?1")
	public int adicionarTentativa(EstudanteHabilidadeId id);
	
	@Modifying
	@Query("UPDATE EstudanteHabilidade eh SET eh.tentativasCertas = eh.tentativasCertas + 1 WHERE eh.id = ?1")
	public int adicionarTentativaCerta(EstudanteHabilidadeId id);
	
	public Optional<EstudanteHabilidade> findByEstudanteAndHabilidade(Estudante estudante, Habilidade habilidade); // funciona? quando é null...?
	
}
