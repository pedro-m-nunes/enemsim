package br.ifsul.enemsim.entidades;

import java.math.BigDecimal;

import br.ifsul.enemsim.entidades.auxiliar.Resposta;
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
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String imagemSrc; // ""?
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Resposta respostaCerta;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Habilidade habilidade;
	
//	@ManyToMany
//	private Set<Disciplina> disciplinas; // LazyInitializationException no momento de pegar o item // ?
	
//	@OneToMany
//	private Set<Resolucao> resolucoes; // LazyInitializationException também // ?
	
	@Column(nullable = false)
	private Integer tentativas = 0; // default = 0 // (0, inf) // talvez faça mais sentido ser relacionado ao usuário
	
	@Column(nullable = false)
	private Integer tentativasCertas = 0; // default = 0 // (0, attempts] // talvez faça mais sentido ser relacionado ao usuário
	
	@Column(precision = 6, scale = 5)
	private BigDecimal discriminacao; // a // (0, inf) // (0, 3]
	
	@Column(precision = 6, scale = 5)
	private BigDecimal dificuldade; // b // (-inf, inf) // [-3, 3], [-4, 4]
	
	@Column(precision = 6, scale = 5)
	private BigDecimal chanceAcertoCasual; // Probabilidade? // c // [0, 1]

	public Item(String imagemSrc, Resposta respostaCerta, Habilidade habilidade, /*disciplina?*/ BigDecimal discriminacao, BigDecimal dificuldade, BigDecimal chanceAcertoCasual) {
		super();
		this.imagemSrc = imagemSrc;
		this.respostaCerta = respostaCerta;
		this.habilidade = habilidade;
		// disciplina?
		this.discriminacao = discriminacao;
		this.dificuldade = dificuldade;
		this.chanceAcertoCasual = chanceAcertoCasual;
	}

	public Item(Integer id) {
		super();
		this.id = id;
	}
	
	// construtor com restrições?
	
}
