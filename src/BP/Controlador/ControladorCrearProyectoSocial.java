package BP.Controlador;

import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;

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
		double num;
		
		
		if(Nombre.equals("") || DescripcionC.equals("") || DescripcionL.equals("") || GSocial.equals("") || Financiacion.equals("")) {
			JOptionPane.showMessageDialog(panel,
					"Faltan campos obligatorios por rellenar.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(DescripcionC.length() > 50 && DescripcionL.length() > 500) {
			JOptionPane.showMessageDialog(panel,
					"Descripcion larga y descripcion corta demasiado largas (Solo 50 caracteres DescC, solo 500 caracteres DescL) ", "Error", JOptionPane.ERROR_MESSAGE);
			return;
			
		}else if(DescripcionC.length() > 50) {
			JOptionPane.showMessageDialog(panel,
					"Descripcion corta demasiado larga (Solo 50 caracteres) ", "Error", JOptionPane.ERROR_MESSAGE);
			return;
			
		}else if(DescripcionL.length() > 500) {
			JOptionPane.showMessageDialog(panel,
					"Descripcion larga demasiado extensa (Solo 500 caracteres) ", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		try {
			num = Double.parseDouble(Financiacion);

		}catch(Exception e) {
			JOptionPane.showMessageDialog(panel,
					"Se ha introducido un caracter ilegal en el campo financiacion ", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		
		ProyectoSocial PS = modelo.crearProyectoSocial(p, Nombre, DescripcionL, DescripcionC, num, GSocial, Nacional);
		JOptionPane.showMessageDialog(panel,
				"Se ha creado el proyecto solicitado.", "OK", JOptionPane.INFORMATION_MESSAGE);
		return;
	}
}
