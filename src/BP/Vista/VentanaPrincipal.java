package BP.Vista;

import javax.swing.*;
import java.awt.*;

import BP.Controlador.Controlador;
import BP.Modelo.Aplicacion;
/** 
* 
* @author Adián Rubio adrian.rubiop@estudiante.uam.es, Guillermo Solla guillermo.solla@estudiante.uam.es 
* y Diego Tapia diego.tapias@estudiante.uam.es
*/
public class VentanaPrincipal extends JFrame{

	
	private Controlador controlador;
	private Aplicacion modelo;
	
	
	//Paneles
	private LoginPanel loginPanel;
	private RegistroPanel registroPanel;
	private BienvenidaPanel bienvenidaPanel;
	private UsuarioPanel usuarioPanel;
	private ProyectosPanel proyectosPanel;
	private ColectivosPanel colectivosPanel;
	
	private AdminPanel adminPanel;
	private CrearColectivoPanel crearColectivoPanel;
	private CrearProyectoPanel crearProyectoPanel;
	private CrearProyectoSocialPanel crearProyectoSocialPanel;
	private CrearProyectoInfPanel crearProyectoInfPanel;
	private DetallesProyectoPanel detallesProyectoPanel;
	
	/**
	 * Este es el constructor de VentanaPrincipal, contiene el contenedor de paneles, ademas de lacreacion e introduccion 
	 * de todos los paneles de nuestro proyecto en este contenedor
	 * @param modelo es la aplicacion que hemos creado
	 * @param titulo un string del titulo
	 */
	public VentanaPrincipal(Aplicacion modelo,String titulo) {
		
		super(titulo); //Lo mismo que  JFrame ventanaPrincipal = new JFrame("Titulo");
		this.modelo = modelo;
		
	
		//Container y Layout
		Container contenedor = this.getContentPane();	
		contenedor.setLayout(new FlowLayout());
		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTitle("BP: Becoming a Project");

	
		//Creamos los paneles
		this.loginPanel = new LoginPanel();
		this.registroPanel = new RegistroPanel();
		this.bienvenidaPanel = new BienvenidaPanel();
		this.proyectosPanel = new ProyectosPanel();
		this.colectivosPanel = new ColectivosPanel();
		this.usuarioPanel = new UsuarioPanel(this);
		this.adminPanel = new AdminPanel(modelo.getRegistrosPendientesDeAprobacion(),modelo.getUsuariosActivos(),modelo.getUsuariosBloqueados(),modelo.getProyectosPendientesValidacion() );
		this.crearColectivoPanel = new CrearColectivoPanel();
		this.crearProyectoPanel = new CrearProyectoPanel();
		this.crearProyectoSocialPanel = new CrearProyectoSocialPanel();
		this.crearProyectoInfPanel = new CrearProyectoInfPanel();
		this.detallesProyectoPanel = new DetallesProyectoPanel();
		//Anniadimos panelens al contenedor
		contenedor.add(this.loginPanel);
		contenedor.add(this.registroPanel);
		contenedor.add(this.bienvenidaPanel);
		contenedor.add(this.usuarioPanel);
		contenedor.add(this.proyectosPanel);
		contenedor.add(this.colectivosPanel);
		contenedor.add(this.adminPanel );
		
		contenedor.add(this.crearColectivoPanel);
		contenedor.add(this.crearProyectoPanel);
		contenedor.add(this.crearProyectoSocialPanel);
		contenedor.add(this.crearProyectoInfPanel);
		contenedor.add(this.detallesProyectoPanel);
		
		
		//Establecemos la visibilidad inicial de los paneles
		this.loginPanel.setVisible(false);
		this.registroPanel.setVisible(false);
		this.bienvenidaPanel.setVisible(true);
		this.usuarioPanel.setVisible(false);
		this.colectivosPanel.setVisible(false);
		this.proyectosPanel.setVisible(false);
		this.adminPanel.setVisible(false); 
		this.crearColectivoPanel.setVisible(false);
		this.crearProyectoPanel.setVisible(false);
		this.crearProyectoSocialPanel.setVisible(false);
		this.crearProyectoInfPanel.setVisible(false);
		this.detallesProyectoPanel.setVisible(false);
		//Visibilidad de la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.setVisible(true);	

	
	}
	
	
	
	//METODO EN EL QUE SE ASIGNAN TODOS LOS CONTROLADORES DE LOS PANELES
	
	/**
	 * Esta es la funcion setControlador padre, asigna el geter especifico a cada controlador
	 * @param controlador es el controlador 
	 */
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
		
		this.loginPanel.setControlador(controlador.getControladorLogin() );
		this.registroPanel.setControlador(controlador.getControladorRegistro());
		this.bienvenidaPanel.setControlador(controlador.getControladorBienvenida());
		this.usuarioPanel.setControlador(controlador.getControladorUsuario());
		this.adminPanel.setControlador(controlador.getControladorAdmin());
		this.proyectosPanel.setControlador(controlador.getControladorProyectos());
		this.colectivosPanel.setControlador(controlador.getControladorColectivos());
		this.crearProyectoPanel.setControlador(controlador.getControladorCrearProyecto());
		this.crearProyectoSocialPanel.setControlador(controlador.getControladorCrearProyectoSocial());
		this.crearProyectoInfPanel.setControlador(controlador.getControladorCrearProyectoInf());
		this.crearColectivoPanel.setControlador(controlador.getControladorCrearColectivo());
		this.detallesProyectoPanel.setControlador(controlador.getControladorDetallesProyecto());


	}
	
	
	/**
	 * Esta funcion nos devuelve el controlador
	 * @return the controlador controlador que se quiere devolver
	 */
	public Controlador getControlador() {
		return this.controlador;
	}
	
	 
	
	
	
	
	
	
	
	//  *** GETTERS DE PANELES ***
	/**
	 * Esta funcion devuelve el panel de login
	 * @return the loginPanel panel que se quiere devolver
	 */
	public LoginPanel getPanelLogin() {
		return this.loginPanel;
	}



	/**
	 * Esta funcion devuelve el panel de usuario
	 * @return the usuarioPanel panel que se quiere devolver
	 */
	public UsuarioPanel getPanelUsuario() {
		// TODO Auto-generated method stub
		return this.usuarioPanel;
	}



	/**
	 * Esta funcion devuelve el panel de registro
	 * @return the registroPanel panel que se quiere devolver
	 */
	public RegistroPanel getPanelRegistro() {
		return this.registroPanel;
	}



	/**
	 * Esta funcion devuelve el panel de bienvenida
	 * @return the bienvenidaPanel panel que se quiere devolver
	 */
	public BienvenidaPanel getPanelBienvenida() {
		return this.bienvenidaPanel;
	}
	
	/**
	 * Esta funcion devuelve el panel de proyectos
	 * @return the proyectosPanel panel que se quiere devolver
	 */
	public ProyectosPanel getPanelProyectos() {
		return this.proyectosPanel;
	}
	/**
	 * Esta funcion devuelve el panel de colectivos
	 * @return the colectivosPanel panel que se quiere devolver
	 */
	public ColectivosPanel getPanelColectivos() {
		return this.colectivosPanel;
	}
	/**
	 * Esta funcion devuelve el panel de admin
	 * @return the adminPanel panel que se quiere devolver
	 */
	public AdminPanel getPanelAdmin() {
		return this.adminPanel;
	}
	
	/**
	 * Esta funcion devuelve el panel de crear proyecto
	 * @return the crearProyectoPanel panel que se quiere devolver
	 */
	public CrearProyectoPanel getPanelCrearProyecto() {
		return this.crearProyectoPanel;
	}
	/**
	 * Esta funcion devuelve el panel de crear proyecto social
	 * @return the crearProyectoSocialPanel panel que se quiere devolver
	 */
	public CrearProyectoSocialPanel getPanelCrearProyectoSocial() {
		return this.crearProyectoSocialPanel;
	}
	/**
	 * Esta funcion devuelve el panel de crear proyecto inf
	 * @return the crearProyectoInfPanel panel que se quiere devolver
	 */
	public CrearProyectoInfPanel getPanelCrearProyectoInf() {
		return this.crearProyectoInfPanel;
	}
	/**
	 * Esta funcion devuelve el panel de crear colectivo
	 * @return the crearColectivoPanel panel que se quiere devolver
	 */
	public CrearColectivoPanel getPanelCrearColectivo() {
		return this.crearColectivoPanel;
	}
	
	/**
	 * Esta funcion devuelve el panel de DetallesProyecto
	 * @return the detallesProyectoPanel panel que se quiere devolver
	 */
	public DetallesProyectoPanel getPanelDetallesProyecto() {
		return this.detallesProyectoPanel;
	}
	
}
