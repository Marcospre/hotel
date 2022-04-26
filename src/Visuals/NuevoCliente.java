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
				
				nuevoCliente = new Cliente(txtNombre.getText(),txtApellidos.getText(),txtDNI.getText(),txtCorreo.getText(),txtEdad.getText(),txtTelefono.getText());
				misClientes.add(nuevoCliente);
				
				//añadir cliente
				dbf.añadirFilaCliente(nuevoCliente);
				
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			ventana.dispose();
			RealizarReserva nuevaReserva = new RealizarReserva(nuevoCliente,miHotel);
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
