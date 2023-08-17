package br.ifsul.enemsim.entidades;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	
	// many to one
//	@JoinColumn(nullable = false)
//	private Estudante estudante;
	
	@Column(nullable = false)
	private Boolean finalizado = false; // default = false
	
	private BigDecimal escore; // "pontuacao"?
	
//	@Enumerated(EnumType.STRING)
//	private Adaptacao adaptacao;
	
//	public Simulado(Estudante estudante, Adaptacao adaptacao) {
//		super();
//		this.estudante = estudante;
//		this.adaptacao = adaptacao;
//	}
	
	public Simulado(Integer id) {
		super();
		this.id = id;
	}
	
}
