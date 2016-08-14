package com.htcursos.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.htcursos.model.entity.Conta;


@Repository
public class ContaDAO {
	@PersistenceContext
	private EntityManager em;

	public ContaDAO() {
		// em = JPAUtil.abreConexao();
	}
	
	@Transactional
	public void salvar(Conta conta) throws DAOException {

		try {
			em.merge(conta);
		} catch (Exception causa) {// captura a excecao do banco
			throw new DAOException("Não foi possivel salvar", causa);

		}
	}

	@Transactional
	public void excluir(Conta conta) {
		conta = buscarPorId(conta.getId());
		em.remove(conta);
}

	@SuppressWarnings("unchecked")
	public List<Conta> buscarTodos() {

		Query consulta = em.createQuery("select c from Conta c", Conta.class);
		return consulta.getResultList();
	}

	public Conta buscarPorId(Long id) {
		return em.find(Conta.class, id);
	}

	

}
