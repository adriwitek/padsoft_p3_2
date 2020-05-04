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
	private Proponente proponente;
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
			
		}
		
		
	}
	
	
	
	public void cancelar() {
		frame.getPanelUsuario().setVisible(true);
		this.panel.setVisible(false);
	}
	
	public void proyectoSocial() {
		CrearProyectoSocialPanel pProyectoSoc = frame.getPanelCrearProyectoSocial();
		frame.getControlador().getControladorCrearProyectoSocial().setProponente(proponente);
		pProyectoSoc.setVisible(true);
		this.panel.setVisible(false);
	}
	
	public void proyectoInfra() {
		CrearProyectoInfPanel pProyectoInf = frame.getPanelCrearProyectoInf();
		frame.getControlador().getControladorCrearProyectoInf().setProponente(proponente);
		pProyectoInf.setVisible(true);
		this.panel.setVisible(false);
	}
	public void setProponente(Colectivo c) {
		this.proponente = c;
	}
	public void setProponente(Usuario u) {
		this.proponente = u;
	}
	
}
 