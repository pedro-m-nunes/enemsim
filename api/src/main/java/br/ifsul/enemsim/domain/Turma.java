package br.ifsul.enemsim.domain;

import java.util.Set;

import br.ifsul.enemsim.domain.usuarios.Estudante;
import br.ifsul.enemsim.domain.usuarios.Professor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Turma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String nome;
	
	private String descricao;
	
	// disciplina?
	
	@ManyToMany
	@JoinTable(
			name = "turma_estudante", 
			joinColumns = @JoinColumn(name = "turma_id"), 
			inverseJoinColumns = @JoinColumn(name = "estudante_id"))
	private Set<Estudante> estudantes; // não deixar turma sem estudante?
	
	@ManyToMany
	@JoinTable(
			name = "turma_professor", 
			joinColumns = @JoinColumn(name = "turma_id"), 
			inverseJoinColumns = @JoinColumn(name = "professor_id"))
	private Set<Professor> professores; // não deixar turma sem professor.
	
//	@ManyToMany
//	@JoinTable(
//			name = "turma_simulado", 
//			joinColumns = @JoinColumn(name = "turma_id"), 
//			inverseJoinColumns = @JoinColumn(name = "simulado_id"))
//	private List<Simulado> simulados; // ?
	
	public Turma(String nome, String descricao, Set<Estudante> estudantes, Set<Professor> professores) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.estudantes = estudantes;
		this.professores = professores;
	}
	
}
