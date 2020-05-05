package BP.Controlador;

import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;
import java.io.File;       
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import BP.Modelo.*;
import BP.Vista.*;
/** 
* 
* @author Adián Rubio adrian.rubiop@estudiante.uam.es, Guillermo Solla guillermo.solla@estudiante.uam.es 
* y Diego Tapia diego.tapias@estudiante.uam.es
*/
public class ControladorCrearProyectoInf implements ActionListener, ListSelectionListener {

	private CrearProyectoInfPanel panel;
	private VentanaPrincipal frame;
	private Aplicacion modelo;
	private HashSet<String> distritos;

	/**
	 * Este es el constructo de ControladorCrearProyectoInf
	 * @param frame ventana de la aplicacion
	 * @param modelo aplicacion que hemos desarrollado
	 */

	private Proponente proponente;

	public ControladorCrearProyectoInf(VentanaPrincipal frame ,Aplicacion modelo) {
		this.panel= frame.getPanelCrearProyectoInf();
		this.frame= frame;
		this.modelo=modelo;
		this.distritos = new HashSet<String>();
	}
	 
	/**
	 * Esta funcion se encargara de que al interactuar con el programa(dar a un boton, escribir en un texto, seleccionar un valor de una list, etc)
	 * se realice la accion correspondiente.
	 * @param e es el actionEvent
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Atras")) {
			Atras();
		}else if(e.getActionCommand().equals("Finalizar")) {
			Finalizar();
		}else if(e.getActionCommand().equals("Abrir Imagen")) {

			JFileChooser f =this.panel.getf1();
			int result = f.showOpenDialog(frame);
			if (result == JFileChooser.APPROVE_OPTION) {
			    File selectedFile = f.getSelectedFile();
			    panel.setPathImagen(selectedFile.getAbsolutePath());
			}
			
		}else if(e.getActionCommand().equals("Abrir Coquis")) {

			JFileChooser f =this.panel.getf2();
			int result = f.showOpenDialog(frame);
			if (result == JFileChooser.APPROVE_OPTION) {
			    File selectedFile = f.getSelectedFile();
			    panel.setPathCroquis(selectedFile.getAbsolutePath());
			}
		
		}
		
		
	}
	
	/** 
	 * Esta funcion crea la funcionalidad para el boton atras
	 * de tal manera que la aplicacion se iria al panel CrearProyectoPanel
	 */
	public void Atras(){
		CrearProyectoPanel cProyectos = frame.getPanelCrearProyecto();
		cProyectos.setVisible(true);
		this.panel.setVisible(false);
	}
	
	/**
	 * Esta funcion crea la funcionalidad para el boton finalizar
	 * de tal manera que se crearia un proyecto de infraestructura
	 */
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
	
	/**
	 * Esta funcion crea la funcionalidad para el boton de InfoFoto
	 * muestra unas directrices para introducir una foto en un proyecto
	 */
	public void InfoFoto() {
		JOptionPane.showMessageDialog(panel,
				"Introduce el nombre del archivo .png especifico de la carpeta (img). Si no se ha introducido un .png en esta carpeta itroduzcalo antes de introducir su nombre ", "OK", JOptionPane.INFORMATION_MESSAGE);
		return;
	}

	/**
	 * Esta funcion se encarga de añadir a los distritos lista.getSelectedValuesList()
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(!e.getValueIsAdjusting()) {
			this.distritos.clear();
			JList lista = (JList) e.getSource();
			if(!lista.getSelectedValuesList().isEmpty()) distritos.addAll(lista.getSelectedValuesList());
		}
		
	}


	public void setProponente(Proponente proponente) {
		this.proponente = proponente;
		
	}
	
}
