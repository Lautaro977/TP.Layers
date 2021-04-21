package ar.unrn.tp3.modelo;

public class RegionParticipante {

	private String region;

	public RegionParticipante(String region) {
		if (!region.equals("China") && !region.equals("US") && !region.equals("Europa")) {
			throw new RuntimeException("Region desconocida. Las conocidasson:China, US, Europa");
		}
		this.region = region;

	}

	public String obtenerRegion() {
		return this.region;
	}

}
