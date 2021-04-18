package ar.unrn.tp3.modelo;

import javax.swing.JOptionPane;

public class NombreParticipante {
	private String nombre;

	public NombreParticipante(String nombre) {
		if (nombre.equals("")) {
			JOptionPane.showMessageDialog(null, "Debe cargar un nombre", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			this.nombre = nombre;
		}

	}

	public String obtenerNombre() {
		return this.nombre;
	}

}
