package ar.unrn.tp3.Main;

import java.time.LocalDate;

import ar.unrn.tp3.Libreria.EnviarCorreoElectronico;
import ar.unrn.tp3.Persistencia.EnDiscoRegistroEmpleado;
import ar.unrn.tp3.modelo.Empleado;
import ar.unrn.tp3.modelo.EnviarEmail;
import ar.unrn.tp3.modelo.RegistrarEmpleado;

public class Main {

	public static void main(String[] args) {

		RegistrarEmpleado regEmp = new EnDiscoRegistroEmpleado();
		EnviarEmail enviarEmail = new EnviarCorreoElectronico();

		LocalDate fecha1 = LocalDate.of(1997, 12, 9);
		LocalDate fecha2 = LocalDate.of(1997, 04, 22);

		try {
			Empleado empleado1 = new Empleado("Lapuente", "Lautaro", fecha1.toString(), "Lautary977@gmail.com");
			Empleado empleado2 = new Empleado("Lapuente", "Alexis", fecha2.toString(), "Alexis77@gmail.com");
			regEmp.guardarEmpleado(empleado1);
			regEmp.guardarEmpleado(empleado2);
			String ListaEmpleado = regEmp.obtenerEmpleados();
			if (!ListaEmpleado.isEmpty()) {
				enviarEmail.enviar("Lapuente Alexis", "Feliz Cumpleaños,", "Hola que pases un buen dia Alexis");

			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

}
