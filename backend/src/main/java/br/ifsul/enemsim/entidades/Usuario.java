package br.ifsul.enemsim.entidades;

import br.ifsul.enemsim.entidades.perfis.Estudante;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
	
	@Column(nullable = false)
	private String nome; // ?
	
	// nome e sobrenome?
	
	// foto?
	
	@OneToOne(cascade = CascadeType.ALL) // cascade all?
	private Estudante estudante;
	
//	@OneToOne(cascade = CascadeType.ALL) // cascade all?
//	private Administrador administrador;
	
	public Usuario(String username, String senha, String nome, Estudante estudante /*adm...*/) {
		super();
		this.username = username;
		this.senha = senha;
		this.nome = nome;
		this.estudante = estudante;
		// adm...
	}

	public Usuario(Integer id) {
		super();
		this.id = id;
	}
	
}
