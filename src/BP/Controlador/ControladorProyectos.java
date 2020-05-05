package BP.Controlador;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import BP.Modelo.*;
import BP.Vista.*;
/** 
* 
* @author Adián Rubio adrian.rubiop@estudiante.uam.es, Guillermo Solla guillermo.solla@estudiante.uam.es 
* y Diego Tapia diego.tapias@estudiante.uam.es
*/
public class ControladorProyectos implements ActionListener, ListSelectionListener {

	private ProyectosPanel panel;
	private VentanaPrincipal frame;
	private Aplicacion modelo;
	private Proyecto proyectoSeleccionado;

	
	/**
	 * Este es el contructor de ControladorProyectos
	 * @param frame ventana de la aplicacion
	 * @param modelo aplicacion que hemos desarrollado
	 */

	private Proyecto proyectoSeleccionadoAp;

	public ControladorProyectos(VentanaPrincipal frame ,Aplicacion modelo) {
		this.panel= frame.getPanelProyectos();
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
	
		if(e.getActionCommand().equals("crearProyecto")) {
			cProyecto();
			
		}else if(e.getActionCommand().equals("Actualizar")){
			actualizar();
		}else if(e.getActionCommand().equals("Detalles")) {
			goToDetallesProyecto(proyectoSeleccionado);
		}else if(e.getActionCommand().equals("Detalles.")) {

			goToDetallesProyecto(proyectoSeleccionadoAp);
		}
	}
	
	/**
	 * Esta funcion se encargara de crear la funcionalidad de actualizar
	 * de actualizar la informacion de los proyectos del usuario
	 */
	private void actualizar() {
		frame.getControlador().getControladorLogin().loadUserInfo();
	}
	

	/**
	 * Esta funcion se encargara de crear la funcionalidad del boton detalles
	 * nos mandara al panel DetallesProyectoPanel
	 * @param p Proyecto
	 */

	public void goToDetallesProyecto(Proyecto p) {
        DetallesProyectoPanel detallesP = frame.getPanelDetallesProyecto();

        if(p!= null) {

            if(p.getTipoProyecto().equals("Infraestructura")) {
                ProyectoInfraestructura pif = (ProyectoInfraestructura)p;
                detallesP.setDetallesInf(pif,pif.getImgPath(),pif.getCroquisPath());
            }else if(p.getTipoProyecto().equals("Social"))
                detallesP.setDetallesSocial(p);


        }else {
            JOptionPane.showMessageDialog(panel,"Debe seleccionar un proyecto de la lista", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        frame.getControlador().getControladorDetallesProyecto().setFrom("Proyectos");
        detallesP.setVisible(true);
        frame.getPanelUsuario().setVisible(false);
    }
	
	/**
	 * Esta funcion se encargara de la funcionalidad del boto de crear proyect
	 * nos mandara al panel CrearProyectoPanel
	 */
	private void cProyecto() {
		CrearProyectoPanel ccProyecto = frame.getPanelCrearProyecto();
		frame.getControlador().getControladorCrearProyecto().setProponente(modelo.getUsuarioConectado());
		ccProyecto.setVisible(true);
		frame.getPanelUsuario().setVisible(false);
	}
	
	/**
	 * Esta funcion cambiara los valores de proyectoSeleccionado
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {
	}
	
	/**
	 * Esta funcion devolvera proyectoSeleccionado
	 * @return the proyectoSeleccionado proyecto a devolver
	 */
	public Proyecto getProyectoSelected() {
		return this.proyectoSeleccionado;
	}

	public ListSelectionListener getControllerTusProyectos() {
		return new ListSelectionListener () {
			public void valueChanged(ListSelectionEvent e) {
				if(e.getValueIsAdjusting()==false) {
			    	JList lista = (JList) e.getSource();
			    	proyectoSeleccionado  = (Proyecto) lista.getSelectedValue();
				}
			}
			
		};
	}
	public ListSelectionListener getControllerProyectosAp() {
		return new ListSelectionListener () {
			public void valueChanged(ListSelectionEvent e) {
				if(e.getValueIsAdjusting()==false) {
			    	JList lista = (JList) e.getSource();
			    	proyectoSeleccionadoAp  = (Proyecto) lista.getSelectedValue();
				}
			}
			
		};
	}
}

