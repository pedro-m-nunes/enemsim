package br.ifsul.enemsim.gerador;

import lombok.Getter;

@Getter
public class Distribuicao {

	private Filtro[] filtros;
	
	private int[] quantidades; // ""?

	public Distribuicao(Filtro[] filtros, int[] quantidades) {
		super();
		
		if(filtros.length != quantidades.length)
			throw new IllegalArgumentException("Deve ser informado o mesmo número de filtros e quantidades de itens."); // ""? // exception própria?
		else if(filtros.length == 0)
			throw new IllegalArgumentException("Os vetores de filtros e quantidades não podem ser vazios."); // ""? // exception própria?
		else {
			this.filtros = filtros;
			this.quantidades = quantidades;
		}
	}
	
	public int size() {
		return filtros.length;
	}
	
}
