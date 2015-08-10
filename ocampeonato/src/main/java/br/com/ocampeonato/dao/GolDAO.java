package br.com.ocampeonato.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;

import br.com.ocampeonato.model.Gol;

public class GolDAO {

	EntityManagerProvider factory = new EntityManagerProvider();

	EntityManager em = factory.getEntityManagerFactory().createEntityManager();
	Session session = em.unwrap(Session.class);

	public List<Gol> listaTudo() {
		return session.createCriteria(Gol.class).list();
		/*
		 * Query query = em.createQuery("SELECT p from Gol p"); return
		 * query.getResultList();
		 */
	}

	public void atualiza(Gol j) {
		em.getTransaction().begin();
		em.merge(j);
		em.getTransaction().commit();
	}

	public void deleta(Gol j) {
		em.getTransaction().begin();
		em.remove(j);
		em.getTransaction().commit();
	}

	public void inclui(Gol j) {
		em.getTransaction().begin();
		em.persist(j);
		em.getTransaction().commit();
	}

}