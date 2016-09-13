package com.htcursos.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.htcursos.model.entity.SubCategoria;

@Repository
public class SubCategoriaDAO {

	// injecao de dependencia do EntityManager
	@PersistenceContext
	private EntityManager em;

	public SubCategoriaDAO() {
		// em = JPAUtil.abreConexao();
	}

	 @Transactional(noRollbackFor = DAOException.class)
	public void salvar(SubCategoria subCategoria) throws DAOException {

		try {
			em.merge(subCategoria);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Transactional
	public void excluir(SubCategoria subCategoria) {

		try {
			SubCategoria subCategoriaExcluir = buscarPorId(subCategoria.getId());
			em.remove(subCategoriaExcluir);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@SuppressWarnings("unchecked")
	public List<SubCategoria> buscarTodos() {

		Query consulta = em.createQuery("select sc from SubCategoria sc", SubCategoria.class);
		return consulta.getResultList();
	}

	public SubCategoria buscarPorId(Long id) {
		return em.find(SubCategoria.class, id);
	}
}
