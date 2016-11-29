package br.com.sysfinanceiro.model.service;

import br.com.sysfinanceiro.model.dao.DAOException;

public class ServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	public ServiceException(String mensagem) {
		super(mensagem);
	}

	public ServiceException(String mensagem, DAOException causa) {
		super(mensagem, causa);
	}

}
