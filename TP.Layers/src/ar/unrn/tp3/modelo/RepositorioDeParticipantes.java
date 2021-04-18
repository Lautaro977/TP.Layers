package ar.unrn.tp3.modelo;

import java.sql.SQLException;

public interface RepositorioDeParticipantes {

	void setupBaseDeDatos() throws SQLException, ClassNotFoundException;

	void cargarPacticipante(Participante participante) throws SQLException;

}
