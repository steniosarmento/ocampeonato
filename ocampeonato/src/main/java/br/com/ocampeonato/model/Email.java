package br.com.ocampeonato.model;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.com.ocampeonato.controller.ParametroService;

@Entity
public class Email {
	@Id
	@GeneratedValue
	private int id;
	private String remetente;
	private String destino;
	private String assunto;
	private String texto;

	public Session ConfiguraEmail() {
		// Recupera a senha do email no Banco.
		ParametroService parametroService = new ParametroService();
		Parametro parametro = parametroService.listaUnico();
		final String senha = parametro.getSenha();
		Properties props = new Properties();
		/** Parâmetros de conexão com servidor Hotmail */
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", "smtp.live.com");
		props.put("mail.smtp.socketFactory.port", "587");
		props.put("mail.smtp.socketFactory.fallback", "false");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "587");
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(remetente, senha);
			}
		});

		/** Ativa Debug para sessão */
		session.setDebug(true);
		return session;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRemetente() {
		return remetente;
	}

	public void setRemetente(String remetente) {
		this.remetente = remetente;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public void enviaEmail() {
		try {
			Message message = new MimeMessage(ConfiguraEmail());
			message.setFrom(new InternetAddress(remetente)); // Remetente
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destino)); // Destinatário
			message.setSubject(assunto);// Assunto
			message.setText(texto); // Texto
			Transport.send(message); // Método para enviar a mensagem criada

			System.out.println("E-mail enviado com sucesso!");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
