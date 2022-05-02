package hotel;

import java.util.List;

import javax.swing.JOptionPane;

public class Trabajador extends Persona {
	
	private String id;
	private String contraseņa;
	private boolean ocupado;
	
	public Trabajador(String dNI, String nombre, String apellidos, String correo, String edad, String telef, String id,
			String contraseņa) {
		super(dNI, nombre, apellidos, correo, edad, telef);
		this.id = id;
		this.contraseņa = contraseņa;
		this.ocupado = false;
	}
	
	public void setOcupado(boolean res) {
		this.ocupado = res;
	}
	public String getId() {
		return this.id;
	}
	
	public boolean getOcupado() {
		return ocupado;
	}
	
	
	
	
}
