package br.ifsul.enemsim.domain;

import br.ifsul.enemsim.domain.auxiliar.Adaptacao;
import br.ifsul.enemsim.domain.usuarios.Estudante;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Simulado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne // cascade? mappedBy?
	@JoinColumn(nullable = false) // nullable?
	private Estudante estudante; // precisa fazer estudante e usuário primeiro...
	
	@Column(nullable = false)
	private Boolean finalizado = false; // boolean?
	
	// data de criação e finalização? // tempo para finalizar? tempo levado para finalizar?
	
//	private BigDecimal escore; // "pontuacao"?
	
	@Enumerated(EnumType.STRING)
	private Adaptacao adaptacao;
	
	public Simulado(Integer id) {
		super();
		this.id = id;
	}
	
	public Simulado(Estudante estudante) {
		super();
		this.estudante = estudante;
	}

	public Simulado(Estudante estudante, Adaptacao adaptacao) {
		super();
		this.estudante = estudante;
		this.adaptacao = adaptacao;
	}

}
