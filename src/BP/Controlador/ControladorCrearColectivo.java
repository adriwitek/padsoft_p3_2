package BP.Controlador;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import BP.Modelo.*;
import BP.Vista.*;

public class ControladorCrearColectivo implements ActionListener{
	private CrearColectivoPanel panel;
	private VentanaPrincipal frame;
	private Aplicacion modelo;
	
	public ControladorCrearColectivo(VentanaPrincipal frame ,Aplicacion modelo) {
		this.panel= frame.getPanelCrearColectivo();
		this.frame= frame;
		this.modelo=modelo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		 if(e.getActionCommand().equals("cancelar")) {
			cancelar();
			
		}else if(e.getActionCommand().equals("finalizar")) {
			finalizar();
		}else {
			frame.getPanelBienvenida().setVisible(true);
			this.panel.setVisible(false);
		}	
		
	}
	
	public void cancelar() {
		frame.getPanelUsuario().setVisible(true);
		this.panel.setVisible(false);
	}
	
	public void finalizar() {
		String nombre = panel.getNombreColectivo();
		String descripcion = panel.getDescripcion();
		
		if(nombre.equals("") || descripcion.equals("") || nombre == null) {
			JOptionPane.showMessageDialog(panel,
					"Faltan campos obligatorios por rellenar.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		modelo.crearColectivo(modelo.getUsuarioConectado(), nombre, null);
		JOptionPane.showMessageDialog(panel, "Colectivo creado");
		return;
	}
}
