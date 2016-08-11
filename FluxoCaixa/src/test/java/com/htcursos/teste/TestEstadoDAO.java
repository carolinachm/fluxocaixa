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
import com.htcursos.model.dao.EstadoDAO;
import com.htcursos.model.entity.Estado;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class TestEstadoDAO {
	@Inject
	EstadoDAO estadoDAO;

	@Test
	
	public void salvar() throws DAOException {
		Estado estado = new Estado();
		estado.setNome("Goias");
		estado.setUf("GO");

		estadoDAO.salvar(estado);

	}

	@Test
	@Ignore
	public void listarTodos() {
		List<Estado> lista = estadoDAO.buscarTodos();

		for (Estado estado : lista) {
			System.out.println("Nome" + estado.getNome() + "UF"
					+ estado.getUf());
		}
	}
	@Test
	
	public void excluir(){
		Long id = 1L;
		
		Estado estado = estadoDAO.buscarPorId(id);
		
		if(estado == null){
			System.out.println("Nenhum registro encontrado");
		}else{
			estadoDAO.excluir(estado);
			System.out.println("Registro removido:");
			System.out.println(estado.getId() + " - " + estado.getUf() + " - " + estado.getNome());
		}
	}
	

}
