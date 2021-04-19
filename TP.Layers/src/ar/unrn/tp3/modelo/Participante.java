package ar.unrn.tp3.modelo;

public class Participante {

	private NombreParticipante nombreP;
	private TelefonoParticipante telefonoP;
	private RegionParticipante regionP;

	public Participante(String nombre, String telefono, String region) {
		nombreP = new NombreParticipante(nombre);
		telefonoP = new TelefonoParticipante(telefono);
		regionP = new RegionParticipante(region);
	}

	public String obtenerNombre() {
		return this.nombreP.obtenerNombre();
	}

	public String obtenerTelefono() {
		return this.telefonoP.obtenerTelefono();
	}

	public String obtenerRegion() {
		return this.regionP.obtenerRegion();
	}

}
