package br.com.ocampeonato.view;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.com.ocampeonato.controller.EmailService;
import br.com.ocampeonato.controller.ParametroService;
import br.com.ocampeonato.model.Email;
import br.com.ocampeonato.model.Parametro;

@ManagedBean(name = "emailView")
@ViewScoped
public class EmailView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Email selecionadoEmail;
	private Email novoEmail = new Email();

	@ManagedProperty("#{emailService}")
	private EmailService service;

	public List<Email> getEmails() {
		return service.lista();
	}

	public void setService(EmailService service) {
		this.service = service;
	}

	public Email getSelecionadoEmail() {
		return selecionadoEmail;
	}

	public void setSelecionadoEmail(Email selecionadoEmail) {
		this.selecionadoEmail = selecionadoEmail;
	}

	public Email getNovoEmail() {
		return novoEmail;
	}

	public void setNovoEmail(Email novoEmail) {
		this.novoEmail = novoEmail;
	}

	public void atualizaAction(ActionEvent actionEvent) {
		service.atualiza(selecionadoEmail);
		adicionaMenssagem("Email Atualizado");
	}

	public void deletaAction(ActionEvent actionEvent) {
		service.deleta(selecionadoEmail);
		adicionaMenssagem("Email excluído!");
	}

	public void novoAction(ActionEvent actionEvent) {
		//Recupera os parâmetros de email do Banco de Dados,
		//tais como remetente, destinatário, assunto padrão e senha.
		ParametroService parametroService = new ParametroService();
		Parametro parametro = parametroService.listaUnico();
		novoEmail.setAssunto(parametro.getAssunto());
		novoEmail.setDestino(parametro.getDestino());
		novoEmail.setRemetente(parametro.getRemetente());
		service.inclui(novoEmail);
		adicionaMenssagem("Email enviado!");
		novoEmail = new Email();
	}

	public void adicionaMenssagem(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

}