//package br.ifsul.enemsim.temp;
//
//import java.math.BigDecimal;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Random;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import br.ifsul.enemsim.entidades.Habilidade;
//import br.ifsul.enemsim.entidades.Item;
//import br.ifsul.enemsim.entidades.Prova;
//import br.ifsul.enemsim.entidades.auxiliar.Resposta;
//import br.ifsul.enemsim.repositories.HabilidadeRepository;
//import br.ifsul.enemsim.repositories.ItemRepository;
//
//public class insertItensAleatorios {
//
//	@Autowired
//	private ItemRepository itemRepository;
//	
//	@Autowired
//	private HabilidadeRepository habilidadeRepository;
//	
////	@PostConstruct
//	public void run() {
//		itemRepository.saveAll(gerarItensAleatorios(360));
//	}
//
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
//					BigDecimal.valueOf(random.nextDouble(0.15, 0.25)), 
//					new Prova(1), 
//					(short) 1
//					);
//
//		return Arrays.asList(itens);
//	}
//	
//}
