package BP.Vista;

import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;

import javax.swing.*;

import BP.Modelo.Aplicacion;



public class CrearProyectoSocialPanel extends JPanel{

	private JLabel nombreProyecto;
	private JTextField textNombreProyecto;
	private JLabel descripcionCorta;
	private JTextField textDescripcionCorta;
	private JLabel descripcionLarga;
	private JTextField textDescripcionLarga;
	private JLabel financiacion;
	private JTextField textFinanciacion;
	private JButton atras;
	private JButton finalizar;

	private JLabel grupoSocial;
	private JTextField textGrupoSocial;
	
	private JPanel subP1;
	private JPanel subPSocial; 
	private JRadioButton nacional;
	private JLabel aux;
	/**
	 * Este es el contructor de CrearProyectoSocialPanel, en el se encuentra el panel subP1, ademas se encontrara la creacion e introduccion de
	 * todos los objetos-elementos en el panel subP1
	 */
	public CrearProyectoSocialPanel() {
		this.setLayout(new BorderLayout());
		this.nombreProyecto = new JLabel("Nombre del proyecto:");
		this.textNombreProyecto = new JTextField(30);
		this.descripcionCorta = new JLabel("Descripcion Corta: ");
		this.textDescripcionCorta = new JTextField(10);
		this.descripcionLarga = new JLabel("Descripcion Larga: ");
		this.textDescripcionLarga = new JTextField(10);
		
		this.financiacion = new JLabel("Financiacion necesaria: ");
		this.textFinanciacion = new JTextField(10);
		this.grupoSocial = new JLabel("Grupo Social: ");
		this.textGrupoSocial = new JTextField(10);
		this.nacional = new JRadioButton("Proyecto nacional");
		this.aux = new JLabel("");
		this.atras = new JButton("atras");
		this.finalizar = new JButton("finalizar");
		
		subPSocial = new JPanel(new GridLayout(10,1));
		subPSocial.add(nombreProyecto);
		subPSocial.add(textNombreProyecto);
		subPSocial.add(descripcionCorta);
		subPSocial.add(textDescripcionCorta);
		subPSocial.add(descripcionLarga);
		subPSocial.add(textDescripcionLarga);
		subPSocial.add(financiacion);
		subPSocial.add(textFinanciacion);
		subPSocial.add(grupoSocial);
		subPSocial.add(textGrupoSocial);
		subPSocial.add(nacional);
		subPSocial.add(aux);
		
		subPSocial.add(atras);
		subPSocial.add(finalizar);
		
		this.add(subPSocial);

	}
	
	/**
	 * Esta es la funcion setControlador, se encarga de permitir que algunos de los objetos que hemos introducido en el panel
	 * tengan una funcionalidad(es para objetos como botones, listas, etc)
	 * @param c  es el campo actionListener que nos permitira utilizar la funcionalidad correcta del controlador que le corresponda a este panel
	 */
	public void setControlador(ActionListener c) {	
		atras.addActionListener(c);
		finalizar.addActionListener(c);
		
	}

	/**
	 * Esta funcion devuelve el nombre del proyecto que se quiere crear
	 * @return the string textNombreProyecto nombre del proyecto
	 */
	public String getNombre() {
		return this.textNombreProyecto.getText();
	}
	/**
	 * Esta funcion devuelve la descripcion corta del proyecto que se quiere crear
	 * @return the string textDescripcionCorta descripcion corta proyecto
	 */
	public String getDescripcionC() {
		return this.textDescripcionCorta.getText();
	}
	/**
	 * Esta funcion devuelve la descripcion larga del proyecto que se quiere crear
	 * @return the string textDescripcionLarga descripcion larga proyecto
	 */
	public String getDescripcionL() {
		return this.textDescripcionLarga.getText();
	}
	/**
	 * Esta funcion devuelve la financiacion que el usuario ha indicado en la creacion del proyecto
	 * @return the String textFinanciacion financiacion proyecto
	 */
	public String getFinanciacion() {
		return this.textFinanciacion.getText();
	}
	/**
	 * Esta funcion devuelve el grupo o grupos sociales a los que va referido este proyecto
	 * @return the string textGrupoSocial grupo/s social del proyecto
	 */
	public String getGrupoSocial() {
		return this.textGrupoSocial.getText();
	}
	/**
	 * Esta funcion nos dice sie el proyecto es nacional o no
	 * @return the true or false, true si es nacional y false si no
	 */
	public boolean getNacional() {
		return this.nacional.isSelected();
	}
}
