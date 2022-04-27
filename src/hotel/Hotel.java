package hotel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Hotel {
	private String nombre;
	private String direccion;
	private String valoracion;
	private List<Trabajador> misTrabajadores;
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
		ordenarHabitaciones(misHabitaciones);
		this.misReservas = misReservas;
		
	}
	
	public void ordenarHabitaciones(List<Habitacion> misHabis) {
		
		for(int i = 0; i < misHabis.size(); i++) {
			if(misHabis.get(i).getTipo().equals("Individual")) {
				individuales.add(misHabis.get(i));
			}else if(misHabis.get(i).getTipo().equals("Doble")) {
				dobles.add(misHabis.get(i));
			}else if(misHabis.get(i).getTipo().equals("Familiar")) {
				familiares.add(misHabis.get(i));
			}else {
				lujo.add(misHabis.get(i));
			}
		}
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
		
		if(tipo.equals("Individual")) {
			if(numero <= getLibres(individuales)) {
				res = true;

			}
		}else if(tipo.equals("Doble")) {
			if(numero <= getLibres(dobles)) {
				res = true;
			}
		}else if(tipo.equals("Familiar")) {
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
	
	public Habitacion getHabitacion(String tipo,int numero, Reserva reser) {
		
		Habitacion habi = null;
		
		if(tipo.equals("Individual")) {
			for(int i=0; i < numero; i++) {
				if(!individuales.get(i).getOcupado()) {
					reser.addHabitacion(individuales.get(i));
					individuales.get(i).setOcupado(true);
					habi = individuales.get(i);
				}
			}
		}else if(tipo.equals("Doble")) {
			for(int i=0; i < numero; i++) {
				if(!dobles.get(i).getOcupado()) {
					reser.addHabitacion(dobles.get(i));
					dobles.get(i).setOcupado(true);
					habi = dobles.get(i);
				}
			}
		}else if(tipo.equals("Familiar")) {
			for(int i=0; i < numero; i++) {
				if(!familiares.get(i).getOcupado()) {
					reser.addHabitacion(familiares.get(i));
					familiares.get(i).setOcupado(true);
					habi = familiares.get(i);
				}
			}
		}else if(tipo.equals("Lujo")) {
			for(int i=0; i < numero; i++) {
				if(!lujo.get(i).getOcupado()) {
					reser.addHabitacion(lujo.get(i));
					lujo.get(i).setOcupado(true);
					habi = lujo.get(i);
				}
			}
		}
		
		return habi;
	}
	
	
	
	
}
