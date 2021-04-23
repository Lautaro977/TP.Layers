package ar.unrn.tp3.modelo;

public class FechaEmpleado {
	private String fecha;

	public FechaEmpleado(String fecha) {
		if (fecha.equals("")) {
			throw new RuntimeException("El empleado debe tener una Fecha de Nacimiento NO vacio");
		}
		this.fecha = fecha;

	}

	public String obtenerFecha() {
		return this.fecha;
	}
}
