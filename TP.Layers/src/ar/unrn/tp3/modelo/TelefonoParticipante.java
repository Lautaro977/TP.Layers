package ar.unrn.tp3.modelo;

import javax.swing.JOptionPane;

public class TelefonoParticipante {

	private String telefono;

	public TelefonoParticipante(String telefono) {
		if (telefono.equals("")) {
			JOptionPane.showMessageDialog(null, "Debe cargar un telefono", "Error", JOptionPane.ERROR_MESSAGE);
		}
		if (!validarTelefono(telefono)) {
			JOptionPane.showMessageDialog(null, "El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN",
					"Error", JOptionPane.ERROR_MESSAGE);
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
