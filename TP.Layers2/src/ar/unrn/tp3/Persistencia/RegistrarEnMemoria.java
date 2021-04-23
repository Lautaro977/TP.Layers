package ar.unrn.tp3.Persistencia;

import java.util.ArrayList;
import java.util.List;

import ar.unrn.tp3.modelo.Empleado;
import ar.unrn.tp3.modelo.RegistrarEmpleado;

public class RegistrarEnMemoria implements RegistrarEmpleado {

	private List<Empleado> registroEmpleado = new ArrayList<>();

	public void guardarEmpleado(Empleado empleado) {
		registroEmpleado.add(empleado);
	}

	public String obtenerEmpleados() {
		String texto = "";
		for (Empleado empleado : registroEmpleado) {

			texto += empleado.obtenerApellido() + ",";
			texto += empleado.obtenerNombre() + ",";
			texto += empleado.obtenerFecha() + ",";
			texto += empleado.obtenerEmail() + "--|--";
		}

		return texto;

	}

}
