package br.ifsul.enemsim.gerador;

import java.util.LinkedHashSet;
import java.util.Set;

import br.ifsul.enemsim.entidades.Item;
import br.ifsul.enemsim.entidades.Simulado;
import br.ifsul.enemsim.entidades.relacionais.SimuladoItem;
import br.ifsul.enemsim.repositories.SimuladoRepository;
import br.ifsul.enemsim.repositories.entidadesrelacionais.SimuladoItemRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SimuladoGerado {
	
	private Simulado simulado;
	
	private Set<Item> itens;
	
	public SimuladoGerado save(SimuladoRepository simuladoRepository, SimuladoItemRepository simuladoItemRepository) { // SimuladoController?
		simulado = simuladoRepository.save(getSimulado());
		
		Set<SimuladoItem> simuladoItens = new LinkedHashSet<>();
		
		for(Item item : itens)
			simuladoItens.add(new SimuladoItem(simulado, item));
		
		simuladoItemRepository.saveAll(simuladoItens);
		
		return this;
	}

}
