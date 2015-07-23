package br.com.ocampeonato.testes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.ocampeonato.dao.EntityManagerProvider;
import br.com.ocampeonato.model.Jogador;
import br.com.ocampeonato.model.Time;

public class TestaInsereJogadorTime {

	public static void main(String[] args) {

		EntityManagerProvider factory = new EntityManagerProvider();

		EntityManager em = factory.getEntityManagerFactory()
				.createEntityManager();

		Calendar cal = Calendar.getInstance();
		cal.set(1988, 8, 3);
		Date data = cal.getTime();

		em.getTransaction().begin();

		Jogador jogadorA = new Jogador();
		jogadorA.setNome("Patrick");
		jogadorA.setCpf("09366258646");
		jogadorA.setDataNascimento(data);
		jogadorA.setEmail("stenio.sarmento@gmail.com");
		jogadorA.setIdentidade("MG10690225");
		Jogador jogadorB = new Jogador();
		jogadorB.setNome("Datolo");
		jogadorB.setCpf("09366258646");
		jogadorB.setDataNascimento(data);
		jogadorB.setEmail("stenio.sarmento@gmail.com");
		jogadorB.setIdentidade("MG10690225");
		Jogador jogadorC = new Jogador();
		jogadorC.setNome("Lucas");
		jogadorC.setCpf("09366258646");
		jogadorC.setDataNascimento(data);
		jogadorC.setEmail("stenio.sarmento@gmail.com");
		jogadorC.setIdentidade("MG10690225");

		List<Jogador> jogadores = new ArrayList<Jogador>();
		jogadores.add(jogadorA);
		jogadores.add(jogadorB);
		jogadores.add(jogadorC);

		Time time = new Time();
		time.setNome("Atletico");
		time.setTipo("Futebol");
		time.setNomeImagem("galo.png");
		time.setJogadores(jogadores);
		em.persist(jogadorA);
		em.persist(jogadorB);
		em.persist(jogadorC);
		em.persist(time);
		em.getTransaction().commit();

	}
}