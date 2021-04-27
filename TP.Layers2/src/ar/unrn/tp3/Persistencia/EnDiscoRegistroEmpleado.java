package ar.unrn.tp3.Persistencia;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

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
	public List<Empleado> obtenerEmpleados() {
		List<Empleado> ListaEmpleados = new ArrayList<>();
		List<String> contenido;
		try {

			contenido = Files.readAllLines(
					Paths.get("C:\\Users\\lauta\\Desktop\\Archivos Tipo Documento de POO 2\\Archivo Layers2.txt"));

			for (String emp : contenido) {
				String[] contenidoSplit = emp.split(",");
				try {
					Empleado empleado = new Empleado(contenidoSplit[0], contenidoSplit[1], contenidoSplit[2],
							contenidoSplit[3]);
					ListaEmpleados.add(empleado);
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
		} catch (FileNotFoundException ex) {
			throw new RuntimeException("No se pudo Abrir...", ex);
		} catch (IOException ex) {
			throw new RuntimeException("No se pudo Abrir...", ex);
		}

		return ListaEmpleados;
	}

	@Override
	public boolean existeEmpleado(Empleado emp) {
		boolean resultado = false;
		List<Empleado> ListaEmpleados = obtenerEmpleados();
		String StringEmpleado;
		for (Empleado empleado : ListaEmpleados) {
			StringEmpleado = empleado.obtenerApellido() + "," + empleado.obtenerNombre() + "," + empleado.obtenerFecha()
					+ "," + empleado.obtenerEmail();
			if (StringEmpleado.contains(emp.obtenerApellido() + "," + emp.obtenerNombre() + "," + emp.obtenerFecha()
					+ "," + emp.obtenerEmail())) {
				resultado = true;
			}
		}
		return resultado;
	}

}
