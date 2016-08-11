package com.htcursos.model.entity;

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
	private Integer numero;
	private String nomeConta;
	
	public Conta() {
		// TODO Auto-generated constructor stub
	}

	public Conta(Long id, Integer numero, String nomeConta) {
		super();
		this.id = id;
		this.numero = numero;
		this.nomeConta = nomeConta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getNomeConta() {
		return nomeConta;
	}

	public void setNomeConta(String nomeConta) {
		this.nomeConta = nomeConta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((nomeConta == null) ? 0 : nomeConta.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Conta [id=" + id + ", numero=" + numero + ", nomeConta="
				+ nomeConta + "]";
	}
	

}
