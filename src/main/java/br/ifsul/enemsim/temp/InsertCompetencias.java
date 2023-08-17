package br.ifsul.enemsim.temp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ifsul.enemsim.entidades.Competencia;
import br.ifsul.enemsim.enums.Area;
import br.ifsul.enemsim.repositories.CompetenciaRepository;
import jakarta.annotation.PostConstruct;

@Component
public class InsertCompetencias {

	@Autowired
	private CompetenciaRepository competenciaRepository;
	
	@PostConstruct
	public void run() {
		List<Competencia> competencias = new ArrayList<>();
		
		competencias.add(Competencia.builder().area(Area.MT).numero((byte) 1).descricao("Construir significados para os números naturais, inteiros, racionais e reais.").build());
		competencias.add(Competencia.builder().area(Area.MT).numero((byte) 2).descricao("Utilizar o conhecimento geométrico para realizar a leitura e a representação da realidade e agir sobre ela.").build());
		competencias.add(Competencia.builder().area(Area.MT).numero((byte) 3).descricao("Construir noções de grandezas e medidas para a compreensão da realidade e a solução de problemas do cotidiano.").build());
		
		competenciaRepository.saveAll(competencias);
	}
	
}
