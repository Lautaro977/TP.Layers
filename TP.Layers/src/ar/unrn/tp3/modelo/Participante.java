package ar.unrn.tp3.modelo;

public class Participante {

	private String nombre;
	private String telefono;
	private String region;

	private NombreParticipante np;
	private TelefonoParticipante tp;
	private RegionParticipante rp;

	public Participante(String nombre, String telefono, String region) {
		NombreParticipante nom = new NombreParticipante(nombre);
		this.nombre = nombre;
		TelefonoParticipante tel = new TelefonoParticipante(telefono);
		this.telefono = telefono;
		RegionParticipante rp = new RegionParticipante(region);
		if (rp.obtenerRegion() != null) {
			this.region = region;
		}
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
