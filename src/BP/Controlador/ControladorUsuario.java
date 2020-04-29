package BP.Controlador;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import BP.Modelo.*;
import BP.Vista.*;

public class ControladorUsuario {
	private UsuarioPanel panel;
	private VentanaPrincipal frame;
	private Aplicacion modelo;
	public ControladorUsuario(VentanaPrincipal frame, Aplicacion modelo) {
		this.panel = frame.getPanelUsuario();
		this.frame = frame;
		this.modelo = modelo;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	
		
		if(e.getActionCommand().equals("goUsuarios")) {
			

		}else if(e.getActionCommand().equals("goColectivos")){
			goColectivos();
		}else if(e.getActionCommand().equals("goColectivos")){
			goProyectos();
		}
		
		else {
			frame.getPanelBienvenida().setVisible(true);
			this.panel.setVisible(false);
		}
		
	}
}
