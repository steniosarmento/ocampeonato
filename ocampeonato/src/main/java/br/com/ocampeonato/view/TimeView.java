package br.com.ocampeonato.view;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.com.ocampeonato.controller.TimeService;
import br.com.ocampeonato.model.Email;
import br.com.ocampeonato.model.Jogador;
import br.com.ocampeonato.model.Time;

@ManagedBean(name = "timeView")
@ViewScoped
public class TimeView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Time selecionadoTime;
	private Time novoTime = new Time();
	private Email novoEmail = new Email();

	@ManagedProperty("#{timeService}")
	private TimeService service;

	public List<Time> getTimes() {
		return service.lista();
	}

	public void setService(TimeService service) {
		this.service = service;
	}

	public Time getSelecionadoTime() {
		return selecionadoTime;
	}

	public void setSelecionadoTime(Time selecionadoTime) {
		this.selecionadoTime = selecionadoTime;
	}

	public Time getNovoTime() {
		return novoTime;
	}

	public void setNovoTime(Time novoTime) {
		this.novoTime = novoTime;
	}

	public void atualizaAction(ActionEvent actionEvent) {
		service.atualiza(selecionadoTime);
		adicionaMenssagem("Time Atualizado");
	}

	public void deletaAction(ActionEvent actionEvent) {
		service.deleta(selecionadoTime);
		adicionaMenssagem("Time excluído!");
	}

	public void removeJogadorAction(Jogador j) {
		selecionadoTime.getJogadores().remove(j);
		service.atualiza(selecionadoTime);
		adicionaMenssagem("Jogador Excluído do Time");
	}

	public void adicionaJogadorAction(Jogador j) {
		selecionadoTime.getJogadores().add(j);
		novoEmail.setAssunto("Inclusão de Jogador no Time - " + selecionadoTime.getNome());
		novoEmail.setDestino("stenio.sarmento@gmail.com");
		novoEmail.setRemetente("stenio.sarmento@hotmail.com");
		novoEmail.setTexto("O jogador " + j.getNome() + " foi adicionado ao time: " + selecionadoTime.getNome());
		novoEmail.enviaEmail();
		service.atualiza(selecionadoTime);
		adicionaMenssagem("Jogador Adicionado ao Time");
	}

	public void novoAction(ActionEvent actionEvent) {
		service.inclui(novoTime);
		adicionaMenssagem("Time incluído!");
		novoTime = new Time();
	}

	public void adicionaMenssagem(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

}