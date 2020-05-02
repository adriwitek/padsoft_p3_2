package BP.Controlador;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import BP.Modelo.*;
import BP.Vista.*;

public class ControladorColectivos implements ActionListener {

	private ColectivosPanel panel;
	private VentanaPrincipal frame;
	private Aplicacion modelo;
	
	public ControladorColectivos(VentanaPrincipal frame ,Aplicacion modelo) {
		this.panel= frame.getPanelColectivos();
		this.frame= frame;
		this.modelo=modelo;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(e.getActionCommand().equals("crearColectivo")){
			CColectivo();
			
		}else if(e.getActionCommand().equals("goColectivos")) {
			GoToProyectos();
		
		}else if(e.getActionCommand().equals("goUsuario")) {
			GoToUsuario();

		}else {
			frame.getPanelBienvenida().setVisible(true);
			this.panel.setVisible(false);
		}
		
	}
	
	private void GoToProyectos(){
		ProyectosPanel pProyectos = frame.getPanelProyectos();
		pProyectos.setVisible(true);
		this.panel.setVisible(false);
	}
	
	
	private void GoToUsuario() {
		UsuarioPanel pUsuario = frame.getPanelUsuario();
		pUsuario.setVisible(true);
		this.panel.setVisible(false);
	}
	
	private void CColectivo() {
		CrearColectivoPanel cColectivo = frame.getPanelCrearColectivo();
		cColectivo.setVisible(true);
		this.panel.setVisible(false);
	}
}
