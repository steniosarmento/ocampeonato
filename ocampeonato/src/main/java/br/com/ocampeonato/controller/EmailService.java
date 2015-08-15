package br.com.ocampeonato.controller;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import br.com.ocampeonato.dao.EmailDAO;
import br.com.ocampeonato.model.Email;

@ManagedBean(name = "emailService")
@ApplicationScoped
public class EmailService {

	EmailDAO dao = new EmailDAO();

	public List<Email> lista() {
		return dao.listaTudo();
	}

	public void atualiza(Email t) {
		dao.atualiza(t);
	}

	public void deleta(Email t) {
		dao.deleta(t);
	}

	public void inclui(Email t) {
		dao.inclui(t);
	}
}