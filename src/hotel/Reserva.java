package hotel;

import java.time.LocalDateTime;
import java.util.List;

public class Reserva {
	private String codigo;
	LocalDateTime fecha_reserva;
	private double precio;
	private String codigo_cliente;
	List<Habitacion> habitacion_reserva = null;
	
	
	public Reserva(String codigo_cliente,List<Habitacion> habi_reserva) {
		this.habitacion_reserva = habi_reserva; 
		this.fecha_reserva = LocalDateTime.now();   
		this.precio = calcularPrecio();
		this.codigo_cliente = codigo_cliente;
		this.codigo = generarCodigo();
	}
	
	
	public String generarCodigo() {
		
		return fecha_reserva.toString();
	}
	
	public double calcularPrecio() {
		double total = 0;
		
		for(int i=0; i < habitacion_reserva.size(); i++) {
			total = total + habitacion_reserva.get(i).getPrecio();
		}
		
		return total;
		
	}
	
}
