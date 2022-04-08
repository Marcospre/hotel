package hotel;

import java.util.List;

public class Main {
	
	
	static List<Trabajador> misTrabajadores;
	static List<Administrador> misAdministradores;
	static List<Cliente> misClientes;
	static Hotel miHotel = new Hotel("Tricaro", "*****","Calle ***** nº*",misTrabajadores,misAdministradores);
	static Menu miMenu = new Menu(misClientes,miHotel);
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		do {
			
			miMenu.elejirOpcion();
		}while(!miMenu.getSalir());
	}

}