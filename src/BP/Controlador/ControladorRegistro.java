package BP.Controlador;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import BP.Modelo.*;
import BP.Vista.*;



public class ControladorRegistro implements ActionListener {
	
	
	private RegistroPanel panel;
	private VentanaPrincipal frame;
	private Aplicacion modelo;
	

	public ControladorRegistro(VentanaPrincipal frame ,Aplicacion modelo) {
		this.panel= frame.getPanelRegistro();
		this.frame= frame;
		this.modelo=modelo;
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		// validar valores en la vista
		String NIF = panel.getNombreUsuario();
		String nombreUsuario = panel.getNombreUsuario();
		String password1 = panel.getPassword();
		String password2 = panel.getPassword();

		
		if(!password1.equals(password2)) {
			JOptionPane.showMessageDialog(panel,
					"Las claves no coinciden.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
			
		}else if (nombreUsuario.equals("") || password1.equals("") ||  NIF.equals("")) {
			JOptionPane.showMessageDialog(panel,
					"Debe introducir un nombre y una contraseña.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		
		
		// modificar modelo
		if( null == modelo.solicitarRegistro(NIF, nombreUsuario, password1)) {
			JOptionPane.showMessageDialog(panel,
					"El NIF o nombre de Usuario ya estan registrados.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		
		JOptionPane.showMessageDialog(panel,
				"La solicitud de registro se ha enviado.", "OK", JOptionPane.INFORMATION_MESSAGE);
	
		// mostrar nueva vista
		BienvenidaPanel pBienv = frame.getPanelBienvenida();
		pBienv.setVisible(true);
		this.panel.setVisible(false);
		
	}
	
	
}
