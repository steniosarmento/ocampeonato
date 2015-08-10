package br.com.ocampeonato.controller;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import br.com.ocampeonato.dao.GolDAO;
import br.com.ocampeonato.model.Gol;

@ManagedBean(name = "golService")
@ApplicationScoped
public class GolService {

	GolDAO dao = new GolDAO();

	public List<Gol> lista() {
		return dao.listaTudo();
	}

	public void atualiza(Gol p) {
		dao.atualiza(p);
	}

	public void deleta(Gol p) {
		dao.deleta(p);
	}

	public void inclui(Gol p) {
		dao.inclui(p);
	}
}