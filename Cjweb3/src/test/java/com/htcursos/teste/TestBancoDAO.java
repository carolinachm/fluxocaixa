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

import com.htcursos.model.dao.BancoDAO;
import com.htcursos.model.dao.DAOException;
import com.htcursos.model.entity.Banco;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class TestBancoDAO {
	@Inject
	BancoDAO bancoDAO;

	@Test

	public void salvar() throws DAOException {
		Banco banco = new Banco();
		banco.setNome("Banco do Brasil");
		banco.setNumero(1);
		banco.setSigla("BB");

		bancoDAO.salvar(banco);

	}

	@Test
	@Ignore
	public void listarTodos() {
		List<Banco> lista = bancoDAO.buscarTodos();

		for (Banco banco : lista) {
			System.out.println("Nome" + banco.getNome());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long id = 1L;

		Banco banco = bancoDAO.buscarPorId(id);

		if (banco == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			bancoDAO.excluir(banco);
			System.out.println("Registro removido:");
			System.out.println(banco.getId() + " - " + banco.getNome());
		}
	}

}
