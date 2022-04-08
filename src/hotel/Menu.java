package hotel;
import javax.swing.*;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Menu {
	
	private int op;
	Boolean salir = false;
	List<Cliente> misClientes;
	Hotel miHotel;
	public Menu(List<Cliente> misClientes, Hotel hotel) {
		this.misClientes = misClientes;
		this.miHotel = hotel;
	}
	
	public String mostrarMenu() {
		String men = "Menu de Hotel\n"
					+"1.- Solicitud de reserva\n"
					+"2.- Ver mi Reserva\n"
					+"3.- Acceso como personal del centro\n"
					+"Introduzca una opcion:";
	
		return men;
	}
	
	public void elejirOpcion() {
		
		op=Integer.parseInt(JOptionPane.showInputDialog(mostrarMenu()));
		
		switch(op) {
			case 1: Cliente nuevoCli = nuevoCliente();
					Trabajador recep= miHotel.atenderCliente();
					recep.realizarReserva(miHotel,recep,nuevoCli);
				break;
			case 2:
				break;
			case 3:
				break;
			
		}
	}
	
	public boolean getSalir() {

		return salir;
	}
	
	public Cliente nuevoCliente() {
		
		
		Cliente nuevoCliente;
		String nombre = null;
		String apellidos = null;
		String DNI = null;
		String correo = null;
		String edad = null;
		String telef = null;
		
		Formularios formCliente = new Formularios();
		formCliente.setVisible(true);
		
		/*try {
			nombre = JOptionPane.showInputDialog("Introduce un nombre:");
			apellidos = JOptionPane.showInputDialog("Introduce Apellidos");
			DNI = JOptionPane.showInputDialog("Introduce el DNI:");
			correo = JOptionPane.showInputDialog("Introduce el correo:");
			edad = JOptionPane.showInputDialog("Edad:");
			telef = JOptionPane.showInputDialog("Introduce un telefono:");
		}catch(Exception e) {
			if(nombre.length() > 10 || apellidos.length() > 10 || DNI.length() != 9 || telef.length() != 9 ) {
				System.out.println("Datos incorrectos");
			}
			
			if(DNI.indexOf(9))
		}*/
		nuevoCliente = new Cliente(nombre,apellidos,DNI,correo,edad,telef);
		misClientes.add(nuevoCliente);
		
		return nuevoCliente; 
		
	}
	

}
