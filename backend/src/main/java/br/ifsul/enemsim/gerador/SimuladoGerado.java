package br.ifsul.enemsim.gerador;

import java.util.LinkedHashSet;
import java.util.Set;

import br.ifsul.enemsim.entidades.Item;
import br.ifsul.enemsim.entidades.Simulado;
import br.ifsul.enemsim.entidades.relacionais.SimuladoItem;
import br.ifsul.enemsim.services.entidades.SimuladoCreateAndUpdateService;
import br.ifsul.enemsim.services.entidades.relacionais.SimuladoItemCreateAndUpdateService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SimuladoGerado {
	
	private Simulado simulado;
	
	private Set<Item> itens;
	
	public SimuladoGerado salvar(SimuladoCreateAndUpdateService simuladoService, SimuladoItemCreateAndUpdateService itensService) { // ?
		simulado = simuladoService.salvarOuAtualizar(getSimulado());
		
		Set<SimuladoItem> simuladoItens = new LinkedHashSet<>();
		
		for(Item item : itens)
			simuladoItens.add(new SimuladoItem(simulado, item));
		
		itensService.salvarOuAtualizarTodos(simuladoItens);
		
		return this;
	}

}
