package BP.Controlador;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import BP.Modelo.*;
import BP.Vista.*;

public class ControladorProyectos implements ActionListener, ListSelectionListener {

	private ProyectosPanel panel;
	private VentanaPrincipal frame;
	private Aplicacion modelo;
	private Proyecto proyectoSeleccionado;
	private Proyecto proyectoSeleccionadoAp;
	public ControladorProyectos(VentanaPrincipal frame ,Aplicacion modelo) {
		this.panel= frame.getPanelProyectos();
		this.frame= frame;
		this.modelo=modelo;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(e.getActionCommand().equals("crearProyecto")) {
			cProyecto();
			
		}else if(e.getActionCommand().equals("Actualizar")){
			actualizar();
		}else if(e.getActionCommand().equals("Detalles")) {
			goToDetallesProyecto(proyectoSeleccionado);
		}
	}

	private void actualizar() {
		frame.getControlador().getControladorLogin().loadUserInfo();
	}
	
	public void goToDetallesProyecto(Proyecto p) {
		DetallesProyectoPanel detallesP = frame.getPanelDetallesProyecto();
    	
    	if(p!= null) {
    		
    		if(p.getTipoProyecto().equals("Infraestructura")) {
    			detallesP.setDetallesInf(p);
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
	
	private void cProyecto() {
		CrearProyectoPanel ccProyecto = frame.getPanelCrearProyecto();
		frame.getControlador().getControladorCrearProyecto().setProponente(modelo.getUsuarioConectado());
		ccProyecto.setVisible(true);
		frame.getPanelUsuario().setVisible(false);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
	}
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
			    	proyectoSeleccionado  = (Proyecto) lista.getSelectedValue();
				}
			}
			
		};
	}
}

