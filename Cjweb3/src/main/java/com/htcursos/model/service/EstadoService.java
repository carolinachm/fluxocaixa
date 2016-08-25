package com.htcursos.model.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.htcursos.model.dao.DAOException;
import com.htcursos.model.dao.EstadoDAO;
import com.htcursos.model.entity.Estado;
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
			// Validação de Regras de Negócio
			if (estado.getNome() == null || estado.getNome() == "") {
				throw new ServiceException("Campo Nome vázio!");
			}
			estadoDAO.salvar(estado);
		} catch (DAOException e) {
			throw new ServiceException("Não foi possivel salvar!", e);
		}
	}

	public List<Estado> buscarTodos() {
		List<Estado> lista = estadoDAO.buscarTodos();
		return lista;
	}

	public void excluir(Estado estado) {
		estadoDAO.excluir(estado);
		
	}


	public Estado buscarPorId(Long id) {
		return estadoDAO.buscarPorId(id);
	}


	

	
}
