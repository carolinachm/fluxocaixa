package br.com.sysfinanceiro.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.sysfinanceiro.model.entity.Banco;

@Repository
public class BancoDAO {

	// injecao de dependencia do EntityManager
	@PersistenceContext
	private EntityManager em;

	public BancoDAO() {
		// em = JPAUtil.abreConexao();
	}

	 @Transactional(noRollbackFor = DAOException.class)
	public void salvar(Banco banco) throws DAOException {

		try {
			em.merge(banco);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Transactional
	public void excluir(Banco banco) {

		try {
			Banco bancoExcluir = buscarPorId(banco.getId());
			em.remove(bancoExcluir);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@SuppressWarnings("unchecked")
	public List<Banco> buscarTodos() {

		Query consulta = em.createQuery("select e from Banco e", Banco.class);
		return consulta.getResultList();
	}

	public Banco buscarPorId(Long id) {
		return em.find(Banco.class, id);
	}
}
