package com.htcursos.model.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.htcursos.model.dao.PessoaDAO;
import com.htcursos.model.dao.DAOException;
import com.htcursos.model.entity.Pessoa;
import com.htcursos.model.entity.Estado;
@Service
public class PessoaService {
	
	@Inject
	private PessoaDAO pessoaDAO;

	
	public PessoaDAO getPessoaDAO() {
		return pessoaDAO;
	}

	public void setPessoaDAO(PessoaDAO pessoaDAO) {
		this.pessoaDAO = pessoaDAO;
	}

	public void salvar(Pessoa pessoa) throws ServiceException {

		try {
			if (pessoa.getId() == null)
				pessoaDAO.salvar(pessoa);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException("Não foi possivel salvar", e);
		}

	}

	public void excluir(Pessoa pessoa) {
		pessoaDAO.excluir(pessoa);

	}

	public List<Pessoa> buscarTodos() {
		List<Pessoa> lista = pessoaDAO.buscarTodos();
		return lista;
	}

	public Pessoa buscarPorId(Long id) {
		Pessoa pessoa =  pessoaDAO.buscarPorId(id);
		return pessoa;
	}

	public List<Pessoa> buscarPessoas(Estado estado) {
		
		return pessoaDAO.buscarPessoas(estado);
	}

}
