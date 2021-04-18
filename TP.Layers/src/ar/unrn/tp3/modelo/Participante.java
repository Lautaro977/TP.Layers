package ar.unrn.tp3.modelo;

public class Participante {

	private String nombre;
	private String telefono;
	private String region;

	public Participante(String nombre, String telefono, String region) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.region = region;
	}

	public String obtenerNombre() {
		return this.nombre;
	}

	public String obtenerTelefono() {
		return this.telefono;
	}

	public String obtenerRegion() {
		return this.region;
	}

	public void asignarNombre(String nombre) {
		this.nombre = nombre;
	}

	public void asignarTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void asignarRegion(String region) {
		this.region = region;
	}

}
