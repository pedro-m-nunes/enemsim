package br.ifsul.enemsim.services.auxiliar;

import java.util.Set;

import br.ifsul.enemsim.entidades.Item;
import br.ifsul.enemsim.entidades.Simulado;
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
