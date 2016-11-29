package br.com.sysfinanceiro.model.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import br.com.sysfinanceiro.model.dao.DAOException;
import br.com.sysfinanceiro.model.dao.PessoaDAO;
import br.com.sysfinanceiro.model.entity.Estado;
import br.com.sysfinanceiro.model.entity.Pessoa;
@Service
public class PessoaService {
	
	@Inject
	private PessoaDAO pessoaDAO;

	
	public void salvar(Pessoa pessoa) throws ServiceException {
		try {
			// Validação de Regras de Negócio
			if (pessoa.getNome() == null || pessoa.getNome() == "") {
				throw new ServiceException("Campo Nome vázio!");
			}
			pessoaDAO.salvar(pessoa);
		} catch (DAOException e) {
			throw new ServiceException("Não foi possivel salvar!", e);
		}
	}

	public List<Pessoa> buscarTodos() {
		List<Pessoa> lista = pessoaDAO.buscarTodos();
		return lista;
	}

	public void excluir(Pessoa pessoa) {
		pessoaDAO.excluir(pessoa);
		
	}

	public Pessoa buscarPorId(long id) {
		Pessoa pessoa =  pessoaDAO.buscarPorId(id);
		return pessoa;
	}


}
