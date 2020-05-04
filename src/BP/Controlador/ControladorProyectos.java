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
			DetallesProyectoPanel detallesP = frame.getPanelDetallesProyecto();
        	
        	if(this.proyectoSeleccionado != null) {
        		
        		if(this.proyectoSeleccionado.getTipoProyecto().equals("Infraestructura")) {
        			detallesP.setDetallesInf(this.proyectoSeleccionado);
        		}else if(this.proyectoSeleccionado.getTipoProyecto().equals("Social"))
        			detallesP.setDetallesSocial(this.proyectoSeleccionado);
        		
        		goToDetallesProyecto();
        	}else {
        		JOptionPane.showMessageDialog(panel,"Debe seleccionar un proyecto de la lista", "Error", JOptionPane.ERROR_MESSAGE);
        		return;
        	}
		}
	}

	private void actualizar() {
		panel.setTusProyectos(modelo.getProyectosUsuario(modelo.getUsuarioConectado()));
	}
	
	private void goToDetallesProyecto() {
        DetallesProyectoPanel pDetalles = frame.getPanelDetallesProyecto();
        frame.getControlador().getControladorDetallesProyecto().setFrom("Proyectos");
        pDetalles.setVisible(true);
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
		if(!e.getValueIsAdjusting()) {
			JList lista = (JList) e.getSource();
	    	proyectoSeleccionado  = (Proyecto) lista.getSelectedValue();
		}
		
	}
	public Proyecto getProyectoSelected() {
		return this.proyectoSeleccionado;
	}

}

