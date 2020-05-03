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

	
	public void setControlador(ActionListener c) {
		botonRegistro.addActionListener(c);
		botonBack.addActionListener(c);
	}
	
	
	
	
	
	//Metodos de devolucion de datos

	public String getNIF() {
		return this.campoNIF.getText();
	}
	
	
	public String getNombreUsuario() {
		return this.campoUsuario.getText();
	}
	
	
	public String getPassword() {
		return this.campoContrasena.getText();
	}
	
	public String getPassword2() {
		return this.campoContrasena.getText();
	}
	
}
