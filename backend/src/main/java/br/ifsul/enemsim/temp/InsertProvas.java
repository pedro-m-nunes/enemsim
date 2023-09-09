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
public class InsertProvas {

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
	
}
