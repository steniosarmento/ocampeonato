package br.com.ocampeonato.controller;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import br.com.ocampeonato.dao.JogadorDAO;
import br.com.ocampeonato.model.Jogador;

@ManagedBean(name = "jogadorService")
@ApplicationScoped
public class JogadorService {

	JogadorDAO dao = new JogadorDAO();

	public List<Jogador> lista() {
		return dao.listaTudo();
	}

	public void atualiza(Jogador p) {
		dao.atualiza(p);
	}

	public void deleta(Jogador p) {
		dao.deleta(p);
	}

	public void inclui(Jogador p) {
		dao.inclui(p);
	}
}