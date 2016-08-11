package com.htcursos.model.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.htcursos.model.dao.CidadeDAO;
import com.htcursos.model.dao.DAOException;
import com.htcursos.model.entity.Cidade;
import com.htcursos.model.entity.Estado;
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
			if (cidade.getId() == null)
				cidadeDAO.salvar(cidade);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException("Não foi possivel salvar", e);
		}

	}

	public void excluir(Cidade cidade) {
		cidadeDAO.excluir(cidade);

	}

	public List<Cidade> buscarTodos() {
		List<Cidade> lista = cidadeDAO.buscarTodos();
		return lista;
	}

	public Cidade buscarPorId(long id) {
		Cidade cidade =  cidadeDAO.buscarPorId(id);
		return cidade;
	}

	public List<Cidade> buscarCidades(Estado estado) {
		
		return cidadeDAO.buscarCidades(estado);
	}

}
