package br.com.ocampeonato.view;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.com.ocampeonato.controller.ParametroService;
import br.com.ocampeonato.model.Parametro;

@ManagedBean(name = "parametroView")
@ViewScoped
public class ParametroView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Parametro selecionadoParametro;
	private Parametro novoParametro = new Parametro();

	@ManagedProperty("#{parametroService}")
	private ParametroService service;

	public List<Parametro> getParametros() {
		return service.lista();
	}

	public void setService(ParametroService service) {
		this.service = service;
	}

	public Parametro getSelecionadoParametro() {
		return selecionadoParametro;
	}

	public void setSelecionadoParametro(Parametro selecionadoParametro) {
		this.selecionadoParametro = selecionadoParametro;
	}

	public Parametro getNovoParametro() {
		return novoParametro;
	}

	public void setNovoParametro(Parametro novoParametro) {
		this.novoParametro = novoParametro;
	}

	public void atualizaAction(ActionEvent actionEvent) {
		service.atualiza(selecionadoParametro);
		adicionaMenssagem("Parametro Atualizado");
	}

	public void deletaAction(ActionEvent actionEvent) {
		service.deleta(selecionadoParametro);
		adicionaMenssagem("Parametro excluído!");
	}

	public void novoAction(ActionEvent actionEvent) {
		service.inclui(novoParametro);
		adicionaMenssagem("Parametro incluido!");
	}

	public void adicionaMenssagem(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

}