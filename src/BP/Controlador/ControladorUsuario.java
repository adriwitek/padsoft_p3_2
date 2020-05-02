package BP.Controlador;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import BP.Modelo.*;
import BP.Vista.*;

public class ControladorUsuario implements ActionListener{
	private UsuarioPanel panel;
	private VentanaPrincipal frame;
	private Aplicacion modelo;
	private Usuario user;
	public ControladorUsuario(VentanaPrincipal frame, Aplicacion modelo) {
		this.panel = frame.getPanelUsuario();
		this.frame = frame;
		this.modelo = modelo;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("goColectivos")){
			goToColectivo();
			
		}else if(e.getActionCommand().equals("goProyectos")){
			goToProyectos();
			
		}else {
			frame.getPanelBienvenida().setVisible(true);
			this.panel.setVisible(false);
		}
		
		
		
	}
	
	private void goToColectivo() {
		ColectivosPanel pColectivos = frame.getPanelColectivos();
		pColectivos.setVisible(true);
		this.panel.setVisible(false);
	}
	
	private void goToProyectos() {
		ProyectosPanel pProyectos = frame.getPanelProyectos();
		pProyectos.setVisible(true);
		this.panel.setVisible(false);
	}

		
		

}


