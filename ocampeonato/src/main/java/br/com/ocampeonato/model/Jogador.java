package br.com.ocampeonato.model;

//Jogador.java
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Jogador {
	@Id
	@GeneratedValue
	private int id;
	private String nome;
	private Date dataNascimento;
	private String cpf;
	private String identidade;
	private String email;

	@ManyToMany(mappedBy = "jogadores", targetEntity = Time.class)
	private List times;

	@OneToMany(mappedBy = "jogador", targetEntity = Gol.class)
	private List gols;

	public List getGols() {
		return gols;
	}

	public void setGols(List gols) {
		this.gols = gols;
	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public String getCpfMascarado() {
		return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9);
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getIdentidade() {
		return identidade;
	}

	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List getTimes() {
		return times;
	}

	public void setTimes(List times) {
		this.times = times;
	}
}
