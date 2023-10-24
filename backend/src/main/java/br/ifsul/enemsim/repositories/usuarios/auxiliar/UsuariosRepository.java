package br.ifsul.enemsim.repositories.usuarios.auxiliar;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifsul.enemsim.domain.usuarios.Usuario;

public interface UsuariosRepository<T extends Usuario> extends JpaRepository<T, Integer> {
	
	public boolean existsByUsername(String username);
	
	public Optional<T> findByUsername(String username);
	
//	@Query(nativeQuery = true, value = "")
//	public List<Usuario> findByDiscriminatorValue();
	
}
