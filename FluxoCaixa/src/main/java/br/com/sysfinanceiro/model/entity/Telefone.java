package br.com.sysfinanceiro.model.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Telefone {
	
	private String num;
	
	public Telefone() {
		// TODO Auto-generated constructor stub
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}
	
	
}