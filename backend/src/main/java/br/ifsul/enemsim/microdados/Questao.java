package br.ifsul.enemsim.microdados;

import java.math.BigDecimal;
import java.time.Year;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Questao {
	
	private Integer numero;
	
	private String area;
	
	private Integer codigo;
	
	private Integer habilidade;
	
	private Boolean abandonado;
	
	private BigDecimal a;
	
	private BigDecimal b;
	
	private BigDecimal c;
	
	private String cor;
	
	private Integer prova;
	
	private Boolean adaptado;
	
	private Year ano;
	
	private Integer competencia;
	
}
