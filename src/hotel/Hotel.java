package hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
	private String nombre;
	private String direccion;
	private String valoracion;
	private List<Trabajador> misTrabajadores;
	private List<Habitacion> individuales;
	private	List<Habitacion> dobles;
    private List<Habitacion> familiares;
    private List<Habitacion> lujo;
	List<Reserva> misReservas;

	public Hotel(String nombre, String valo, String dire, List<Trabajador> misTrabajadores, List<Administrador> misAdminis) {
		this.nombre = nombre;
		this.valoracion = valo;
		this.direccion = dire;
		this.misTrabajadores = misTrabajadores;
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
		
		if(tipo.equals(individuales.getClass().getName())) {
			if(numero <= getLibres(individuales)) {
				res = true;

			}
		}else if(tipo.equals(dobles.getClass().getName())) {
			if(numero <= getLibres(dobles)) {
				res = true;
			}
		}else if(tipo.equals(familiares.getClass().getName())) {
			if(numero <= getLibres(familiares)) {
				res = true;
			}
		}else if(tipo.equals(lujo.getClass().getName())) {
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
	
	public void getHabitacion(String tipo,int numero, List<Habitacion> hab_reser) {
		if(tipo.equals(individuales.getClass().getName())) {
			for(int i=0; i < numero; i++) {
				if(individuales.get(i).getOcupado()) {
					hab_reser.add(individuales.get(i));
					individuales.get(i).setOcupado(false);
				}
			}
		}else if(tipo.equals(dobles.getClass().getName())) {
			for(int i=0; i < numero; i++) {
				if(dobles.get(i).getOcupado()) {
					hab_reser.add(dobles.get(i));
					dobles.get(i).setOcupado(false);
				}
			}
		}else if(tipo.equals(familiares.getClass().getName())) {
			for(int i=0; i < numero; i++) {
				if(familiares.get(i).getOcupado()) {
					hab_reser.add(familiares.get(i));
					familiares.get(i).setOcupado(false);
				}
			}
		}else if(tipo.equals(lujo.getClass().getName())) {
			for(int i=0; i < numero; i++) {
				if(lujo.get(i).getOcupado()) {
					hab_reser.add(lujo.get(i));
					lujo.get(i).setOcupado(false);
				}
			}
		}
		
		
	}
	
	
	
	
}
