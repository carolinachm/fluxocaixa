package com.htcursos.model.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.htcursos.model.dao.ContaDAO;
import com.htcursos.model.dao.DAOException;
import com.htcursos.model.entity.Conta;
import com.htcursos.model.entity.Usuario;

@Service
public class ContaService {
	
	@Inject
	private ContaDAO contaDAO;

	
	public void salvar(Conta conta) throws ServiceException {
		try {
			// Valida��o de Regras de Neg�cio
			if (conta.getDescricao() == null || conta.getDescricao() == "") {
				throw new ServiceException("Campo Descricao v�zio!");
			}
			contaDAO.salvar(conta);
		} catch (DAOException e) {
			throw new ServiceException("N�o foi possivel salvar!", e);
		}
	}

	public List<Conta> buscarTodos() {
		List<Conta> lista = contaDAO.buscarTodos();
		return lista;
	}

	public void excluir(Conta conta) {
		contaDAO.excluir(conta);
		
	}

	public Conta buscarPorId(long id) {
		Conta conta =  contaDAO.buscarPorId(id);
		return conta;
	}
	
	public Conta buscarFavorita(Usuario usuario){
		return contaDAO.buscarFavorita(usuario);
	}

	public void tornarFavorita(Conta contaFavorita) throws DAOException {
		Conta conta = buscarFavorita(contaFavorita.getUsuario());
		if(conta !=null){
			conta.setFavorita(false);
			contaDAO.salvar(conta);
		}
		conta.setFavorita(true);
		contaDAO.salvar(contaFavorita);
		
	}


}
