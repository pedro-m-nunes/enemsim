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
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
//	@Column(nullable = false) // por enquanto, nullable
	private String imagemSrc; // ""?
	
	@Enumerated(EnumType.STRING)
	private Resposta respostaCerta;
	
	@ManyToOne
	private Habilidade habilidade;
	
//	@ManyToMany(fetch = FetchType.EAGER) // desempenho? // ou mapear em Disciplina
//	@JoinTable(name = "item_disciplina")
//	private Set<Disciplina> disciplinas;
	
//	@OneToMany(fetch = FetchType.EAGER) // desempenho? // ou mapear em Resolucao
//	@JoinColumn(name = "item_id")
//	private Set<Resolucao> resolucoes;
	
	@Column(nullable = false)
	private Integer tentativas = 0; // ? // default = 0 // (0, inf)
	
	@Column(nullable = false)
	private Integer tentativasCertas = 0; // ? // default = 0 // (0, attempts]
	
	@Column(precision = 6, scale = 5)
	private BigDecimal discriminacao; // a // (0, inf) // (0, 3]
	
	@Column(precision = 6, scale = 5)
	private BigDecimal dificuldade; // b // (-inf, inf) // [-3, 3], [-4, 4]
	
	@Column(precision = 6, scale = 5)
	private BigDecimal chanceAcertoCasual; // Probabilidade? // c // [0, 1]
	
	@ManyToOne // cascade?
//	@JoinColumn(nullable = false) // por enquanto, nullable
	private Prova prova; // temp
	
	@Column(nullable = false)
	private Short numero; // temp
	
	public Item(String imagemSrc, Resposta respostaCerta, Habilidade habilidade, BigDecimal discriminacao, BigDecimal dificuldade, BigDecimal chanceAcertoCasual, Prova prova, Short numero) {
		super();
		this.imagemSrc = imagemSrc;
		this.respostaCerta = respostaCerta;
		this.habilidade = habilidade;
		this.discriminacao = discriminacao;
		this.dificuldade = dificuldade;
		this.chanceAcertoCasual = chanceAcertoCasual;
		this.prova = prova;
		this.numero = numero;
	}

	public Item(Integer id) {
		super();
		this.id = id;
	}
	
	// construtor com restrições?
	
	public boolean isValido() {
		return discriminacao != null && dificuldade != null && chanceAcertoCasual != null && respostaCerta != null && habilidade != null;
	}
	
}
