package ar.unrn.tp3.Libreria;

import ar.unrn.tp3.modelo.EnviarEmail;

public class EnviarCorreoElectronico implements EnviarEmail {

	public void enviar(String destinatarioEmail, String tituloEmail, String cuerpoEmail) {
		try {
			Email email = new Email(destinatarioEmail, tituloEmail, cuerpoEmail);
			email.enviar();
		} catch (SmtpException ex) {
			throw new RuntimeException("NO se pudo Enviar el Mail");
		}
	}

}
