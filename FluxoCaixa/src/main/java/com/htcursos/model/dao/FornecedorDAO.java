package com.htcursos.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.htcursos.model.entity.Fornecedor;

@Repository
public class FornecedorDAO {

	// injecao de dependencia do EntityManager
	@PersistenceContext
	private EntityManager em;

	public FornecedorDAO() {
		// em = JPAUtil.abreConexao();
	}

	 @Transactional(noRollbackFor = DAOException.class)
	public void salvar(Fornecedor fornecedor) throws DAOException {

		try {
			em.merge(fornecedor);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Transactional
	public void excluir(Fornecedor fornecedor) {

		try {
			Fornecedor fornecedorExcluir = buscarPorId(fornecedor.getId());
			em.remove(fornecedorExcluir);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@SuppressWarnings("unchecked")
	public List<Fornecedor> buscarTodos() {

		Query consulta = em.createQuery("select e from Fornecedor e", Fornecedor.class);
		return consulta.getResultList();
	}

	public Fornecedor buscarPorId(Long id) {
		return em.find(Fornecedor.class, id);
	}
}
