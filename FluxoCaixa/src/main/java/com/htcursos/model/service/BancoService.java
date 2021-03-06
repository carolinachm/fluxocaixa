package com.htcursos.model.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.htcursos.model.dao.DAOException;
import com.htcursos.model.dao.BancoDAO;
import com.htcursos.model.entity.Banco;

@Service
public class BancoService {
	@Inject
	private BancoDAO bancoDAO;

	public BancoDAO getBancoDAO() {
		return bancoDAO;
	}

	public void setBancoDAO(BancoDAO bancoDAO) {
		this.bancoDAO = bancoDAO;
	}

	public void salvar(Banco banco) throws ServiceException {

		try {
			if (banco.getId() == null)
				bancoDAO.salvar(banco);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException("Não foi possivel salvar", e);
		}

	}

	public void excluir(Banco banco) {
		bancoDAO.excluir(banco);

	}

	public List<Banco> buscarTodos() {
		List<Banco> lista = bancoDAO.buscarTodos();
		return lista;
	}

	public Banco buscarPorId(Long id) {
		Banco banco =  bancoDAO.buscarPorId(id);
		return banco;
	}

	

	
}
