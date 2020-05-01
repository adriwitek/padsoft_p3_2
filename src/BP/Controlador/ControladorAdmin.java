package BP.Controlador;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;

import BP.Modelo.*;
import BP.Vista.*;

public class ControladorAdmin    implements ListSelectionEvent, ActionListener{ 

	private AdminPanel panel;
	private VentanaPrincipal frame;
	private Aplicacion modelo;
	
	public ControladorAdmin(VentanaPrincipal frame ,Aplicacion modelo) {
		this.panel= frame.getPanelAdmin();
		this.frame= frame;
		this.modelo=modelo;
	}

	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public void valueChanged(ListSelectionEvent ev) {
	    	JList lista = (JList) ev.getSource();
	    	if (! ev.getValueIsAdjusting() ) {
	    	  Usuario valorSeleccionado = (Usuario) lista.getSelectedValue();
	          this.panel.updateSolicitudRegitroSeleccionada(valorSeleccionado.getNombre(), valorSeleccionado.getNIF());
	    	}
	}
	
}
