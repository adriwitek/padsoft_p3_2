package BP.Controlador;

import BP.Modelo.*;
import BP.Vista.*;
import java.awt.event.*;

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
	 * @return the controladorLogin
	 */
	public ControladorLogin getControladorLogin() {
		return controladorLogin;
	}



	/**
	 * @return the controladorRegistro
	 */
	public ControladorRegistro getControladorRegistro() {
		return controladorRegistro;
	}




	/**
	 * @return the controladorBienvenida
	 */
	public ControladorBienvenida getControladorBienvenida() {
		return controladorBienvenida;
	}




	/**
	 * @return the controladorUsuario
	 */
	public ControladorUsuario getControladorUsuario() {
		// TODO Auto-generated method stub
		return controladorUsuario;
	}
	
	
	/**
	 * @return the controladorProyectos
	 */
	public ControladorProyectos getControladorProyectos() {
		return controladorProyectos;
	}
	
	/**
	 * @return the controladorColectivos
	 */
	public ControladorColectivos getControladorColectivos() {
		return controladorColectivos;
	}
	
	
	/**
	 * @return the controladorCrearProyecto
	 */
	public ControladorCrearProyecto getControladorCrearProyecto() {
		return controladorCrearProyecto;
	}
	
	
	/**
	 * @return the controladorCrearProyectoSocial
	 */
	public ControladorCrearProyectoSocial getControladorCrearProyectoSocial() {
		return controladorCrearProyectoSocial;
	}
	
	
	/**
	 * @return the controladorCrearProyectoInf
	 */
	public ControladorCrearProyectoInf getControladorCrearProyectoInf() {
		return controladorCrearProyectoInf;
	}



	/**
	 * @return the controladorAdmin
	 */
	public ControladorAdmin getControladorAdmin() {
		return controladorAdmin;
	}


	public Aplicacion getModelo() {
		return this.modelo;
	}
	
	public ControladorCrearColectivo getControladorCrearColectivo() {
		return this.controladorCrearColectivo;
	}
	
	public ControladorDetallesProyecto getControladorDetallesProyecto() {
		return this.controladorDetallesProyecto;
	}
}
