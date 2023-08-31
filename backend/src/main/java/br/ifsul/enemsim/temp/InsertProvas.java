package br.ifsul.enemsim.temp;

import java.time.Year;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ifsul.enemsim.entidades.Prova;
import br.ifsul.enemsim.entidades.auxiliar.Cor;
import br.ifsul.enemsim.repositories.ProvaRepository;
import jakarta.annotation.PostConstruct;

@Component
public class InsertProvas { // ProvaItem!!

	@Autowired
	private ProvaRepository provaRepository;
	
	@PostConstruct
	public void run() {
		Set<Prova> provas = new LinkedHashSet<>();
		
		provas.add(new Prova(Year.of(2022), Cor.AMARELO));
		provas.add(new Prova(Year.of(2021), Cor.AMARELO));
		provas.add(new Prova(Year.of(2020), Cor.AMARELO));
		
		provaRepository.saveAll(provas);
	}
	
//	private void insertProvaItem() { // não funcionou
//		Item item = itemRepository.findById(1).get();
//		
//		provaItemRepository.save(new ProvaItem(new Prova(Year.of(2022), Cor.AMARELO), item, (short) 146));
//		provaItemRepository.save(new ProvaItem(new Prova(Year.of(2022), Cor.AZUL), item, (short) 178));
//		
//	}
	
}
