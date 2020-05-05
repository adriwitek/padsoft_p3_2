package BP.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import BP.Modelo.Aplicacion;
import BP.Vista.DetallesProyectoPanel;
import BP.Vista.ProyectosPanel;
import BP.Vista.UsuarioPanel;
import BP.Vista.VentanaPrincipal;
/** 
* 
* @author Adián Rubio adrian.rubiop@estudiante.uam.es, Guillermo Solla guillermo.solla@estudiante.uam.es 
* y Diego Tapia diego.tapias@estudiante.uam.es
*/
public class ControladorDetallesProyecto implements ActionListener {
	private DetallesProyectoPanel panel;
	private String from;
    private VentanaPrincipal frame;
    private Aplicacion modelo; 
    /**
     * Este es el constructor de ControladorDetallesProyecto
     * @param frame ventana de la aplicacion
     * @param modelo aplicacion que hemos desarrollado
     */
	public ControladorDetallesProyecto(VentanaPrincipal frame, Aplicacion modelo) {
	        this.panel = frame.getPanelDetallesProyecto();
	        this.frame = frame;
	        this.modelo = modelo;
	    }
	
	/**
	 * Esta funcion se encargara de que al interactuar con el programa(dar a un boton, escribir en un texto, seleccionar un valor de una list, etc)
	 * se realice la accion correspondiente.
	 * @param e es el actionEvent
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Volver")) {
			volverToUsuario();
		}
	}
	/**
	 * Esta funcion se encargara de crear la funcionalidad del boton volver
	 * de tal manera que la aplicacion volveria a la pestaña de usuario
	 */
	private void volverToUsuario() {
        UsuarioPanel pUser = frame.getPanelUsuario();
        pUser.setVisible(true);
        this.panel.setVisible(false);
    }

	/**
	 * Esta funcion introduce en this.from un strinf
	 * @param from string que se quiere introducir en from
	 */
	public void setFrom(String from) {
		this.from = from;
	}
}
