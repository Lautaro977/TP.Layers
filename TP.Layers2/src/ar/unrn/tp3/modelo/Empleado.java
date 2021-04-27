package ar.unrn.tp3.modelo;

public class Empleado {

	private ApellidoEmpleado apellido;
	private NombreEmpleado nombre;
	private FechaEmpleado fechaNacimiento;
	private EmailEmpleado email;

	public Empleado(String apellido, String nombre, String fechaNacimiento, String email) {

		this.apellido = new ApellidoEmpleado(apellido);
		this.nombre = new NombreEmpleado(nombre);
		this.fechaNacimiento = new FechaEmpleado(fechaNacimiento);
		this.email = new EmailEmpleado(email);
	}

	public String obtenerApellido() {
		return this.apellido.obtenerApellido();
	}

	public String obtenerNombre() {
		return this.nombre.obtenerNombre();
	}

	public String obtenerFecha() {
		return this.fechaNacimiento.obtenerFecha();
	}

	public String obtenerEmail() {
		return this.email.obtenerEmail();
	}

	public boolean esTuCumpleaños(String cumple) {
		if (this.fechaNacimiento.obtenerFecha().contains(cumple)) {
			return true;
		} else {
			return false;
		}
	}
}
