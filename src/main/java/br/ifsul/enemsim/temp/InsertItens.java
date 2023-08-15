package br.ifsul.enemsim.temp;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import br.ifsul.enemsim.entidades.Habilidade;
import br.ifsul.enemsim.entidades.Item;
import br.ifsul.enemsim.repositories.HabilidadeRepository;
import br.ifsul.enemsim.repositories.ItemRepository;
import jakarta.annotation.PostConstruct;

@Component
@DependsOn("insertHabilidades")
public class InsertItens {
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private HabilidadeRepository habilidadeRepository;

	@PostConstruct
	public void run() {
		List<Item> itens = gerarItensAleatorios(400);
		
		List<Habilidade> habilidades = habilidadeRepository.findAll();
		
		for(int i = 0; i < itens.size(); i++)
			itens.get(i).setHabilidade(habilidades.get(i % habilidades.size()));
		
		itemRepository.saveAll(itens);
	}
	
	private List<Item> gerarItensAleatorios(int quantidade) {
		Item[] itens = new Item[quantidade];

		Random random = new Random();

		for(int i = 0; i < quantidade; i++)
			itens[i] = Item.builder()
					.discriminacao(BigDecimal.valueOf(random.nextDouble(3)))
					.dificuldade(BigDecimal.valueOf(random.nextDouble(-3, 3)))
					.chanceAcertoCasual(BigDecimal.valueOf(random.nextDouble(0.15, 0.25)))
					.build();

		return Arrays.asList(itens);
	}
	
}
