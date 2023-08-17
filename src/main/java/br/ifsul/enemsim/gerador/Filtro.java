package br.ifsul.enemsim.gerador;

import java.math.BigDecimal;

import br.ifsul.enemsim.entidades.Habilidade;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
//@Setter // ?
@AllArgsConstructor
public class Filtro {

	private Habilidade habilidade;
	
	private BigDecimal dificuldadeMinima;
	
	private BigDecimal dificuldadeMaxima;
	
	public boolean isNull() {
		return habilidade == null && dificuldadeMinima == null && dificuldadeMaxima == null;
	}
	
}
