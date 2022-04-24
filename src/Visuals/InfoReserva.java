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
	
	public void mostarMenu() {
		
		JFrame ventana = new JFrame("Reserva");
		ventana.setBounds(100, 100, 700, 300);
		ventana.getContentPane().setLayout(new GridLayout(7, 2, 10, 10));
		ventana.setLocationRelativeTo(null);
		
		JLabel labelCodigo = new JLabel("Codigo Reserva:");
		ventana.getContentPane().add(labelCodigo);
		
		JLabel txtCodigo = new JLabel(miReserva.getCodigo());
		ventana.getContentPane().add(txtCodigo);
		
		JLabel labelCodigoCliente = new JLabel("Codigo Cliente:");
		ventana.getContentPane().add(labelCodigoCliente);
		
		JLabel txtCodigoCliente = new JLabel(miReserva.getCodigoCliente());
		ventana.getContentPane().add(txtCodigoCliente);
		
		JLabel labelFecha_entrada = new JLabel("Fecha entrada:");
		ventana.getContentPane().add(labelFecha_entrada);
		
		JLabel txtFecha_entrada = new JLabel(miReserva.getFecha_entrada());
		ventana.getContentPane().add(txtFecha_entrada);
		
		JLabel labelFecha_salida = new JLabel("Fecha salida:");
		ventana.getContentPane().add(labelFecha_salida);
		
		JLabel txtFecha_salida = new JLabel(miReserva.getFecha_salida());
		ventana.getContentPane().add(txtFecha_salida);
		
		JLabel labelPrecio = new JLabel("Precio:");
		ventana.getContentPane().add(labelPrecio);
		
		JLabel txtPrecio = new JLabel(miReserva.getPrecio()+"");
		ventana.getContentPane().add(txtPrecio);
		
		JTextArea habis  =new JTextArea(miReserva.contarHabi());
		ventana.getContentPane().add(habis);
		
		ventana.setVisible(true);
	}
	
	

}
