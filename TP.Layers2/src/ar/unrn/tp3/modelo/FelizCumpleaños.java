package ar.unrn.tp3.modelo;

import java.time.LocalDate;
import java.util.List;

public class FelizCumpleaños {

	private RegistrarEmpleado regEmp;
	private EnviarEmail enviarEmail;

	public FelizCumpleaños(RegistrarEmpleado regEmp, EnviarEmail enviarEmail) {
		this.regEmp = regEmp;
		this.enviarEmail = enviarEmail;
	}

	public void enviarFelicitaciones() {

		LocalDate fechaHoy = LocalDate.now();
		List<Empleado> ListaEmpleado = regEmp.obtenerEmpleados();

		for (Empleado emp : ListaEmpleado) {
			if (emp.esTuCumpleaños(fechaHoy.getMonthValue() + "-" + fechaHoy.getDayOfMonth())) {
				enviarEmail.enviar(emp.obtenerEmail(), "Feliz Cumpleaños,", "Hola que pases un buen dia Cumpleañero");
				System.out.println("Se envio Felicitaciones a " + emp.obtenerApellido() + " " + emp.obtenerNombre());
			}
		}

	}

}
