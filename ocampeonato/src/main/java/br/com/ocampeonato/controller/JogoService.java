package br.com.ocampeonato.controller;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import br.com.ocampeonato.dao.JogoDAO;
import br.com.ocampeonato.model.Jogo;

@ManagedBean(name = "jogoService")
@ApplicationScoped
public class JogoService {

	JogoDAO dao = new JogoDAO();

	public List<Jogo> lista() {
		return dao.listaTudo();
	}

	public void atualiza(Jogo p) {
		dao.atualiza(p);
	}

	public void deleta(Jogo p) {
		dao.deleta(p);
	}

	public void inclui(Jogo p) {
		dao.inclui(p);
	}
}