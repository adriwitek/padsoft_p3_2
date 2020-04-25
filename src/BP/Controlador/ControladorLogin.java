package BP.Controlador;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import BP.Modelo.*;
import BP.Vista.*;


public class ControladorLogin implements ActionListener {

	private LoginPanel panel;
	private VentanaPrincipal frame;
	private Aplicacion modelo;

	public ControladorLogin(VentanaPrincipal frame ,Aplicacion modelo) {
		this.panel= frame.getPanelLogin();
		this.frame= frame;
		this.modelo=modelo;
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		
		// validar valores en la vista
		String nombreUsuario = panel.getNombreUsuario();
		String password = panel.getPassword();
		
		// modificar modelo

		
		// mostrar nueva vista

		
	}
	
	
	
}
