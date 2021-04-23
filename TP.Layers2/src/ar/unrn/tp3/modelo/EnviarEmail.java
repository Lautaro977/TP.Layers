package ar.unrn.tp3.modelo;

public interface EnviarEmail {

	void enviar(String destinatarioEmail, String tituloEmail, String cuerpoEmail);
}
