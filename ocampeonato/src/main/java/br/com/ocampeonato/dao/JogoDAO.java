package br.com.ocampeonato.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;

import br.com.ocampeonato.model.Jogo;

public class JogoDAO {

	EntityManagerProvider factory = new EntityManagerProvider();

	EntityManager em = factory.getEntityManagerFactory().createEntityManager();
	Session session = em.unwrap(Session.class);

	public List<Jogo> listaTudo() {
		return session.createCriteria(Jogo.class).list();
		/*
		 * Query query = em.createQuery("SELECT p from Jogo p"); return
		 * query.getResultList();
		 */
	}

	public void atualiza(Jogo j) {
		em.getTransaction().begin();
		em.merge(j);
		em.getTransaction().commit();
	}

	public void deleta(Jogo j) {
		em.getTransaction().begin();
		em.remove(j);
		em.getTransaction().commit();
	}

	public void inclui(Jogo j) {
		em.getTransaction().begin();
		em.persist(j);
		em.getTransaction().commit();
	}

}