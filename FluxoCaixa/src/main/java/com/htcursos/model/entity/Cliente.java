package com.htcursos.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_cliente")
public class Cliente {

	@Id
	@SequenceGenerator(name = "seq_cli", initialValue = 1)
	@GeneratedValue(generator = "seq_cli", strategy = GenerationType.AUTO)
	@Temporal(TemporalType.DATE)
	@Column(name = "dataCadastro", nullable = false)
	private Date dataCadastro;
	@Column(name = "liberado", nullable = false)
	private Boolean liberado;
	@OneToOne
	@JoinColumn(nullable = false)
	private Pessoa pessoa;
	@Embedded
	private Endereco endereco;
	@Embedded
	private Telefone telefone;

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(Date dataCadastro, Boolean liberado, Pessoa pessoa,
			Endereco endereco, Telefone telefone) {
		super();
		this.dataCadastro = dataCadastro;
		this.liberado = liberado;
		this.pessoa = pessoa;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Boolean getLiberado() {
		return liberado;
	}

	public void setLiberado(Boolean liberado) {
		this.liberado = liberado;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result
				+ ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result
				+ ((liberado == null) ? 0 : liberado.hashCode());
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		result = prime * result
				+ ((telefone == null) ? 0 : telefone.hashCode());
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
		Cliente other = (Cliente) obj;
		if (dataCadastro == null) {
			if (other.dataCadastro != null)
				return false;
		} else if (!dataCadastro.equals(other.dataCadastro))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (liberado == null) {
			if (other.liberado != null)
				return false;
		} else if (!liberado.equals(other.liberado))
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [dataCadastro=" + dataCadastro + ", liberado="
				+ liberado + ", pessoa=" + pessoa + ", endereco=" + endereco
				+ ", telefone=" + telefone + "]";
	}

}
