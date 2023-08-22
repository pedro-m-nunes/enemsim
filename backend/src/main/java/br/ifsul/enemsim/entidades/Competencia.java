package br.ifsul.enemsim.entidades;

import br.ifsul.enemsim.entidades.auxiliar.Area;
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
public class Competencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Byte id; // Byte?
	
	@Column(nullable = false)
	private String descricao;
	
	@Column(nullable = false)
	private Byte numero;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Area area;

	public Competencia(String descricao, Byte numero, Area area) {
		super();
		this.descricao = descricao;
		this.numero = numero;
		this.area = area;
	}

	public Competencia(Byte id) {
		super();
		this.id = id;
	}
	
}
