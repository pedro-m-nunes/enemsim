package br.ifsul.enemsim.services.entidades.interfaces;

import java.util.List;
import java.util.Optional;

public interface ReadService<T, ID> {

	public List<T> listar();
	
	public Optional<T> buscarPorId(ID id); // ""?
	
}