package br.com.sysfinanceiro.model.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import br.com.sysfinanceiro.model.dao.DAOException;
import br.com.sysfinanceiro.model.dao.LancamentoDAO;
import br.com.sysfinanceiro.model.entity.Conta;
import br.com.sysfinanceiro.model.entity.Lancamento;

@Service
public class LancamentoPagarService {
	@Inject
	private LancamentoDAO lancamentoDAO;

	public LancamentoDAO getLancamentoDAO() {
		return lancamentoDAO;
	}

	public void setLancamentoDAO(LancamentoDAO lancamentoDAO) {
		this.lancamentoDAO = lancamentoDAO;
	}

	public void salvar(Lancamento lancamento) throws ServiceException {

		try {
			if (lancamento.getId() == null)
				lancamentoDAO.salvar(lancamento);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException("Não foi possivel salvar", e);
		}

	}

	public void excluir(Lancamento lancamento) {
		lancamentoDAO.excluir(lancamento);

	}

	public List<Lancamento> buscarTodos() {
		List<Lancamento> lista = lancamentoDAO.buscarTodos();
		return lista;
	}

	public Lancamento buscarPorId(Long id) {
		Lancamento lancamento =  lancamentoDAO.buscarPorId(id);
		return lancamento;
	}
	
	/*public float saldo(Conta conta, Date data){
		BigDecimal saldoInicial = conta.getSaldoInicial();
		float saldoNaData = lancamentoDAO.saldo(conta, data);
		return saldoInicial + saldoNaData;
	}
	public List<Lancamento> listar(Conta conta, Date dataInicial, Date dataFim){
		return lancamentoDAO.listar(conta, dataInicial, dataFim);
	}*/
}
