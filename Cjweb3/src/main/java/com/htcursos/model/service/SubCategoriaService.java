package com.htcursos.model.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.htcursos.model.dao.DAOException;
import com.htcursos.model.dao.SubCategoriaDAO;
import com.htcursos.model.entity.SubCategoria;

@Service
public class SubCategoriaService {
	@Inject
	private SubCategoriaDAO subCategoriaDAO;

	public SubCategoriaDAO getSubCategoriaDAO() {
		return subCategoriaDAO;
	}

	public void setSubCategoriaDAO(SubCategoriaDAO subCategoriaDAO) {
		this.subCategoriaDAO = subCategoriaDAO;
	}

	public void salvar(SubCategoria subCategoria) throws ServiceException {

		try {
			if (subCategoria.getId() == null)
				subCategoriaDAO.salvar(subCategoria);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException("Não foi possivel salvar", e);
		}

	}

	public void excluir(SubCategoria subCategoria) {
		subCategoriaDAO.excluir(subCategoria);

	}

	public List<SubCategoria> buscarTodos() {
		List<SubCategoria> lista = subCategoriaDAO.buscarTodos();
		return lista;
	}

	public SubCategoria buscarPorId(Long id) {
		SubCategoria subCategoria =  subCategoriaDAO.buscarPorId(id);
		return subCategoria;
	}

	

	
}
