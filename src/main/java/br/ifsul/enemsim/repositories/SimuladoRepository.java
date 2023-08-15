package br.ifsul.enemsim.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifsul.enemsim.entidades.Simulado;

public interface SimuladoRepository extends JpaRepository<Simulado, Integer> {

}
