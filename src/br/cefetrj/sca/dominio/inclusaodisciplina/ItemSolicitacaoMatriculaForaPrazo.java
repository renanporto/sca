package br.cefetrj.sca.dominio.inclusaodisciplina;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.cefetrj.sca.dominio.Departamento;
import br.cefetrj.sca.dominio.EnumStatusSolicitacao;
import br.cefetrj.sca.dominio.Turma;

@Entity
public class ItemSolicitacaoMatriculaForaPrazo {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataSolicitacao;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Turma turma;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Departamento departamento;

	@OneToOne(cascade = CascadeType.ALL)
	private Comprovante comprovante; 

	@Enumerated(EnumType.ORDINAL)
	private EnumStatusSolicitacao status;
	
	private int opcao;
	
	private String observacao;
	
	@SuppressWarnings("unused")
	private ItemSolicitacaoMatriculaForaPrazo(){
	}
	
	public ItemSolicitacaoMatriculaForaPrazo(Date dataSolicitacao, Turma turma, Departamento departamento,
			Comprovante comprovante, EnumStatusSolicitacao status, int opcao, String observacao) {
		
		if (turma == null || departamento == null || status == null || dataSolicitacao == null) {
			throw new IllegalArgumentException(
					"Erro: argumentos inválidos para SolicitacaoInclusao().");
		}
		
		this.dataSolicitacao = dataSolicitacao;
		this.turma = turma;
		this.departamento = departamento;
		this.comprovante = comprovante;
		this.status = status;
		this.opcao = opcao;
		this.observacao = observacao;
	}
	
	public ItemSolicitacaoMatriculaForaPrazo(Turma turma, Departamento departamento, int opcao, String observacao) {
		
		if (turma == null || departamento == null) {
			throw new IllegalArgumentException(
					"Erro: argumentos inválidos para SolicitacaoInclusao().");
		}
		
		this.turma = turma;
		this.departamento = departamento;
		this.opcao = opcao;
		this.observacao = observacao;
	}

	public Turma getTurma() {
		return turma;
	}

	public Long getId() {
		return id;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public Comprovante getComprovante() {
		return comprovante;
	}

	public EnumStatusSolicitacao getStatus() {
		return status;
	}

	public int getOpcao() {
		return opcao;
	}

	public String getObservacao() {
		return observacao;
	}
	
	public Date getDataSolicitacao() {
		return dataSolicitacao;
	}
	
	public void setStatus(EnumStatusSolicitacao status) {
		this.status = status;
	}
	
}
