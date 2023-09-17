package br.ifsul.enemsim.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifsul.enemsim.entidades.Habilidade;

public interface HabilidadeRepository extends JpaRepository<Habilidade, Byte> {

	public List<Habilidade> findByIdIn(Iterable<Byte> ids);
	
}
