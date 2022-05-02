package hotel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Hotel {
	private String nombre;
	private String direccion;
	private String valoracion;
	private List<Trabajador> misTrabajadores;     /* Lista de trabajadires del hotel*/
	private List<Habitacion> individuales = new LinkedList<Habitacion>();  /* Lista con las habitaciones individuales*/
	private List<Habitacion> dobles = new LinkedList<Habitacion>();			/* Lista con las habitaciones dobles*/
    private List<Habitacion> familiares = new LinkedList<Habitacion>();     /* Lista con las habitaciones familiares*/
    private List<Habitacion> lujo = new LinkedList<Habitacion>();           /* Lista con las habitaciones de lujo*/
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
	
	/* Metodo que pasandole una lista de habitaciones, las almacena en las listas individuales
	 * dobles, familiares o lujo dependiendo de su tipo
	 */
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
	
	/* Metodo que pasandole un string que especifica el tipo de habitacion, y un entero,
	 * que define el numero de habitaciones; devuelve un booleano diciendo si hay ese numero
	 * de habitaciones libres
	 */
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
	
	/* Metodo que devuelve cuantas habitaciones hay libres
	 * en la lista que se le pasa como parametro de entrada
	 */
	public int getLibres(List<Habitacion> tipoHabi) {
		int cont=0;
		
		for (int i = 0; i < tipoHabi.size(); i++) {
			if(!tipoHabi.get(i).getOcupado()) {
				cont++;
			}
		}
		
		return cont;
	}
	
	/* Metodo que devuelve una lista de habitaciones reservadas. Ademas, guarda 
	 * en la reserva que se le pasa como parametro de entrada el numero de habitaciones que
	 * se han reservado. El metodo devuelve una lista de las habitaciones reservadas.
	 */
	public List<Habitacion> getHabitacion(String tipo,int numero, Reserva reser) {
		
		List<Habitacion> habi = new LinkedList<>();
		
		if(tipo.equals("Individual")) {
			recorrerHabis(numero,reser,individuales,habi);
		}else if(tipo.equals("Doble")) {
			recorrerHabis(numero,reser,dobles,habi);
		}else if(tipo.equals("Familiar")) {
			recorrerHabis(numero,reser,familiares,habi);
		}else if(tipo.equals("Lujo")) {
			recorrerHabis(numero,reser,lujo,habi);
		}
		return habi;
	}
	
	/* Metodo que recorre las habitaciones la lista habis viendo si estan ocupadas. En el caso de que no esten ocupadas,
	 * se añade la habitacion a la reserva que se pasa como parametro de entrada y la lista habi
	 */
	public void recorrerHabis(int numero, Reserva reser, List<Habitacion> habis, List<Habitacion> habi) {
		
		boolean salir;
		int j;
		
		for(int i = 0; i < numero; i++) {
			salir = false;
			j = 0;
			while(!salir && j < habis.size()) {
				if(!habis.get(j).getOcupado()) {
					System.out.println("dentro");
					reser.addHabitacion(habis.get(j));
					habis.get(j).setOcupado(true);
					habi.add(habis.get(j));
					salir = true;
				}
				j++;
			}
		}
	}
	
	
	
}
