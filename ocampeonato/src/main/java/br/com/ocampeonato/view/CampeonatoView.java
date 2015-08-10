package br.com.ocampeonato.view;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.com.ocampeonato.controller.CampeonatoService;
import br.com.ocampeonato.model.Campeonato;
import br.com.ocampeonato.model.Time;

@ManagedBean(name = "campeonatoView")
@ViewScoped
public class CampeonatoView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Campeonato selecionadoCampeonato;
	private Campeonato novoCampeonato = new Campeonato();

	@ManagedProperty("#{campeonatoService}")
	private CampeonatoService service;

	public List<Campeonato> getCampeonatos() {
		return service.lista();
	}

	public void setService(CampeonatoService service) {
		this.service = service;
	}

	public Campeonato getSelecionadoCampeonato() {
		return selecionadoCampeonato;
	}

	public void setSelecionadoCampeonato(Campeonato selecionadoCampeonato) {
		this.selecionadoCampeonato = selecionadoCampeonato;
	}

	public Campeonato getNovoCampeonato() {
		return novoCampeonato;
	}

	public void setNovoCampeonato(Campeonato novoCampeonato) {
		this.novoCampeonato = novoCampeonato;
	}

	public void atualizaAction(ActionEvent actionEvent) {
		service.atualiza(selecionadoCampeonato);
		adicionaMenssagem("Campeonato Atualizado");
	}

	public void deletaAction(ActionEvent actionEvent) {
		service.deleta(selecionadoCampeonato);
		adicionaMenssagem("Campeonato excluído!");
	}

	public void removeTimeAction(Time t) {
		selecionadoCampeonato.getTimes().remove(t);
		service.atualiza(selecionadoCampeonato);
		adicionaMenssagem("Time Excluído do Campeonato");
	}

	public void adicionaTimeAction(Time t) {
		selecionadoCampeonato.getTimes().add(t);
		service.atualiza(selecionadoCampeonato);
		adicionaMenssagem("Time Adicionado ao Campeonato");
	}

	public void novoAction(ActionEvent actionEvent) {
		service.inclui(novoCampeonato);
		adicionaMenssagem("Campeonato incluído!");
		novoCampeonato = new Campeonato();
	}

	public void adicionaMenssagem(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

}