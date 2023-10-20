package br.ifsul.enemsim.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifsul.enemsim.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

//	@Query(nativeQuery = true, value = "")
//	public List<Usuario> findByDiscriminatorValue();
	
}
