package com.htcursos.model.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	protected static EntityManagerFactory factory;// fabrica de conexão
	protected static EntityManager em;//gerenciador de entidades
	
	//Executa apenas a primeira vez
	static {
		//instanciando a fabrica
		factory = Persistence.createEntityManagerFactory("Cjweb3PU");
		//instanciando o gerenciador
		em = factory.createEntityManager();
	}
	/**
	 * Metodo que retorna um objeto EntityManager
	 * @return
	 */
	public static EntityManager abreConexao(){
		return em;
	}

}
