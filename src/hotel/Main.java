package hotel;

import java.util.LinkedList;
import java.util.Hashtable;
import java.util.List;

import Database.DBF;
import Visuals.WindowMenu;

public class Main {
	
	
	static List<Trabajador> misTrabajadores;
	static List<Cliente> misClientes;
	static List<Habitacion> misHabitaciones;
	static List<Reserva> misReservas;
	
	
	/* Metodo main donde se va a iniciar el programa. Aqui se va a hacer una instancia de la
	 * base de datos y se recogen todos lo datos.
	 */
	public static void main(String[] args) {
		
		String database = "3";
		
		int intDatabase = Integer.valueOf(database).intValue();
		
		DBF dbf= new DBF();
		dbf.selectDB(intDatabase);
		
		/*Recogida de Datos*/

		misClientes =  dbf.getListaCliente();
		misTrabajadores = dbf.getListaTrabajador();
		misHabitaciones = dbf.getListaHabitacion();
		misReservas = dbf.getListaReseva();
		Hotel miHotel = new Hotel("Tricaro", "*****","Calle ***** nº*",misTrabajadores,misHabitaciones, misReservas);
		WindowMenu miMenu = new WindowMenu(misClientes,miHotel,dbf);
	
	}

}