package br.com.ocampeonato.model;

//Campeonato.java
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Campeonato {
	@Id
	@GeneratedValue
	private int id;
	private String nome;
	private String tipo;
	private String nomeImagem;
	@ManyToMany(targetEntity = Time.class)
	@JoinTable(joinColumns = { @JoinColumn(name = "campeonato_id") }, inverseJoinColumns = {
			@JoinColumn(name = "time_id") })
	private List times;

	@OneToMany(mappedBy = "campeonato", targetEntity = Jogo.class)
	private List jogos;

	public List getJogos() {
		return jogos;
	}

	public void setJogos(List jogos) {
		this.jogos = jogos;
	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
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

	public List getTimes() {
		return times;
	}

	public void setTimes(List times) {
		this.times = times;
	}

	public String getNomeImagem() {
		return nomeImagem;
	}

	public void setNomeImagem(String nomeImagem) {
		this.nomeImagem = nomeImagem;
	}
}
