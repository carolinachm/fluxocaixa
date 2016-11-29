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

import br.com.sysfinanceiro.model.dao.CidadeDAO;
import br.com.sysfinanceiro.model.dao.DAOException;
import br.com.sysfinanceiro.model.dao.EstadoDAO;
import br.com.sysfinanceiro.model.entity.Cidade;
import br.com.sysfinanceiro.model.entity.Estado;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class TestCidadeDAO {
	@Inject
	private EstadoDAO estadoDAO;
	@Inject
	private CidadeDAO cidadeDAO;
	@Test
	@Ignore
	public void salvar() throws DAOException{
		
		Estado estado = estadoDAO.buscarPorId(8L);
		
		Cidade cidade = new Cidade();
		cidade.setNome("Varginha");
		cidade.setEstado(estado);
		
		cidadeDAO.salvar(cidade);
	}
	
	

}
