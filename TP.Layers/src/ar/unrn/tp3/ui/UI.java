package ar.unrn.tp3.ui;

import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ar.unrn.tp3.modelo.NombreParticipante;
import ar.unrn.tp3.modelo.Participante;
import ar.unrn.tp3.modelo.RegionParticipante;
import ar.unrn.tp3.modelo.RepositorioDeParticipantes;
import ar.unrn.tp3.modelo.TelefonoParticipante;

public class UI extends JFrame {
	private Connection dbConn;
	private JTextField nombre;
	private JTextField telefono;
	private JTextField region;

	private RepositorioDeParticipantes repositorio;

	public UI(RepositorioDeParticipantes repositorio) {
		this.repositorio = repositorio;

	}

	public void setupUIComponents() throws SQLException, ClassNotFoundException {
		repositorio.setupBaseDeDatos();
		setTitle("Add Participant");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.nombre = new JTextField(10);
		this.telefono = new JTextField(10);
		this.region = new JTextField(10);
		this.nombre.setText("");
		this.telefono.setText("");
		this.region.setText("China");
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new FlowLayout());
		contentPane.add(new JLabel("Nombre: "));
		contentPane.add(nombre);
		contentPane.add(new JLabel("Telefono: "));
		contentPane.add(telefono);
		contentPane.add(new JLabel("Region: "));
		contentPane.add(region);
		JButton botonCargar = new JButton("Cargar");
		botonCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					NombreParticipante nom = new NombreParticipante(nombre.getText());
					TelefonoParticipante tel = new TelefonoParticipante(telefono.getText());
					RegionParticipante rp = new RegionParticipante(region.getText());
					if (rp.obtenerRegion() != null) {
						Participante participante = new Participante(nom.obtenerNombre(), tel.obtenerTelefono(),
								rp.obtenerRegion());
						repositorio.cargarPacticipante(participante);
					}
					setVisible(false);
				} catch (SQLException e1) {
					throw new RuntimeException(e1);
				}
			}
		});
		contentPane.add(botonCargar);
		setContentPane(contentPane);
		contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		pack();
		setVisible(true);
	}

}
