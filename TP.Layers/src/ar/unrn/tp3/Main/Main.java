package ar.unrn.tp3.Main;

import java.sql.SQLException;

import ar.unrn.tp3.bd.JDBCParticipante;
import ar.unrn.tp3.ui.UI;

public class Main {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		UI ui = new UI(new JDBCParticipante());
		ui.setupUIComponents();
	}

}
