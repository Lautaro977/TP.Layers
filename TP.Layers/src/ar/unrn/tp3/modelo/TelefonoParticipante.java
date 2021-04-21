package ar.unrn.tp3.modelo;

public class TelefonoParticipante {

	private String telefono;

	public TelefonoParticipante(String telefono) {
		if (telefono.equals("")) {
			throw new RuntimeException("Debe cargar un telefono");
		}
		if (!validarTelefono(telefono)) {
			throw new RuntimeException("El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
		} else {
			this.telefono = telefono;
		}

	}

	private boolean validarTelefono(String telefono) {
		String regex = "\\d{4}-\\d{6}";
		return telefono.matches(regex);
	}

	public String obtenerTelefono() {
		return this.telefono;
	}
}
