package hotel;

public class Administrador extends Persona {

	private String ID;
	private String contrase�a;
	
	public Administrador(String dNI, String nombre, String apellidos, String correo, String edad, String telef, String id, String contrase�a) {
		super(dNI, nombre, apellidos, correo, edad, telef);
		// TODO Auto-generated constructor stub
		this.ID = id;
		this.contrase�a = contrase�a;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}
	
	public void setContra(String contra) {
		this.contrase�a = contra;
	}
	

}
