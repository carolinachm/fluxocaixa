package com.htcursos.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.htcursos.model.entity.Cidade;
import com.htcursos.model.entity.Estado;

@Repository
public class CidadeDAO {
	@PersistenceContext
	private EntityManager em;

	public CidadeDAO() {
		// em = JPAUtil.abreConexao();
	}

	@Transactional
	public void salvar(Cidade cidade) throws DAOException {

		try {
			em.merge(cidade);
		} catch (Exception causa) {// captura a excecao do banco
			throw new DAOException("Não foi possivel salvar", causa);

		}
	}

	@Transactional
	public void excluir(Cidade cidade) {

		try {
			Cidade cidadeExcluir = buscarPorId(cidade.getId());
			em.remove(cidadeExcluir);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@SuppressWarnings("unchecked")
	public List<Cidade> buscarTodos() {

		Query consulta = em.createQuery("select c from Cidade c", Cidade.class);
		return consulta.getResultList();
	}

	public Cidade buscarPorId(Long id) {
		return em.find(Cidade.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Cidade> buscarCidades(Estado estado) {
		Query consulta = em
				.createQuery("select c from Cidade c where c.estado =:est");
		consulta.setParameter("est", estado);

		return consulta.getResultList();
	}

}
