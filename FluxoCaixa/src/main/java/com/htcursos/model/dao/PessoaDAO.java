package com.htcursos.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.htcursos.model.entity.Pessoa;
import com.htcursos.model.entity.Estado;

@Repository
public class PessoaDAO {
	@PersistenceContext
	private EntityManager em;

	public PessoaDAO() {
		// em = JPAUtil.abreConexao();
	}

	@Transactional
	public void salvar(Pessoa pessoa) throws DAOException {

		try {
			em.merge(pessoa);
		} catch (Exception causa) {// captura a excecao do banco
			throw new DAOException("Não foi possivel salvar", causa);

		}
	}

	@Transactional
	public void excluir(Pessoa pessoa) {

		try {
			Pessoa pessoaExcluir = buscarPorId(pessoa.getId());
			em.remove(pessoaExcluir);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@SuppressWarnings("unchecked")
	public List<Pessoa> buscarTodos() {

		Query consulta = em.createQuery("select c from Pessoa c", Pessoa.class);
		return consulta.getResultList();
	}

	public Pessoa buscarPorId(Long id) {
		return em.find(Pessoa.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Pessoa> buscarPessoas(Estado estado) {
		Query consulta = em
				.createQuery("select c from Pessoa c where c.estado =:est");
		consulta.setParameter("est", estado);

		return consulta.getResultList();
	}

}
