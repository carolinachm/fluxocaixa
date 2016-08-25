package com.htcursos.model.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.htcursos.model.dao.DAOException;
import com.htcursos.model.dao.LancamentoDAO;
import com.htcursos.model.entity.Lancamento;

@Service
public class LancamentoService {
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

	

	
}
