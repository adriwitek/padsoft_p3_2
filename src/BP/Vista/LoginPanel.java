package BP.Vista;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginPanel extends JPanel {

	private JLabel etiquetaUsuario;
	private JTextField campoUsuario;
	private JLabel etiquetaContrasena;
	private JPasswordField campoContrasena;
	
	private JButton botonLogin;
	
	private JButton botonBack;

	/**
	 * Este es el constructor de LoginPanel, contiene el panel subP1, ademas de la creacion e introduccion de los elementos-objetos en el panel subP1
	 */
	public LoginPanel() {
		
		//Layout de todo el panel
		this.setLayout(new BorderLayout());
		
		
		//Subpanel 1
		JPanel subP1 = new JPanel(new GridLayout(3,3));
		this.etiquetaUsuario = new JLabel("Usuario:");
		this.campoUsuario = new JTextField(20);
		this.etiquetaContrasena = new JLabel("Clave");
		this.campoContrasena = new JPasswordField(20);
		subP1.add(etiquetaUsuario);
		subP1.add(campoUsuario);
		subP1.add(etiquetaContrasena);
		subP1.add(campoContrasena);
		this.botonLogin = new JButton("LogIn");
		subP1.add(botonLogin);
		this.botonBack = new JButton("Volver");
		subP1.add(botonBack);
		this.add(subP1);
		
		
	}
	
	
	
	//Metodos para el controlador
	/**
	 * Esta es la funcion setControlador, se encarga de permitir que algunos de los objetos que hemos introducido en el panel
	 * tengan una funcionalidad(es para objetos como botones, listas, etc)
	 * @param c es el action listener, nos permitira especificar el lugar donde se encuentra la funcionalidad para el boton de login y back
	 */
	public void setControlador(ActionListener c) {
		botonLogin.addActionListener(c);
		botonBack.addActionListener(c);

	}

	
	
	
	
	//Metodos de devolucion de datos
	/**
	 * Esta funcion devuelve el nombre del usuario que quiere iniciar sesion
	 * @return the String campoUsuario nombre usuario
	 */
	public String getNombreUsuario() {
		return this.campoUsuario.getText();
	}
	
	/**
	 * Esta funcion devuelve la contraseña del usuario que quiere iniciar sesion
	 * @return the String campoContrasena contraseña usuario
	 */
	public String getPassword() {
		char[] pass = this.campoContrasena.getPassword();
		return String.valueOf(pass);
	}
}