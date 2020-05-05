package BP.Controlador;

import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;

import javax.swing.*;
import BP.Modelo.*;
import BP.Vista.*;
/** 
* 
* @author Adián Rubio adrian.rubiop@estudiante.uam.es, Guillermo Solla guillermo.solla@estudiante.uam.es 
* y Diego Tapia diego.tapias@estudiante.uam.es
*/
public class ControladorCrearProyectoSocial implements ActionListener {

	private CrearProyectoSocialPanel panel;
	private VentanaPrincipal frame;
	private Aplicacion modelo;

	
	/**
	 * Este es el constructor de ControladorCrearProyectoSocial
	 * @param frame ventana de la aplicacion
	 * @param modelo aplicacion que hemos desarrollado
	 */

	private Proponente proponente;

	public ControladorCrearProyectoSocial(VentanaPrincipal frame ,Aplicacion modelo) {
		this.panel= frame.getPanelCrearProyectoSocial();
		this.frame= frame;
		this.modelo=modelo;
	}
	/**
	 * Esta funcion se encargara de que al interactuar con el programa(dar a un boton, escribir en un texto, seleccionar un valor de una list, etc)
	 * se realice la accion correspondiente.
	 * @param e es el actionEvent
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("atras")) {
			atras();
			
		}else if(e.getActionCommand().equals("finalizar")) {
			finalizar();
		}else {
			frame.getPanelBienvenida().setVisible(true);
			this.panel.setVisible(false);
		}		
	}
	

	/**
	 * Esta funcion crea la funcionalidad del boton atras
	 * de tal manera que la aplicacion volveria a CrearProyectoPanel
	 */

	public void atras(){

		CrearProyectoPanel cProyectos = frame.getPanelCrearProyecto();
		cProyectos.setVisible(true);
		this.panel.setVisible(false);
	}
	

	/**
	 * Esta funcion se encarga de crear la funcionalidad del boton finalizar
	 * de tal manera que se crearia un proyecto social en la aplicacion
	 */

	
	public void finalizar() { 
		String Nombre = panel.getNombre();
		String DescripcionC = panel.getDescripcionC();
		String DescripcionL = panel.getDescripcionL();
		String GSocial = panel.getGrupoSocial();
		String Financiacion = panel.getFinanciacion();
		Boolean Nacional = panel.getNacional();
		Proponente p = this.proponente;
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
		
		
		 modelo.crearProyectoSocial(p, Nombre, DescripcionL, DescripcionC, num, GSocial, Nacional);
		JOptionPane.showMessageDialog(panel,
				"Se ha creado el proyecto solicitado.", "OK", JOptionPane.INFORMATION_MESSAGE);
		return;
	}
	public void setProponente(Proponente p) {
		this.proponente = p;
	}
}
