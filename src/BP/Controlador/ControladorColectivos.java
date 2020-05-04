package BP.Controlador;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import BP.Modelo.*;
import BP.Vista.*;

public class ControladorColectivos implements ActionListener, ListSelectionListener {

	private ColectivosPanel panel;
	private VentanaPrincipal frame;
	private Aplicacion modelo;
	private Colectivo colectivoSeleccionado;
	private Proyecto proyectoSeleccionado;
	private Proyecto proyectoSeleccionadoCol;
	public ControladorColectivos(VentanaPrincipal frame ,Aplicacion modelo) {
		this.panel= frame.getPanelColectivos();
		this.frame= frame;
		this.modelo=modelo;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(e.getActionCommand().equals("crearColectivo")){
			CColectivo();
			
			

		}else if(e.getActionCommand().equals("Apoyar como representante de colectivo")){
				apoyarComoRepresentate();
		}else if(e.getActionCommand().equals("Actualizar")) {
				actualizar();
		}else if(e.getActionCommand().equals("Crear proyecto como representante de colectivo")) {
				crearProyectoComoRepresentante();
		}else if(e.getActionCommand().equals("DetallesPD")) {
				frame.getControlador().getControladorProyectos().goToDetallesProyecto(proyectoSeleccionado);
		}else if(e.getActionCommand().equals("DetallesPC")) {
				frame.getControlador().getControladorProyectos().goToDetallesProyecto(proyectoSeleccionadoCol);
		}
		
	}
	private void apoyarComoRepresentate() {
		if(colectivoSeleccionado == null) {
			JOptionPane.showMessageDialog(panel,
					"Seleccione un colectivo.", "Error", JOptionPane.ERROR_MESSAGE);
			
			return;
		}
		if(proyectoSeleccionado == null) { 
			JOptionPane.showMessageDialog(panel,
					"Seleccione un proyecto.", "Error", JOptionPane.ERROR_MESSAGE);
			
			return;
		}
			
		
		int option = JOptionPane.showConfirmDialog(panel,"Apoyar proyecto:" + this.proyectoSeleccionado + " como representante del colectivo: "+ this.colectivoSeleccionado );
		if(option == 0) {
			proyectoSeleccionado.apoyarProyectoComoColectivo(colectivoSeleccionado);
		}else if(option == 1 || option == 2) {
			return;
		}
	}
	private void crearProyectoComoRepresentante() {
		if(colectivoSeleccionado == null) {
			JOptionPane.showMessageDialog(panel,
					"Seleccione un colectivo.", "Error", JOptionPane.ERROR_MESSAGE);
			
			return;
		}
		CrearProyectoPanel cPP = frame.getPanelCrearProyecto();
		frame.getControlador().getControladorCrearProyecto().setProponente(colectivoSeleccionado);
		cPP.setVisible(true);
		frame.getPanelUsuario().setVisible(false);
	}
	public ListSelectionListener getControllerProyectosApoyables() {
		return new ListSelectionListener () {	
				public void valueChanged(ListSelectionEvent e) {
					if(e.getValueIsAdjusting()==false) {
				    	JList lista = (JList) e.getSource();
				    	proyectoSeleccionado  = (Proyecto) lista.getSelectedValue();
					}
				}
				
		};
	}

	
	public ListSelectionListener getControllerTusColectivos() {
		return new ListSelectionListener () {
				
				public void valueChanged(ListSelectionEvent e) {
					panel.setLabelProyectosCol("Proyectos de: ");
					if(e.getValueIsAdjusting()==false) {
				    	JList lista = (JList) e.getSource();
				    	colectivoSeleccionado  = (Colectivo) lista.getSelectedValue();
				    	if(colectivoSeleccionado == null) {
				    		return;
				    	}
				    	if(colectivoSeleccionado.equals(lista.getSelectedValue())) {
				    		panel.setLabelProyectosCol("Proyectos de: " + colectivoSeleccionado);
				    	}
				    	panel.setListaProyectosCol(modelo.getProyectosColectivo(colectivoSeleccionado));
					}
				}
				
		};
		
	}
	private void CColectivo() {
		frame.getPanelCrearColectivo().setVisible(true);
		frame.getPanelUsuario().setVisible(false);
	}
	
	private void actualizar() {
		frame.getControlador().getControladorLogin().loadUserInfo();
	}
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public ListSelectionListener getControllerTusProyectos() {
		return new ListSelectionListener () {
			public void valueChanged(ListSelectionEvent e) {
				if(e.getValueIsAdjusting()==false) {
			    	JList lista = (JList) e.getSource();
			    	proyectoSeleccionadoCol  = (Proyecto) lista.getSelectedValue();
				}
			}
			
	};
	}
}
