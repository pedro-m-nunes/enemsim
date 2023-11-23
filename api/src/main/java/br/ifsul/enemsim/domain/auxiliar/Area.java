package br.ifsul.enemsim.domain.auxiliar;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum Area { // como enum mesmo?
	LC("Linguagens, Códigos e suas Tecnologias"), 
	CH("Ciências Humanas e suas Tecnologias"), 
	CN("Ciências da Natureza e suas Tecnologias"), 
	MT("Matemática e suas Tecnologias");
	
	private final String nome; // não é em caps? final...
	
}
