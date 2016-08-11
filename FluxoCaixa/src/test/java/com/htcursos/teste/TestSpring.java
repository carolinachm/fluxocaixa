package com.htcursos.teste;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.htcursos.model.dao.DAOException;
import com.htcursos.model.dao.UsuarioDAO;
import com.htcursos.model.entity.Usuario;


public class TestSpring {
	
	@Test
	public void testString() throws DAOException {
		
		ApplicationContext contexto = new ClassPathXmlApplicationContext("applicationContext.xml");
		UsuarioDAO usuarioDAO = contexto.getBean(UsuarioDAO.class);
		
		Usuario usuario = new Usuario();

		usuario.setSenha("1234");

		usuarioDAO.salvar(usuario);
		
		System.out.println("Salvo");
						
		
	}
}
