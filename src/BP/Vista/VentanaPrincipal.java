package BP.Vista;

import javax.swing.*;
import java.awt.*;

import BP.Controlador.Controlador;

public class VentanaPrincipal extends JFrame{

	
	private Controlador controlador;
	
	
	
	//Paneles
	private LoginPanel loginPanel;
	
	
	public VentanaPrincipal(String titulo) {
		
		super(titulo); //Lo mismo que  JFrame ventanaPrincipal = new JFrame("Titulo");
	
	
	
		//Container y Layout
		Container contenedor = this.getContentPane();	
		contenedor.setLayout(new FlowLayout());
	

	
		//Creamos los paneles
		this.loginPanel = new LoginPanel();
	
		
		
		
	
		//Anniadimos panelens al contenedor
		contenedor.add(this.loginPanel);


		
		
		
		//Establecemos la visibilidad inicial de los paneles
		this.loginPanel.setVisible(false);
	
		
		
		
		//Visibilidad de la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.setVisible(true);	

	
	}
	
	
	
	
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
		//hacer set en los paneles
	}
	
	
	public Controlador getContorlador() {
		return this.controlador;
	}
	
	
	
	
	
	
	//Getters de Paneles
	
	public LoginPanel getPanelLogin() {
		return this.loginPanel;
	}
	
}
