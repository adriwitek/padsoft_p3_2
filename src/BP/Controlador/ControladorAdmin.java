package BP.Controlador;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import BP.Modelo.*;
import BP.Vista.*;

public class ControladorAdmin     implements ListSelectionListener , ActionListener{ 

	private AdminPanel panel;
	private VentanaPrincipal frame;
	private Aplicacion modelo;
	private Usuario  ultimoUsuarioSeleccionado;
	
	public ControladorAdmin(VentanaPrincipal frame ,Aplicacion modelo) {
		this.panel= frame.getPanelAdmin();
		this.frame= frame;
		this.modelo=modelo;
		this.ultimoUsuarioSeleccionado = null;
	}

	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Validar Registro")) {

			if(null == ultimoUsuarioSeleccionado) {
				JOptionPane.showMessageDialog(panel,
						"Debe seleccionar un usuario de la lista", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}else {
				modelo.validarRegistro(ultimoUsuarioSeleccionado);
				JOptionPane.showMessageDialog(frame, "Se ha validado el usuario: " + ultimoUsuarioSeleccionado.getNombre());
				this.panel.borraDeListaUsuarios(ultimoUsuarioSeleccionado);
				ultimoUsuarioSeleccionado= null;

			}
			

		}else {//REchazar registro
			if(null == ultimoUsuarioSeleccionado) {
				JOptionPane.showMessageDialog(panel,
						"Debe seleccionar un usuario de la lista", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}else if( panel.getMotivoRechazo().equals("")) {
				JOptionPane.showMessageDialog(panel,
						"Debe indicar un motivo de rechazo", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
	
			if(!modelo.rechazarRegistro(ultimoUsuarioSeleccionado, panel.getMotivoRechazo())) {
				JOptionPane.showMessageDialog(panel,
						"Ha ocurrido un error interno al rechazar la solititud de registro indicada", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}else {
				JOptionPane.showMessageDialog(frame, "Se ha rechazado la solicitud de registro del usuario: " + ultimoUsuarioSeleccionado.getNombre());
			}
			
			this.panel.borraDeListaUsuarios(ultimoUsuarioSeleccionado);
			ultimoUsuarioSeleccionado= null;


		}
	}
	
	
	@Override
	public void valueChanged(ListSelectionEvent ev) {
	    	JList lista = (JList) ev.getSource();
	    	if (! ev.getValueIsAdjusting() ) {
	    	   this.ultimoUsuarioSeleccionado = (Usuario) lista.getSelectedValue();
	    	   if(null != ultimoUsuarioSeleccionado)  this.panel.updateSolicitudRegitroSeleccionada(ultimoUsuarioSeleccionado.getNombre(), ultimoUsuarioSeleccionado.getNIF()); 
	    	   else  this.panel.updateSolicitudRegitroSeleccionada("", ""); 
	    	}
	}
	
}
