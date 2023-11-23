package br.ifsul.enemsim.testes10habilidadesmaisfrequentes;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ifsul.enemsim.domain.Turma;
import br.ifsul.enemsim.domain.usuarios.Estudante;
import br.ifsul.enemsim.domain.usuarios.Professor;
import br.ifsul.enemsim.repositories.TurmaRepository;
import br.ifsul.enemsim.repositories.usuarios.EstudanteRepository;
import br.ifsul.enemsim.repositories.usuarios.UsuarioRepository;
import jakarta.annotation.PostConstruct;

@Component
public class InsertUsuarios {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private EstudanteRepository estudanteRepository;
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	@PostConstruct
	public void run() {
		if(estudanteRepository.count() == 0) {
			
			Set<Estudante> projetistas = new LinkedHashSet<>();
			projetistas.add(new Estudante("joaoguiss", "enemsimjoao", "João Guilherme Severo Schröer"));
			projetistas.add(new Estudante("pedromn", "pedrok", "Pedro Müller Nunes"));
			projetistas.add(new Estudante("roberto", "roberto", "Roberto Maurício Bokowski Sobrinho"));
			projetistas.add(new Estudante("monica", "monica", "Mônica Xavier Py"));
			
			Set<Estudante> estudantesQuinta = new LinkedHashSet<>();
			estudantesQuinta.add(new Estudante("080880EVEQ", "080880EVEQ", "Alana R. N."));
			estudantesQuinta.add(new Estudante("20211SS.INF_Q0074", "20211SS.INF_Q0074", "Alessandra V. L. C."));
			estudantesQuinta.add(new Estudante("079520EVEQ", "079520EVEQ", "Ana L. B. V."));
			estudantesQuinta.add(new Estudante("079590EVEQ", "079590EVEQ", "Brenda R. M. M."));
			estudantesQuinta.add(new Estudante("080180EVEQ", "080180EVEQ", "Dafny B. S."));
			estudantesQuinta.add(new Estudante("20211SS.EVE_Q0061", "20211SS.EVE_Q0061", "Eduarda S. C."));
			estudantesQuinta.add(new Estudante("078780INFQ", "078780INFQ", "Gabriel M. P."));
			estudantesQuinta.add(new Estudante("079480EVEQ", "079480EVEQ", "Gabrielle F. S. B."));
			estudantesQuinta.add(new Estudante("20231SS.TDS_Q0033", "20231SS.TDS_Q0033", "João H. P."));
			estudantesQuinta.add(new Estudante("20211SS.INF_Q0028", "20211SS.INF_Q0028", "João T. R. R."));
			estudantesQuinta.add(new Estudante("080210EVEQ", "080210EVEQ", "Karolinne V. M."));
			estudantesQuinta.add(new Estudante("079610EVEQ", "079610EVEQ", "Kauã F. S."));
			estudantesQuinta.add(new Estudante("079780EVEQ", "079780EVEQ", "Laura V. L."));
			estudantesQuinta.add(new Estudante("079430EVEQ", "079430EVEQ", "Maiara G. S."));
			estudantesQuinta.add(new Estudante("079530EVEQ", "079530EVEQ", "Maria E. S. D."));
			estudantesQuinta.add(new Estudante("079390EVEQ", "079390EVEQ", "Maria L. A. A."));
			estudantesQuinta.add(new Estudante("079800EVEQ", "079800EVEQ", "Nicole O. C."));
			estudantesQuinta.add(new Estudante("20221SS.INF_Q0002", "20221SS.INF_Q0002", "Nicoly F. G. K."));
			estudantesQuinta.add(new Estudante("079450EVEQ", "079450EVEQ", "Rafaela B. C."));
			estudantesQuinta.add(new Estudante("079490EVEQ", "079490EVEQ", "Thaissa R. D."));
			estudantesQuinta.add(new Estudante("20221SS.INF_Q0004", "20221SS.INF_Q0004", "Vinícius R. R."));
			estudantesQuinta.add(new Estudante("20211SS.INF_Q0011", "20211SS.INF_Q0011", "Vitória P."));
			
			Set<Estudante> estudantesSegunda = new LinkedHashSet<>();
			estudantesSegunda.add(new Estudante("079850EVEQ", "079850EVEQ", "Alanis O. H."));
			estudantesSegunda.add(new Estudante("079680EVEQ", "079680EVEQ", "Amanda R."));
			estudantesSegunda.add(new Estudante("080650EVEQ", "080650EVEQ", "Carolyne M. J."));
			estudantesSegunda.add(new Estudante("075820EVEQ", "075820EVEQ", "Danielle F. V."));
			estudantesSegunda.add(new Estudante("079640EVEQ", "079640EVEQ", "Gabriela M. R. S."));
			estudantesSegunda.add(new Estudante("079630EVEQ", "079630EVEQ", "Larissa T. R. M."));
			estudantesSegunda.add(new Estudante("080220EVEQ", "080220EVEQ", "Laura C. A."));
			estudantesSegunda.add(new Estudante("080890EVEQ", "080890EVEQ", "Mariana N. P."));
			estudantesSegunda.add(new Estudante("079810EVEQ", "079810EVEQ", "Mehll R."));
			estudantesSegunda.add(new Estudante("079690EVEQ", "079690EVEQ", "Raíssa O. B."));
			estudantesSegunda.add(new Estudante("079840EVEQ", "079840EVEQ", "Rochelly A. S."));
			estudantesSegunda.add(new Estudante("079730EVEQ", "079730EVEQ", "Samantha M. T."));
			estudantesSegunda.add(new Estudante("079770EVEQ", "079770EVEQ", "Thauane S. M."));

			Set<Estudante> extras = new LinkedHashSet<>(); // Caso haja algum problema com algum usuário.
			extras.add(new Estudante("extra1", "111111", "Extra 1"));
			extras.add(new Estudante("extra2", "222222", "Extra 2"));
			extras.add(new Estudante("extra3", "333333", "Extra 3"));
			extras.add(new Estudante("extra4", "444444", "Extra 4"));
			extras.add(new Estudante("extra5", "555555", "Extra 5"));
			extras.add(new Estudante("extra6", "666666", "Extra 6"));
			
			usuarioRepository.saveAll(projetistas);
			Set<Estudante> estudantesQuintaCadastrados = new LinkedHashSet<>(usuarioRepository.saveAll(estudantesQuinta));
			Set<Estudante> estudantesSegundaCadastrados = new LinkedHashSet<>(usuarioRepository.saveAll(estudantesSegunda));
			usuarioRepository.saveAll(extras);
			
			// Turmas
			
			Set<Professor> professores = new LinkedHashSet<>();
			professores.add(new Professor("Prof. Roberto", "enemsim_professor", "Roberto Maurício Bokowski Sobrinho"));
			
			Set<Professor> professoresCadastrados = new LinkedHashSet<>(usuarioRepository.saveAll(professores));
			
			Set<Turma> turmas = new LinkedHashSet<>();
			turmas.add(new Turma("Matemática e suas Tecnologias (Manhã)", "Aulas nas quintas-feiras.", estudantesQuintaCadastrados, professoresCadastrados));
			turmas.add(new Turma("Matemática e suas Tecnologias (Tarde)", "Aulas nas segundas-feiras.", estudantesSegundaCadastrados, professoresCadastrados));
			
			turmaRepository.saveAll(turmas);
			
		}
	}

}
