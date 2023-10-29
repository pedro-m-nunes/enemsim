package br.ifsul.enemsim.services.auxiliar;

import java.util.Set;

import br.ifsul.enemsim.domain.Item;
import br.ifsul.enemsim.domain.Simulado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SimuladoGerado {
	
	private Simulado simulado;
	
	private Set<Item> itens;

}
