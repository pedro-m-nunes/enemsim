package br.ifsul.enemsim.temp;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import br.ifsul.enemsim.entidades.Competencia;
import br.ifsul.enemsim.entidades.Habilidade;
import br.ifsul.enemsim.entidades.auxiliar.Area;
import br.ifsul.enemsim.repositories.HabilidadeRepository;
import jakarta.annotation.PostConstruct;

@Component
@DependsOn("insertCompetencias")
public class InsertHabilidades { // mover para test?

	@Autowired
	private HabilidadeRepository habilidadeRepository;
	
	@PostConstruct
	public void run() {
		Competencia competencia = new Competencia("Construir significados para os números naturais, inteiros, racionais e reais.", (byte) 1, Area.MT); // competenciaRepository.findById((byte) 1).get();
		
		Set<Habilidade> habilidades = new HashSet<>();
		
		habilidades.add(new Habilidade("Reconhecer, no contexto social, diferentes significados e representações dos números e operações - naturais, inteiros, racionais ou reais.", (byte) 1, competencia));
		habilidades.add(new Habilidade("Identificar padrões numéricos ou princípios de contagem.", (byte) 2, competencia));
		habilidades.add(new Habilidade("Resolver situação-problema envolvendo conhecimentos numéricos.", (byte) 3, competencia));
		habilidades.add(new Habilidade("Avaliar a razoabilidade de um resultado numérico na construção de argumentos sobre afirmações quantitativas.", (byte) 4, competencia));
		
		habilidadeRepository.saveAll(habilidades);
	}
	
}
