package ar.unrn.tp3.Main;

import ar.unrn.tp3.Libreria.EnviarCorreoElectronico;
import ar.unrn.tp3.Persistencia.EnDiscoRegistroEmpleado;
import ar.unrn.tp3.modelo.FelizCumpleaños;

public class Main {

	public static void main(String[] args) {

		FelizCumpleaños fc = new FelizCumpleaños(new EnDiscoRegistroEmpleado(), new EnviarCorreoElectronico());
		fc.enviarFelicitaciones();
	}

}
