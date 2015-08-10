package br.com.ocampeonato.view;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.com.ocampeonato.controller.JogoService;
import br.com.ocampeonato.model.Jogo;

@ManagedBean(name = "jogoView")
@ViewScoped
public class JogoView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Jogo selecionadoJogo;
	private Jogo novoJogo = new Jogo();

	@ManagedProperty("#{jogoService}")
	private JogoService service;

	public List<Jogo> getJogos() {
		return service.lista();
	}

	public void setService(JogoService service) {
		this.service = service;
	}

	public Jogo getSelecionadoJogo() {
		return selecionadoJogo;
	}

	public void setSelecionadoJogo(Jogo selecionadoJogo) {
		this.selecionadoJogo = selecionadoJogo;
	}

	public Jogo getNovoJogo() {
		return novoJogo;
	}

	public void setNovoJogo(Jogo novoJogo) {
		this.novoJogo = novoJogo;
	}

	public void atualizaAction(ActionEvent actionEvent) {
		service.atualiza(selecionadoJogo);
		adicionaMenssagem("Jogo Atualizado");
	}

	public void deletaAction(ActionEvent actionEvent) {
		service.deleta(selecionadoJogo);
		adicionaMenssagem("Jogo excluído!");
	}

	public void novoAction(ActionEvent actionEvent) {
		service.inclui(novoJogo);
		adicionaMenssagem("Jogo incluído!");
		novoJogo = new Jogo();
	}

	public void adicionaMenssagem(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

}