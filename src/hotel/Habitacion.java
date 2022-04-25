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
	
	public Habitacion(String numero, String tipo, double precio, int ocu, String nombre_hotel) {
		this.numero = numero;
		this.tipo = tipo;
		this.precio = precio;
		if(ocu == 1)
			this.ocupado = false;
		else
			this.ocupado = true;
		this.nombre_hotel = nombre_hotel;
		
	}
	public Habitacion(String numero, String tipo, double precio, String nombre_tama) {
		this.numero = numero;
		this.tipo = tipo;
		this.precio = precio;
		this.ocupado = false;
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
	
	@Override
	
	public String toString() {
		return this.ocupado+"";
	}
}
