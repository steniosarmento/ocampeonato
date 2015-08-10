package br.com.ocampeonato.controller;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import br.com.ocampeonato.dao.CampeonatoDAO;
import br.com.ocampeonato.model.Campeonato;

@ManagedBean(name = "campeonatoService")
@ApplicationScoped
public class CampeonatoService {

	CampeonatoDAO dao = new CampeonatoDAO();

	public List<Campeonato> lista() {
		return dao.listaTudo();
	}

	public void atualiza(Campeonato c) {
		dao.atualiza(c);
	}

	public void deleta(Campeonato c) {
		dao.deleta(c);
	}

	public void inclui(Campeonato c) {
		dao.inclui(c);
	}
}