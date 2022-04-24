package hotel;

import java.time.LocalDateTime;

public class Habitacion {
	
	private String numero;
	private String tipo;
	private double precio;
	private LocalDateTime fecha_entrada;
	private LocalDateTime fecha_salida;
	private Boolean ocupado;
	private String descripcion;
	private Tamaño tamaño;
	private String nombre_hotel;
	
	public Habitacion(String numero, String tipo, double precio, String descrip, boolean ocu, String nombre_hotel) {
		this.numero = numero;
		this.tipo = tipo;
		this.precio = precio;
		this.descripcion = descrip;
		this.ocupado = ocu;
		this.nombre_hotel = nombre_hotel;
		
	}
	public Habitacion(String numero, String tipo, double precio, String des, String nombre_tama) {
		this.numero = numero;
		this.tipo = tipo;
		this.precio = precio;
		this.ocupado = false;
		this.descripcion = des;
	}
	
	public String getNumero() {
		return this.numero;
	}
	
	public String getTipo() {
		return this.tipo;
	}
	
	public double getPrecio() {
		return this.precio;
	}
	
	public void setTime_entrada(LocalDateTime time) {
		this.fecha_entrada = time;
	}
	
	public void setTime_salida(LocalDateTime time) {
		this.fecha_salida = time;
	}
	
	public void setOcupado(Boolean res) {
		this.ocupado = res;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public boolean getOcupado() {
		return this.ocupado;
	}
	
}
