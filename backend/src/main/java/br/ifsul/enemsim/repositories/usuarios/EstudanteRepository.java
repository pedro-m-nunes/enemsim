package br.ifsul.enemsim.repositories.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifsul.enemsim.entidades.usuarios.Estudante;

public interface EstudanteRepository extends JpaRepository<Estudante, Integer> {

}
