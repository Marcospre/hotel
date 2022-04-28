package Visuals;
import java.awt.*;
import java.util.Calendar;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
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
import javax.swing.border.EmptyBorder;

import Database.DBF;
import hotel.Cliente;
import hotel.Habitacion;
import hotel.Hotel;
import hotel.Reserva;
import hotel.Trabajador;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import com.toedter.calendar.JCalendar;

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
	private DBF dbf;
	private final JCalendar calendar = new JCalendar();
	private final JCalendar calendar_1 = new JCalendar();
	
	//private ButtonGroup tipos = new ButtonGroup();
	
	public RealizarReserva(Cliente cliente, Hotel hotel, DBF dbf) {
		this.miHotel = hotel;
		this.cliente = cliente;
		this.dbf = dbf;
		//this.recep = recep;
		mostrarMenu();
	}
	
	public void mostrarMenu() {
		
		ventana = new JFrame("Reserva");
		ventana.setBounds(100, 100, 1000, 900);
		ventana.getContentPane().setLayout((new BorderLayout()));
		ventana.setLocationRelativeTo(null);
		
		JPanel panelInfo = new JPanel();
		panelInfo.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelInfo.setLayout(new GridLayout(0,2,0,0));
		
		JLabel labelTipo = new JLabel("Tipo");
		labelTipo.setFont(new Font("Tahoma", Font.PLAIN, 40));
		labelTipo.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel labelNumero = new JLabel("Numero");
		labelNumero.setFont(new Font("Tahoma", Font.PLAIN, 40));
		labelNumero.setHorizontalAlignment(SwingConstants.CENTER);
		panelInfo.add(labelTipo);
		panelInfo.add(labelNumero);
		
		ventana.getContentPane().add(panelInfo,BorderLayout.NORTH);
		
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(2,0,0,0));
		
		JPanel tipo = new JPanel();
		tipo.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		tipo.setLayout(new GridLayout(4,2));
		bIndi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bIndi.setHorizontalAlignment(SwingConstants.CENTER);
		
		bIndi.setActionCommand("Individual");
		tipo.add(bIndi);
		tipo.add(txt1);
		
		bIndi.setActionCommand("Doble");
		bDobl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bDobl.setHorizontalAlignment(SwingConstants.CENTER);
		tipo.add(bDobl);
		tipo.add(txt2);
		
		bIndi.setActionCommand("Familiar");
		bFami.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bFami.setHorizontalAlignment(SwingConstants.CENTER);
		tipo.add(bFami);
		tipo.add(txt3);
		
		bIndi.setActionCommand("Lujo");
		bLujo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bLujo.setHorizontalAlignment(SwingConstants.CENTER);
		tipo.add(bLujo);
		tipo.add(txt4);
		
		center.add(tipo);
		ventana.getContentPane().add(center,BorderLayout.CENTER);
		
		
		JPanel fechas = new JPanel();
		fechas.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		fechas.setLayout(new GridLayout(2,2,0,0));
		
		JLabel label = new JLabel("Fecha entrada: ");
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		fechas.add(label);
		
		JPanel panelFechaentrada = new JPanel();
		panelFechaentrada.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		
		FlowLayout fl_panelFechaentrada = new FlowLayout();
		panelFechaentrada.setLayout(fl_panelFechaentrada);
		/*panelFechaentrada.add(dia_e);
		panelFechaentrada.add(new JLabel("/"));
		panelFechaentrada.add(mes_e);
		panelFechaentrada.add(new JLabel("/"));
		panelFechaentrada.add(anio_e);*/

		
		
		fechas.add(panelFechaentrada);
		panelFechaentrada.add(calendar);
		
		JPanel panelFechasalida = new JPanel();
		panelFechasalida.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel label_1 = new JLabel("Fecha salida: ");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		fechas.add(label_1);
		
		/*panelFechasalida.setLayout(new FlowLayout());
		panelFechasalida.add(dia_s);
		panelFechasalida.add(new JLabel("/"));
		panelFechasalida.add(mes_s);
		panelFechasalida.add(new JLabel("/"));
		panelFechasalida.add(anio_s);*/
		
		fechas.add(panelFechasalida);
		
		panelFechasalida.add(calendar_1);
		center.add(fechas);
		ventana.getContentPane().add(center,BorderLayout.CENTER);
		
		JPanel acept = new JPanel();
		acept.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		acept.setLayout(new GridLayout(0,2,0,0));
		aceptar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		aceptar.addActionListener(this);
		aceptar.setActionCommand("Aceptar");
		acept.add(aceptar);
		cancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		cancelar.addActionListener(this);
		cancelar.setActionCommand("Cancelar");
		acept.add(cancelar);
		
		ventana.getContentPane().add(acept,BorderLayout.SOUTH);
		ventana.setVisible(true);
		
		
	}
	
	public void actionPerformed(ActionEvent click) {
		switch(click.getActionCommand()) {
		case "Aceptar":
			try {
				if(bIndi.getActionCommand().equals("") && bDobl.getActionCommand().equals("") && bFami.getActionCommand().equals("") && bLujo.getActionCommand().equals("")) {
					throw new Exception("Inserte algun valor");
				}
				
				SimpleDateFormat fmonth = new SimpleDateFormat("MM");             
			   
				
				//LocalDate time_entrada = LocalDate.of(Integer.parseInt(anio_e.getText()), Integer.parseInt(mes_e.getText()), Integer.parseInt(dia_e.getText()));
				//LocalDate time_salida = LocalDate.of(Integer.parseInt(anio_s.getText()), Integer.parseInt(mes_s.getText()), Integer.parseInt(dia_s.getText()));
				
				LocalDate time_entrada = calendar.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				LocalDate time_salida = calendar_1.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				
				Reserva nuevaReserva = new Reserva(cliente.getDNI(),new LinkedList<Habitacion>(), time_entrada, time_salida);
				System.out.println(nuevaReserva.mostrarInfo());
				dbf.añadirReserva(nuevaReserva);
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
				dbf.modificiarPrecio(nuevaReserva, nuevaReserva.getPrecio());
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
	
	public void Reservar(String tipo, int numero, Reserva reser) throws Exception {
			List<Habitacion> habi = null;
			if(miHotel.comprobarHabitacion(tipo,numero)) {
				habi = miHotel.getHabitacion(tipo,numero,reser);
				
				dbf.añadirReserva_Habi(reser, habi);
				
				//cambiar estado de la ocupacion 
				for(int i = 0; i < habi.size(); i++) {
					dbf.estadoHabi(habi.get(i), true);
				}
				
				//miHotel.misReservas.add(nuevaReserva);
			}else {
				throw new Exception("Habitaciones ocupadas");
			}
	}
}
