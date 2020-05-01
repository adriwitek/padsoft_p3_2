package BP.Controlador;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import BP.Modelo.*;
import BP.Vista.*;

public class ControladorCrearProyecto implements ActionListener{

	private CrearProyectoPanel panel;
	private VentanaPrincipal frame;
	private Aplicacion modelo;
	
	public ControladorCrearProyecto(VentanaPrincipal frame ,Aplicacion modelo) {
		this.panel= frame.getPanelCrearProyecto();
		this.frame= frame;
		this.modelo=modelo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Cancelar")) {
			cancelar();

		}else if(e.getActionCommand().equals("ProyectoSocial")){
			proyectoSocial();
			
		}else if(e.getActionCommand().equals("ProyectoInfraestructuras")){
			proyectoInfra();
			
		}else {
			frame.getPanelBienvenida().setVisible(true);
			this.panel.setVisible(false);
		}
		
		
	}
	
	
	
	public void cancelar() {
		ProyectosPanel pProyecto = frame.getPanelProyectos();
		pProyecto.setVisible(true);
		this.panel.setVisible(false);
	}
	
	public void proyectoSocial() {
		this.panel.setSubPSocialVisible(true);
	}
	
	public void proyectoInfra() {
		this.panel.setSubPInfraVisible(true);
	}
}