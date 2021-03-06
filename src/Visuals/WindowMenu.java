package Visuals;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Database.DBF;

import javax.swing.*;
import java.awt.*;
import hotel.Cliente;
import hotel.Hotel;
import hotel.Trabajador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class WindowMenu implements ActionListener {
	private JFrame frame;
	private List<Cliente> misClientes;
	private Hotel miHotel;
	private DBF dbf;
	
	public WindowMenu(List<Cliente> misClientes, Hotel miHotel, DBF dbf) {
		this.misClientes = misClientes;
		this.miHotel = miHotel;
		this.dbf = dbf;
		mostrarMenu();
	}
	
	/* Metodo que muestra el menu del hotel. En esta caso, solo funciona el primer
	 * caso de uso donde se raliza una reserva y el boton de salir.
	 */
	public void mostrarMenu() {
		
		frame = new JFrame("Hotel Tricaro");
		frame.setLocationRelativeTo(null);
		frame.setBounds(100, 100, 1140, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		frame.add(panel);
		
		JButton btnReserva = new JButton("Realizar Reserva");
		btnReserva.addActionListener(this);
		btnReserva.setActionCommand("Reserva");
		panel.add(btnReserva);
		
		JButton btnVisualizar = new JButton("Visualizar mi Reserva");
		btnVisualizar.addActionListener(this);
		btnVisualizar.setActionCommand("Ver");
		panel.add(btnVisualizar);
		
		JButton btnAdmin = new JButton("Acceso Administrador");
		btnAdmin.addActionListener(this);
		btnAdmin.setActionCommand("Admin");
		panel.add(btnAdmin);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setActionCommand("Salir");
		panel.add(btnSalir);
		
		frame.setVisible(true);
		
	}
	
	/* Metodo que registra la accion realiza por el usuario en la ventana anterior. */
	public void actionPerformed(ActionEvent click) {
		switch(click.getActionCommand()) {
			
			case "Reserva":
				NuevoCliente nuevoCli = new NuevoCliente(misClientes,miHotel,dbf);
				//Cliente clien = nuevoCli.getNuevocliente();
				//Trabajador recep= miHotel.atenderCliente();
				//RealizarReserva nuevaReserva = new RealizarReserva(miHotel,recep,clien);
				break;
				
			case "Salir":
				frame.dispose();
				System.exit(0);
				break;
		}
	}
	
	
}
