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
		
		if(e.getActionCommand().equals("atras")) {
			Atras();
			
		}else if(e.getActionCommand().equals("finalizar")) {
			Finalizar();
		}else {
			frame.getPanelBienvenida().setVisible(true);
			this.panel.setVisible(false);
		}		
	}
	
	public void Atras(){
		CrearProyectoPanel cProyectos = frame.getPanelCrearProyecto();
		cProyectos.setVisible(true);
		this.panel.setVisible(false);
	}
	
	
	public void Finalizar() { 
		String Nombre = panel.getNombre();
		String DescripcionC = panel.getDescripcionC();
		String DescripcionL = panel.getDescripcionL();
		String GSocial = panel.getGrupoSocial();
		String Financiacion = panel.getFinanciacion();
		Boolean Nacional = panel.getNacional();
		Proponente p = modelo.getUsuarioConectado();
		
		
		
		if(Nombre.equals("") || DescripcionC.equals("") || DescripcionL.equals("") || GSocial.equals("") || Financiacion.equals("")) {
			JOptionPane.showMessageDialog(panel,
					"Faltan campos obligatorios por rellenar.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		
		
		//ProyectoSocial PS = modelo.crearProyectoSocial(p, Nombre, DescripcionL, DescripcionC, Financiacion, GSocial, Nacional);
		
		/*if(!PS) {
			JOptionPane.showMessageDialog(panel,
					"No ha podido crear el proyecto. ", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}*/
		
		JOptionPane.showMessageDialog(panel,
				"Se ha creado el proyecto solicitado.", "OK", JOptionPane.INFORMATION_MESSAGE);
		return;
	}
}
