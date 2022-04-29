package Visuals;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Database.DBF;
import hotel.Cliente;
import hotel.Hotel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NuevoCliente implements ActionListener {
	
	private JFrame ventana;
	private JButton aceptar = new JButton("Aceptar");
	private JButton cancelar = new JButton("Cancelar");
	private JTextField txtNombre = new JTextField();
	private JTextField txtApellidos = new JTextField();
	private JTextField txtDNI = new JTextField();
	private JTextField txtCorreo = new JTextField();
	private JTextField txtEdad = new JTextField();
	private JTextField txtTelefono = new JTextField();
	private List<Cliente> misClientes;
	private Cliente nuevoCliente;
	private Hotel miHotel;
	private DBF dbf;
	
	public NuevoCliente(List<Cliente> misClientes, Hotel hotel, DBF dbf) {
		this.misClientes = misClientes;
		this.miHotel = hotel;
		this.dbf = dbf;
		mostrarMenu();
	}
	
	public void mostrarMenu() {
		ventana = new JFrame("Datos Cliente");
		ventana.setBounds(100, 100, 700, 300);
		ventana.getContentPane().setLayout(new GridLayout(7, 2, 10, 10));
		ventana.setLocationRelativeTo(null);
		
		JLabel labelNombre = new JLabel("Nombre:");
		ventana.getContentPane().add(labelNombre);
		ventana.getContentPane().add(txtNombre);
		
		JLabel labelApellidos = new JLabel("Apellidos:");
		ventana.getContentPane().add(labelApellidos);
		ventana.getContentPane().add(txtApellidos);
		
		JLabel labelDNI = new JLabel("DNI:");
		ventana.getContentPane().add(labelDNI);
		ventana.getContentPane().add(txtDNI);
		
		JLabel labelCorreo = new JLabel("Correo:");
		ventana.getContentPane().add(labelCorreo);
		ventana.getContentPane().add(txtCorreo);
		
		JLabel labelEdad = new JLabel("Edad:");
		ventana.getContentPane().add(labelEdad);
		ventana.getContentPane().add(txtEdad);
		
		JLabel labelTele = new JLabel("Telefono:");
		ventana.getContentPane().add(labelTele);
		ventana.getContentPane().add(txtTelefono);
		
		aceptar.addActionListener(this);
		aceptar.setActionCommand("Aceptar");
		ventana.getContentPane().add(aceptar);
		
		cancelar.addActionListener(this);
		cancelar.setActionCommand("Cancelar");
		ventana.getContentPane().add(cancelar);
		
		ventana.setVisible(true);
	
	}
	
	public void actionPerformed(ActionEvent click) {
		switch(click.getActionCommand()) {
			
		case "Aceptar":
			try {
				
				if(txtNombre.getText().equals("") || txtApellidos.getText().equals("") || txtDNI.getText().equals("") || txtCorreo.getText().equals("") || txtEdad.getText().equals("") || txtTelefono.getText().equals("")) {
					throw new Exception("Rellene todos los campos");
				}
				Pattern dni_formato = Pattern.compile("^[0-9]{8}[a-zA-Z]$");
				Matcher comparador = dni_formato.matcher(txtDNI.getText());
				
				if (!comparador.matches()) {
					throw new Exception("Formato DNI incorrecto");
				}
				
				Pattern correo_formato = Pattern.compile("[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$");
				Matcher comparadorCorreo = correo_formato.matcher(txtCorreo.getText());
				
				if (!comparadorCorreo.matches()) {
					throw new Exception("Formato email incorrecto");
				}
				
				Pattern tel_formato = Pattern.compile("^[0-9]{9}$");
				Matcher comparadorTele = tel_formato.matcher(txtTelefono.getText());
				
				if (!comparadorTele.matches()) {
					throw new Exception("Formato telefono incorrecto");
				}
				
				Pattern edad_formato = Pattern.compile("^[0-9]+$");
				Matcher comparadorEdad = edad_formato.matcher(txtEdad.getText());
				
				if (!comparadorEdad.matches()) {
					throw new Exception("Formato edad incorrecto");
				}
				
				nuevoCliente = new Cliente(txtDNI.getText(),txtNombre.getText(),txtApellidos.getText(),txtCorreo.getText(),txtEdad.getText(),txtTelefono.getText());
				misClientes.add(nuevoCliente);
				
				//añadir cliente
				dbf.añadirFilaCliente(nuevoCliente);
				
				ventana.dispose();
				RealizarReserva nuevaReserva = new RealizarReserva(nuevoCliente,miHotel,dbf);
				
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			
			
			break;
			
		case "Cancelar":
			ventana.dispose();
			break;
			
		}
	}
	
	public Cliente getNuevocliente() {
		return this.nuevoCliente;
	}
}
