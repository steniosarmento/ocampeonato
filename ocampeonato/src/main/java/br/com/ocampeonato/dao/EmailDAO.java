package br.com.ocampeonato.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;

import br.com.ocampeonato.model.Email;

public class EmailDAO {

	EntityManagerProvider factory = new EntityManagerProvider();

	EntityManager em = factory.getEntityManagerFactory().createEntityManager();
	Session session = em.unwrap(Session.class);

	public List<Email> listaTudo() {
		return session.createCriteria(Email.class).list();
	}

	public void atualiza(Email t) {
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
	}

	public void deleta(Email t) {
		em.getTransaction().begin();
		em.remove(t);
		em.getTransaction().commit();
	}

	public void inclui(Email t) {
		t.enviaEmail();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
	}
}