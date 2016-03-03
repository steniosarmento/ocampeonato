package br.com.ocampeonato.controller;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import br.com.ocampeonato.dao.ParametroDAO;
import br.com.ocampeonato.model.Parametro;

@ManagedBean(name = "parametroService")
@ApplicationScoped
public class ParametroService {

	ParametroDAO dao = new ParametroDAO();

	public List<Parametro> lista() {
		return dao.listaTudo();
	}

	public Parametro listaUnico() {
		return dao.listaUnico();
	}

	public void atualiza(Parametro t) {
		dao.atualiza(t);
	}

	public void deleta(Parametro t) {
		dao.deleta(t);
	}

	public void inclui(Parametro t) {
		dao.inclui(t);
	}
}