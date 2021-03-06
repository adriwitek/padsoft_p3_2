package BP.Vista;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/** 
* 
* @author Adi�n Rubio adrian.rubiop@estudiante.uam.es, Guillermo Solla guillermo.solla@estudiante.uam.es 
* y Diego Tapia diego.tapias@estudiante.uam.es
*/
public class CrearColectivoPanel extends JPanel {
	
	private JLabel nombreColectivo;
	private JTextField textNombreColectivo;
	private JLabel nombreDescripcion;
	private JTextField textNombreDescripcion;
	private JButton cancelar;
	private JButton finalizar;
	
	//paneles
	private JPanel subP1;
	
	/**
	 * Este es el controlador de CrearColectivoPanel, el el se encuentra el panel subP1, ademas nos encontraremos la creacion e introduccion de todos los 
	 * objetos en este panel (botones, listas, labels, etc)
	 */
	public CrearColectivoPanel() {
		this.setLayout(new BorderLayout());
		subP1 = new JPanel(new GridLayout(10,10));
		
		this.nombreColectivo = new JLabel("Nombre colectivo: ");
		this.textNombreColectivo = new JTextField(15);
		
		this.nombreDescripcion = new JLabel("Descripcion: ");
		this.textNombreDescripcion = new JTextField(15);
		
		this.cancelar = new JButton("cancelar");
		this.finalizar = new JButton("finalizar");
		
		
		
		subP1.add(nombreColectivo);
		subP1.add(textNombreColectivo);
		subP1.add(nombreDescripcion);
		subP1.add(textNombreDescripcion);
		subP1.add(cancelar);
		subP1.add(finalizar);
		
		this.add(subP1);
	}
	
	/**
	 * Esta es la funcion setControlador, se encarga de permitir que algunos de los objetos que hemos introducido en el panel
	 * tengan una funcionalidad(es para objetos como botones, listas, etc)
	 * @param c llama al action listener especifico que contiene la funcionalidad de los objetos de esta funcion
	 */
	public void setControlador(ActionListener c) {
		cancelar.addActionListener(c);
		finalizar.addActionListener(c);
	}
	/**
	 * Esta funcion nos muestra el nombre del colectivo
	 * @return the String textNombreColectivo nombre del colectivo
	 */
	public String getNombreColectivo() {
		return this.textNombreColectivo.getText();
	}
	/**
	 * Esta funcion nos devuelve en un string la descripcion de un colectivo
	 * @return the String textNombreDescripcion descripcion de colectivo
	 */
	public String getDescripcion() {
		return this.textNombreDescripcion.getText();
	}
}
