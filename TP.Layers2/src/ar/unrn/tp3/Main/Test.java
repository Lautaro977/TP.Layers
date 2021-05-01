package ar.unrn.tp3.Main;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.time.LocalDate;
import java.util.List;

import ar.unrn.tp3.Libreria.EnviarCorreoElectronico;
import ar.unrn.tp3.Persistencia.RegistrarEnMemoria;
import ar.unrn.tp3.modelo.Empleado;
import ar.unrn.tp3.modelo.EnviarEmail;
import ar.unrn.tp3.modelo.FelizCumpleaños;
import ar.unrn.tp3.modelo.RegistrarEmpleado;

class Test {

	@org.junit.jupiter.api.Test
	public void testCrearEmpleado() {
		LocalDate fecha2 = LocalDate.of(1997, 4, 30);
		assertDoesNotThrow(() -> new Empleado("Lapuente", "Alexis", fecha2.toString(), "Alexis77@gmail.com"));

	}

	@org.junit.jupiter.api.Test
	public void testExisteEmpleado() {

		RegistrarEmpleado regEmp = new RegistrarEnMemoria();

		LocalDate fecha1 = LocalDate.of(1997, 12, 9);
		LocalDate fecha2 = LocalDate.of(1997, 04, 30);

		Empleado empleado1 = null;
		Empleado empleado2 = null;
		try {
			empleado1 = new Empleado("Lapuente", "Lautaro", fecha1.toString(), "Lautary977@gmail.com");
			empleado2 = new Empleado("Lapuente", "Alexis", fecha2.toString(), "Alexis77@gmail.com");

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		regEmp.guardarEmpleado(empleado1);
		regEmp.guardarEmpleado(empleado2);

		assertTrue(regEmp.existeEmpleado(empleado2));

	}

	@org.junit.jupiter.api.Test
	public void testRecuperarEmpleado() {
		RegistrarEmpleado regEmp = new RegistrarEnMemoria();

		List<Empleado> ListaEmpleados = regEmp.obtenerEmpleados();
		assertNotNull(ListaEmpleados);
	}

	@org.junit.jupiter.api.Test
	public void testExisteEmailEnviado() {
		RegistrarEmpleado regEmp = new RegistrarEnMemoria();
		EnviarEmail enviarEmail = new EnviarCorreoElectronico();
		LocalDate fecha1 = LocalDate.of(1997, 04, 30);
		try {
			Empleado empleado = new Empleado("Lapuente", "Alexis", fecha1.toString(), "Alexis77@gmail.com");
			regEmp.guardarEmpleado(empleado);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		FelizCumpleaños fc = new FelizCumpleaños(regEmp, enviarEmail);

		fc.enviarFelicitaciones();

		assertTrue(enviarEmail.existeEmail("Alexis77@gmail.com"));

	}

}
