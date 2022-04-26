package hotel;

import java.util.LinkedList;
import java.util.Hashtable;
import java.util.List;

import Database.DBF;
import Visuals.WindowMenu;

public class Main {
	
	
	static List<Trabajador> misTrabajadores;
	static List<Administrador> misAdministradores;
	static List<Cliente> misClientes;
	static List<Habitacion> misHabitaciones;
	static List<Reserva> misReservas;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			/*misTrabajadores = new LinkedList<Trabajador>();
			misClientes = new LinkedList<Cliente>();
			misTrabajadores.add(new Trabajador("1","marcos","prego","correo","edad","943762","1S","1daw3"));
			misTrabajadores.add(new Trabajador("2","david","barberio","correo","edad","943762","2S","1daw3"));
			Habitacion indi = new Habitacion("1","Individual",60,"","");
			Habitacion doble = new Habitacion("2","Doble",60,"","");
			Hotel miHotel = new Hotel("Tricaro", "*****","Calle ***** nº*",misTrabajadores,misAdministradores);
			miHotel.individuales.add(indi);
			miHotel.dobles.add(doble);
			WindowMenu miMenu = new WindowMenu(misClientes,miHotel);*/
		
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