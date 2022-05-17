package hotel;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.List;

import javax.swing.text.DateFormatter;

public class Reserva {
	private String codigo;
	private LocalDate fecha_reserva;  /* fecha en la que se hizo la reserva */
	private double precio;
	private String codigo_cliente;
	private List<Habitacion> habitacion_reserva = null;  /* Lista donde se guardan las habitaciones reservadas */
	private LocalDate fecha_entrada;   /* fecha en la que entra a la habitacion */
	private LocalDate fecha_salida;    /* fecha en la que se sale de la habitacion */
	DateTimeFormatter f = DateTimeFormatter.ofPattern("YYYY/MM/dd");
	DateTimeFormatter z = DateTimeFormatter.ofPattern("YY/MM/dd");
	DateTimeFormatter c = DateTimeFormatter.ofPattern("YYMMdd");
	
	
	public Reserva(String codigo,double precio, String codigo_cliente, LocalDate fecha_entrada2, LocalDate fecha_salida2, LocalDate fecha_reserva2) {
		
		this.fecha_reserva = fecha_reserva2;  
		this.precio = precio;
		this.codigo_cliente = codigo_cliente;
		this.codigo = codigo;
		//this.fecha_entrada = (Date) fecha_entrada2;
		//this.fecha_salida = (Date) fecha_salida2;
		this.fecha_entrada = fecha_entrada2;
		this.fecha_salida = fecha_salida2;
		this.habitacion_reserva = new LinkedList<Habitacion>();
	}
	
	public Reserva(String codigo_cliente,List<Habitacion> habi_reserva, LocalDate fecha_e, LocalDate fecha_s) {
		this.habitacion_reserva = habi_reserva; 
		this.fecha_reserva = LocalDate.now();   
		///this.precio = calcularPrecio();
		this.codigo_cliente = codigo_cliente;
		this.codigo = generarCodigo();
		this.fecha_entrada = fecha_e;
		this.fecha_salida = fecha_s;
		this.habitacion_reserva = new LinkedList<Habitacion>();
	}
	
	/* Metodo que genera el codigo de reserva apartir del DNI del cliente y de la fecha de la reserva */
	public String generarCodigo() {
		
		return this.codigo_cliente+fecha_reserva.format(c);
	}
	
	public String getCodigoCliente() {
		return this.codigo_cliente;
	}
	
	public String getCodigo() {
		return this.codigo;
	}
	
	public String getFecha() {
		return this.fecha_reserva.format(f);
	}
	
	public String getFecha_entrada() {
		return this.fecha_entrada.format(f).toString();
	}
	
	public Date getDateFechaEntrada() {
		return (Date) Date.from(fecha_entrada.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}
	
	public Date getDateFechaSalida() {
		return (Date) Date.from(fecha_salida.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}
	
	public Date getDateFechaReserva() {
		return (Date) Date.from(fecha_reserva.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}
	
	public String getFecha_salida() {
		return this.fecha_salida.format(f).toString();
	}
	
	public double getPrecio() {
		return this.precio;
	}
	
	/* Metodo que calcula el precio de la reserva */
	public double calcularPrecio() {
		double total = 0;
		
		int dias = (int) fecha_entrada.until(fecha_salida, ChronoUnit.DAYS);
		
		for(int i=0; i < habitacion_reserva.size(); i++) {
			total = total + habitacion_reserva.get(i).getPrecio()*dias;
		}
		
		return total;
		
	}
	

	/* Metodo que añade una habitacion a la lista de habitaciones reservadas */
	public void addHabitacion(Habitacion nueva) {
		this.habitacion_reserva.add(nueva);
	}
	
	public List<Habitacion> gethabitacion_reserva(){
		return this.habitacion_reserva;
	}
	
	public String mostrarInfo() {
		this.precio = calcularPrecio();
		String m = "Reserva\n";
		m = m + "codigo: " + this.codigo+"\n";
		m = m + "Cliente: "+ this.codigo_cliente+"\n";
		m = m + "precio: " + this.precio+"\n";
		m = m + "fecha_entrada: " + getFecha_entrada()+"\n";
		m = m + "fecha_salida: " + getFecha_salida()+"\n";
		m = m + "fecha_reserva: " + getFecha()+"\n";
		
		
		return m;
	}
	
	/* Metodo que cuenta las habitaciones de cada tipo que hay y las devuelve en un formato string */
	public String contarHabi() {
		int indi = 0;
		int doble = 0;
		int fami = 0;
		int lujo = 0;
		String m = "";
		
		for(int i = 0; i < habitacion_reserva.size(); i++) {
			if(habitacion_reserva.get(i).getTipo().equals("Individual")) {
				indi++;
			}
			if(habitacion_reserva.get(i).getTipo().equals("Doble")) {
				doble++;
			}
			if(habitacion_reserva.get(i).getTipo().equals("Familiar")) {
				fami++;
			}
			if(habitacion_reserva.get(i).getTipo().equals("Lujo")) {
				lujo++;
			}
		}
		
		if(indi != 0) {
			m = m +"Tiene "+indi+" Habitaciones individuales\n";
		}
		if(doble != 0) {
			m = m +"Tiene "+doble+" Habitaciones dobles\n";
		}
		if(fami != 0) {
			m = m +"Tiene "+fami+" Habitaciones familiares\n";
		}
		if(lujo != 0) {
			m = m +"Tiene "+lujo+" Habitaciones de lujo\n";
		}
		
		return m;
	}
	
}
