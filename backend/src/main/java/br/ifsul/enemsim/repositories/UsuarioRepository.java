package br.ifsul.enemsim.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifsul.enemsim.entidades.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
