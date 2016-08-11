package com.htcursos.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.htcursos.model.entity.Usuario;

@Repository
public class UsuarioDAO {

	// injecao de dependencia do EntityManager
	@PersistenceContext
	private EntityManager em;

	public UsuarioDAO() {
		// em = JPAUtil.abreConexao();
	}

	@Transactional
	public void salvar(Usuario usuario) throws DAOException {

		try {
			em.merge(usuario);
		} catch (Exception causa) {// captura a excecao do banco
			throw new DAOException("Não foi possivel salvar", causa);

		}
	}

	@Transactional
	public void excluir(Usuario usuario){
			Usuario usuarioExcluir = buscarPorId(usuario.getId());
			em.remove(usuarioExcluir);
		
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> buscarTodos() {

		Query consulta = em.createQuery("select u from Usuario u",
				Usuario.class);
		return consulta.getResultList();
	}

	public Usuario buscarPorId(Long id) {
		return em.find(Usuario.class, id);
	}
}
