package br.ifsul.enemsim.gerador;

import java.util.Arrays;

import br.ifsul.enemsim.exceptions.DistribuicaoException;
import lombok.Getter;

@Getter
public class Distribuicao {

	private Filtro[] filtros;
	
	private Integer[] quantidades; // ""?

	public Distribuicao(Filtro[] filtros, Integer[] quantidades) throws DistribuicaoException {
		super();
		
		if(filtros.length != quantidades.length)
			throw new DistribuicaoException("Deve ser informado o mesmo número de filtros e quantidades de itens."); // ""?
		else if(filtros.length == 0)
			throw new DistribuicaoException("Os vetores de filtros e quantidades não podem ser vazios."); // ""?
		else if(Arrays.asList(quantidades).contains(null))
			throw new DistribuicaoException("Todos os valores do vetor de quantidades devem ser preenchidos."); // ""?
		else {
			this.filtros = filtros;
			this.quantidades = quantidades;
		}
	}
	
	// public Distribuicao(Filtro[] filtros, Integer quantidadeDeCada)
	
	public int size() {
		return filtros.length;
	}
	
}
