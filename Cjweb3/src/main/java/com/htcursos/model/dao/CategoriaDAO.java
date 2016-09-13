package com.htcursos.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.htcursos.model.entity.Categoria;

@Repository
public class CategoriaDAO {

	// injecao de dependencia do EntityManager
	@PersistenceContext
	private EntityManager em;

	public CategoriaDAO() {
		// em = JPAUtil.abreConexao();
	}

	 @Transactional(noRollbackFor = DAOException.class)
	public void salvar(Categoria categoria) throws DAOException {

		try {
			em.merge(categoria);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Transactional
	public void excluir(Categoria categoria) {

		try {
			Categoria categoriaExcluir = buscarPorId(categoria.getId());
			em.remove(categoriaExcluir);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@SuppressWarnings("unchecked")
	public List<Categoria> buscarTodos() {

		Query consulta = em.createQuery("select c from Categoria c", Categoria.class);
		return consulta.getResultList();
	}

	public Categoria buscarPorId(Long id) {
		return em.find(Categoria.class, id);
	}
}
