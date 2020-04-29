package BP.Vista;

import javax.swing.*;
import java.awt.*;

import BP.Controlador.Controlador;

public class VentanaPrincipal extends JFrame{

	
	private Controlador controlador;
	
	
	
	//Paneles
	private LoginPanel loginPanel;
	private RegistroPanel registroPanel;
	private BienvenidaPanel bienvenidaPanel;
	private UsuarioPanel usuarioPanel;
	private ProyectosPanel proyectosPanel;
	private ColectivosPanel colectivosPanel;
	
	public VentanaPrincipal(String titulo) {
		
		super(titulo); //Lo mismo que  JFrame ventanaPrincipal = new JFrame("Titulo");
	
	
	
		//Container y Layout
		Container contenedor = this.getContentPane();	
		contenedor.setLayout(new FlowLayout());
	

	
		//Creamos los paneles
		this.loginPanel = new LoginPanel();
		this.registroPanel = new RegistroPanel();
		this.bienvenidaPanel = new BienvenidaPanel();
		this.usuarioPanel = new UsuarioPanel();
		this.proyectosPanel = new ProyectosPanel();
		this.colectivosPanel = new ColectivosPanel();
		
	
		//Anniadimos panelens al contenedor
		contenedor.add(this.loginPanel);
		contenedor.add(this.registroPanel);
		contenedor.add(this.bienvenidaPanel);
		contenedor.add(this.usuarioPanel);
		contenedor.add(this.proyectosPanel);
		contenedor.add(this.colectivosPanel);
		
		
		//Establecemos la visibilidad inicial de los paneles
		this.loginPanel.setVisible(false);
		this.registroPanel.setVisible(false);
		this.bienvenidaPanel.setVisible(true);
		this.usuarioPanel.setVisible(false);
		this.colectivosPanel.setVisible(false);
		this.proyectosPanel.setVisible(false);
		
		
		
		//Visibilidad de la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.setVisible(true);	

	
	}
	
	
	
	//METODO EN EL QUE SE ASIGNAN TODOS LOS CONTROLADORES DE LOS PANELES
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
		
		this.loginPanel.setControlador(controlador.getControladorLogin() );
		this.registroPanel.setControlador(controlador.getControladorRegistro());
		this.bienvenidaPanel.setControlador(controlador.getControladorBienvenida());
		this.usuarioPanel.setControlador(controlador.getControladorUsuario());
		this.proyectosPanel.setControlador(controlador.getControladorBienvenida());
		this.colectivosPanel.setControlador(controlador.getControladorBienvenida());
		
	}
	
	
	public Controlador getControlador() {
		return this.controlador;
	}
	
	
	
	
	
	
	//Getters de Paneles
	
	public LoginPanel getPanelLogin() {
		return this.loginPanel;
	}




	public UsuarioPanel getPanelUsuario() {
		// TODO Auto-generated method stub
		return this.usuarioPanel;
	}




	public RegistroPanel getPanelRegistro() {
		return this.registroPanel;
	}




	public BienvenidaPanel getPanelBienvenida() {
		return this.bienvenidaPanel;
	}
	
	
	
	public ProyectosPanel getPanelProyectos() {
		return this.proyectosPanel;
	}
	
	public ColectivosPanel getPanelColectivos() {
		return this.colectivosPanel;
	}
	
	
}
