package BP.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import BP.Modelo.Aplicacion;
import BP.Vista.LoginPanel;
import BP.Vista.UsuarioPanel;
import BP.Vista.VentanaPrincipal;
import BP.Modelo.*;
import BP.Vista.*;


public class ControladorBienvenida implements ActionListener{
	
	
	private BienvenidaPanel panel;
	private VentanaPrincipal frame;
	private Aplicacion modelo;
	
	
	public ControladorBienvenida(VentanaPrincipal frame ,Aplicacion modelo) {
		this.panel= frame.getPanelBienvenida();
		this.frame= frame;
		this.modelo=modelo;
	}

 
	@Override
	public void actionPerformed(ActionEvent e) {

		// mostrar nueva vista
		if(e.getActionCommand().equals("LogIn")) {
			frame.getPanelLogin().setVisible(true);
			this.panel.setVisible(false);

		}else {//Registro
			frame.getPanelRegistro().setVisible(true);
			this.panel.setVisible(false);
		}		
		
	}
	

}
