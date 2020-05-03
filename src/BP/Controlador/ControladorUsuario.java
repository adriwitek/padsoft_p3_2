package BP.Controlador;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import BP.Modelo.*;
import BP.Vista.*;

public class ControladorUsuario implements ActionListener, ListSelectionListener{
    private UsuarioPanel panel;
    private VentanaPrincipal frame;
    private Aplicacion modelo;
    private Proyecto proyectoSeleccionado;
    private Colectivo colectivoSeleccionado;
    public ControladorUsuario(VentanaPrincipal frame, Aplicacion modelo) {
        this.panel = frame.getPanelUsuario();
        this.frame = frame;
        this.modelo = modelo;
        this.colectivoSeleccionado = null;
        this.proyectoSeleccionado = null;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Colectivos")){
            goToColectivo();

        }else if(e.getActionCommand().equals("Proyectos")){
            goToProyectos();

        }else if(e.getActionCommand().equals("Apoyar")) {
        	if(null == proyectoSeleccionado) {
				JOptionPane.showMessageDialog(panel,"Debe seleccionar un proyecto de la lista", "Error", JOptionPane.ERROR_MESSAGE);
				return;
        	}
        	this.proyectoSeleccionado.apoyarProyecto(modelo.getUsuarioConectado());
        	modelo.saveAplicacion();
            
        }else if(e.getActionCommand().equals("Suscribirse")) {
        	if(null == colectivoSeleccionado) {
				JOptionPane.showMessageDialog(panel,"Debe seleccionar un colectivo de la lista", "Error", JOptionPane.ERROR_MESSAGE);
				return;
        	}
        	this.colectivoSeleccionado.suscribirseColectivo(modelo.getUsuarioConectado());
        	modelo.saveAplicacion();
        }else if(e.getActionCommand().equals("DetallesP")) {
        	DetallesProyectoPanel detallesP = frame.getDetallesProyectoPanel();
        	if(this.proyectoSeleccionado != null) {
        		if(this.proyectoSeleccionado.getTipoProyecto().equals("Infraestructura")) {
        			detallesP.setDetallesSocial(this.proyectoSeleccionado);
        		}else if(this.proyectoSeleccionado.getTipoProyecto().equals("Social"))
        			detallesP.setDetallesInf(this.proyectoSeleccionado);
        		
        		goToDetallesProyecto();
        	}
        	JOptionPane.showMessageDialog(panel,"Debe seleccionar un proyecto de la lista", "Error", JOptionPane.ERROR_MESSAGE);
			return;
        }else if(e.getActionCommand().equals("DetallesC")) {
        	
            
        }else if(e.getActionCommand().equals("Actualizar")) {
        	actualizar();
        }



    }

    private void goToColectivo() {
        ColectivosPanel pColectivos = frame.getPanelColectivos();
        pColectivos.setVisible(true);
        this.panel.setVisible(false);
    }
    private void goToDetallesProyecto() {
        DetallesProyectoPanel pDetalles = frame.getDetallesProyectoPanel();
        pDetalles.setVisible(true);
        this.panel.setVisible(false);
    }
    private void goToProyectos() {
        ProyectosPanel pProyectos = frame.getPanelProyectos();
        pProyectos.setVisible(true);
        this.panel.setVisible(false);
    }

	private void actualizar() {
		panel.setListaProyectos(modelo.getProyectosApoyables(modelo.getUsuarioConectado()));
		panel.setListaColectivos(modelo.getColectivosDisponibles(modelo.getUsuarioConectado()));
	}
	@Override
	public void valueChanged(ListSelectionEvent ev) {
		if(!ev.getValueIsAdjusting()) {

		}
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


	public ListSelectionListener getControllerColectivosDisponibles() {
		return new ListSelectionListener () {
				public void valueChanged(ListSelectionEvent e) {
					if(e.getValueIsAdjusting()==false) {
				    	JList lista = (JList) e.getSource();
				    	colectivoSeleccionado  = (Colectivo) lista.getSelectedValue();
					}
				}
				
		};
		
	}

}


