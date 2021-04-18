package ar.unrn.tp3.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ar.unrn.tp3.modelo.Participante;
import ar.unrn.tp3.modelo.RepositorioDeParticipantes;

public class JDBCParticipante implements RepositorioDeParticipantes {
	private Connection dbConn;

	public void setupBaseDeDatos() throws SQLException, ClassNotFoundException {
		String url = "jdbc:mysql://localhost:3306/participantes";
		String user = "root";
		String password = "";
		Class.forName("com.mysql.jdbc.Driver");
		this.dbConn = DriverManager.getConnection(url, user, password);
	}

	public void cargarPacticipante(Participante participante) throws SQLException {
		PreparedStatement st = dbConn
				.prepareStatement("insert into participantes(nombre, telefono, region)values(?,?,?)");
		st.setString(1, participante.obtenerNombre());
		st.setString(2, participante.obtenerTelefono());
		st.setString(3, participante.obtenerRegion());
		st.executeUpdate();
		st.close();

	}

}
