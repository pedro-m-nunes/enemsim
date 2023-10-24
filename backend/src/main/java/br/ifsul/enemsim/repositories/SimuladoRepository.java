package br.ifsul.enemsim.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import br.ifsul.enemsim.domain.Item;
import br.ifsul.enemsim.domain.Simulado;

public interface SimuladoRepository extends JpaRepository<Simulado, Integer> {

	public List<Simulado> findByEstudanteId(Integer estudanteId);
	
	@Query("SELECT si.item FROM SimuladoItem si INNER JOIN Simulado s ON si.simulado = s WHERE s.id = ?1")
	public List<Item> getItens(Integer simuladoId);
	
	@Query("SELECT si.item FROM SimuladoItem si INNER JOIN Simulado s ON si.simulado = s INNER JOIN Item i ON si.item = i WHERE s.id = ?1 AND s.finalizado = TRUE AND si.resposta = i.respostaCerta")
	public List<Item> getItensAcertados(Integer simuladoId);
	
	@Query("SELECT CASE WHEN COUNT(s) > 0 THEN TRUE ELSE FALSE END FROM Simulado s WHERE s.id = ?1 AND s.finalizado = TRUE")
	public boolean isFinalizado(Integer simuladoId);
	
	@Modifying
	@Query("UPDATE Simulado s SET s.finalizado = TRUE WHERE s.id = ?1")
	public int setFinalizado(Integer simuladoId); // ? // int?
	
	@Query("SELECT CASE WHEN COUNT(s) > 0 THEN TRUE ELSE FALSE END FROM Simulado s INNER JOIN SimuladoItem si ON s = si.simulado WHERE s.id = ?1 AND si.id.itemId = ?2")
	public boolean simuladoPossuiItem(Integer simuladoId, Integer itemId); // testar
	
	public int countByEstudanteIdAndAdaptacaoIsNullAndFinalizadoIsTrue(Integer estudanteId);
	
	public boolean existsByEstudanteIdAndFinalizadoIsFalse(Integer estudanteId);
	
}
