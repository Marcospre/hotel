package Database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Date;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import hotel.Cliente;
import hotel.Habitacion;
import hotel.Hotel;
import hotel.Reserva;
import hotel.Trabajador;

public class DBF {

	private static DBF instance;
	private String url;
	private Connection konexioa;
	private Statement statement;
		
	/* gestion de multi instancias*/
	
	  public static DBF instance()
	  {
	  	if (instance == null)
	  		instance = new DBF();    
	  	return instance;
	  }
	  
	// estructura multi base de datos 
	public void selectDB(int database)
	  {
	  try
		{  				 
		 switch (database) {
	           
	             case 1://mysql              
	              //url = "jdbc:mysql://IP/esquemaBBDD?user=username&password=password";  ejemplo
	              url = "jdbc:mysql://172.16.6.207/inesmecgestion?user=inesmec&password=inesmec2020*"; 
	              Class.forName("com.mysql.jdbc.Driver").newInstance();
	              konexioa = DriverManager.getConnection(url);	              
	              statement = konexioa.createStatement();
	              System.out.println("Mysql connected");
	                     break;
	                     
	             case 2:  //access
	              url = "jdbc:odbc:KBPACC";
	              Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	              konexioa = DriverManager.getConnection(url, "", "");
	              statement = konexioa.createStatement();
	              System.out.println("access connected");
	                     break;
	       
	            case 3://oracle	            	
	              
	            	//URL of Oracle database server
	                String url = "jdbc:oracle:thin:@91.200.117.27:49161:xe";       
	                Properties props = new Properties();
	                props.setProperty("user", "MARCOS");
	                props.setProperty("password", "plaiaundi");
	              
	                //creating connection to Oracle database 
	              
	                konexioa = DriverManager.getConnection(url,props);
	                statement = konexioa.createStatement();

	                System.out.println("Se ha conectado a la BBDD-Oracle satisfactoriamente");	   
	                     break;
	                     
	                     
	            case 4: //sqlserver
	              url = "jdbc:odbc:KBPACC";
	              Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	              konexioa = DriverManager.getConnection(url, "", "");
	              statement = konexioa.createStatement();
	              System.out.println("Sqlserver connected");
	                     break;
	            
	        }  	
		}
		catch (SQLException anException)
		{
			while (anException != null)
			{
				System.out.println("SQL Exception:  " + anException.getMessage());
				anException = anException.getNextException();
			}
		}
		catch (java.lang.Exception anException)
		{
			anException.printStackTrace();
		}
	  }
	
	//@SuppressWarnings("rawtypes")
	public List<Cliente> getListaCliente()
	{
		
		String query;
		List<Cliente> ListaClientes;
		ResultSet resultSet;
				
	                
		query = "SELECT * FROM Cliente ORDER BY DNI ASC";
		System.out.println("SQL a ejecutar: " + query);
		ListaClientes = new LinkedList<Cliente>();
	    Cliente cliente;
	    
		try
		{
			// Run SQL
	        resultSet = statement.executeQuery(query);    
			//	vamos a gestionar los resultados de la query
	    
	    int lineas=0;
			while (resultSet.next())
		{     
				String DNI = resultSet.getString(1);
				String Nombre = resultSet.getString(2);     
				String Apellidos = resultSet.getString(3);
				String edad = resultSet.getString(4);
				String email = resultSet.getString(5);           
				String Telefono = resultSet.getString(6);
				String ID_trabaja = resultSet.getString(7);
	      
				//System.out.println("employee : " + "first_name = " + first_name );
			  //System.out.println("Select usuario Result: " + "employee_id = " + employee_id );
	  
			  cliente = new Cliente (DNI,Nombre, Apellidos, email, edad, Telefono, ID_trabaja);        
			  ListaClientes.add(cliente);  
	      
	          
			  lineas++;
			}
	   
			System.out.println("lineas :"+lineas);    
	     
			resultSet.close();
	    //konexioa.close();
	    
	  }
	      
		catch (SQLException anException)
		{
			while (anException != null)
			{
				System.out.println("SQL Exception:  " + anException.getMessage());
				anException = anException.getNextException();
			}
		}
		catch (java.lang.Exception anException)
		{
	    System.out.println("DBF: "+ anException.getMessage());
		  anException.printStackTrace();
		}
		finally
		{
			return ListaClientes;
		}
	}
	
	public List<Trabajador> getListaTrabajador()
	{
		
		String query;
		List<Trabajador> ListaTrabajador;
		ResultSet resultSet;
				
	                
		query = "SELECT * FROM Trabajador ORDER BY DNI ASC";
		System.out.println("SQL a ejecutar: " + query);
		ListaTrabajador = new LinkedList<Trabajador>();
	    Trabajador trabajador;
	    
		try
		{
			// Run SQL
	        resultSet = statement.executeQuery(query);    
			//	vamos a gestionar los resultados de la query
	    
	    int lineas=0;
		while (resultSet.next())
		{     
				String DNI = resultSet.getString(1);
				String Nombre = resultSet.getString(2);     
				String Apellidos = resultSet.getString(3);
				String edad = resultSet.getString(4);
				String email = resultSet.getString(5);           
				String Telefono = resultSet.getString(6);
				String id = resultSet.getString(7);
				String contraseña = resultSet.getString(8);
	      
				//System.out.println("employee : " + "first_name = " + first_name );
			  //System.out.println("Select usuario Result: " + "employee_id = " + employee_id );
	  
			  trabajador = new Trabajador (DNI,Nombre, Apellidos, email, edad, Telefono, id, contraseña);        
			  ListaTrabajador.add(trabajador);  
	      
	          
			  lineas++;
			}
	   
			System.out.println("lineas :"+lineas);    
	     
			resultSet.close();
	    //konexioa.close();
	    
	  }
	      
		catch (SQLException anException)
		{
			while (anException != null)
			{
				System.out.println("SQL Exception:  " + anException.getMessage());
				anException = anException.getNextException();
			}
		}
		catch (java.lang.Exception anException)
		{
	    System.out.println("DBF: "+ anException.getMessage());
		  anException.printStackTrace();
		}
		finally
		{
			return ListaTrabajador;
		}
	}
	
	public List<Reserva> getListaReseva()
	{
		
		String query;
		List<Reserva> ListaReserva;
		ResultSet resultSet;
				
	                
		query = "SELECT * FROM Reserva ORDER BY codigo ASC";
		System.out.println("SQL a ejecutar: " + query);
		ListaReserva = new LinkedList<Reserva>();
	    Reserva reserva;
	    
		try
		{
			// Run SQL
	        resultSet = statement.executeQuery(query);    
			//	vamos a gestionar los resultados de la query
	    
	    int lineas=0;
			while (resultSet.next())
		{     
				String codigo = resultSet.getString(1);
				double precio = resultSet.getDouble(2);     
				String dni_cliente = resultSet.getString(3);
				Date fecha_entrada = resultSet.getDate(4);
				Date fecha_salida = resultSet.getDate(5);
				Date fecha_reserva = resultSet.getDate(6);  
				
	      
				//System.out.println("employee : " + "first_name = " + first_name );
			  //System.out.println("Select usuario Result: " + "employee_id = " + employee_id );
	  
			  reserva = new Reserva (codigo, precio, dni_cliente, fecha_entrada, fecha_salida, fecha_reserva);        
			  ListaReserva.add(reserva);  
	      
	          
			  lineas++;
			}
	   
			System.out.println("lineas :"+lineas);    
	     
			resultSet.close();
	    //konexioa.close();
	    
	  }
	      
		catch (SQLException anException)
		{
			while (anException != null)
			{
				System.out.println("SQL Exception:  " + anException.getMessage());
				anException = anException.getNextException();
			}
		}
		catch (java.lang.Exception anException)
		{
	    System.out.println("DBF: "+ anException.getMessage());
		  anException.printStackTrace();
		}
		finally
		{
			return ListaReserva;
		}
	}
	
	public List<Habitacion> getListaHabitacion()
	{
		
		String query;
		List<Habitacion> ListaHabitacion;
		ResultSet resultSet;
				
	                
		query = "SELECT * FROM Habitaciones ORDER BY numero ASC";
		System.out.println("SQL a ejecutar: " + query);
		ListaHabitacion = new LinkedList<Habitacion>();
	    Habitacion habitacion;
	    
		try
		{
			// Run SQL
	        resultSet = statement.executeQuery(query);    
			//	vamos a gestionar los resultados de la query
	    
	    int lineas=0;
			while (resultSet.next())
		{     
				String numero = resultSet.getString(1);
				String tipo = resultSet.getString(2);     
				double precio = resultSet.getDouble(3);
				int ocu = resultSet.getInt(4);
				String nombre_hotel = resultSet.getString(5);
				
	      
				//System.out.println("employee : " + "first_name = " + first_name );
			  //System.out.println("Select usuario Result: " + "employee_id = " + employee_id );
	  
			  habitacion = new Habitacion (numero, tipo, precio, ocu, nombre_hotel);        
			  ListaHabitacion.add(habitacion);  
	      
	          
			  lineas++;
			}
	   
			System.out.println("lineas :"+lineas);    
	     
			resultSet.close();
	    //konexioa.close();
	    
	  }
	      
		catch (SQLException anException)
		{
			while (anException != null)
			{
				System.out.println("SQL Exception:  " + anException.getMessage());
				anException = anException.getNextException();
			}
		}
		catch (java.lang.Exception anException)
		{
	    System.out.println("DBF: "+ anException.getMessage());
		  anException.printStackTrace();
		}
		finally
		{
			return ListaHabitacion;
		}
	}
	
	public Hotel getHotel()
	{
		
		String query;
	
		ResultSet resultSet;
				
	                
		query = "SELECT * FROM Hotel";
		System.out.println("SQL a ejecutar: " + query);
	    Hotel hotel = null;
	    
		try
		{
			// Run SQL
	        resultSet = statement.executeQuery(query);    
			//	vamos a gestionar los resultados de la query
	    
	    int lineas=0;
			while (resultSet.next())
		{     
				String nombre = resultSet.getString(1);
				String direccion = resultSet.getString(2);     
				String valoracion = resultSet.getString(3);
				
				
	      
				//System.out.println("employee : " + "first_name = " + first_name );
			  //System.out.println("Select usuario Result: " + "employee_id = " + employee_id );
	  
			  hotel = new Hotel (nombre, direccion, valoracion);        
	          
			  lineas++;
			}
	   
			System.out.println("lineas :"+lineas);    
	     
			resultSet.close();
	    //konexioa.close();
	    
	  }
	      
		catch (SQLException anException)
		{
			while (anException != null)
			{
				System.out.println("SQL Exception:  " + anException.getMessage());
				anException = anException.getNextException();
			}
		}
		catch (java.lang.Exception anException)
		{
	    System.out.println("DBF: "+ anException.getMessage());
		  anException.printStackTrace();
		}
		finally
		{
			return hotel;
		}
	}
	
	public void añadirFilaCliente(Cliente cliente) {
		
		String SQL = "INSERT INTO Cliente(DNI,Nombre,Apellidos,Edad,Correo,Telefono) "
                + "VALUES(?,?,?,?,?,?)";

        

        try (PreparedStatement pstmt = konexioa.prepareStatement(SQL,
                Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, cliente.getDNI());
            pstmt.setString(2, cliente.getNombre());
            pstmt.setString(3, cliente.getApellidos());
            pstmt.setString(4, cliente.getEdad());
            pstmt.setString(5, cliente.getCorreo());
            pstmt.setString(6, cliente.getTelef());

            pstmt.executeUpdate();
            System.out.println("Linea añadida");
            pstmt.close();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
		
	}
	
	public void añadirReserva(Reserva reserva) {
		
		String SQL = "INSERT INTO Reserva(codigo,precio,DNI_cliente,fecha_entrada,fecha_salida,fecha_reserva) "
                + "VALUES(?,?,?,?,?,?)";
		
		try (PreparedStatement pstmt = konexioa.prepareStatement(SQL,
                Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, reserva.getCodigo());
            pstmt.setDouble(2, reserva.getPrecio());
            pstmt.setString(3, reserva.getCodigoCliente());
            pstmt.setString(4,reserva.getFecha_entrada());
            pstmt.setString(5, reserva.getFecha_salida());
            pstmt.setString(6,reserva.getFecha());

            pstmt.executeUpdate();
            System.out.println("Linea añadida");
            pstmt.close();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
	}
	
	public void añadirReserva_Habi(Reserva reserva, Habitacion habi) {
		
		String SQL = "INSERT INTO Habi_Reser(numero,codigo_reser) "
                + "VALUES(?,?)";
		
		try (PreparedStatement pstmt = konexioa.prepareStatement(SQL,
                Statement.RETURN_GENERATED_KEYS)) {
			
	            pstmt.setString(1, habi.getNumero());
	            pstmt.setString(2, reserva.getCodigo());
	
	            pstmt.executeUpdate();
			
	            System.out.println("Linea añadida");
	            pstmt.close();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
	}
	
	public void estadoHabi(Habitacion habi, boolean ocu) {
		
		int e;
		
		if(ocu)
			e = 0;
		else 
			e = 1;
		
		
		String SQL = "update Habitacion "
                + "set disponi = "+ e
				+ "where numero = "+habi.getNumero();
		
		try (PreparedStatement pstmt = konexioa.prepareStatement(SQL,
                Statement.RETURN_GENERATED_KEYS)) {
			
	            pstmt.executeUpdate();
			
	            System.out.println("Linea añadida");
	            pstmt.close();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
	}

	
	
} // end class

