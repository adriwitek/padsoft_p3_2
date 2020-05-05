package BP.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import BP.Modelo.Aplicacion;
import BP.Vista.LoginPanel;
import BP.Vista.UsuarioPanel;
import BP.Vista.VentanaPrincipal;
import BP.Modelo.*;
import BP.Vista.*;
/** 
* 
* @author Adián Rubio adrian.rubiop@estudiante.uam.es, Guillermo Solla guillermo.solla@estudiante.uam.es 
* y Diego Tapia diego.tapias@estudiante.uam.es
*/

public class ControladorBienvenida implements ActionListener{
	
	
	private BienvenidaPanel panel;
	private VentanaPrincipal frame;
	private Aplicacion modelo;
	
	/**
	 * Este es el constructo de ControladorBienvenida
	 * @param frame ventana de la aplicacion
	 * @param modelo la apllicacion creada
	 */
	public ControladorBienvenida(VentanaPrincipal frame ,Aplicacion modelo) {
		this.panel= frame.getPanelBienvenida();
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

		// mostrar nueva vista
		if(e.getActionCommand().equals("LogIn")) {
			frame.getPanelLogin().setVisible(true);
			this.panel.setVisible(false);

		}else {//Registro
			frame.getPanelRegistro().setVisible(true);
			this.panel.setVisible(false);
		}		
		
	}
	

}
