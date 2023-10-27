package br.ifsul.enemsim.teste10habilidadesmaisfrequentes;

import java.time.Year;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ifsul.enemsim.domain.Prova;
import br.ifsul.enemsim.domain.auxiliar.Cor;
import br.ifsul.enemsim.repositories.ProvaRepository;
import jakarta.annotation.PostConstruct;

@Component
public class InsertProvas {

	@Autowired
	private ProvaRepository provaRepository;
	
	@PostConstruct
	public void run() {
		if(provaRepository.count() == 0) {
			Set<Prova> provas = new LinkedHashSet<>();
			
			provas.add(new Prova(Year.of(2022), Cor.AMARELO)); // id = 1
			provas.add(new Prova(Year.of(2021), Cor.AMARELO)); // id = 2
			provas.add(new Prova(Year.of(2020), Cor.AMARELO)); // id = 3
			provas.add(new Prova(Year.of(2019), Cor.AMARELO)); // id = 4
			provas.add(new Prova(Year.of(2018), Cor.AMARELO)); // id = 5
			// sem 2017 mesmo
			provas.add(new Prova(Year.of(2016), Cor.AMARELO)); // id = 6
			provas.add(new Prova(Year.of(2015), Cor.AMARELO)); // id = 7
			
			provaRepository.saveAll(provas);
		}
	}
	
}
