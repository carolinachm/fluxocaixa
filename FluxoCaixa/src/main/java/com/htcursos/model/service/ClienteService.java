package com.htcursos.model.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.htcursos.model.dao.DAOException;
import com.htcursos.model.dao.ClienteDAO;
import com.htcursos.model.entity.Cliente;

@Service
public class ClienteService {
	@Inject
	private ClienteDAO clienteDAO;

	public ClienteDAO getClienteDAO() {
		return clienteDAO;
	}

	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	public void salvar(Cliente cliente) throws ServiceException {

		try {
			if (cliente.getId() == null)
				clienteDAO.salvar(cliente);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException("Não foi possivel salvar", e);
		}

	}

	public void excluir(Cliente cliente) {
		clienteDAO.excluir(cliente);

	}

	public List<Cliente> buscarTodos() {
		List<Cliente> lista = clienteDAO.buscarTodos();
		return lista;
	}

	public Cliente buscarPorId(Long id) {
		Cliente cliente =  clienteDAO.buscarPorId(id);
		return cliente;
	}

	

	
}
