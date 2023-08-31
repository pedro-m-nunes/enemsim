package br.ifsul.enemsim.entidades;

import br.ifsul.enemsim.entidades.perfis.Estudante;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
	
	@Column(nullable = false, unique = true)
	@NotNull
	@Size(min = 6, message = "O nome de usuário deve ter pelo menos 6 caracteres.") // max?
	private String username; // ""? "login"?
	
	@Column(nullable = false)
	@NotNull
	@NotBlank // size?
	private String senha; // criptografar...
	
	@Column(nullable = false)
	@NotNull
	@NotBlank
	private String nome; // ? // nome e sobrenome?
	
	// foto? por ora, não
	
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
