package br.ifsul.enemsim.entidades;

import jakarta.persistence.Column;
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
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, unique = true) // length?
	private String username;
	
	@Column(nullable = false) // length?
	private String senha; // criptografar...
	
	// nome? sobrenome?
	
	// foto?
	
	public Usuario(String username, String senha) {
		super();
		this.username = username;
		this.senha = senha;
	}

	public Usuario(Integer id) {
		super();
		this.id = id;
	}
	
}
