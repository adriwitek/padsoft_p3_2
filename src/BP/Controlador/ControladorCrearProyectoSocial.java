package BP.Controlador;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import BP.Modelo.*;
import BP.Vista.*;

public class ControladorCrearProyectoSocial implements ActionListener {

	private CrearProyectoSocialPanel panel;
	private VentanaPrincipal frame;
	private Aplicacion modelo;
	public ControladorCrearProyectoSocial(VentanaPrincipal frame ,Aplicacion modelo) {
		this.panel= frame.getPanelCrearProyectoSocial();
		this.frame= frame;
		this.modelo=modelo;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
