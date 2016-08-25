package com.htcursos.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.htcursos.model.entity.Permissao;
@Repository
public class PermissaoDAO {
	@PersistenceContext
	private EntityManager em;
	
	public PermissaoDAO() {
		// em = JPAUtil.abreConexao();
	}

	@Transactional
	public void salvar(Permissao permissao) throws DAOException {

		try {
			em.merge(permissao);
		} catch (Exception causa) {// captura a excecao do banco
			throw new DAOException("Não foi possivel salvar", causa);

		}
	}

	@Transactional
	public void excluir(Permissao permissao) {

		try {
			Permissao permissaoExcluir = buscarPorId(permissao.getId());
			em.remove(permissaoExcluir);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@SuppressWarnings("unchecked")
	public List<Permissao> buscarTodos() {

		Query consulta = em.createQuery("select p from Permissao p",
				Permissao.class);
		return consulta.getResultList();
	}

	public Permissao buscarPorId(Long id) {
		return em.find(Permissao.class, id);
	}

}
