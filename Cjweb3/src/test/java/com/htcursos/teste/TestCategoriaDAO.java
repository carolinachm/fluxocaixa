package com.htcursos.teste;

import java.util.List;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.htcursos.model.dao.CategoriaDAO;
import com.htcursos.model.dao.DAOException;
import com.htcursos.model.entity.Categoria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class TestCategoriaDAO {
	@Inject
	CategoriaDAO categoriaDAO;

	@Test

	public void salvar() throws DAOException {
		Categoria categoria = new Categoria();

		categoria.setNumero(1);
		categoria.setDescricao("Despesa");

		categoriaDAO.salvar(categoria);

	}

	@Test
	@Ignore
	public void listarTodos() {
		List<Categoria> lista = categoriaDAO.buscarTodos();

		for (Categoria categoria : lista) {
			System.out.println("Nome" + categoria.getDescricao());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long id = 1L;

		Categoria categoria = categoriaDAO.buscarPorId(id);

		if (categoria == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			categoriaDAO.excluir(categoria);
			System.out.println("Registro removido:");
			System.out.println(categoria.getId() + " - " + categoria.getDescricao());
		}
	}

}
