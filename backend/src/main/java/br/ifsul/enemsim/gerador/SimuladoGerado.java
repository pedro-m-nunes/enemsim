package br.ifsul.enemsim.gerador;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
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
public class SimuladoGerado { // ??? // public?
	
	private Simulado simulado;
	
	private final /* ? */ Set<Item> itens;
	
	public void save(SimuladoRepository simuladoRepository, SimuladoItemRepository simuladoItemRepository) { // boolean? // ?
		simulado = simuladoRepository.save(getSimulado());
		
		Set<SimuladoItem> simuladoItens = new LinkedHashSet<>();
		
		for(Item item : itens)
			simuladoItens.add(new SimuladoItem(simulado, item));
		
//		List<SimuladoItem> simuladoItensSalvos = // ???
		simuladoItemRepository.saveAll(simuladoItens);
		
//		List<Item> itensSalvos = new ArrayList<>();
//		
//		for(SimuladoItem simuladoItem : simuladoItensSalvos)
//			itensSalvos.add(simuladoItem.getItem());
	}
	
//	

}
