package com.htcursos.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.htcursos.model.entity.Lancamento;

@Repository
public class LancamentoDAO {

	// injecao de dependencia do EntityManager
	@PersistenceContext
	private EntityManager em;

	public LancamentoDAO() {
		// em = JPAUtil.abreConexao();
	}

	 @Transactional(noRollbackFor = DAOException.class)
	public void salvar(Lancamento lancamento) throws DAOException {

		try {
			em.merge(lancamento);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Transactional
	public void excluir(Lancamento lancamento) {

		try {
			Lancamento lancamentoExcluir = buscarPorId(lancamento.getId());
			em.remove(lancamentoExcluir);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@SuppressWarnings("unchecked")
	public List<Lancamento> buscarTodos() {

		Query consulta = em.createQuery("select l from Lancamento l", Lancamento.class);
		return consulta.getResultList();
	}

	public Lancamento buscarPorId(Long id) {
		return em.find(Lancamento.class, id);
	}
}
