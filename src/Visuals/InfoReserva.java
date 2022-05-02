package Visuals;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import hotel.Reserva;
import hotel.Habitacion;

public class InfoReserva {
	
	private Reserva miReserva;
	private JTextField txtCodigo;
	private JTextField txtCodigoCliente;
	private JTextField txtFecha;
	private List<Habitacion> habreser;
	
	public InfoReserva(Reserva reser) {
		this.miReserva = reser;
		mostarMenu();
	}
	
	/* Metodo que muestra la pantalla de informacion de la reserva realizada por el cliente */
	public void mostarMenu() {
		
		JFrame ventana = new JFrame("Reserva");
		ventana.setBounds(100, 100, 700, 600);
		ventana.getContentPane().setLayout(new GridLayout(7, 2, 10, 10));
		ventana.setLocationRelativeTo(null);
		
		JLabel labelCodigo = new JLabel("Codigo Reserva:");
		labelCodigo.setFont(new Font("Tahoma", Font.BOLD, 11));
		ventana.getContentPane().add(labelCodigo);
		
		JLabel txtCodigo = new JLabel(miReserva.getCodigo());
		txtCodigo.setBackground(Color.WHITE);
		ventana.getContentPane().add(txtCodigo);
		
		JLabel labelCodigoCliente = new JLabel("Codigo Cliente:");
		labelCodigoCliente.setFont(new Font("Tahoma", Font.BOLD, 11));
		ventana.getContentPane().add(labelCodigoCliente);
		
		JLabel txtCodigoCliente = new JLabel(miReserva.getCodigoCliente());
		txtCodigoCliente.setBackground(Color.WHITE);
		ventana.getContentPane().add(txtCodigoCliente);
		
		JLabel labelFecha_entrada = new JLabel("Fecha entrada:");
		labelFecha_entrada.setFont(new Font("Tahoma", Font.BOLD, 11));
		ventana.getContentPane().add(labelFecha_entrada);
		
		JLabel txtFecha_entrada = new JLabel(miReserva.getFecha_entrada());
		txtFecha_entrada.setBackground(Color.WHITE);
		ventana.getContentPane().add(txtFecha_entrada);
		
		JLabel labelFecha_salida = new JLabel("Fecha salida:");
		labelFecha_salida.setFont(new Font("Tahoma", Font.BOLD, 11));
		ventana.getContentPane().add(labelFecha_salida);
		
		JLabel txtFecha_salida = new JLabel(miReserva.getFecha_salida());
		txtFecha_salida.setBackground(Color.WHITE);
		ventana.getContentPane().add(txtFecha_salida);
		
		JLabel labelPrecio = new JLabel("Precio:");
		labelPrecio.setFont(new Font("Tahoma", Font.BOLD, 11));
		ventana.getContentPane().add(labelPrecio);
		
		JLabel txtPrecio = new JLabel(miReserva.getPrecio()+"");
		txtPrecio.setBackground(Color.WHITE);
		ventana.getContentPane().add(txtPrecio);
		
		JTextArea habis  =new JTextArea(40,20);
		habis.setText(miReserva.contarHabi());
		habis.setBackground(Color.WHITE);
		//habis.setTabSize(20);
		ventana.getContentPane().add(habis);
		
		ventana.setVisible(true);
	}
	
	

}
