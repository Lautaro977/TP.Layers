package ar.unrn.tp3.modelo;

public class ApellidoEmpleado {

	private String apellido;

	public ApellidoEmpleado(String apellido) {
		if (apellido.equals("")) {
			throw new RuntimeException("El empleado debe tener un apellido NO vacio");
		}
		this.apellido = apellido;

	}

	public String obtenerApellido() {
		return this.apellido;
	}

}
