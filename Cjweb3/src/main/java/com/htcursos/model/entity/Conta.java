package com.htcursos.model.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="tb_conta")
public class Conta {
	
	@Id
	@SequenceGenerator(name="seq_con", initialValue=1)
	@GeneratedValue(generator="seq_con",strategy = GenerationType.AUTO)
	private Long id;
	private String nomeConta;
	private BigDecimal saldoInicial;
	private BigDecimal valorLimite;
	private String observacao;
	
	public Conta() {
		// TODO Auto-generated constructor stub
	}

	public Conta(Long id, String nomeConta, BigDecimal saldoInicial,
			BigDecimal valorLimite, String observacao) {
		super();
		this.id = id;
		this.nomeConta = nomeConta;
		this.saldoInicial = saldoInicial;
		this.valorLimite = valorLimite;
		this.observacao = observacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeConta() {
		return nomeConta;
	}

	public void setNomeConta(String nomeConta) {
		this.nomeConta = nomeConta;
	}

	public BigDecimal getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(BigDecimal saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	public BigDecimal getValorLimite() {
		return valorLimite;
	}

	public void setValorLimite(BigDecimal valorLimite) {
		this.valorLimite = valorLimite;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((nomeConta == null) ? 0 : nomeConta.hashCode());
		result = prime * result
				+ ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result
				+ ((saldoInicial == null) ? 0 : saldoInicial.hashCode());
		result = prime * result
				+ ((valorLimite == null) ? 0 : valorLimite.hashCode());
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
		Conta other = (Conta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nomeConta == null) {
			if (other.nomeConta != null)
				return false;
		} else if (!nomeConta.equals(other.nomeConta))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (saldoInicial == null) {
			if (other.saldoInicial != null)
				return false;
		} else if (!saldoInicial.equals(other.saldoInicial))
			return false;
		if (valorLimite == null) {
			if (other.valorLimite != null)
				return false;
		} else if (!valorLimite.equals(other.valorLimite))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Conta [id=" + id + ", nomeConta=" + nomeConta
				+ ", saldoInicial=" + saldoInicial + ", valorLimite="
				+ valorLimite + ", observacao=" + observacao + "]";
	}
	

}
