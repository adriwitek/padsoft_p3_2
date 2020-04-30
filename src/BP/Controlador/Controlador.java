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
	private ControladorCrearProyecto controladorCrearProyecto;
	
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
		this.controladorCrearProyecto = new ControladorCrearProyecto(frame, modelo);
		
	}

	
	

	
	
	
	
	// ****** GETTERS DE LOS CONTROLADORES COMPLEJOS***

	
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


	
	
	
}
