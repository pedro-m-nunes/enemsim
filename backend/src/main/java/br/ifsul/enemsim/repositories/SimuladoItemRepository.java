package br.ifsul.enemsim.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifsul.enemsim.entidades.SimuladoItem;
import br.ifsul.enemsim.entidades.auxiliar.SimuladoItemId;

public interface SimuladoItemRepository extends JpaRepository<SimuladoItem, SimuladoItemId> {

	public List<SimuladoItem> findByIdSimuladoId(Integer simuladoId);
	
}
