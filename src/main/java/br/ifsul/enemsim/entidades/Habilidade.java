package br.ifsul.enemsim.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Habilidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Byte id; // Byte?
	
	private String descricao;
	
	private Byte numero;
	
	@ManyToOne // cascade persist?
	private Competencia competencia;
	
//	public Habilidade(String descricao, Short numero) { // ?
//		super();
//		this.descricao = descricao;
//		this.numero = numero;
//		// atributos comentados
//	}
	
	public Habilidade(Byte id) { // só para testes?
		super();
		this.id = id;
	}
	
}
