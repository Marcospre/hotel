package hotel;

import java.util.List;

import javax.swing.JOptionPane;

public class Trabajador extends Persona {
	
	private String id;
	private String contraseña;
	private boolean ocupado;
	
	public Trabajador(String dNI, String nombre, String apellidos, String correo, String edad, String telef, String id,
			String contraseña) {
		super(dNI, nombre, apellidos, correo, edad, telef);
		this.id = id;
		this.contraseña = contraseña;
		this.ocupado = false;
	}
	
	public void setOcupado(boolean res) {
		this.ocupado = res;
	}
	public String getId() {
		return this.id;
	}
	
	public void realizarReserva(Hotel hotel,Trabajador recep, Cliente cliente) {
		Reserva nuevaReserva;
		String tipo;
		int numero;
		List<Habitacion> habReser = null;
		
		tipo = JOptionPane.showInputDialog("Tipo de Habitacion:");
		numero = Integer.parseInt(JOptionPane.showInputDialog("Nº Habitaciones:"));
		
		if(hotel.comprobarHabitacion(tipo,numero)) {
			
			hotel.getHabitacion(tipo,numero,habReser);
			nuevaReserva = new Reserva(cliente.getDNI(),habReser);
			hotel.misReservas.add(nuevaReserva);
		}else {
			JOptionPane.showMessageDialog(null, "Habitaciones ocupadas");
		}
		
	}
	
	public boolean getOcupado() {
		return ocupado;
	}
	
	
	
	
}
