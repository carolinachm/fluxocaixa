package com.htcursos.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.htcursos.model.entity.Cliente;

@Repository
public class ClienteDAO {

	// injecao de dependencia do EntityManager
	@PersistenceContext
	private EntityManager em;

	public ClienteDAO() {
		// em = JPAUtil.abreConexao();
	}

	 @Transactional(noRollbackFor = DAOException.class)
	public void salvar(Cliente cliente) throws DAOException {

		try {
			em.merge(cliente);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Transactional
	public void excluir(Cliente cliente) {

		try {
			Cliente clienteExcluir = buscarPorId(cliente.getId());
			em.remove(clienteExcluir);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> buscarTodos() {

		Query consulta = em.createQuery("select e from Cliente e", Cliente.class);
		return consulta.getResultList();
	}

	public Cliente buscarPorId(Long id) {
		return em.find(Cliente.class, id);
	}
}
