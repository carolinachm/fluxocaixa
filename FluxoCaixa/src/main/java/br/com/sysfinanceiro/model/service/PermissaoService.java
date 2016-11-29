package br.com.sysfinanceiro.model.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import br.com.sysfinanceiro.model.dao.DAOException;
import br.com.sysfinanceiro.model.dao.PermissaoDAO;
import br.com.sysfinanceiro.model.entity.Permissao;

@Service
public class PermissaoService {
	
	@Inject
	private PermissaoDAO permissaoDAO;

	
	public PermissaoDAO getPermissaoDAO() {
		return permissaoDAO;
	}

	public void setPermissaoDAO(PermissaoDAO permissaoDAO) {
		this.permissaoDAO = permissaoDAO;
	}

	public void salvar(Permissao permissao) throws ServiceException {

		try {
			if (permissao.getId() == null)
				permissaoDAO.salvar(permissao);
		} catch (DAOException e) {
			e.printStackTrace();
		}

	}

	public void excluir(Permissao permissao) {
		permissaoDAO.excluir(permissao);

	}

	public List<Permissao> buscarTodos() {
		List<Permissao> lista = permissaoDAO.buscarTodos();
		return lista;
	}

	public Permissao buscarPorId(long id) {
		Permissao permissao =  permissaoDAO.buscarPorId(id);
		return permissao;
	}

}
