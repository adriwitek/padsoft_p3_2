package BP.Controlador;

import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import BP.Modelo.*;
import BP.Vista.*;

public class ControladorCrearProyectoInf implements ActionListener, ListSelectionListener {

	private CrearProyectoInfPanel panel;
	private VentanaPrincipal frame;
	private Aplicacion modelo;
	private HashSet<String> distritos;
	private Proponente proponente;
	public ControladorCrearProyectoInf(VentanaPrincipal frame ,Aplicacion modelo) {
		this.panel= frame.getPanelCrearProyectoInf();
		this.frame= frame;
		this.modelo=modelo;
		
	}
	 
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("infoFoto")) {
			InfoFoto();
		}else if(e.getActionCommand().equals("Atras")) {
			Atras();
			
		}else if(e.getActionCommand().equals("Finalizar")) {
			Finalizar();
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
		String Financiacion = panel.getFinanciacion();
		String Foto = panel.getNombreArchivoPNG();
		String Foto2 = panel.getNombreArchivoPNG2();
		Proponente p = this.proponente;
		//HashSet<String> distrito = panel.getDistrito;
		double num;
		
		
		if(Nombre.equals("") || DescripcionC.equals("") || DescripcionL.equals("") ||  Foto.equals("") ||  Financiacion.equals("")) {
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
		if(distritos == null || distritos.isEmpty()) {
			JOptionPane.showMessageDialog(panel,
					"Seleccione al menos un distrito ", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		
		ProyectoInfraestructura PI = modelo.crearProyectoInfraestructura( p,Nombre, DescripcionL, DescripcionC ,num ,Foto ,Foto2, distritos);
		
		JOptionPane.showMessageDialog(panel,
				"Se ha creado el proyecto solicitado.", "OK", JOptionPane.INFORMATION_MESSAGE);
		return;
	}
	
	public void InfoFoto() {
		JOptionPane.showMessageDialog(panel,
				"Introduce el nombre del archivo .png especifico de la carpeta (img). Si no se ha introducido un .png en esta carpeta itroduzcalo antes de introducir su nombre ", "OK", JOptionPane.INFORMATION_MESSAGE);
		return;
	}


	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(!e.getValueIsAdjusting()) {
			JList lista = (JList) e.getSource();
	    	distritos.addAll(lista.getSelectedValuesList());
		}
		
	}


	public void setProponente(Proponente proponente) {
		this.proponente = proponente;
		
	}
	
}
