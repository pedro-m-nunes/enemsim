package br.ifsul.enemsim.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import br.ifsul.enemsim.entidades.Item;
import br.ifsul.enemsim.entidades.Simulado;

public interface SimuladoRepository extends JpaRepository<Simulado, Integer> {

	public List<Simulado> findByEstudanteId(Integer estudanteId);
	
	@Query("SELECT si.item FROM SimuladoItem si INNER JOIN Simulado s ON si.simulado = s WHERE s.id = ?1")
	public List<Item> getItens(Integer simuladoId);
	
	@Modifying
	@Query("UPDATE Simulado s SET s.finalizado = TRUE WHERE s.id = ?1")
	public int setFinalizado(Integer simuladoId); // ? // int?
	
//	public boolean existsByEstudanteIdAndFinalizadoIsFalse(Integer estudanteId);
	
//	public boolean existsByEstudanteAndAdaptacaoIsNotNull(Integer estudanteId); // ? // testar
	
	@Query("SELECT CASE WHEN COUNT(s) > 0 THEN TRUE ELSE FALSE END FROM Simulado s INNER JOIN SimuladoItem si ON s = si.simulado WHERE s.id = ?1 AND si.id.itemId = ?2")
	public boolean simuladoPossuiItem(Integer simuladoId, Integer itemId); // testar
	
}
