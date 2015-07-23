package br.com.ocampeonato.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;

import br.com.ocampeonato.model.Jogador;

public class JogadorDAO {

	EntityManagerProvider factory = new EntityManagerProvider();

	EntityManager em = factory.getEntityManagerFactory().createEntityManager();
	Session session = em.unwrap(Session.class);

	public List<Jogador> listaTudo() {
		return session.createCriteria(Jogador.class).list();
		/*
		 * Query query = em.createQuery("SELECT p from Jogador p"); return
		 * query.getResultList();
		 */
	}

	public void atualiza(Jogador j) {
		em.getTransaction().begin();
		em.merge(j);
		em.getTransaction().commit();
	}

	public void deleta(Jogador j) {
		em.getTransaction().begin();
		em.remove(j);
		em.getTransaction().commit();
	}

	public void inclui(Jogador j) {
		em.getTransaction().begin();
		em.persist(j);
		em.getTransaction().commit();
	}

}