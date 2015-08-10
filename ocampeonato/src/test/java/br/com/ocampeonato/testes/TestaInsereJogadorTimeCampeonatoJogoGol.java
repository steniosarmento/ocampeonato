package br.com.ocampeonato.testes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.ocampeonato.dao.EntityManagerProvider;
import br.com.ocampeonato.model.Campeonato;
import br.com.ocampeonato.model.Gol;
import br.com.ocampeonato.model.Jogador;
import br.com.ocampeonato.model.Jogo;
import br.com.ocampeonato.model.Time;

public class TestaInsereJogadorTimeCampeonatoJogoGol {

	public static void main(String[] args) {

		EntityManagerProvider factory = new EntityManagerProvider();

		EntityManager em = factory.getEntityManagerFactory().createEntityManager();

		Calendar cal = Calendar.getInstance();
		cal.set(1988, 8, 3);
		Date data = cal.getTime();
		int qtdGolsLocal = 2;
		int qtdGolsVisitante = 1;
		Jogador jogadorA = new Jogador();
		Jogador jogadorB = new Jogador();
		Jogador jogadorC = new Jogador();
		Jogador jogadorD = new Jogador();
		Jogador jogadorE = new Jogador();
		Jogador jogadorF = new Jogador();
		Time timeA = new Time();
		Time timeB = new Time();
		Campeonato campeonato = new Campeonato();
		Jogo jogo1 = new Jogo();
		Gol gol1 = new Gol();
		Gol gol2 = new Gol();
		Gol gol3 = new Gol();
		List<Jogo> jogos = new ArrayList<Jogo>();
		List<Jogador> jogadoresA = new ArrayList<Jogador>();
		List<Jogador> jogadoresB = new ArrayList<Jogador>();
		List<Time> times = new ArrayList<Time>();
		List<Gol> gols = new ArrayList<Gol>();

		jogadorA.setNome("Patrick");
		jogadorA.setCpf("09366258646");
		jogadorA.setDataNascimento(data);
		jogadorA.setEmail("stenio.sarmento@gmail.com");
		jogadorA.setIdentidade("MG10690225");

		jogadorB.setNome("Datolo");
		jogadorB.setCpf("09366258646");
		jogadorB.setDataNascimento(data);
		jogadorB.setEmail("stenio.sarmento@gmail.com");
		jogadorB.setIdentidade("MG10690225");

		jogadorC.setNome("Lucas");
		jogadorC.setCpf("09366258646");
		jogadorC.setDataNascimento(data);
		jogadorC.setEmail("stenio.sarmento@gmail.com");
		jogadorC.setIdentidade("MG10690225");

		jogadorD.setNome("Fabio");
		jogadorD.setCpf("09366258646");
		jogadorD.setDataNascimento(data);
		jogadorD.setEmail("stenio.sarmento@gmail.com");
		jogadorD.setIdentidade("MG10690225");

		jogadorE.setNome("Leo");
		jogadorE.setCpf("09366258646");
		jogadorE.setDataNascimento(data);
		jogadorE.setEmail("stenio.sarmento@gmail.com");
		jogadorE.setIdentidade("MG10690225");

		jogadorF.setNome("Henrique");
		jogadorF.setCpf("09366258646");
		jogadorF.setDataNascimento(data);
		jogadorF.setEmail("stenio.sarmento@gmail.com");
		jogadorF.setIdentidade("MG10690225");

		timeA.setNome("Cruzeiro");
		timeA.setTipo("Futebol");
		timeA.setNomeImagem("galo.png");

		timeB.setNome("Palmeiras");
		timeB.setTipo("Futebol");
		timeB.setNomeImagem("palmeiras.png");

		campeonato.setNome("TesteBR");
		campeonato.setNomeImagem("zoeira.png");
		campeonato.setTipo("Copa");

		jogo1.setDataJogo(data);
		jogo1.setQtdGolLocal(qtdGolsLocal);
		jogo1.setQtdGolVisitante(qtdGolsVisitante);

		jogadoresA.add(jogadorA);
		jogadoresA.add(jogadorB);
		jogadoresA.add(jogadorC);
		jogadoresB.add(jogadorD);
		jogadoresB.add(jogadorE);
		jogadoresB.add(jogadorF);

		timeA.setJogadores(jogadoresA);
		timeB.setJogadores(jogadoresB);

		times.add(timeA);
		times.add(timeB);

		campeonato.setTimes(times);

		jogo1.setTimeLocal(timeA);
		jogo1.setTimeVisitante(timeB);
		jogo1.setCampeonato(campeonato);

		gol1.setJogador(jogadorA);
		gol1.setTime(timeA);
		gol1.setJogo(jogo1);
		gol2.setJogador(jogadorB);
		gol2.setTime(timeA);
		gol2.setJogo(jogo1);
		gol3.setJogador(jogadorD);
		gol3.setTime(timeB);
		gol3.setJogo(jogo1);

		jogo1.setGols(gols);

		jogos.add(jogo1);

		campeonato.setJogos(jogos);

		em.getTransaction().begin();
		em.persist(jogadorA);
		em.persist(jogadorB);
		em.persist(jogadorC);
		em.persist(jogadorD);
		em.persist(jogadorE);
		em.persist(jogadorF);
		em.persist(timeA);
		em.persist(timeB);
		em.persist(campeonato);
		em.persist(jogo1);
		em.persist(gol1);
		em.persist(gol2);
		em.persist(gol3);
		em.getTransaction().commit();

	}
}