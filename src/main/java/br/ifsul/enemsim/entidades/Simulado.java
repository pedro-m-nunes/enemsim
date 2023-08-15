package br.ifsul.enemsim.entidades;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@EqualsAndHashCode // precisa? acho que não... // considerar id? // sem para não dar StackOverflow com SimuladoItem (?)
@Entity
public class Simulado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
//	private Estudante estudante;
	
//	private Boolean finalizado; // ?
	
//	private BigDecimal escore; // "pontuacao"?
	
//	private Adaptacao adaptacao; // enum
	
	@OneToMany(mappedBy = "simulado")
	private Set<SimuladoItem> itens;
	
}
