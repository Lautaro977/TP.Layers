package ar.unrn.tp3.modelo;

import java.time.LocalDate;
import java.util.List;

public class FelizCumpleaņos {

	private RegistrarEmpleado regEmp;
	private EnviarEmail enviarEmail;

	public FelizCumpleaņos(RegistrarEmpleado regEmp, EnviarEmail enviarEmail) {
		this.regEmp = regEmp;
		this.enviarEmail = enviarEmail;
	}

	public void enviarFelicitaciones() {

		// Los Empleados ya fueron cargados previamente en el Archivo de los Empleados

		LocalDate fechaHoy = LocalDate.now();
		List<Empleado> ListaEmpleado = regEmp.obtenerEmpleados();

		for (Empleado emp : ListaEmpleado) {
			if (emp.esTuCumpleaņos(fechaHoy.getMonthValue() + "-" + fechaHoy.getDayOfMonth())) {
				enviarEmail.enviar(emp.obtenerEmail(), "Feliz Cumpleaņos", "Hola que pases un buen dia Cumpleaņero");
				System.out.println("Se envio Felicitaciones a " + emp.obtenerApellido() + " " + emp.obtenerNombre());
			}
		}

	}

}
