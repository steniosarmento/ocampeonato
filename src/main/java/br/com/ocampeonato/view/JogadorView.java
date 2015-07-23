package br.com.ocampeonato.view;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.com.ocampeonato.controller.JogadorService;
import br.com.ocampeonato.model.Jogador;

@ManagedBean(name = "jogadorView")
@ViewScoped
public class JogadorView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Jogador selecionadoJogador;
	private Jogador novoJogador = new Jogador();

	@ManagedProperty("#{jogadorService}")
	private JogadorService service;

	public List<Jogador> getJogadores() {
		return service.lista();
	}

	public void setService(JogadorService service) {
		this.service = service;
	}

	public Jogador getSelecionadoJogador() {
		return selecionadoJogador;
	}

	public void setSelecionadoJogador(Jogador selecionadoJogador) {
		this.selecionadoJogador = selecionadoJogador;
	}

	public Jogador getNovoJogador() {
		return novoJogador;
	}

	public void setNovoJogador(Jogador novoJogador) {
		this.novoJogador = novoJogador;
	}

	public void atualizaAction(ActionEvent actionEvent) {
		service.atualiza(selecionadoJogador);
		adicionaMenssagem("Jogador Atualizado");
	}

	public void deletaAction(ActionEvent actionEvent) {
		service.deleta(selecionadoJogador);
		adicionaMenssagem("Jogador excluído!");
	}

	public void novoAction(ActionEvent actionEvent) {
		service.inclui(novoJogador);
		adicionaMenssagem("Jogador incluído!");
		novoJogador = new Jogador();
	}

	public void adicionaMenssagem(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

}