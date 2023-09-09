package br.ifsul.enemsim.entidades;

import java.time.Year;

import br.ifsul.enemsim.entidades.auxiliar.Cor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class Prova {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private Year ano;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Cor cor; // usar java.awt.Color?

	public Prova(Year ano, Cor cor) {
		super();
		this.ano = ano;
		this.cor = cor;
	}

	public Prova(Integer id) {
		super();
		this.id = id;
	}
	
}
