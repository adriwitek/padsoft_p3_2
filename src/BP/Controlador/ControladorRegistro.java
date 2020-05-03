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
		
		if(e.getActionCommand().equals("Solicitar Registro")) {
			registro();
		}else {
			frame.getPanelBienvenida().setVisible(true);
			this.panel.setVisible(false);
		}
			
	}
	
	 
	
	//Funcion auxiliar
	private void registro() {
		// validar valores en la vista
				String NIF = panel.getNombreUsuario();
				String nombreUsuario = panel.getNombreUsuario();
				String password1 = panel.getPassword();
				String password2 = panel.getPassword2();

				
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
				Usuario u = modelo.solicitarRegistro(NIF, nombreUsuario, password1);
				if( null == u) {
					JOptionPane.showMessageDialog(panel,
							"El NIF o nombre de Usuario ya estan registrados.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				frame.getPanelAdmin().addSolicitudRegistro(u);
				JOptionPane.showMessageDialog(panel,
						"La solicitud de registro se ha enviado.", "OK", JOptionPane.INFORMATION_MESSAGE);
			
				// mostrar nueva vista
				BienvenidaPanel pBienv = frame.getPanelBienvenida();
				pBienv.setVisible(true);
				this.panel.setVisible(false);
	}
	
	
}
