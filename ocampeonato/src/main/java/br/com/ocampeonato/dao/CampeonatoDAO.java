package br.com.ocampeonato.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;

import br.com.ocampeonato.model.Campeonato;

public class CampeonatoDAO {

	EntityManagerProvider factory = new EntityManagerProvider();

	EntityManager em = factory.getEntityManagerFactory().createEntityManager();
	Session session = em.unwrap(Session.class);

	public List<Campeonato> listaTudo() {
		return session.createCriteria(Campeonato.class).list();
	}

	public void atualiza(Campeonato c) {
		em.getTransaction().begin();
		em.merge(c);
		em.getTransaction().commit();
	}

	public void deleta(Campeonato c) {
		em.getTransaction().begin();
		em.remove(c);
		em.getTransaction().commit();
	}

	public void inclui(Campeonato c) {
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
	}
}