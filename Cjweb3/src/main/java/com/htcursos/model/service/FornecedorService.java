package com.htcursos.model.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.htcursos.model.dao.DAOException;
import com.htcursos.model.dao.FornecedorDAO;
import com.htcursos.model.entity.Fornecedor;

@Service
public class FornecedorService {
	@Inject
	private FornecedorDAO fornecedorDAO;

	public FornecedorDAO getFornecedorDAO() {
		return fornecedorDAO;
	}

	public void setFornecedorDAO(FornecedorDAO fornecedorDAO) {
		this.fornecedorDAO = fornecedorDAO;
	}

	public void salvar(Fornecedor fornecedor) throws ServiceException {

		try {
			if (fornecedor.getId() == null)
				fornecedorDAO.salvar(fornecedor);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException("Não foi possivel salvar", e);
		}

	}

	public void excluir(Fornecedor fornecedor) {
		fornecedorDAO.excluir(fornecedor);

	}

	public List<Fornecedor> buscarTodos() {
		List<Fornecedor> lista = fornecedorDAO.buscarTodos();
		return lista;
	}

	public Fornecedor buscarPorId(Long id) {
		Fornecedor fornecedor =  fornecedorDAO.buscarPorId(id);
		return fornecedor;
	}

	

	
}
