package hotel;

public class Cliente extends Persona{
	
	String id_trabaja;
	public Cliente(String dNI, String nombre, String apellidos, String correo, String edad, String telef, String id_trabaja) {
		super(dNI, nombre, apellidos, correo, edad, telef);
		this.id_trabaja = id_trabaja;
		// TODO Auto-generated constructor stub
	}

}
