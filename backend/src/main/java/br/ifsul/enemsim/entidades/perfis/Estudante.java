package br.ifsul.enemsim.entidades.perfis;

import jakarta.persistence.Entity;
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
public class Estudante /*extends Perfil ?*/ /*implements ...?*/ {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	// simulados? para poder usar cascade...
	
	// atributos...
	
	// construtor
	
	// construtor de Usuario?

	public Estudante(Integer id) {
		super();
		this.id = id;
	}

}
