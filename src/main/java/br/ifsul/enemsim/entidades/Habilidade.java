package br.ifsul.enemsim.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder // só para testes?
@Getter
@Setter
@NoArgsConstructor // ?
@AllArgsConstructor // ?
@EqualsAndHashCode // ? // considerar id?
@Entity
public class Habilidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; // Short? Byte?
	
	private String descricao;
	
	private Short numero;
	
//	private Competencia competencia;
	
}
