package br.com.ocampeonato.model;

//Produto.java
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Time {
	@Id
	@GeneratedValue
	private int id;
	private String nome;
	private String nomeImagem;
	private String tipo;
	@ManyToMany(targetEntity = Jogador.class)
	@JoinTable(joinColumns = { @JoinColumn(name = "time_id") }, inverseJoinColumns = { @JoinColumn(name = "jogador_id") })
	private List jogadores;

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
}
