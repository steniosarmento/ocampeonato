package br.com.ocampeonato.view;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.com.ocampeonato.controller.GolService;
import br.com.ocampeonato.model.Gol;

@ManagedBean(name = "golView")
@ViewScoped
public class GolView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Gol selecionadoGol;
	private Gol novoGol = new Gol();

	@ManagedProperty("#{golService}")
	private GolService service;

	public List<Gol> getGols() {
		return service.lista();
	}

	public void setService(GolService service) {
		this.service = service;
	}

	public Gol getSelecionadoGol() {
		return selecionadoGol;
	}

	public void setSelecionadoGol(Gol selecionadoGol) {
		this.selecionadoGol = selecionadoGol;
	}

	public Gol getNovoGol() {
		return novoGol;
	}

	public void setNovoGol(Gol novoGol) {
		this.novoGol = novoGol;
	}

	public void atualizaAction(ActionEvent actionEvent) {
		service.atualiza(selecionadoGol);
		adicionaMenssagem("Gol Atualizado");
	}

	public void deletaAction(ActionEvent actionEvent) {
		service.deleta(selecionadoGol);
		adicionaMenssagem("Gol excluído!");
	}

	public void novoAction(ActionEvent actionEvent) {
		service.inclui(novoGol);
		adicionaMenssagem("Gol incluído!");
		novoGol = new Gol();
	}

	public void adicionaMenssagem(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

}