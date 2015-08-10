package br.com.ocampeonato.model;

//Time.java
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Time {
	@Id
	@GeneratedValue
	private int id;
	private String nome;
	private String nomeImagem;
	private String tipo;
	@ManyToMany(targetEntity = Jogador.class)
	@JoinTable(joinColumns = { @JoinColumn(name = "time_id") }, inverseJoinColumns = {
			@JoinColumn(name = "jogador_id") })
	private List jogadores;
	@ManyToMany(mappedBy = "times", targetEntity = Campeonato.class)
	private List campeonatos;

	@OneToMany(mappedBy = "timeLocal", targetEntity = Jogo.class)
	private List jogosLocal;

	@OneToMany(mappedBy = "timeVisitante", targetEntity = Jogo.class)
	private List jogosVisitante;

	@OneToMany(mappedBy = "time", targetEntity = Gol.class)
	private List gols;

	public List getGols() {
		return gols;
	}

	public void setGols(List gols) {
		this.gols = gols;
	}

	public List getJogosLocal() {
		return jogosLocal;
	}

	public void setJogosLocal(List jogosLocal) {
		this.jogosLocal = jogosLocal;
	}

	public List getJogosVisitante() {
		return jogosVisitante;
	}

	public void setJogosVisitante(List jogosVisitante) {
		this.jogosVisitante = jogosVisitante;
	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public String getNomeImagem() {
		return nomeImagem;
	}

	public void setNomeImagem(String nomeImagem) {
		this.nomeImagem = nomeImagem;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List getJogadores() {
		return jogadores;
	}

	public void setJogadores(List jogadores) {
		this.jogadores = jogadores;
	}

	public List getCampeonatos() {
		return campeonatos;
	}

	public void setCampeonatos(List campeonatos) {
		this.campeonatos = campeonatos;
	}
}
