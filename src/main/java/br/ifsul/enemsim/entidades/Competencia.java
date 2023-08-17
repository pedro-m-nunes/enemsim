package br.ifsul.enemsim.entidades;

import br.ifsul.enemsim.enums.Area;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@NoArgsConstructor
@AllArgsConstructor // ?
@EqualsAndHashCode // considerar id?
@Entity
public class Competencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Byte id; // Byte?
	
	private String descricao;
	
	private Byte numero;

	@Enumerated(EnumType.STRING)
	private Area area;
	
}
