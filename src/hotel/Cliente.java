package hotel;

public class Cliente extends Persona{
	
	String id_trabaja;
	public Cliente(String dNI, String nombre, String apellidos, String correo, String edad, String telef) {
		super(dNI, nombre, apellidos, correo, edad, telef);
		
		// TODO Auto-generated constructor stub
	}
	
	public Cliente(String dNI, String nombre, String apellidos, String correo, String edad, String telef, String id_trabajador) {
		super(dNI, nombre, apellidos, correo, edad, telef);
		this.id_trabaja = id_trabajador;
		// TODO Auto-generated constructor stub
	}

}
