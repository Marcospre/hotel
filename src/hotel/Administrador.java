package hotel;

public class Administrador extends Persona {

	private String ID;
	private String contraseña;
	
	public Administrador(String dNI, String nombre, String apellidos, String correo, String edad, String telef, String id, String contraseña) {
		super(dNI, nombre, apellidos, correo, edad, telef);
		// TODO Auto-generated constructor stub
		this.ID = id;
		this.contraseña = contraseña;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}
	
	public void setContra(String contra) {
		this.contraseña = contra;
	}
	

}
