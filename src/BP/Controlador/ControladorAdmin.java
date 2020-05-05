package BP.Controlador;

import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import BP.Modelo.*;
import BP.Vista.*;
/** 
* 
* @author Adián Rubio adrian.rubiop@estudiante.uam.es, Guillermo Solla guillermo.solla@estudiante.uam.es 
* y Diego Tapia diego.tapias@estudiante.uam.es
*/
public class ControladorAdmin  implements ListSelectionListener , ActionListener,ChangeListener { 

	private AdminPanel panel;
	private VentanaPrincipal frame;
	private Aplicacion modelo;
	private Usuario  ultimoUsuarioSeleccionado;
	private Usuario  ultimoUsuarioSeleccionado2;
	private Usuario  ultimoUsuarioSeleccionado3;
	private int idProyecto;
	private int filaTabla;
	
	/**
	 * Este es el constructor de ControladorAdmin
	 * @param frame ventana de la aplicacion
	 * @param modelo la aplicacion creada
	 */
	public ControladorAdmin(VentanaPrincipal frame ,Aplicacion modelo) {
		this.panel= frame.getPanelAdmin();
		this.frame= frame;
		this.modelo=modelo;
		this.ultimoUsuarioSeleccionado = null;
		this.ultimoUsuarioSeleccionado2 = null;
		this.ultimoUsuarioSeleccionado3 = null;
		this.idProyecto = -1;
		this.filaTabla = -1;
	}

	
	 
	/**
	 * Esta funcion se encargara de que al interactuar con el programa(dar a un boton, escribir en un texto, seleccionar un valor de una list, etc)
	 * se realice la accion correspondiente.
	 * @param e actionEvent
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		if(e.getActionCommand().equals("Validar Registro")) {

			if(null == ultimoUsuarioSeleccionado) {
				JOptionPane.showMessageDialog(panel,"Debe seleccionar un usuario de la lista", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}else {
				modelo.validarRegistro(ultimoUsuarioSeleccionado);
				JOptionPane.showMessageDialog(frame, "Se ha validado el usuario: " + ultimoUsuarioSeleccionado.getNombre());
				this.panel.addListaUsuariosActivos(ultimoUsuarioSeleccionado);
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
			
			String nombre =  ultimoUsuarioSeleccionado2.getNombre();
			this.ultimoUsuarioSeleccionado2.bloquear(panel.getMotivoBloqueo());
			this.panel.addListaUsuariosBloqueados(this.ultimoUsuarioSeleccionado2);
			this.panel.borrarListaUsuariosActivos(this.ultimoUsuarioSeleccionado2);
			JOptionPane.showMessageDialog(frame, "Se ha bloqueado al usuario: " + nombre);
			ultimoUsuarioSeleccionado2= null;
			
		}else  if(e.getActionCommand().equals("Desbloquear Usuario")) {
			
			if(null == this.ultimoUsuarioSeleccionado3) {
				JOptionPane.showMessageDialog(panel,"Debe seleccionar un usuario de la lista", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
				String nombre =  ultimoUsuarioSeleccionado3.getNombre();
				this.ultimoUsuarioSeleccionado3.desbloquear();
				this.panel.addListaUsuariosActivos(this.ultimoUsuarioSeleccionado3);
				this.panel.borrarListaUsuariosBloqueados(this.ultimoUsuarioSeleccionado3);
				JOptionPane.showMessageDialog(frame, "Se ha desbloqueado al usuario: " + nombre);
				ultimoUsuarioSeleccionado3= null;

		}else if(e.getActionCommand().equals("Validar Proyecto")) {
			
			
			this.filaTabla  = this.panel.getTablaProyectosValidacion().getSelectedRow();
			if(filaTabla == -1) {
				JOptionPane.showMessageDialog(panel,"Debe seleccionar un proyecto de la tabla", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			idProyecto = (int) this.panel.getModeloTablaProyectosValidacion().getValueAt(filaTabla, 5);
			
			
			
			HashSet<Proyecto> proyectosPendientesValidacion = modelo.getProyectosPendientesValidacion();
			Proyecto pSeleccionado = null;
			for(Proyecto p:proyectosPendientesValidacion ) {
				if(this.idProyecto == p.getUniqueID()) pSeleccionado = p;
			}
			
			
			
			
			if(null!= pSeleccionado) {
				pSeleccionado.validarProyecto();
				proyectosPendientesValidacion.remove(pSeleccionado);
				panel.getModeloTablaProyectosValidacion().removeRow(filaTabla);//FIX NECESARIO
				panel.setModeloProyectosValidacion(proyectosPendientesValidacion);
				this.filaTabla = -1;
				JOptionPane.showMessageDialog(frame, "Se ha validado el proyecto " + pSeleccionado.getNombre());
			}else {
				JOptionPane.showMessageDialog(panel,"Ha ocurrido un error", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			
		}else if(e.getActionCommand().equals("Rechazar Proyecto")) {
			
			
			 if(panel.getMotivoRechazoValidacionProyecto().equals("")) {
					JOptionPane.showMessageDialog(panel,"Debe especificar un motivo de rechazo", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
			
			
			this.filaTabla  = this.panel.getTablaProyectosValidacion().getSelectedRow();
			if(filaTabla == -1) {
				JOptionPane.showMessageDialog(panel,"Debe seleccionar un proyecto de la tabla", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			idProyecto = (int) this.panel.getModeloTablaProyectosValidacion().getValueAt(filaTabla, 5);
			
			
			
			HashSet<Proyecto> proyectosPendientesValidacion = modelo.getProyectosPendientesValidacion();
			Proyecto pSeleccionado = null;
			for(Proyecto p:proyectosPendientesValidacion ) {
				if(this.idProyecto == p.getUniqueID()) pSeleccionado = p;
			}
			
			
			
			
			if(null!= pSeleccionado) {
				pSeleccionado.rechazarProyecto(panel.getMotivoRechazoValidacionProyecto());
				panel.getModeloTablaProyectosValidacion().removeRow(filaTabla);//FIX NECESARIO
				panel.setModeloProyectosValidacion(modelo.getProyectosSolicitandoFinanciacion() );
				this.filaTabla = -1;
				JOptionPane.showMessageDialog(frame, "Se ha rechazado el proyecto " + pSeleccionado.getNombre());
			}else {
				JOptionPane.showMessageDialog(panel,"Ha ocurrido un error", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			
		} else if(e.getActionCommand().equals("Cerrar Sesion")) {
			modelo.logOut();
			modelo.saveAplicacion();
			JOptionPane.showMessageDialog(frame, "Hasta pronto! " );
			frame.getPanelLogin().setVisible(true);
			this.panel.setVisible(false);
		}
		
		
		 

		
		
		
	}
	
	/**
	 * Esta funcion se va a encargar de cambiar un valor dependiendo de si (ultimoUsuarioSeleccionado == null) o (ultimoUsuarioSeleccionado != null)
	 */
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
	
	
	/**
	 * Esta funcionse encarga de devolver un ListSelectionListener de los usuarios activos
	 * @return the new ListSelectionListener
	 */
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
	
	/**
	 * Esta funcionse encarga de devolver un ListSelectionListener de los usuarios bloquados
	 * @return the new ListSelectionListener
	 */
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
		
	


	/**
	 * 
	 */
	@Override
	public void stateChanged(ChangeEvent e) {
		//pestanias
		
	}


 

 

	
}
