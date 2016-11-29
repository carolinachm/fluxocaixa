package br.com.sysfinanceiro.model.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import br.com.sysfinanceiro.model.dao.DAOException;
import br.com.sysfinanceiro.model.dao.EmpresaDAO;
import br.com.sysfinanceiro.model.entity.Empresa;

@Service
public class EmpresaService {
	@Inject
	private EmpresaDAO empresaDAO;

	public EmpresaDAO getEmpresaDAO() {
		return empresaDAO;
	}

	public void setEmpresaDAO(EmpresaDAO empresaDAO) {
		this.empresaDAO = empresaDAO;
	}

	public void salvar(Empresa empresa) throws ServiceException {

		try {
			if (empresa.getId() == null)
				empresaDAO.salvar(empresa);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException("Não foi possivel salvar", e);
		}

	}

	public void excluir(Empresa empresa) {
		empresaDAO.excluir(empresa);

	}

	public List<Empresa> buscarTodos() {
		List<Empresa> lista = empresaDAO.buscarTodos();
		return lista;
	}

	public Empresa buscarPorId(Long id) {
		Empresa empresa =  empresaDAO.buscarPorId(id);
		return empresa;
	}

	

	
}
