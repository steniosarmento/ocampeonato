package br.com.ocampeonato.model;

//Jogo.java
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Jogo {
	@Id
	@GeneratedValue
	private int id;
	private Date dataJogo;
	private int qtdGolLocal;
	private int qtdGolVisitante;

	@ManyToOne(targetEntity = Time.class)
	private Time timeLocal;

	@ManyToOne(targetEntity = Time.class)
	private Time timeVisitante;

	@ManyToOne(targetEntity = Campeonato.class)
	private Campeonato campeonato;

	@OneToMany(mappedBy = "jogo", targetEntity = Gol.class)
	private List gols;

	public List getGols() {
		return gols;
	}

	public void setGols(List gols) {
		this.gols = gols;
	}

	public Time getTimeLocal() {
		return timeLocal;
	}

	public void setTimeLocal(Time timeLocal) {
		this.timeLocal = timeLocal;
	}

	public Time getTimeVisitante() {
		return timeVisitante;
	}

	public void setTimeVisitante(Time timeVisitante) {
		this.timeVisitante = timeVisitante;
	}

	public Campeonato getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}

	public Date getDataJogo() {
		return dataJogo;
	}

	public void setDataJogo(Date dataJogo) {
		this.dataJogo = dataJogo;
	}

	public int getQtdGolLocal() {
		return qtdGolLocal;
	}

	public void setQtdGolLocal(int qtdGolLocal) {
		this.qtdGolLocal = qtdGolLocal;
	}

	public int getQtdGolVisitante() {
		return qtdGolVisitante;
	}

	public void setQtdGolVisitante(int qtdGolVisitante) {
		this.qtdGolVisitante = qtdGolVisitante;
	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

}
