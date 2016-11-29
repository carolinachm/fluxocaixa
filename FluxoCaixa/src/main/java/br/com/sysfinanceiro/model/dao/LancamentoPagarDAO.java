package br.com.sysfinanceiro.model.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.sysfinanceiro.model.entity.Conta;
import br.com.sysfinanceiro.model.entity.Lancamento;

@Repository
public class LancamentoPagarDAO {

	// injecao de dependencia do EntityManager
	@PersistenceContext
	private EntityManager em;

	public LancamentoPagarDAO() {
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

		Query consulta = em.createQuery("select l from Lancamento l",
				Lancamento.class);
		return consulta.getResultList();
	}

	public Lancamento buscarPorId(Long id) {
		return em.find(Lancamento.class, id);
	}
/*
	public float saldo(Conta conta, Date data) {
		StringBuffer sql = new StringBuffer();
		sql.append("select sum(1.valor * c.fator)");
		sql.append("from LANCAMENTO 1,");
		sql.append("CATEGORIA c");
		sql.append("where 1.categoria = c.id");
		sql.append("and 1.conta =:conta");
		sql.append("and 1.data <=:data");

		Query query = em.createQuery(sql.toString());
		query.setParameter("conta", conta);
		query.setParameter("data", data);

		BigDecimal saldo = (BigDecimal) query.uniquerResult();
		if (saldo != null) {
			return saldo.floatValue();
		}
		return 0f;
	}

	public List<Lancamento> listar(Conta conta, Date dataInicial, Date dataFim) {
		Query consulta = em.createQuery(Lancamento.class);
		
		if(dataInicial !=null && dataFim !=null){
			consulta.setParameter("data", dataInicial,dataFim);
		}else if(dataInicial !=null){
			consulta.setParameter("data", dataInicial);
		}else if(dataFinal !=null){
			consulta.setParameter("data", dataFinal);
			
		return consulta.getResultList();
	}
*/
}
