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

	public Controlador(VentanaPrincipal frame, Aplicacion modelo) {
		this.frame = frame;
		this.modelo = modelo;
		
		
		//Creacion de los controladores de los paneles
		this.controladorLogin = new ControladorLogin(frame,modelo);
		this.controladorRegistro = new ControladorRegistro(frame, modelo);
		this.controladorBienvenida = new ControladorBienvenida(frame, modelo);
		
		
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


	
	
	
}
