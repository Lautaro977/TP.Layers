package ar.unrn.tp3.modelo;

import javax.swing.JOptionPane;

public class RegionParticipante {

	private String region;

	public RegionParticipante(String region) {
		if (!region.equals("China") && !region.equals("US") && !region.equals("Europa")) {
			JOptionPane.showMessageDialog(null, "Region desconocida. Las conocidas son:China, US, Europa", "Error",
					JOptionPane.ERROR_MESSAGE);
		} else {
			this.region = region;
		}

	}

	public String obtenerRegion() {
		return this.region;
	}

}
