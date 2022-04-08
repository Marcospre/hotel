package hotel;

public class Tamaño {
	
	private String nombre_habitacion;
	private int nºcamas;
	private int nºbaños;
	
	public Tamaño(String nombre, int num_camas, int num_baños) {
		this.nombre_habitacion = nombre;
		this.nºcamas = num_camas;
		this.nºbaños = num_baños;
	}
	public Tamaño(String nombre) {
		this.nombre_habitacion = nombre;
	}
}
