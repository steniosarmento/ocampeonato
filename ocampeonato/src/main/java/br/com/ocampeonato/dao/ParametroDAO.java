package br.com.ocampeonato.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import br.com.ocampeonato.model.Parametro;

public class ParametroDAO {

	EntityManagerProvider factory = new EntityManagerProvider();

	EntityManager em = factory.getEntityManagerFactory().createEntityManager();
	Session session = em.unwrap(Session.class);

	public List<Parametro> listaTudo() {
		return session.createCriteria(Parametro.class).list();
	}

	public Parametro listaUnico() {
		Criteria crit = session.createCriteria(Parametro.class);
		Criterion remetente = Restrictions.gt("remetente", "stenio.sarmento@hotmail.com");
		crit.setMaxResults(1);
		Parametro parametro = (Parametro) crit.uniqueResult();
		return parametro;
	}

	public void atualiza(Parametro t) {
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
	}

	public void deleta(Parametro t) {
		em.getTransaction().begin();
		em.remove(t);
		em.getTransaction().commit();
	}

	public void inclui(Parametro t) {
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
	}
}