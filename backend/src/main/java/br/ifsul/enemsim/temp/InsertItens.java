package br.ifsul.enemsim.temp;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import br.ifsul.enemsim.controllers.ItemController;
import br.ifsul.enemsim.entidades.Habilidade;
import br.ifsul.enemsim.entidades.Item;
import br.ifsul.enemsim.entidades.Prova;
import br.ifsul.enemsim.entidades.auxiliar.Resposta;
import jakarta.annotation.PostConstruct;

@Component
@DependsOn({"insertHabilidades", "insertProvas"})
public class InsertItens { // mover para test?
	
	@Autowired
	private ItemController itemController;
	
	@PostConstruct
	public void run() {
//		itemRepository.saveAll(gerarItensAleatorios(360));
		
		Prova prova2022 = new Prova(1);
		Prova prova2021 = new Prova(2);
		Prova prova2020 = new Prova(3);
		
		itemController.save(new Item(
				"https://drive.google.com/file/d/1ItWArfJ0iV796ot2UR4zi9NwjufH9joT/preview", 
				Resposta.C, 
				new Habilidade((byte) 3), 
				new BigDecimal("3.29525"), 
				new BigDecimal("1.21452"), 
				new BigDecimal("0.20483"), 
				prova2021, 
				(short) 138
				));
		
		// ...
		
	}
	
//	private List<Item> gerarItensAleatorios(int quantidade) {
//		Item[] itens = new Item[quantidade];
//
//		Random random = new Random();
//		
//		List<Habilidade> habilidades = habilidadeRepository.findAll();
//
//		for(int i = 0; i < quantidade; i++)
//			itens[i] = new Item(
//					"PLACEHOLDER", 
//					Resposta.values()[random.nextInt(Resposta.values().length)], 
//					habilidades.get(i % habilidades.size()), 
//					BigDecimal.valueOf(random.nextDouble(3)), 
//					BigDecimal.valueOf(random.nextDouble(-3, 3)), 
//					BigDecimal.valueOf(random.nextDouble(0.15, 0.25))
//					);
//
//		return Arrays.asList(itens);
//	}
	
}
