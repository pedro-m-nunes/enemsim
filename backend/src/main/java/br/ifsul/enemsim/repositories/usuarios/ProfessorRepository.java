package br.ifsul.enemsim.repositories.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifsul.enemsim.entidades.usuarios.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

}
