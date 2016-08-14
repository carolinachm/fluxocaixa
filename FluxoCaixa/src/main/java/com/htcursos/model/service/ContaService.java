package com.htcursos.model.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.htcursos.model.dao.ContaDAO;
import com.htcursos.model.dao.DAOException;
import com.htcursos.model.entity.Conta;

@Service
public class ContaService {
	
	@Inject
	private ContaDAO contaDAO;

	
	public void salvar(Conta conta) throws ServiceException {
		try {
			// Valida��o de Regras de Neg�cio
			if (conta.getConta() == null || conta.getAgencia() =="") {
				throw new ServiceException("Campo Nome v�zio!");
			}
			contaDAO.salvar(conta);
		} catch (DAOException e) {
			throw new ServiceException("N�o foi possivel salvar!", e);
		}
	}

	public List<Conta> buscarTodos() {
		List<Conta> lista = contaDAO.buscarTodos();
		return lista;
	}

	public void excluir(Conta conta) {
		contaDAO.excluir(conta);
		
	}

	public Conta buscarPorId(long id) {
		Conta conta =  contaDAO.buscarPorId(id);
		return conta;
	}


}
