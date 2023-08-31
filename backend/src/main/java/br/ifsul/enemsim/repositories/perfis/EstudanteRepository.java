package br.ifsul.enemsim.repositories.perfis;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifsul.enemsim.entidades.perfis.Estudante;

public interface EstudanteRepository extends JpaRepository<Estudante, Integer> {

}
