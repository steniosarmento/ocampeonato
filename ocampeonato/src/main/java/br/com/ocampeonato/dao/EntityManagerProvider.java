package br.com.ocampeonato.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProvider {
	private static EntityManagerFactory emf = null;

	public EntityManagerProvider() {
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("ocampeonato");
		}
		return emf;
	}
}