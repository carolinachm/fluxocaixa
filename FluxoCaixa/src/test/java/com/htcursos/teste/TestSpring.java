package com.htcursos.teste;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.sysfinanceiro.model.dao.DAOException;
import br.com.sysfinanceiro.model.dao.UsuarioDAO;
import br.com.sysfinanceiro.model.entity.Usuario;


public class TestSpring {
	
	@Test
	@Ignore
	public void testString() throws DAOException {
		
		ApplicationContext contexto = new ClassPathXmlApplicationContext("applicationContext.xml");
		UsuarioDAO usuarioDAO = contexto.getBean(UsuarioDAO.class);
		
		Usuario usuario = new Usuario();

		usuario.setSenha("1234");

		usuarioDAO.salvar(usuario);
		
		System.out.println("Salvo");
						
		
	}
}
