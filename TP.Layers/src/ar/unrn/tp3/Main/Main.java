package ar.unrn.tp3.Main;

import ar.unrn.tp3.bd.JDBCParticipante;
import ar.unrn.tp3.ui.UI;

public class Main {

	public static void main(String[] args) {

		UI ui = new UI(new JDBCParticipante());
		ui.setupUIComponents();
	}

}
