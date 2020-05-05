package BP.Controlador;

import BP.Modelo.*;
import BP.Vista.*;
import java.awt.event.*;
/** 
* 
* @author Adián Rubio adrian.rubiop@estudiante.uam.es, Guillermo Solla guillermo.solla@estudiante.uam.es 
* y Diego Tapia diego.tapias@estudiante.uam.es
*/
public class Controlador {

	
	private VentanaPrincipal frame;
	private Aplicacion modelo;
	
	
	//Controladores
	private ControladorLogin controladorLogin;
	private ControladorRegistro controladorRegistro;
	private ControladorBienvenida controladorBienvenida;
	private ControladorUsuario controladorUsuario;
	private ControladorProyectos controladorProyectos;
	private ControladorColectivos controladorColectivos;
	private ControladorAdmin controladorAdmin;
	private ControladorCrearProyecto controladorCrearProyecto;
	private ControladorCrearProyectoSocial controladorCrearProyectoSocial;
	private ControladorCrearProyectoInf controladorCrearProyectoInf;
	private ControladorCrearColectivo controladorCrearColectivo;
	private ControladorDetallesProyecto controladorDetallesProyecto;
	
	/**
	 * Este es el constructoe de controlador, en el se encuentra la creacion de todos los controladores que contempla la aplicacion
	 * @param frame es la unica ventana de nuestro proyecto (VentanaPrincipal)
	 * @param modelo es la a plicacion que hemos realizado
	 */
	public Controlador(VentanaPrincipal frame, Aplicacion modelo) {
		this.frame = frame;
		this.modelo = modelo;
		
		
		//Creacion de los controladores de los paneles
		this.controladorLogin = new ControladorLogin(frame,modelo);
		this.controladorRegistro = new ControladorRegistro(frame, modelo);
		this.controladorBienvenida = new ControladorBienvenida(frame, modelo);
		this.controladorUsuario = new ControladorUsuario(frame, modelo);
		this.controladorProyectos = new ControladorProyectos(frame, modelo);
		this.controladorColectivos = new ControladorColectivos(frame, modelo);
		this.controladorAdmin = new ControladorAdmin(frame,modelo);
		this.controladorCrearProyecto = new ControladorCrearProyecto(frame, modelo);
		this.controladorCrearProyectoSocial = new ControladorCrearProyectoSocial(frame, modelo);
		this.controladorCrearProyectoInf = new ControladorCrearProyectoInf(frame, modelo);
		this.controladorCrearColectivo = new ControladorCrearColectivo(frame,modelo);
		this.controladorDetallesProyecto = new ControladorDetallesProyecto(frame, modelo);
	}

	
	

	
	 
	
	
	// ****** GETTERS DE LOS CONTROLADORES ***

	
	/**
	 * esta funcion devuelve  controladorLogin
	 * @return the controladorLogin controlador a devolver
	 */
	public ControladorLogin getControladorLogin() {
		return controladorLogin;
	}



	/**
	 * Esta funcion devuelve controladorRegistro
	 * @return the controladorRegistro controlador a devolver
	 */
	public ControladorRegistro getControladorRegistro() {
		return controladorRegistro;
	}




	/**
	 * Esta funcion devuelve controladorBienvenida
	 * @return the controladorBienvenida controlador a devolver
	 */
	public ControladorBienvenida getControladorBienvenida() {
		return controladorBienvenida;
	}




	/**
	 * Esta funcion devuelve controladorUsuario
	 * @return the controladorUsuario controlador a devolver
	 */
	public ControladorUsuario getControladorUsuario() {
		// TODO Auto-generated method stub
		return controladorUsuario;
	}
	
	
	/**
	 * esta funcion devuelve controladorProyectos
	 * @return the controladorProyectos controlador a devolver
	 */
	public ControladorProyectos getControladorProyectos() {
		return controladorProyectos;
	}
	
	/**
	 * Esta funcion devuelve controladorColectivos
	 * @return the controladorColectivos controlador a devolver
	 */
	public ControladorColectivos getControladorColectivos() {
		return controladorColectivos;
	}
	
	
	/**
	 * Esta funcion devuelve controladorCrearProyecto
	 * @return the controladorCrearProyecto controlador a devolver
	 */
	public ControladorCrearProyecto getControladorCrearProyecto() {
		return controladorCrearProyecto;
	}
	
	
	/**
	 * Esta funcion devuelve controladorCrearProyectoSocial
	 * @return the controladorCrearProyectoSocial controlador a devolver
	 */
	public ControladorCrearProyectoSocial getControladorCrearProyectoSocial() {
		return controladorCrearProyectoSocial;
	}
	
	
	/**
	 * Esta funcion devuelve controladorCrearProyectoInf
	 * @return the controladorCrearProyectoInf controlador a devolver
	 */
	public ControladorCrearProyectoInf getControladorCrearProyectoInf() {
		return controladorCrearProyectoInf;
	}



	/**
	 * Esta funcion devuelve controladorAdmin
	 * @return the controladorAdmin controlador a devolver
	 */
	public ControladorAdmin getControladorAdmin() {
		return controladorAdmin;
	}

	/**
	 * Esta funcion devuleve la aplicacion (modelo)
	 * @return the modelo 
	 */
	public Aplicacion getModelo() {
		return this.modelo;
	}
	/**
	 * Esta funcion devuelve controladorCrearColectivo
	 * @return the controladorCrearColectivo controlador a devolver
	 */
	public ControladorCrearColectivo getControladorCrearColectivo() {
		return this.controladorCrearColectivo;
	}
	/**
	 * Esta funcion devuelve controladorDetallesProyecto
	 * @return the controladorDetallesProyecto controlador a devolver
	 */
	public ControladorDetallesProyecto getControladorDetallesProyecto() {
		return this.controladorDetallesProyecto;
	}
}
