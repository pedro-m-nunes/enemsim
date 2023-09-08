package br.ifsul.enemsim.repositories.entidadesrelacionais;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ifsul.enemsim.entidades.Simulado;
import br.ifsul.enemsim.entidades.perfis.Estudante;
import br.ifsul.enemsim.entidades.relacionais.SimuladoItem;
import br.ifsul.enemsim.entidades.relacionais.auxiliar.SimuladoItemId;

public interface SimuladoItemRepository extends JpaRepository<SimuladoItem, SimuladoItemId> {

	public List<SimuladoItem> findBySimulado(Simulado simulado);
	
	// itens ja feitos
	
	@Query("SELECT si.item.id FROM SimuladoItem si INNER JOIN si.simulado s INNER JOIN si.item i WHERE s.estudante = ?1 AND i.respostaCerta = si.resposta AND si.simulado.finalizado = TRUE")
	public List<Integer> getItensJaAcertadosPorEstudante(Estudante estudante); // temp? // mover para itemRepo?
	
}
