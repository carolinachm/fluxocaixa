package br.com.sysfinanceiro.model.entity;

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
	private Long id;
	@Temporal(TemporalType.DATE)
	@Column(name = "dataCadastro", nullable = false)
	private Date dataCadastro;
	@Column(name = "liberado", nullable = false)
	private Boolean liberado;
	@OneToOne
	@JoinColumn(nullable = false)
	private Pessoa pessoa;
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(Long id, Date dataCadastro, Boolean liberado, Pessoa pessoa) {
		super();
		this.id = id;
		this.dataCadastro = dataCadastro;
		this.liberado = liberado;
		this.pessoa = pessoa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((liberado == null) ? 0 : liberado.hashCode());
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", dataCadastro=" + dataCadastro
				+ ", liberado=" + liberado + ", pessoa=" + pessoa + "]";
	}

	
	

}
