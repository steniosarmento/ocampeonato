package br.com.ocampeonato.controller;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import br.com.ocampeonato.dao.TimeDAO;
import br.com.ocampeonato.model.Time;

@ManagedBean(name = "timeService")
@ApplicationScoped
public class TimeService {

	TimeDAO dao = new TimeDAO();

	public List<Time> lista() {
		return dao.listaTudo();
	}

	public void atualiza(Time t) {
		dao.atualiza(t);
	}

	public void deleta(Time t) {
		dao.deleta(t);
	}

	public void inclui(Time t) {
		dao.inclui(t);
	}
}