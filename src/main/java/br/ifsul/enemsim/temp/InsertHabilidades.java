package br.ifsul.enemsim.temp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import br.ifsul.enemsim.entidades.Competencia;
import br.ifsul.enemsim.entidades.Habilidade;
import br.ifsul.enemsim.repositories.CompetenciaRepository;
import br.ifsul.enemsim.repositories.HabilidadeRepository;
import jakarta.annotation.PostConstruct;

@Component
@DependsOn("insertCompetencias")
public class InsertHabilidades {

	@Autowired
	private HabilidadeRepository habilidadeRepository;
	
	@Autowired
	private CompetenciaRepository competenciaRepository;
	
	@PostConstruct
	public void run() {
		Competencia competencia = competenciaRepository.findById((byte) 1).get();
		
		List<Habilidade> habilidades = new ArrayList<>();
		
		habilidades.add(Habilidade.builder().competencia(competencia).numero((byte) 1).descricao("Reconhecer, no contexto social, diferentes significados e representações dos números e operações - naturais, inteiros, racionais ou reais.").build());
		habilidades.add(Habilidade.builder().competencia(competencia).numero((byte) 2).descricao("Identificar padrões numéricos ou princípios de contagem.").build());
		habilidades.add(Habilidade.builder().competencia(competencia).numero((byte) 3).descricao("Resolver situação-problema envolvendo conhecimentos numéricos.").build());
		habilidades.add(Habilidade.builder().competencia(competencia).numero((byte) 4).descricao("Avaliar a razoabilidade de um resultado numérico na construção de argumentos sobre afirmações quantitativas.").build());
		
		habilidadeRepository.saveAll(habilidades);
	}
	
}
