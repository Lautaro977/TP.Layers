package ar.unrn.tp3.Main;

import ar.unrn.tp3.Libreria.EnviarCorreoElectronico;
import ar.unrn.tp3.Persistencia.EnDiscoRegistroEmpleado;
import ar.unrn.tp3.modelo.FelizCumpleaņos;

public class Main {

	public static void main(String[] args) {

		FelizCumpleaņos fc = new FelizCumpleaņos(
				new EnDiscoRegistroEmpleado(
						"C:\\Users\\lauta\\Desktop\\Archivos Tipo Documento de POO 2\\Archivo Layers2.txt"),
				new EnviarCorreoElectronico());
		fc.enviarFelicitaciones();
	}

}
