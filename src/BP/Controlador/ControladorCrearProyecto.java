package BP.Controlador;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import BP.Modelo.*;
import BP.Vista.*;

public class ControladorCrearProyecto implements ActionListener{

	private CrearProyectoPanel panel;
	private VentanaPrincipal frame;
	private Aplicacion modelo;

	/**
	 * Este es el constructor de ControladorCrearProyecto
	 * @param frame ventana de la aplicacion
	 * @param modelo aplicacion que hemos desarrollado
	 */

	private Proponente proponente;

	public ControladorCrearProyecto(VentanaPrincipal frame ,Aplicacion modelo) {
		this.panel= frame.getPanelCrearProyecto();
		this.frame= frame;
		this.modelo=modelo;
	}
	
	/**
	 * Esta funcion se encargara de que al interactuar con el programa(dar a un boton, escribir en un texto, seleccionar un valor de una list, etc)
	 * se realice la accion correspondiente.
	 * @param e es el actionEvent
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Cancelar")) {
			cancelar();

		}else if(e.getActionCommand().equals("ProyectoSocial")){
			proyectoSocial();
			
		}else if(e.getActionCommand().equals("ProyectoInfraestructuras")){
			proyectoInfra();
			
		}
		
		
	}
	
	
	/**
	 * Esta funcion crea la funcionalidad del boton de cancelar
	 * de tal manera que la aplicacion volveria al panel de usuario
	 */
	public void cancelar() {
		frame.getPanelUsuario().setVisible(true);
		this.panel.setVisible(false);
	}
	/**
	 * Esta funcion se encarga de crea la funcionalidad del boton de proyectoSocial
	 * de tal manera que nos mandaria a el panel CrearProyectoSocialPanel
	 */
	public void proyectoSocial() {
		CrearProyectoSocialPanel pProyectoSoc = frame.getPanelCrearProyectoSocial();
		frame.getControlador().getControladorCrearProyectoSocial().setProponente(proponente);
		pProyectoSoc.setVisible(true);
		this.panel.setVisible(false);
	}
	/**
	 * Esta funcion se encarga de crea la funcionalidad del boton de proyectoInfra
	 * de tal manera que nos mandaria a el panel CrearProyectoInfPanel
	 */
	public void proyectoInfra() {
		CrearProyectoInfPanel pProyectoInf = frame.getPanelCrearProyectoInf();
		frame.getControlador().getControladorCrearProyectoInf().setProponente(proponente);
		pProyectoInf.setVisible(true);
		this.panel.setVisible(false);
	}
	public void setProponente(Colectivo c) {
		this.proponente = c;
	}
	public void setProponente(Usuario u) {
		this.proponente = u;
	}
	
}
 