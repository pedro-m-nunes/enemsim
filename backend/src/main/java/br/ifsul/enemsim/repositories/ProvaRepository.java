package br.ifsul.enemsim.repositories;

import java.time.Year;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifsul.enemsim.entidades.Prova;
import br.ifsul.enemsim.entidades.auxiliar.Cor;

public interface ProvaRepository extends JpaRepository<Prova, Integer> {

	public List<Prova> findByAnoAndCor(Year ano, Cor cor);
	
}
