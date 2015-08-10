package br.com.ocampeonato.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Gol {
	@Id
	@GeneratedValue
	private int id;
	private int tempo;

	@ManyToOne(targetEntity = Time.class)
	private Time time;

	@ManyToOne(targetEntity = Jogador.class)
	private Jogador jogador;

	@ManyToOne(targetEntity = Jogo.class)
	private Jogo jogo;

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public int getTempo() {
		return tempo;
	}

	private void setTempo(int tempo) {
		this.tempo = tempo;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

}
