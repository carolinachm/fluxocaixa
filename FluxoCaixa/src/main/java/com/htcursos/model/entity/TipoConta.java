package com.htcursos.model.entity;

public enum TipoConta {

	CORRENTE("Corrente"), POUPANCA("Poupança"), INVESTIMENTO("Investimento");

	private String descricao;

	private TipoConta(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
