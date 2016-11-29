package br.com.sysfinanceiro.model.entity;

import java.util.Date;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

public class Cheque {
	
	public static final char SITUACAO_CHEQUE_BAIXADO = 'B';
	public static final char SITUACAO_CHEQUE_CANCELADO= 'C';
	public static final char SITUACAO_CHEQUE_EMITIDO = 'E';
	
	private Long id;
	@ManyToOne
	@JoinColumn
	private Conta conta;
	private Date dataCadastro;
	private Character situacao;
	@OneToOne
	@JoinColumn
	private Lancamento lancamento;
	
	public Cheque() {
		// TODO Auto-generated constructor stub
	}

	public Cheque(Long id, Conta conta, Date dataCadastro, Character situacao,
			Lancamento lancamento) {
		super();
		this.id = id;
		this.conta = conta;
		this.dataCadastro = dataCadastro;
		this.situacao = situacao;
		this.lancamento = lancamento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Character getSituacao() {
		return situacao;
	}

	public void setSituacao(Character situacao) {
		this.situacao = situacao;
	}

	public Lancamento getLancamento() {
		return lancamento;
	}

	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((conta == null) ? 0 : conta.hashCode());
		result = prime * result
				+ ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((lancamento == null) ? 0 : lancamento.hashCode());
		result = prime * result
				+ ((situacao == null) ? 0 : situacao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cheque other = (Cheque) obj;
		if (conta == null) {
			if (other.conta != null)
				return false;
		} else if (!conta.equals(other.conta))
			return false;
		if (dataCadastro == null) {
			if (other.dataCadastro != null)
				return false;
		} else if (!dataCadastro.equals(other.dataCadastro))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lancamento == null) {
			if (other.lancamento != null)
				return false;
		} else if (!lancamento.equals(other.lancamento))
			return false;
		if (situacao == null) {
			if (other.situacao != null)
				return false;
		} else if (!situacao.equals(other.situacao))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cheque [id=" + id + ", conta=" + conta + ", dataCadastro="
				+ dataCadastro + ", situacao=" + situacao + ", lancamento="
				+ lancamento + "]";
	}

	
}
