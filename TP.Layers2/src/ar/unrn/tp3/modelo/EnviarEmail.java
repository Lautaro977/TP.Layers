package ar.unrn.tp3.modelo;

import java.util.List;

import ar.unrn.tp3.Libreria.Email;

public interface EnviarEmail {

	void enviar(String destinatarioEmail, String tituloEmail, String cuerpoEmail);

	void guardarEmail(Email email);

	List<Email> obtenerEmails();

	boolean existeEmail(String destinatarioEmail);
}
