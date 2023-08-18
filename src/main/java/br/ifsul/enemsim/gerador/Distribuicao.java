package br.ifsul.enemsim.gerador;

import java.util.Arrays;

import lombok.Getter;

@Getter
public class Distribuicao {

	private Filtro[] filtros;
	
	private Integer[] quantidades; // ""?

	public Distribuicao(Filtro[] filtros, Integer[] quantidades) {
		super();
		
		if(filtros.length != quantidades.length)
			throw new IllegalArgumentException("Deve ser informado o mesmo número de filtros e quantidades de itens."); // ""? // exception própria?
		else if(filtros.length == 0)
			throw new IllegalArgumentException("Os vetores de filtros e quantidades não podem ser vazios."); // ""? // exception própria?
		else if(Arrays.asList(filtros).contains(null) || Arrays.asList(quantidades).contains(null))
			throw new IllegalArgumentException("Todos os valores dos vetores de filtros e de quantidades devem ser preenchidos."); // ""? // exception própria?
		else {
			this.filtros = filtros;
			this.quantidades = quantidades;
		}
	}
	
	public int size() {
		return filtros.length;
	}
	
}
