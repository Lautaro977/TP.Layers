package ar.unrn.tp3.modelo;

import java.time.LocalDate;
import java.util.List;

public class FelizCumplea�os {

	private RegistrarEmpleado regEmp;
	private EnviarEmail enviarEmail;

	public FelizCumplea�os(RegistrarEmpleado regEmp, EnviarEmail enviarEmail) {
		this.regEmp = regEmp;
		this.enviarEmail = enviarEmail;
	}

	public void enviarFelicitaciones() {

		LocalDate fechaHoy = LocalDate.now();
		List<Empleado> ListaEmpleado = regEmp.obtenerEmpleados();

		for (Empleado emp : ListaEmpleado) {
			if (emp.esTuCumplea�os(fechaHoy.getMonthValue() + "-" + fechaHoy.getDayOfMonth())) {
				enviarEmail.enviar(emp.obtenerEmail(), "Feliz Cumplea�os,", "Hola que pases un buen dia Cumplea�ero");
				System.out.println("Se envio Felicitaciones a " + emp.obtenerApellido() + " " + emp.obtenerNombre());
			}
		}

	}

}
