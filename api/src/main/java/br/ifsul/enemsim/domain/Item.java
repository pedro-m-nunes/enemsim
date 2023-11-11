package br.ifsul.enemsim.domain;

import java.math.BigDecimal;

import br.ifsul.enemsim.domain.auxiliar.Resposta;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor // ?
@EqualsAndHashCode
@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank
	@Column(nullable = false)
	private String imagemDriveId; // recursoDriveId? (questões em Libras...)
	
	// boolean libras? String videoEmLibrasDriveId?
	
	@Enumerated(EnumType.STRING)
	private Resposta respostaCerta;
	
	@NotNull
	@ManyToOne
	@JoinColumn(nullable = false)
	private Habilidade habilidade;
	
//	@ManyToMany(fetch = FetchType.EAGER) // desempenho? // ou mapear em Disciplina
//	@JoinTable(name = "item_disciplina")
//	// JsonIgnore?
//	private Set<Disciplina> disciplinas;
	
//	@OneToMany(fetch = FetchType.EAGER) // desempenho? // ou mapear em Resolucao
//	@JoinColumn(name = "item_id")
//	// JsonIgnore?
//	private Set<Comentario> comentarios;
	
	@NotNull
	// Digits?
	@Positive
	@Column(precision = 6, scale = 5, nullable = false)
	private BigDecimal discriminacao;
	
	@NotNull
	// Digits?
	@Column(precision = 6, scale = 5, nullable = false)
	private BigDecimal dificuldade;
	
	@NotNull
	// Digits?
	@Min(0)
	@Max(1)
	@Column(precision = 6, scale = 5, nullable = false)
	private BigDecimal chanceAcertoCasual;
	
	@NotNull
	@ManyToOne // cascade?
	@JoinColumn(nullable = false)
	private Prova prova; // temp, N:N
	
	@NotNull
	@Positive
	@Column(nullable = false)
	private Short numero; // temp, N:N
	
	public Item(String imagemDriveId, Resposta respostaCerta, Habilidade habilidade, BigDecimal discriminacao, BigDecimal dificuldade, BigDecimal chanceAcertoCasual, Prova prova, Short numero) {
		super();
		this.imagemDriveId = imagemDriveId;
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
	
}
