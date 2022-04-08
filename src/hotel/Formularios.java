package hotel;
import javax.swing.*;
import java.awt.*;

public class Formularios extends JFrame {
	public Formularios() {
		super("Añadir Cliente");
		setSize(500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contenedor = getContentPane();
		
		JPanel panelDatos = new JPanel();
		GridLayout gl = new GridLayout(3,2,0,5);
		panelDatos.setLayout(gl);
		panelDatos.add(new JLabel("Nombre: "));
		panelDatos.add(new JTextField(18));
		JLabel label = new JLabel("Apellidos: ");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		panelDatos.add(label);
		panelDatos.add(new JTextField(18));
		panelDatos.add(new JLabel("Apellidos: "));
		panelDatos.add(new JTextField(18));
		panelDatos.add(new JLabel("Correo: "));
		panelDatos.add(new JTextField(18));
		panelDatos.add(new JLabel("Edad: "));
		panelDatos.add(new JTextField(18));
		panelDatos.add(new JLabel("Telefono: "));
		panelDatos.add(new JTextField(18));
		
		contenedor.add(panelDatos);
		
		
		
	}
}
