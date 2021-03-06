package br.cefetrj.sca.dominio;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ItemHistoricoEscolar {

	@Id
	@GeneratedValue
	Long id;

	@OneToOne
	Disciplina disciplina;

	@Embedded
	SemestreLetivo periodo;

	@Enumerated(EnumType.ORDINAL)
	EnumSituacaoFinalAvaliacao situacao;

	private ItemHistoricoEscolar() {
	}

	public ItemHistoricoEscolar(Disciplina disciplina, SemestreLetivo periodo,
			EnumSituacaoFinalAvaliacao situacao) {
		this.disciplina = disciplina;
		this.periodo = periodo;
		this.situacao = situacao;
	}

	public Long getId() {
		return id;
	}

	public EnumSituacaoFinalAvaliacao getSituacao() {
		return situacao;
	}

	public Disciplina getDisciplina() {
		return this.disciplina;
	}
}
