package com.htcursos.model.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.htcursos.model.dao.DAOException;
import com.htcursos.model.dao.EstadoDAO;
import com.htcursos.model.entity.Estado;

@Service
public class EstadoService {
	@Inject
	private EstadoDAO estadoDAO;

	public EstadoDAO getEstadoDAO() {
		return estadoDAO;
	}

	public void setEstadoDAO(EstadoDAO estadoDAO) {
		this.estadoDAO = estadoDAO;
	}

	public void salvar(Estado estado) throws ServiceException {

		try {
			if (estado.getId() == null)
				estadoDAO.salvar(estado);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException("Não foi possivel salvar", e);
		}

	}

	public void excluir(Estado estado) {
		estadoDAO.excluir(estado);

	}

	public List<Estado> buscarTodos() {
		List<Estado> lista = estadoDAO.buscarTodos();
		return lista;
	}

	public Estado buscarPorId(Long id) {
		Estado estado =  estadoDAO.buscarPorId(id);
		return estado;
	}

	

	
}
