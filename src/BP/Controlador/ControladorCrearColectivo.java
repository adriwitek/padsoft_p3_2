package BP.Controlador;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import BP.Modelo.*;
import BP.Vista.*;

public class ControladorCrearColectivo implements ActionListener{
	private CrearColectivoPanel panel;
	private VentanaPrincipal frame;
	private Aplicacion modelo;
	
	public ControladorCrearColectivo(VentanaPrincipal frame ,Aplicacion modelo) {
		this.panel= frame.getPanelCrearColectivo();
		this.frame= frame;
		this.modelo=modelo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		 if(e.getActionCommand().equals("cancelar")) {
			Cancelar();
			
		}else if(e.getActionCommand().equals("finalizar")) {
			Finalizar();
		}else {
			frame.getPanelBienvenida().setVisible(true);
			this.panel.setVisible(false);
		}	
		
	}
	
	public void Cancelar() {
		
	}
	
	public void Finalizar() {
		
	}
}
