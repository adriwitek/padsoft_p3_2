package BP.Controlador;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import BP.Modelo.*;
import BP.Vista.*;
/** 
* 
* @author Adián Rubio adrian.rubiop@estudiante.uam.es, Guillermo Solla guillermo.solla@estudiante.uam.es 
* y Diego Tapia diego.tapias@estudiante.uam.es
*/
public class ControladorCrearColectivo implements ActionListener{
	private CrearColectivoPanel panel;
	private VentanaPrincipal frame;
	private Aplicacion modelo;
	
	/**
	 * Esta funcion es el constructo de ControladorCrearColectivo
	 * @param frame ventan de la aplicacion
	 * @param modelo aplicacion que hemos desarrollado
	 */
	public ControladorCrearColectivo(VentanaPrincipal frame ,Aplicacion modelo) {
		this.panel= frame.getPanelCrearColectivo();
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
		
		 if(e.getActionCommand().equals("cancelar")) {
			cancelar();
			
		}else if(e.getActionCommand().equals("finalizar")) {
			finalizar();
		}else {
			frame.getPanelBienvenida().setVisible(true);
			this.panel.setVisible(false);
		}	
		
	}
	

	/**
	 * Esta funcion crea la funcionalidad para el boton de cancelar
	 * mandando el programa al panel usuarioPanel
	 */
	public void cancelar() {

		frame.getPanelUsuario().setVisible(true);
		this.panel.setVisible(false);
	}

	/**
	 * Esta funcion se encarga de crear la funcionalidad para el boton de finalizar
	 * de tal manera que al pulsar este boton el colectivo se crearia dentro de la aplicacion
	 */

	
	public void finalizar() {

		String nombre = panel.getNombreColectivo();
		String descripcion = panel.getDescripcion();
		
		if(nombre.equals("") || descripcion.equals("") || nombre == null) {
			JOptionPane.showMessageDialog(panel,
					"Faltan campos obligatorios por rellenar.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		modelo.crearColectivo(modelo.getUsuarioConectado(), nombre, null);
		JOptionPane.showMessageDialog(panel, "Colectivo creado");
		return;
	}
}
