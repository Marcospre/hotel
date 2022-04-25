package Visuals;
import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import hotel.Cliente;
import hotel.Habitacion;
import hotel.Hotel;
import hotel.Reserva;
import hotel.Trabajador;

public class RealizarReserva implements ActionListener {
	private JFrame ventana;
	private Hotel miHotel;
	private Trabajador recep;
	private Cliente cliente;
	private JButton aceptar = new JButton("Aceptar");
	private JButton cancelar = new JButton("Cancelar");
	private JRadioButton bIndi = new JRadioButton("Individual");
	private JRadioButton bDobl = new JRadioButton("Doble");
	private JRadioButton bFami = new JRadioButton("Familiar");
	private JRadioButton bLujo = new JRadioButton("Lujo");
	JTextField dia_e = new JTextField(2);
	JTextField mes_e = new JTextField(2);
	JTextField anio_e = new JTextField(2);
	JTextField dia_s = new JTextField(2);
	JTextField mes_s = new JTextField(2);
	JTextField anio_s = new JTextField(2);
	private JTextField txt1 = new JTextField(2);
	private JTextField txt2 = new JTextField(2);
	private JTextField txt3 = new JTextField(2);
	private JTextField txt4 = new JTextField(2);
	
	//private ButtonGroup tipos = new ButtonGroup();
	
	public RealizarReserva(Cliente cliente, Hotel hotel) {
		this.miHotel = hotel;
		this.cliente = cliente;
		//this.recep = recep;
		mostrarMenu();
	}
	
	public void mostrarMenu() {
		
		ventana = new JFrame("Reserva");
		ventana.setBounds(100, 100, 900, 500);
		ventana.getContentPane().setLayout((new GridLayout(4,0,0,0)));
		ventana.setLocationRelativeTo(null);
		
		JPanel panelInfo = new JPanel();
		panelInfo.setLayout(new GridLayout(0,2,0,0));
		
		JLabel labelTipo = new JLabel("Tipo");
		JLabel labelNumero = new JLabel("Numero");
		panelInfo.add(labelTipo);
		panelInfo.add(labelNumero);
		
		ventana.add(panelInfo);
		
		JPanel tipo = new JPanel();
		tipo.setLayout(new GridLayout(6,2,10,10));
		
		bIndi.setActionCommand("Individual");
		tipo.add(bIndi);
		tipo.add(txt1);
		
		bIndi.setActionCommand("Doble");
		tipo.add(bDobl);
		tipo.add(txt2);
		
		bIndi.setActionCommand("Familiar");
		tipo.add(bFami);
		tipo.add(txt3);
		
		bIndi.setActionCommand("Lujo");
		tipo.add(bLujo);
		tipo.add(txt4);
		
		ventana.add(tipo);
		
		JPanel fechas = new JPanel();
		fechas.setLayout(new GridLayout(2,2,0,0));
		
		fechas.add(new JLabel("Fecha entrada: "));
		
		JPanel panelFechaentrada = new JPanel();
		
		
		panelFechaentrada.setLayout(new FlowLayout());
		panelFechaentrada.add(dia_e);
		panelFechaentrada.add(new JLabel("/"));
		panelFechaentrada.add(mes_e);
		panelFechaentrada.add(new JLabel("/"));
		panelFechaentrada.add(anio_e);
		
		fechas.add(panelFechaentrada);
		
		JPanel panelFechasalida = new JPanel();
		
		fechas.add(new JLabel("Fecha salida: "));
		
		panelFechasalida.setLayout(new FlowLayout());
		panelFechasalida.add(dia_s);
		panelFechasalida.add(new JLabel("/"));
		panelFechasalida.add(mes_s);
		panelFechasalida.add(new JLabel("/"));
		panelFechasalida.add(anio_s);
		
		fechas.add(panelFechasalida);
		
		ventana.add(fechas);
		
		JPanel acept = new JPanel();
		acept.setLayout(new GridLayout(0,2,0,0));
		aceptar.addActionListener(this);
		aceptar.setActionCommand("Aceptar");
		acept.add(aceptar);
		
		cancelar.addActionListener(this);
		cancelar.setActionCommand("Cancelar");
		acept.add(cancelar);
		
		ventana.add(acept);
		ventana.setVisible(true);
		
		
	}
	
	public void actionPerformed(ActionEvent click) {
		switch(click.getActionCommand()) {
		case "Aceptar":
			try {
				if(bIndi.getActionCommand().equals("") && bDobl.getActionCommand().equals("") && bFami.getActionCommand().equals("") && bLujo.getActionCommand().equals("")) {
					throw new Exception("Inserte algun valor");
				}
				
				LocalDate time_entrada = LocalDate.of(Integer.parseInt(anio_e.getText()), Integer.parseInt(mes_e.getText()), Integer.parseInt(dia_e.getText()));
				LocalDate time_salida = LocalDate.of(Integer.parseInt(anio_s.getText()), Integer.parseInt(mes_s.getText()), Integer.parseInt(dia_s.getText()));
				Reserva nuevaReserva = new Reserva(cliente.getDNI(),new LinkedList<Habitacion>(), time_entrada, time_salida);
				
				if(bIndi.isSelected()) {
					Reservar("Individual",Integer.parseInt(this.txt1.getText()),nuevaReserva);
				}
				if(bDobl.isSelected()) {
					Reservar("Doble",Integer.parseInt(this.txt2.getText()),nuevaReserva);
				}
				if(bFami.isSelected()) {
					Reservar("Familiar",Integer.parseInt(this.txt3.getText()),nuevaReserva);
				}
				if(bLujo.isSelected()) {
					Reservar("Lujo",Integer.parseInt(this.txt4.getText()),nuevaReserva);
				}
				System.out.println(nuevaReserva.mostrarInfo());
				
				InfoReserva inforeser = new InfoReserva(nuevaReserva);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
			break;
			
		case "Cancelar":
			ventana.dispose();
			break;
		}
	}
	
	public void Reservar(String tipo, int numero, Reserva reser) {
		if(miHotel.comprobarHabitacion(tipo,numero)) {
			miHotel.getHabitacion(tipo,numero,reser);
			//miHotel.misReservas.add(nuevaReserva);
		}else {
			JOptionPane.showMessageDialog(null, "Habitaciones ocupadas");
		}
	}
}
