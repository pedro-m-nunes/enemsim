package br.ifsul.enemsim.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class Habilidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String descricao;
	
	@Column(nullable = false)
	private Byte numero;
	
	@ManyToOne(cascade = CascadeType.PERSIST) // cascade?
	@JoinColumn(nullable = false)
	private Competencia competencia;
	
	public Habilidade(String descricao, Byte numero, Competencia competencia) {
		super();
		this.descricao = descricao;
		this.numero = numero;
		this.competencia = competencia;
	}
	
	public Habilidade(Integer id) {
		super();
		this.id = id;
	}
	
}
