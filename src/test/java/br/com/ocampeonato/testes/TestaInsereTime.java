package br.com.ocampeonato.testes;

import javax.persistence.EntityManager;

import br.com.ocampeonato.dao.EntityManagerProvider;
import br.com.ocampeonato.model.Time;

public class TestaInsereTime {

	public static void main(String[] args) {

		EntityManagerProvider factory = new EntityManagerProvider();

		EntityManager em = factory.getEntityManagerFactory()
				.createEntityManager();
		Time t = new Time();

		t.setNome("Alvorada");
		t.setTipo("Futsals");
		t.setNomeImagem("alvorada2.jpg");
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
	}
}