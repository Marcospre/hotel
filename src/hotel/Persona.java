package hotel;

public class Persona {
	
	private String DNI;
	private String nombre;
	private String apellidos;
	private String correo;
	private String edad;
	private String telef;
	
	public Persona(String dNI, String nombre, String apellidos, String correo, String edad, String telef) {
		
		this.DNI = dNI;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.edad = edad;
		this.telef = telef;
	}

	public String getDNI() {
		return this.DNI;
	}

	public void setDNI(String dNI) {
		this.DNI = dNI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getTelef() {
		return telef;
	}

	public void setTelef(String telef) {
		this.telef = telef;
	}
	
	
	
	
}
