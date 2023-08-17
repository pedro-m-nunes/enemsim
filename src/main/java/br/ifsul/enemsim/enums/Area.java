package br.ifsul.enemsim.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Area { // como enum mesmo? // nomes?
	LC("Linguagens, Códigos e suas Tecnologias"), 
	CH("Ciências Humanas e suas Tecnologias"), 
	CN("Ciências da Natureza e suas Tecnologias"), 
	MT("Matemática e suas Tecnologias");
	
	public final String nome;
}
