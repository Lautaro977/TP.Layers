package ar.unrn.tp3.modelo;

public class EmailEmpleado {
	private String email;

	public EmailEmpleado(String email) {
		if (email.equals("")) {
			throw new RuntimeException("El empleado debe tener un Email NO vacio");
		}
		this.email = email;

	}

	public String obtenerEmail() {
		return this.email;
	}
}
