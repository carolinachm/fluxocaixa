package br.com.sysfinanceiro.model.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import br.com.sysfinanceiro.model.dao.CidadeDAO;
import br.com.sysfinanceiro.model.dao.DAOException;
import br.com.sysfinanceiro.model.entity.Cidade;
import br.com.sysfinanceiro.model.entity.Estado;
@Service
public class CidadeService {
	
	@Inject
	private CidadeDAO cidadeDAO;

	
	public CidadeDAO getCidadeDAO() {
		return cidadeDAO;
	}

	public void setCidadeDAO(CidadeDAO cidadeDAO) {
		this.cidadeDAO = cidadeDAO;
	}

	public void salvar(Cidade cidade) throws ServiceException {
		try {
			// Validação de Regras de Negócio
			if (cidade.getNome() == null || cidade.getNome() == "") {
				throw new ServiceException("Campo Nome vázio!");
			}
			cidadeDAO.salvar(cidade);
		} catch (DAOException e) {
			throw new ServiceException("Não foi possivel salvar!", e);
		}
	}

	public List<Cidade> buscarTodos() {
		List<Cidade> lista = cidadeDAO.buscarTodos();
		return lista;
	}

	public void excluir(Cidade cidade) {
		cidadeDAO.excluir(cidade);
		
	}

	public Cidade buscarPorId(long id) {
		Cidade cidade =  cidadeDAO.buscarPorId(id);
		return cidade;
	}

	public List<Cidade> buscarCidades(Estado estado) {
		
		return cidadeDAO.buscarCidades(estado);
	}

}
