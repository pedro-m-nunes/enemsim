package br.ifsul.enemsim.repositories.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifsul.enemsim.entidades.usuarios.Administrador;

public interface AdministradorRepository extends JpaRepository<Administrador, Integer> {

}
