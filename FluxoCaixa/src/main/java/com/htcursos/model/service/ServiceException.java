package com.htcursos.model.service;

import com.htcursos.model.dao.DAOException;

public class ServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	public ServiceException(String mensagem) {
		super(mensagem);
	}

	public ServiceException(String mensagem, DAOException causa) {
		super(mensagem, causa);
	}

}
