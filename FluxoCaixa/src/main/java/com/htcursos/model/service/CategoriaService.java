package com.htcursos.model.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.htcursos.model.dao.DAOException;
import com.htcursos.model.dao.CategoriaDAO;
import com.htcursos.model.entity.Categoria;
import com.htcursos.model.entity.Usuario;

@Service
public class CategoriaService {

	@Inject
		private CategoriaDAO categoriaDAO;
	
		public CategoriaDAO getCategoriaDAO() {
			return categoriaDAO;
		}
	
		public void setCategoriaDAO(CategoriaDAO categoriaDAO) {
			this.categoriaDAO = categoriaDAO;
		}
	
		public void salvar(Categoria categoria) throws ServiceException {
	
			try {
				if (categoria.getId() == null)
					categoriaDAO.salvar(categoria);
			} catch (DAOException e) {
				e.printStackTrace();
				throw new ServiceException("Não foi possivel salvar", e);
			}
	
		}
	
		public void excluir(Categoria categoria) {
			categoriaDAO.excluir(categoria);
	
		}
	
		public List<Categoria> buscarTodos() {
			List<Categoria> lista = categoriaDAO.buscarTodos();
			return lista;
		}
	
		public Categoria buscarPorId(Long id) {
			Categoria categoria =  categoriaDAO.buscarPorId(id);
			return categoria;
		}
	
	
}
