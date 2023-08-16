package br.ifsul.enemsim.entidades;

import java.math.BigDecimal;

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
@NoArgsConstructor
@AllArgsConstructor // ?
@EqualsAndHashCode // considerar id?
@Entity
public class Simulado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
//	private Estudante estudante;
	
	private Boolean finalizado; // not null, default = false
	
	private BigDecimal escore; // "pontuacao"?
	
//	private Adaptacao adaptacao; // enum
	
//	@OneToMany(mappedBy = "simulado")
//	private Set<SimuladoItem> itens; // causa alguns problemas (StackOverflow...)

	// construtor?
	
}
