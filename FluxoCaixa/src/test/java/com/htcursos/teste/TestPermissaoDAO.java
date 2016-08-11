package com.htcursos.teste;

import java.util.List;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.htcursos.model.dao.DAOException;
import com.htcursos.model.dao.PermissaoDAO;
import com.htcursos.model.entity.Permissao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class TestPermissaoDAO {
	@Inject
	PermissaoDAO permissaoDAO;

	@Test

	public void salvar() throws DAOException {
		Permissao permissao = new Permissao();
		permissao.setDescricao("Administrador");;

		permissaoDAO.salvar(permissao);
		
		System.out.println("Descricao" + permissao.getDescricao() + "salva com sucesso");

	}

	@Test
	@Ignore
	public void listarTodos() {
		List<Permissao> lista = permissaoDAO.buscarTodos();

		for (Permissao permissao : lista) {
			System.out.println("Descricao" + permissao.getDescricao());
		}
	}
	@Test
	@Ignore
	public void excluir(){
		Long id = 1L;
		
		Permissao permissao = permissaoDAO.buscarPorId(id);
		
		if(permissao == null){
			System.out.println("Nenhum registro encontrado");
		}else{
			permissaoDAO.excluir(permissao);
			System.out.println("Registro removido:");
			System.out.println(permissao.getId() + " - " + permissao.getDescricao() );
		}
	}
	

}
