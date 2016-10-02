package com.htcursos.model.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.htcursos.model.dao.DAOException;
import com.htcursos.model.dao.UsuarioDAO;
import com.htcursos.model.entity.Usuario;

@Service
public class UsuarioService {

	// @Autowired
	@Inject
	private UsuarioDAO usuarioDAO;
	

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	
	public void salvar(Usuario usuario) throws ServiceException {

		try {
			if (usuario.getId() == null)
				usuarioDAO.salvar(usuario);
			
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException("Não foi possivel salvar", e);
		}

	}

	public void excluir(Usuario usuario) {
		usuarioDAO.excluir(usuario);

	}

	public List<Usuario> buscarTodos() {
		List<Usuario> lista = usuarioDAO.buscarTodos();
		return lista;
	}

}
