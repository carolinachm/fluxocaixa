package br.com.sysfinanceiro.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.sysfinanceiro.model.entity.Empresa;

@Repository
public class EmpresaDAO {
	
	// injecao de dependencia do EntityManager
		@PersistenceContext
		private EntityManager em;

		public EmpresaDAO() {
			// em = JPAUtil.abreConexao();
		}

		 @Transactional(noRollbackFor = DAOException.class)
		public void salvar(Empresa empresa) throws DAOException {

			try {
				em.merge(empresa);
			} catch (Exception e) {
				e.printStackTrace();

			}
		}

		@Transactional
		public void excluir(Empresa empresa) {

			try {
				Empresa empresaExcluir = buscarPorId(empresa.getId());
				em.remove(empresaExcluir);
			} catch (Exception e) {
				e.printStackTrace();

			}
		}

		@SuppressWarnings("unchecked")
		public List<Empresa> buscarTodos() {

			Query consulta = em.createQuery("select e from Empresa e", Empresa.class);
			return consulta.getResultList();
		}

		public Empresa buscarPorId(Long id) {
			return em.find(Empresa.class, id);
		}

}
