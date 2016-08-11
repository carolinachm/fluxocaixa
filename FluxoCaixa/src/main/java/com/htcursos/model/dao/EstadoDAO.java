package com.htcursos.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.htcursos.model.entity.Estado;

@Repository
public class EstadoDAO {

	// injecao de dependencia do EntityManager
	@PersistenceContext
	private EntityManager em;

	public EstadoDAO() {
		// em = JPAUtil.abreConexao();
	}

	@Transactional
	public void salvar(Estado estado) throws DAOException {

		try {
			em.merge(estado);
		} catch (Exception causa) {// captura a excecao do banco
			throw new DAOException("Não foi possivel salvar", causa);

		}
	}

	@Transactional
	public void excluir(Estado estado) {

		try {
			Estado estadoExcluir = buscarPorId(estado.getId());
			em.remove(estadoExcluir);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@SuppressWarnings("unchecked")
	public List<Estado> buscarTodos() {

		Query consulta = em.createQuery("select e from Estado e",
				Estado.class);
		return consulta.getResultList();
	}

	public Estado buscarPorId(Long id) {
		return em.find(Estado.class, id);
	}
}
