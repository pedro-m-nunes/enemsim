package br.ifsul.enemsim.repositories.relacionais;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import br.ifsul.enemsim.entidades.auxiliar.Resposta;
import br.ifsul.enemsim.entidades.relacionais.SimuladoItem;
import br.ifsul.enemsim.entidades.relacionais.auxiliar.SimuladoItemId;

public interface SimuladoItemRepository extends JpaRepository<SimuladoItem, SimuladoItemId> {

	@Modifying
	@Query("UPDATE SimuladoItem si SET si.resposta = ?2 WHERE si.id = ?1 AND si.id.simuladoId IN (SELECT s.id FROM Simulado s WHERE s.finalizado = FALSE)")
	public int salvarResposta(SimuladoItemId simuadoItemId, Resposta resposta); // ""?
	
}
