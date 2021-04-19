package ar.unrn.tp3.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ar.unrn.tp3.modelo.Participante;
import ar.unrn.tp3.modelo.RepositorioDeParticipantes;

public class JDBCParticipante implements RepositorioDeParticipantes {

	private Connection setupBaseDeDatos() {
		try {
			String url = "jdbc:mysql://localhost:3306/participantes";
			String user = "root";
			String password = "";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void cargarPacticipante(Participante participante) {
		try {
			Connection dbConn = setupBaseDeDatos();
			PreparedStatement st = dbConn
					.prepareStatement("insert into participantes(nombre, telefono, region)values(?,?,?)");
			st.setString(1, participante.obtenerNombre());
			st.setString(2, participante.obtenerTelefono());
			st.setString(3, participante.obtenerRegion());
			st.executeUpdate();
			st.close();

		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}

}
