package BP.Controlador;

import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import BP.Modelo.*;
import BP.Vista.*;

public class ControladorAdmin  implements ListSelectionListener , ActionListener,ChangeListener { 

	private AdminPanel panel;
	private VentanaPrincipal frame;
	private Aplicacion modelo;
	private Usuario  ultimoUsuarioSeleccionado;
	private Usuario  ultimoUsuarioSeleccionado2;
	private Usuario  ultimoUsuarioSeleccionado3;


	
	public ControladorAdmin(VentanaPrincipal frame ,Aplicacion modelo) {
		this.panel= frame.getPanelAdmin();
		this.frame= frame;
		this.modelo=modelo;
		this.ultimoUsuarioSeleccionado = null;
		this.ultimoUsuarioSeleccionado2 = null;
		this.ultimoUsuarioSeleccionado3 = null;
	}

	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		if(e.getActionCommand().equals("Validar Registro")) {

			if(null == ultimoUsuarioSeleccionado) {
				JOptionPane.showMessageDialog(panel,"Debe seleccionar un usuario de la lista", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}else {
				modelo.validarRegistro(ultimoUsuarioSeleccionado);
				JOptionPane.showMessageDialog(frame, "Se ha validado el usuario: " + ultimoUsuarioSeleccionado.getNombre());
				this.panel.borraDeListaUsuarios(ultimoUsuarioSeleccionado);
				ultimoUsuarioSeleccionado= null;

			}
			

			
			
		}else if(e.getActionCommand().equals("Rechazar Registro")){//Rechazar registro
			
			if(null == ultimoUsuarioSeleccionado) {
				JOptionPane.showMessageDialog(panel,"Debe seleccionar un usuario de la lista", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}else if( panel.getMotivoRechazo().equals("")) {
				JOptionPane.showMessageDialog(panel,"Debe indicar un motivo de rechazo", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
	
			if(!modelo.rechazarRegistro(ultimoUsuarioSeleccionado, panel.getMotivoRechazo())) {
				JOptionPane.showMessageDialog(panel,"Ha ocurrido un error interno al rechazar la solititud de registro indicada", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}else {
				JOptionPane.showMessageDialog(frame, "Se ha rechazado la solicitud de registro del usuario: " + ultimoUsuarioSeleccionado.getNombre());
			}
			
			this.panel.borraDeListaUsuarios(ultimoUsuarioSeleccionado);
			ultimoUsuarioSeleccionado= null;
			
			
			
			
		}else if(e.getActionCommand().equals("Bloquear Usuario")){
			

			if(null == this.ultimoUsuarioSeleccionado2) {
				JOptionPane.showMessageDialog(panel,"Debe seleccionar un usuario de la lista", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}else if(panel.getMotivoBloqueo().equals("")) {
				JOptionPane.showMessageDialog(panel,"Debe especificar un motivo de bloqueo", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			this.ultimoUsuarioSeleccionado2.bloquear(panel.getMotivoBloqueo());
			this.panel.updateListaUsuariosActivos(this.modelo.getUsuariosActivos());
			JOptionPane.showMessageDialog(frame, "Se ha bloqueado al usuario: " + ultimoUsuarioSeleccionado2.getNombre());
			ultimoUsuarioSeleccionado2= null;
			
		}else  if(e.getActionCommand().equals("Desbloquear Usuario")) {
			
			if(null == this.ultimoUsuarioSeleccionado3) {
				JOptionPane.showMessageDialog(panel,"Debe seleccionar un usuario de la lista", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
				this.ultimoUsuarioSeleccionado2.desbloquear();
				this.panel.updateListaUsuariosBloqueados(this.modelo.getUsuariosBloqueados());
				JOptionPane.showMessageDialog(frame, "Se ha desbloqueado al usuario: " + ultimoUsuarioSeleccionado3.getNombre());
				ultimoUsuarioSeleccionado3= null;

			
			
		}
		
		
		
		 
		
		
		
	}
	
	
	@Override
	public void valueChanged(ListSelectionEvent ev) {
	
	    	if (! ev.getValueIsAdjusting() ) {
		    	JList lista = (JList) ev.getSource();
	    	   this.ultimoUsuarioSeleccionado = (Usuario) lista.getSelectedValue();
	    	   if(null != ultimoUsuarioSeleccionado) {
	    		  this.panel.updateSolicitudRegitroSeleccionada(ultimoUsuarioSeleccionado.getNombre(), ultimoUsuarioSeleccionado.getNIF()); 
	    	   }else {
	    	     this.panel.updateSolicitudRegitroSeleccionada("", ""); 
	    	   }
	    	   
	    	}		    	
	}
	
	
	
	public ListSelectionListener getControllerUsuariosActivos() {
		return new ListSelectionListener () {
				public void valueChanged(ListSelectionEvent e) {
					if(e.getValueIsAdjusting()==false) {
						panel.setVisibilidadCampoMotivoBloqueo(true);
						panel.setVisibilidadBotonBloquearUsuario(true);
						panel.setVisibilidadBotonDesBloquearUsuario(false);
				    	JList lista = (JList) e.getSource();
				    	ultimoUsuarioSeleccionado2  = (Usuario) lista.getSelectedValue();
					}
				}
				
		};
		
	}
	
	
	public ListSelectionListener getControllerUsuariosBloqueados() {
			return new ListSelectionListener () {
					public void valueChanged(ListSelectionEvent e) {
						if(e.getValueIsAdjusting()==false) {
							panel.setVisibilidadCampoMotivoBloqueo(false);
							panel.setVisibilidadBotonBloquearUsuario(false);
							panel.setVisibilidadBotonDesBloquearUsuario(true);
					    	JList lista = (JList) e.getSource();
					    	ultimoUsuarioSeleccionado3  = (Usuario) lista.getSelectedValue();
						}
					}
					
			};
			
		}
		

	


	@Override
	public void stateChanged(ChangeEvent e) {
		//pestanias
		
	}





	
}
