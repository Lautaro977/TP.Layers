package ar.unrn.tp3.ui;

import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ar.unrn.tp3.modelo.Participante;
import ar.unrn.tp3.modelo.RepositorioDeParticipantes;

public class UI extends JFrame {

	private JTextField nombre;
	private JTextField telefono;
	private JTextField region;

	private RepositorioDeParticipantes repositorio;

	public UI(RepositorioDeParticipantes repositorio) {
		this.repositorio = repositorio;
	}

	public void setupUIComponents() {

		setTitle("Add Participant");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.nombre = new JTextField(10);
		this.telefono = new JTextField(10);
		this.region = new JTextField(10);
		this.nombre.setText("");
		this.telefono.setText("");
		this.region.setText("");
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
					Participante participante = new Participante(nombre.getText(), telefono.getText(),
							region.getText());
					repositorio.cargarPacticipante(participante);
				} catch (RuntimeException ex) {
					JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);

				}
				setVisible(false);
			}
		});
		contentPane.add(botonCargar);
		setContentPane(contentPane);
		contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		pack();
		setVisible(true);
	}

}
