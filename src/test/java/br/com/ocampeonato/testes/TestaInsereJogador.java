package br.com.ocampeonato.testes;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;

import br.com.ocampeonato.dao.EntityManagerProvider;
import br.com.ocampeonato.model.Jogador;

public class TestaInsereJogador {

	public static void main(String[] args) {

		EntityManagerProvider factory = new EntityManagerProvider();

		EntityManager em = factory.getEntityManagerFactory()
				.createEntityManager();
		Jogador j = new Jogador();

		Calendar cal = Calendar.getInstance();
		cal.set(1988, 8, 3);
		Date data = cal.getTime();

		j.setNome("Stenio");
		j.setCpf("09366258646");
		j.setDataNascimento(data);
		j.setEmail("stenio.sarmento@gmail.com");
		j.setIdentidade("MG10690225");
		em.getTransaction().begin();
		em.persist(j);
		em.getTransaction().commit();
	}
}