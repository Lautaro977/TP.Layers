package ar.unrn.tp3.Persistencia;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import ar.unrn.tp3.modelo.Empleado;
import ar.unrn.tp3.modelo.RegistrarEmpleado;

public class EnDiscoRegistroEmpleado implements RegistrarEmpleado {

	@Override
	public void guardarEmpleado(Empleado emp) {
		String empleado = emp.obtenerApellido() + "," + emp.obtenerNombre() + "," + emp.obtenerFecha() + ","
				+ emp.obtenerEmail() + "\n";
		try {
			Files.write(Paths.get("C:\\Users\\lauta\\Desktop\\Archivos Tipo Documento de POO 2\\Archivo Layers2.txt"),
					empleado.getBytes(), StandardOpenOption.APPEND);

		} catch (IOException e) {
			throw new RuntimeException("No se pudo persistir...", e);
		}

	}

	@Override
	public String obtenerEmpleados() {
		String contenido = "";
		int c;
		try {
			FileReader f = new FileReader(
					"C:\\Users\\lauta\\Desktop\\Archivos Tipo Documento de POO 2\\Archivo Layers2.txt");
			c = f.read();
			while (c != -1) {
				contenido += (char) c;
				c = f.read();
			}
		} catch (FileNotFoundException ex) {
			throw new RuntimeException("No se pudo Abrir...", ex);
		} catch (IOException ex) {
			throw new RuntimeException("No se pudo Abrir...", ex);
		}

		return contenido;
	}

}
