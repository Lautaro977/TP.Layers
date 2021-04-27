package ar.unrn.tp3.Main;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.time.LocalDate;
import java.util.List;

import ar.unrn.tp3.Libreria.EnviarCorreoElectronico;
import ar.unrn.tp3.Persistencia.EnDiscoRegistroEmpleado;
import ar.unrn.tp3.modelo.Empleado;
import ar.unrn.tp3.modelo.EnviarEmail;
import ar.unrn.tp3.modelo.RegistrarEmpleado;

class Test {

	@org.junit.jupiter.api.Test
	public void testCrearEmpleado() {
		LocalDate fecha2 = LocalDate.of(1997, 4, 22);
		assertDoesNotThrow(() -> new Empleado("Lapuente", "Alexis", fecha2.toString(), "Alexis77@gmail.com"));

	}

	@org.junit.jupiter.api.Test
	public void testExisteEmpleado() {

		RegistrarEmpleado regEmp = new EnDiscoRegistroEmpleado();

		LocalDate fecha1 = LocalDate.of(1997, 12, 9);
		LocalDate fecha2 = LocalDate.of(1997, 04, 22);

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
		RegistrarEmpleado regEmp = new EnDiscoRegistroEmpleado();
		// esta bien? el List<Empleado>
		List<Empleado> ListaEmpleados = regEmp.obtenerEmpleados();
		assertNotNull(ListaEmpleados);
	}

	@org.junit.jupiter.api.Test
	public void testEnvioEmail() {
		EnviarEmail enviarEmail = new EnviarCorreoElectronico();
		assertDoesNotThrow(
				() -> enviarEmail.enviar("Lapuente Alexis", "Feliz Cumpleaños,", "Hola que pases un buen dia Alexis"));

	}

}
