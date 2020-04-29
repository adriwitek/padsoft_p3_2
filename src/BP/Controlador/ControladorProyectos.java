package BP.Controlador;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import BP.Modelo.*;
import BP.Vista.*;

public class ControladorProyectos implements ActionListener {

	private ProyectosPanel panel;
	private VentanaPrincipal frame;
	private Aplicacion modelo;
	
	public ControladorProyectos(VentanaPrincipal frame ,Aplicacion modelo) {
		this.panel= frame.getPanelProyectos();
		this.frame= frame;
		this.modelo=modelo;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		
		if(e.getActionCommand().equals("goColectivos")) {
			GoToColectivo();
		
		}else if(e.getActionCommand().equals("goUsuario")) {
			GoToUsuario();

		}else {
			frame.getPanelBienvenida().setVisible(true);
			this.panel.setVisible(false);
		}
		
	}

	private void GoToColectivo() {
		ColectivosPanel pColectivos = frame.getPanelColectivos();
		pColectivos.setVisible(true);
		this.panel.setVisible(false);
	}
	
	
	
	private void GoToUsuario() {
		UsuarioPanel pUsuario = frame.getPanelUsuario();
		pUsuario.setVisible(true);
		this.panel.setVisible(false);
	}
	
	

}

