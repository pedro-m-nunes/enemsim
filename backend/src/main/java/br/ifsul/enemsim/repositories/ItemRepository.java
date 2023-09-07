package br.ifsul.enemsim.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifsul.enemsim.entidades.Habilidade;
import br.ifsul.enemsim.entidades.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
	
	public List<Item> findByHabilidadeAndDificuldadeBetween(Habilidade habilidade, BigDecimal dificuldadeMinima, BigDecimal dificuldadeMaxima);
	
	public List<Item> findByHabilidadeAndDificuldadeGreaterThanEqual(Habilidade habilidade, BigDecimal dificuldadeMinima);
	
	public List<Item> findByHabilidadeAndDificuldadeLessThanEqual(Habilidade habilidade, BigDecimal dificuldadeMaxima);

	public List<Item> findByHabilidade(Habilidade habilidade);
	
	public List<Item> findByDificuldadeBetween(BigDecimal dificuldadeMinima, BigDecimal dificuldadeMaxima);
	
	public List<Item> findByDificuldadeGreaterThanEqual(BigDecimal dificuldadeMinima);
	
	public List<Item> findByDificuldadeLessThanEqual(BigDecimal dificuldadeMaxima);
	
}
