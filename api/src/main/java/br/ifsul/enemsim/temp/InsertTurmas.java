//package br.ifsul.enemsim.temp;
//
//import java.util.LinkedHashSet;
//import java.util.Set;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.DependsOn;
//import org.springframework.stereotype.Component;
//
//import br.ifsul.enemsim.domain.Turma;
//import br.ifsul.enemsim.domain.usuarios.Estudante;
//import br.ifsul.enemsim.domain.usuarios.Professor;
//import br.ifsul.enemsim.repositories.TurmaRepository;
//import br.ifsul.enemsim.repositories.usuarios.EstudanteRepository;
//import br.ifsul.enemsim.repositories.usuarios.ProfessorRepository;
//import jakarta.annotation.PostConstruct;
//
//@Component
//@DependsOn("insertUsuarios")
//public class InsertTurmas {
//
//	@Autowired
//	private TurmaRepository turmaRepository;
//	
//	@Autowired
//	private EstudanteRepository estudanteRepository;
//	
//	@Autowired
//	private ProfessorRepository professorRepository;
//	
//	@PostConstruct
//	public void run() {
//		if(turmaRepository.count() == 0) {
//			Set<Estudante> estudantes = new LinkedHashSet<>(estudanteRepository.findAll());
//			
//			Set<Professor> professores = new LinkedHashSet<>();
//			professores.add(professorRepository.findById(6).get());
//			
//			turmaRepository.save(new Turma("Turma de teste", "Somente uma turma de teste.", estudantes, null));
//		}
//	}
//	
//}
