package br.ifsul.enemsim.entidades.relacionais;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.ifsul.enemsim.entidades.Habilidade;
import br.ifsul.enemsim.entidades.relacionais.auxiliar.EstudanteHabilidadeId;
import br.ifsul.enemsim.entidades.usuarios.Estudante;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class EstudanteHabilidade { // vai ter muitos registros... (estudantes * habilidades)

	@EmbeddedId
	private EstudanteHabilidadeId id;
	
	@ManyToOne // cascade?
	@MapsId("estudanteId")
	@JoinColumn(nullable = false)
	private Estudante estudante;
	
	@ManyToOne // cascade?
	@MapsId("habilidadeId")
	@JoinColumn(nullable = false)
	private Habilidade habilidade;

//	private BigDecimal pontuacao;
	
	@Column(nullable = false)
	private Integer tentativas = 0;
	
	@Column(nullable = false)
	private Integer tentativasCertas = 0;
	
	public EstudanteHabilidade(Estudante estudante, Habilidade habilidade) {
		super();
		this.id = new EstudanteHabilidadeId();
		this.estudante = estudante;
		this.habilidade = habilidade;
	}

	public EstudanteHabilidade(EstudanteHabilidadeId id) {
		super();
		this.id = id;
	}

	public EstudanteHabilidade(Integer estudanteId, Byte habilidadeId) {
		super();
		this.id = new EstudanteHabilidadeId(estudanteId, habilidadeId);
	}
	
	public BigDecimal getAproveitamento() {
		BigDecimal divisor = tentativas == 0 ? BigDecimal.ONE : BigDecimal.valueOf(tentativas);
		
		return BigDecimal.valueOf(tentativasCertas).divide(divisor, 4, RoundingMode.HALF_UP); // scale???
	}
	
}
