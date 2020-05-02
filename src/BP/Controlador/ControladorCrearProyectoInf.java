package BP.Controlador;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import BP.Modelo.*;
import BP.Vista.*;

public class ControladorCrearProyectoInf implements ActionListener {

	private CrearProyectoInfPanel panel;
	private VentanaPrincipal frame;
	private Aplicacion modelo;
	public ControladorCrearProyectoInf(VentanaPrincipal frame ,Aplicacion modelo) {
		this.panel= frame.getPanelCrearProyectoInf();
		this.frame= frame;
		this.modelo=modelo;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
