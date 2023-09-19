package br.ifsul.enemsim.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ifsul.enemsim.entidades.Habilidade;
import br.ifsul.enemsim.entidades.Item;
import br.ifsul.enemsim.entidades.perfis.Estudante;

public interface ItemRepository extends JpaRepository<Item, Integer> {
	
	public List<Item> findByHabilidadeOrderByDificuldade(Habilidade habilidade);
	
	@Query("SELECT i FROM Item i WHERE i.respostaCerta IS NOT NULL AND i.discriminacao IS NOT NULL AND i.dificuldade IS NOT NULL AND i.chanceAcertoCasual IS NOT NULL")
	public List<Item> findAllValidos(); // ? // testar
	
	// ver Optional
	
	public List<Item> findByHabilidadeAndDificuldadeBetween(Habilidade habilidade, BigDecimal dificuldadeMinima, BigDecimal dificuldadeMaxima);
	
	public List<Item> findByHabilidadeAndDificuldadeGreaterThanEqual(Habilidade habilidade, BigDecimal dificuldadeMinima);
	
	public List<Item> findByHabilidadeAndDificuldadeLessThanEqual(Habilidade habilidade, BigDecimal dificuldadeMaxima);

	public List<Item> findByHabilidade(Habilidade habilidade);
	
	public List<Item> findByDificuldadeBetween(BigDecimal dificuldadeMinima, BigDecimal dificuldadeMaxima);
	
	public List<Item> findByDificuldadeGreaterThanEqual(BigDecimal dificuldadeMinima);
	
	public List<Item> findByDificuldadeLessThanEqual(BigDecimal dificuldadeMaxima);
	
	@Query("SELECT i FROM Item i WHERE i.id IN (SELECT si.item.id FROM SimuladoItem si INNER JOIN si.simulado s INNER JOIN si.item i WHERE s.estudante = ?1 AND i.respostaCerta = si.resposta AND si.simulado.finalizado = TRUE)")
	public List<Item> getItensJaAcertadosPorEstudante(Estudante estudante);
	
	@Query("SELECT i FROM Item i WHERE i.id NOT IN (SELECT si.item.id FROM SimuladoItem si INNER JOIN si.simulado s INNER JOIN si.item i WHERE s.estudante = ?1 AND i.respostaCerta = si.resposta AND si.simulado.finalizado = TRUE)")
	public List<Item> getItensNaoAcertadosPorEstudante(Estudante estudante);
	
	// itens já/não feitos? (acertados ou não)
	
	@Query("SELECT i FROM Item i WHERE i IN ?1 AND i.id NOT IN (SELECT si.item.id FROM SimuladoItem si INNER JOIN si.simulado s WHERE s.estudante = ?2)")
	public List<Item> getItensDoConjuntoNaoPresentesEmOutrosSimuladosDoEstudante(Iterable<Item> conjuntoItens, Estudante estudante);

}
