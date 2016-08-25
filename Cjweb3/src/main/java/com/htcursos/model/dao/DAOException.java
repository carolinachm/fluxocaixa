package com.htcursos.model.dao;

public class DAOException extends Exception {

	private static final long serialVersionUID = 1L;

	public DAOException(String mensagem, Exception causa) {
		super(mensagem, causa);
	}

}
