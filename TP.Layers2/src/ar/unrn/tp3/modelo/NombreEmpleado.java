package ar.unrn.tp3.modelo;

public class NombreEmpleado {

	private String nombre;

	public NombreEmpleado(String nombre) {
		if (nombre.equals("")) {
			throw new RuntimeException("El empleado debe tener un nombre NO vacio");
		}
		this.nombre = nombre;

	}

	public String obtenerNombre() {
		return this.nombre;
	}
}
