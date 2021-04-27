package ar.unrn.tp3.Persistencia;

import java.util.ArrayList;
import java.util.List;

import ar.unrn.tp3.modelo.Empleado;
import ar.unrn.tp3.modelo.RegistrarEmpleado;

public class RegistrarEnMemoria implements RegistrarEmpleado {

	private List<Empleado> ListaEmpleados = new ArrayList<>();

	public void guardarEmpleado(Empleado empleado) {
		ListaEmpleados.add(empleado);
	}

	public List<Empleado> obtenerEmpleados() {

		return ListaEmpleados;

	}

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
