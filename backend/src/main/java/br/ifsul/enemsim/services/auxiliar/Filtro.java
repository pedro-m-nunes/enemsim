package br.ifsul.enemsim.services.auxiliar;

import java.math.BigDecimal;

import br.ifsul.enemsim.entidades.Habilidade;
import lombok.Getter;

@Getter
public class Filtro {

	private Habilidade habilidade;
	
	private BigDecimal dificuldadeMin;
	
	private BigDecimal dificuldadeMax;

	public Filtro(Habilidade habilidade, BigDecimal dificuldadeMin, BigDecimal dificuldadeMax) {
		super();
		this.habilidade = habilidade;
		this.dificuldadeMin = dificuldadeMin;
		this.dificuldadeMax = dificuldadeMax;
	}
	
}
