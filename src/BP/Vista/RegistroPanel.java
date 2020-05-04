package BP.Vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegistroPanel extends JPanel {

	
	private JLabel etiquetaNIF;
	private JTextField campoNIF;
	
	private JLabel etiquetaUsuario;
	private JTextField campoUsuario;
	private JLabel etiquetaContrasena;
	private JLabel etiquetaRepiteContrasena;
	private JTextField campoContrasena;
	private JTextField campoContrasena2;
	
	private JButton botonRegistro;
	
	private JButton botonBack;

	/**
	 * Este es el contructor de RegistroPanel, cuenta con el panel subP1, ademas cuenta con la construccion e introduccion de los 
	 * objetos-elementos que se van a introducir en subP1 
	 */
	public RegistroPanel() {
		
		//Layout de todo el panel
		this.setLayout(new BorderLayout());
		
		
		//Subpanel 1
		JPanel subP1 = new JPanel(new GridLayout(5,5));
		
		this.etiquetaNIF = new JLabel("NIF:");
		this.campoNIF  = new JTextField(9);
		this.etiquetaUsuario = new JLabel("Usuario:");
		this.campoUsuario = new JTextField(20);
		this.etiquetaContrasena = new JLabel("Clave");
		this.campoContrasena = new JPasswordField(20);
		this.etiquetaRepiteContrasena = new JLabel("Repite la clave");
		this.campoContrasena2 = new JPasswordField(20);
		subP1.add(etiquetaNIF);
		subP1.add(campoNIF);
		subP1.add(etiquetaUsuario);
		subP1.add(campoUsuario);
		subP1.add(etiquetaContrasena);
		subP1.add(campoContrasena);
		subP1.add(etiquetaRepiteContrasena);
		subP1.add(campoContrasena2);
		this.botonRegistro = new JButton("Solicitar Registro");
		subP1.add(botonRegistro);
		this.botonBack = new JButton("Volver");
		subP1.add(botonBack);
		this.add(subP1);
		
		
	}
	
	
	
	
	//Metodos para el controlador

	/**
	 * Esta es la funcion setControlador, se encarga de permitir que algunos de los objetos que hemos introducido en el panel
	 * tengan una funcionalidad(es para objetos como botones, listas, etc)
	 * @param c es el action listener, nos permitira especificar el lugar donde se encuentra la funcionalidad para los botones de Registro y Back
	 */
	public void setControlador(ActionListener c) {
		botonRegistro.addActionListener(c);
		botonBack.addActionListener(c);
	}
	
	
	
	
	
	//Metodos de devolucion de datos
	/**
	 * Esta funcion devuelve el texto que se ha introducido en campoNIF
	 * @return the string campoNIF texto introducido en el campo NIF
	 */
	public String getNIF() {
		return this.campoNIF.getText();
	}
	
	/**
	 * Esta funcion devuelve el texto que se ha introducido en campoUsuario
	 * @return the string campoUsuario texto introducido en el campo usuario
	 */
	public String getNombreUsuario() {
		return this.campoUsuario.getText();
	}
	
	/**
	 * Esta funcion devuelve el texto que se ha introducido en campoContrasena
	 * @return the string campoContrasena texto introducido en el campo contrasena
	 */
	public String getPassword() {
		return this.campoContrasena.getText();
	}
	/**
	 * Esta funcion devuelve el texto que se ha introducido en campoContrasena2
	 * @return the string campoContrasena2, texto introducido en el campo contrasena2
	 */
	public String getPassword2() {
		return this.campoContrasena2.getText();
	}
	
}
