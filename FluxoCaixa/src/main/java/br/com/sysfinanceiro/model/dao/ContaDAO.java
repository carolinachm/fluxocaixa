package br.com.sysfinanceiro.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.sysfinanceiro.model.entity.Conta;
import br.com.sysfinanceiro.model.entity.Usuario;

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

	public Conta buscarFavorita(Usuario usuario) {
		Query consulta = em.createQuery("select c from Conta c where c.usuario =:usuario ");
		consulta.setParameter("usuario", usuario);
		return (Conta) consulta.getSingleResult();
	}

}
