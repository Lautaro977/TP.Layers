package ar.unrn.tp3.Libreria;

import java.util.ArrayList;
import java.util.List;

import ar.unrn.tp3.modelo.EnviarEmail;

public class EnviarCorreoElectronico implements EnviarEmail {

	private List<Email> ListaEmails = new ArrayList<>();

	// enviar email de mentira
	// otra implementaciuon de la interfas enviarEmail //guarda el email
	// directamente no Envia Email
	public void enviar(String destinatarioEmail, String tituloEmail, String cuerpoEmail) {
		try {
			Email email = new Email(destinatarioEmail, tituloEmail, cuerpoEmail);
			email.enviar();
			this.guardarEmail(email);
		} catch (SmtpException ex) {
			throw new RuntimeException("NO se pudo Enviar el Mail");
		}
	}

	public void guardarEmail(Email email) {
		this.ListaEmails.add(email);
	}

	public List<Email> obtenerEmails() {
		return this.ListaEmails;
	}

	public boolean existeEmail(String destinatarioEmail) {
		List<Email> ListaEmailsEnviados = obtenerEmails();
		boolean resultado = false;
		for (Email emailActual : ListaEmailsEnviados) {

			if (emailActual.destinatarioEmail.contentEquals(destinatarioEmail)) {
				resultado = true;
			}

		}
		return resultado;
	}

}
