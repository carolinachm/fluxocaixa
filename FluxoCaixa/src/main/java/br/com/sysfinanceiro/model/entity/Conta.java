package br.com.sysfinanceiro.model.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	@Column(unique=true)
	private String descricao;
	private Date dataCadastro;
	private BigDecimal saldoInicial;
	private boolean favorita;
	private Usuario usuario;
	
	public Conta() {
		// TODO Auto-generated constructor stub
	}

	public Conta(Long id, String descricao, Date dataCadastro,
			BigDecimal saldoInicial, boolean favorita, Usuario usuario) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.dataCadastro = dataCadastro;
		this.saldoInicial = saldoInicial;
		this.favorita = favorita;
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public BigDecimal getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(BigDecimal saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	public boolean isFavorita() {
		return favorita;
	}

	public void setFavorita(boolean favorita) {
		this.favorita = favorita;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + (favorita ? 1231 : 1237);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((saldoInicial == null) ? 0 : saldoInicial.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		if (dataCadastro == null) {
			if (other.dataCadastro != null)
				return false;
		} else if (!dataCadastro.equals(other.dataCadastro))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (favorita != other.favorita)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (saldoInicial == null) {
			if (other.saldoInicial != null)
				return false;
		} else if (!saldoInicial.equals(other.saldoInicial))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Conta [id=" + id + ", descricao=" + descricao
				+ ", dataCadastro=" + dataCadastro + ", saldoInicial="
				+ saldoInicial + ", favorita=" + favorita + ", usuario="
				+ usuario + "]";
	}
	

}
