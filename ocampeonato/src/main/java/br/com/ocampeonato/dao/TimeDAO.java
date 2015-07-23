package br.com.ocampeonato.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;

import br.com.ocampeonato.model.Time;

public class TimeDAO {

	EntityManagerProvider factory = new EntityManagerProvider();

	EntityManager em = factory.getEntityManagerFactory().createEntityManager();
	Session session = em.unwrap(Session.class);

	public List<Time> listaTudo() {
		return session.createCriteria(Time.class).list();
	}

	public void atualiza(Time t) {
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
	}

	public void deleta(Time t) {
		em.getTransaction().begin();
		em.remove(t);
		em.getTransaction().commit();
	}

	public void inclui(Time t) {
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
	}
}