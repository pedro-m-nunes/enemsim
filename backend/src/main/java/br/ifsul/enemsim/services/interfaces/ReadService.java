package br.ifsul.enemsim.services.interfaces;

import java.util.List;

public interface ReadService<T, ID> {

	public List<T> listar();
	
	public T get(ID id); // ""?
	
}
