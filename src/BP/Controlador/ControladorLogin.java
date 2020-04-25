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
	
		
		if(e.getActionCommand().equals("LogIn")) {
			login();

		}else {
			frame.getPanelBienvenida().setVisible(true);
			this.panel.setVisible(false);
		}
		
	}
	
	
	
	private void login() {
		
		// validar valores en la vista
		String nombreUsuario = panel.getNombreUsuario();
		String password = panel.getPassword();
		
		if (nombreUsuario.equals("") || password.equals("") ) {
			JOptionPane.showMessageDialog(panel,
					"Debe introducir un nombre y una contraseña.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		
		
		// modificar modelo
		if( !modelo.loginAdmin(nombreUsuario, password) && !!modelo.loginUser(nombreUsuario, password) ) {
			JOptionPane.showMessageDialog(panel,
					"Las credenciales son incorrectas.Intentalo de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		
	
		// mostrar nueva vista
		UsuarioPanel pUsuario = frame.getPanelUsuario();
		pUsuario.setVisible(true);
		this.panel.setVisible(false);
	}
	
	
}
