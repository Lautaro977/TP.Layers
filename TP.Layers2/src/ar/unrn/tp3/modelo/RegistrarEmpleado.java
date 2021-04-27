package ar.unrn.tp3.modelo;

import java.util.List;

public interface RegistrarEmpleado {
	void guardarEmpleado(Empleado empleado);

	List<Empleado> obtenerEmpleados();

	boolean existeEmpleado(Empleado emp);
}
