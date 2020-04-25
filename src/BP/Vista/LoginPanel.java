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

	
	public LoginPanel() {
		
		//Layout de todo el panel
		this.setLayout(new BorderLayout());
		
		
		//Subpanel 1
		JPanel subP1 = new JPanel(new GridLayout(2,2));
		this.etiquetaUsuario = new JLabel("Usuario:");
		this.campoUsuario = new JTextField(20);
		this.etiquetaContrasena = new JLabel("Clave");
		this.campoContrasena = new JPasswordField(20);
		subP1.add(etiquetaUsuario);
		subP1.add(campoUsuario);
		subP1.add(etiquetaContrasena);
		subP1.add(campoContrasena);
		this.add(subP1);
		
		
		//Subpanel2
		JPanel subP2 = new JPanel();
		this.botonLogin = new JButton("LogIn");
		subP2.add(botonLogin);
		this.add(subP2);
		
		
		//Subpanel3
		JPanel subP3 = new JPanel();
		this.botonBack = new JButton("Volver");
		subP3.add(botonBack);
		this.add(subP3);
		
		
	}
	
	
	
	//Metodos para el controlador
	
	public void setControladorBotonLogin(ActionListener c) {
		botonLogin.addActionListener(c);
	}
	
	public void setControladorBotonBack(ActionListener c) {
		botonBack.addActionListener(c);
	}
	
	
	
	
	
	//Metodos de devolucion de datos
	
	public String getNombreUsuario() {
		return this.campoUsuario.getText();
	}
	
	
	public String getPassword() {
		char[] pass = this.campoContrasena.getPassword();
		return String.valueOf(pass);
	}
}