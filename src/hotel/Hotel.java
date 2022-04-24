package hotel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Hotel {
	private String nombre;
	private String direccion;
	private String valoracion;
	private List<Trabajador> misTrabajadores;
	private List<Habitacion> misHabitaciones;
	 List<Habitacion> individuales = new LinkedList<Habitacion>();
	List<Habitacion> dobles = new LinkedList<Habitacion>();
    private List<Habitacion> familiares = new LinkedList<Habitacion>();
    private List<Habitacion> lujo = new LinkedList<Habitacion>();
	List<Reserva> misReservas;
	
	
	public Hotel(String nombre, String valo, String dire) {
		this.nombre = nombre;
		this.valoracion = valo;
		this.direccion = dire;
	}
	public Hotel(String nombre, String valo, String dire, List<Trabajador> misTrabajadores, List<Habitacion> misHabitaciones, List<Reserva> misReservas) {
		this.nombre = nombre;
		this.valoracion = valo;
		this.direccion = dire;
		this.misTrabajadores = misTrabajadores;
		this.misHabitaciones = misHabitaciones;
		this.misReservas = misReservas;
		
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public Trabajador atenderCliente() {
		
		Trabajador traba = null;
		
		for(int i = 0; i < misTrabajadores.size(); i++) {
			if(misTrabajadores.get(i).getOcupado() == false) {
				traba = misTrabajadores.get(i);
				misTrabajadores.get(i).setOcupado(true);
				break;
			}
		}
		
		return traba;
	}
	
	public boolean comprobarHabitacion(String tipo, int numero) {
		boolean res = false;
		
		if(tipo.equals("Individuales")) {
			if(numero <= getLibres(individuales)) {
				res = true;

			}
		}else if(tipo.equals("Dobles")) {
			if(numero <= getLibres(dobles)) {
				res = true;
			}
		}else if(tipo.equals("Familiares")) {
			if(numero <= getLibres(familiares)) {
				res = true;
			}
		}else if(tipo.equals("Lujo")) {
			if(numero <= getLibres(lujo)) {
				res = true;
			}
		}
		return res;
	}
	
	public int getLibres(List<Habitacion> tipoHabi) {
		int cont=0;
		
		for (int i = 0; i < tipoHabi.size(); i++) {
			if(!tipoHabi.get(i).getOcupado()) {
				cont++;
			}
		}
		
		return cont;
	}
	
	public void getHabitacion(String tipo,int numero, Reserva reser) {
		if(tipo.equals("Individuales")) {
			for(int i=0; i < numero; i++) {
				if(!individuales.get(i).getOcupado()) {
					reser.addHabitacion(individuales.get(i));
					individuales.get(i).setOcupado(false);
				}
			}
		}else if(tipo.equals("Dobles")) {
			for(int i=0; i < numero; i++) {
				if(!dobles.get(i).getOcupado()) {
					reser.addHabitacion(dobles.get(i));
					dobles.get(i).setOcupado(false);
				}
			}
		}else if(tipo.equals("Familiares")) {
			for(int i=0; i < numero; i++) {
				if(!familiares.get(i).getOcupado()) {
					reser.addHabitacion(familiares.get(i));
					familiares.get(i).setOcupado(false);
				}
			}
		}else if(tipo.equals("Lujo")) {
			for(int i=0; i < numero; i++) {
				if(!lujo.get(i).getOcupado()) {
					reser.addHabitacion(lujo.get(i));
					lujo.get(i).setOcupado(false);
				}
			}
		}
		
		
	}
	
	
	
	
}
