package hotel;

public class Tama�o {
	
	private String nombre_habitacion;
	private int n�camas;
	private int n�ba�os;
	
	public Tama�o(String nombre, int num_camas, int num_ba�os) {
		this.nombre_habitacion = nombre;
		this.n�camas = num_camas;
		this.n�ba�os = num_ba�os;
	}
	public Tama�o(String nombre) {
		this.nombre_habitacion = nombre;
	}
}
