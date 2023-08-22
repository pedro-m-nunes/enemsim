package br.ifsul.enemsim.temp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ifsul.enemsim.entidades.Competencia;
import br.ifsul.enemsim.entidades.auxiliar.Area;
import br.ifsul.enemsim.repositories.CompetenciaRepository;
import jakarta.annotation.PostConstruct;

@Component
public class InsertCompetencias {

	@Autowired
	private CompetenciaRepository competenciaRepository;
	
	@PostConstruct
	public void run() {
		List<Competencia> competencias = new ArrayList<>();
				
//		competencias.add(new Competencia("Construir significados para os números naturais, inteiros, racionais e reais.", (byte) 1, Area.MT));
		competencias.add(new Competencia("Utilizar o conhecimento geométrico para realizar a leitura e a representação da realidade e agir sobre ela.", (byte) 2, Area.MT));
		competencias.add(new Competencia("Construir noções de grandezas e medidas para a compreensão da realidade e a solução de problemas do cotidiano.", (byte) 3, Area.MT));

		competenciaRepository.saveAll(competencias);
	}
	
}
