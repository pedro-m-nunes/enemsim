package br.ifsul.enemsim.services.interfaces;

import java.util.List;

public interface CreateAndUpdateService<T, ID> {

	public T salvarOuAtualizar(T entidade);
	
	public List<T> salvarOuAtualizarTodos(Iterable<T> entidades);
	
}
