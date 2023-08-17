package br.ifsul.enemsim.entidades;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder // só para testes?
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor // ?
@EqualsAndHashCode // considerar id?
@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
//	private String imagemSrc; // ""?
	
//	@Enumerated(EnumType.STRING)
//	private Resposta respostaCerta;
	
	@ManyToOne // cascade?
	@JoinColumn(nullable = false)
	private Habilidade habilidade;
	
//	private Disciplina disciplina; // nullable
	
	private Integer tentativas; // not null, default = 0 // (0, inf) // talvez faça mais sentido ser relacionado ao usuário
	
	private Integer tentativasCertas; // not null, default = 0 // (0, attempts] // // talvez faça mais sentido ser relacionado ao usuário
	
	@Column(precision = 6, scale = 5)
	private BigDecimal discriminacao; // a // (0, inf) // (0, 3] // nullable
	
	@Column(precision = 6, scale = 5)
	private BigDecimal dificuldade; // b // (-inf, inf) // [-3, 3], [-4, 4] // nullable
	
	@Column(precision = 6, scale = 5)
	private BigDecimal chanceAcertoCasual; // Probabilidade? // c // [0, 1] // nullable
	
	// Set<ProvaItem>

	// construtor?
	
	// construtor com restrições?
	
}
