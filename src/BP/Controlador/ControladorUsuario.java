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
    private Notificacion notificacionSeleccionada;
    
    public ControladorUsuario(VentanaPrincipal frame, Aplicacion modelo) {
        this.panel = frame.getPanelUsuario();
        this.frame = frame;
        this.modelo = modelo;
        this.colectivoSeleccionado = null;
        this.proyectoSeleccionado = null;
        this.notificacionSeleccionada = null;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    	
    	if(e.getActionCommand().equals("Apoyar")) {
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
        }else if(e.getActionCommand().equals("DetallesC")) {
        	
            
        }else if(e.getActionCommand().equals("Actualizar")) {
        	actualizar();
        }else if(e.getActionCommand().equals("Cerrar Sesion")) {
            modelo.logOut();
            modelo.saveAplicacion();
            JOptionPane.showMessageDialog(frame, "Hasta pronto! " );
            frame.getPanelLogin().setVisible(true);
            this.panel.setVisible(false);
        }else if(e.getActionCommand().equals("Borrar Notificacion")) {

            if(this.notificacionSeleccionada == null) {
                JOptionPane.showMessageDialog(panel,"Debe seleccionar una notificacion de la lista", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if(!this.modelo.getUsuarioConectado().borrarNotificacion(notificacionSeleccionada)) {
                JOptionPane.showMessageDialog(panel,"Ha ocurrido un error", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }else {
                JOptionPane.showMessageDialog(panel,"La notificacion ha sido borrada", "Notificacion borrada", JOptionPane.INFORMATION_MESSAGE);
                this.notificacionSeleccionada=null;
                this.panel.setModeloNotificaciones(this.modelo.getUsuarioConectado().getAllNotificaciones());
            }

        }
    	


    }


    private void goToDetallesProyecto() {
        DetallesProyectoPanel pDetalles = frame.getPanelDetallesProyecto();
        frame.getControlador().getControladorDetallesProyecto().setFrom("Usuario");
        pDetalles.setVisible(true);
        this.panel.setVisible(false);
    }


	private void actualizar() {
		panel.setListaProyectos(modelo.getProyectosApoyables(modelo.getUsuarioConectado()));
		panel.setListaColectivos(modelo.getColectivosDisponibles(modelo.getUsuarioConectado()));
	}
	@Override
	public void valueChanged(ListSelectionEvent ev) {
		
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
	
	public ListSelectionListener getControllerNotificaciones() {
        return new ListSelectionListener () {
            public void valueChanged(ListSelectionEvent e) {
                if(e.getValueIsAdjusting()==false) {
                    JList lista = (JList) e.getSource();
                    notificacionSeleccionada  = (Notificacion) lista.getSelectedValue();
                    panel.setCampoTituloNotificacion(notificacionSeleccionada.getTitulo());
                    panel.setCampoDescripcionNotificacion(notificacionSeleccionada.getDescripcion()); 
                }
            }

        };
    }

}


