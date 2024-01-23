package br.ifsul.enemsim.testes10habilidadesmaisfrequentes;

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
			
			provas.add(new Prova(Year.of(2022), Cor.AMARELA)); // id = 1
			provas.add(new Prova(Year.of(2021), Cor.AMARELA)); // id = 2
			provas.add(new Prova(Year.of(2020), Cor.AMARELA)); // id = 3
			provas.add(new Prova(Year.of(2019), Cor.AMARELA)); // id = 4
			provas.add(new Prova(Year.of(2018), Cor.AMARELA)); // id = 5
			// Nenhum item de 2017 selecionado para o teste, portanto sem a prova.
			provas.add(new Prova(Year.of(2016), Cor.AMARELA)); // id = 6
			provas.add(new Prova(Year.of(2015), Cor.AMARELA)); // id = 7
			
			provaRepository.saveAll(provas);
		}
	}
	
}
