package com.htcursos.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "tb_categoria")
public class Categoria {
	
	@Id
	@SequenceGenerator(name = "seq_cat", initialValue = 1)
	@GeneratedValue(generator = "seq_cat", strategy = GenerationType.AUTO)
	private Long id;
	private String numCategoria;
	private String descricao;
	
	public Categoria() {
		// TODO Auto-generated constructor stub
	}

	public Categoria(Long id, String numCategoria, String descricao) {
		super();
		this.id = id;
		this.numCategoria = numCategoria;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumCategoria() {
		return numCategoria;
	}

	public void setNumCategoria(String numCategoria) {
		this.numCategoria = numCategoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((numCategoria == null) ? 0 : numCategoria.hashCode());
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
		Categoria other = (Categoria) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numCategoria == null) {
			if (other.numCategoria != null)
				return false;
		} else if (!numCategoria.equals(other.numCategoria))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", numCategoria=" + numCategoria
				+ ", descricao=" + descricao + "]";
	}
	
	
}