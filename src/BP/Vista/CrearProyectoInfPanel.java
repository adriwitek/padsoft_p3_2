package BP.Vista;

import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;

import BP.Controlador.ControladorCrearProyectoInf;
import BP.Controlador.ControladorUsuario;
import BP.Modelo.Aplicacion;

public class CrearProyectoInfPanel extends JPanel{
	
	private JLabel nombreProyecto;
	private JTextField textNombreProyecto;
	private JLabel descripcionCorta;
	private JTextField textDescripcionCorta;
	private JLabel descripcionLarga;
	private JTextField textDescripcionLarga;
	private JLabel financiacion;
	private JTextField textFinanciacion;
	private JLabel introduceElNombreArchivoPNG;
	private JLabel textIntroduceElNombreArchivoPNG;
	private JLabel introduceElNombreArchivoPNG2;
	private JLabel textIntroduceElNombreArchivoPNG2;
	private JButton atras;
	private JButton finalizar;
	
	public HashSet<String> distritos;
	private DefaultListModel distritosModelo;
	private JList lista; 
	private JScrollPane scroll;
	
	private JPanel subPInfra;

	
	/**
	 * Este es el constructor de CrearProyectoInfPanel, contiene subP1, ademas contiene toda la creacion e introduccion de elmentos-objetos
	 * en el panel subP1
	 */

	private JButton botonAbrirImg;
	private JButton botonAbrirCroquis;

	private JFileChooser f1;
	private JFileChooser f2 ;
	

	public CrearProyectoInfPanel() {
		
		this.setLayout(new FlowLayout());
		this.nombreProyecto = new JLabel("Nombre del proyecto:");
		this.textNombreProyecto = new JTextField(10);
		this.descripcionCorta = new JLabel("Descripcion Corta: ");
		this.textDescripcionCorta = new JTextField(10);
		this.descripcionLarga = new JLabel("Descripcion Larga: ");
		this.textDescripcionLarga = new JTextField(10);
		this.financiacion = new JLabel("Financiacion necesaria: ");
		this.textFinanciacion = new JTextField(10);
		
		this.introduceElNombreArchivoPNG = new JLabel("Introduce la Imagen");
		this.textIntroduceElNombreArchivoPNG =  new JLabel("");
		
		this.introduceElNombreArchivoPNG2 = new JLabel("Introduce el Croquis");
		this.textIntroduceElNombreArchivoPNG2 = new JLabel("");
		this.atras = new JButton("Atras");
		this.finalizar = new JButton("Finalizar");
		this.botonAbrirImg = new JButton("Abrir Imagen");
	    this.botonAbrirCroquis =  new JButton("Abrir Coquis");
		
	  
        this.f1 = new JFileChooser();
        this.f2 = new JFileChooser();
	    
		distritos = Aplicacion.getInstancia().getDistritos();
		distritosModelo = new DefaultListModel(); 
		for(String d : distritos) {
			distritosModelo.addElement(d);
		}
		this.lista = new JList(distritosModelo);
		this.scroll = new JScrollPane(this.lista);
		
		subPInfra = new JPanel(new FlowLayout());
		subPInfra.add(nombreProyecto);
		subPInfra.add(textNombreProyecto);
		subPInfra.add(descripcionCorta);
		subPInfra.add(textDescripcionCorta);
		subPInfra.add(descripcionLarga);
		subPInfra.add(textDescripcionLarga);
		subPInfra.add(financiacion);
		subPInfra.add(textFinanciacion);
		
		//imagen
		subPInfra.add(introduceElNombreArchivoPNG);
		subPInfra.add(textIntroduceElNombreArchivoPNG);
		subPInfra.add(this.botonAbrirImg);
		//croquis
		subPInfra.add(introduceElNombreArchivoPNG2);
		subPInfra.add(textIntroduceElNombreArchivoPNG2);
		subPInfra.add(this.botonAbrirCroquis);
		
		subPInfra.add(lista);
		subPInfra.add(atras);
		subPInfra.add(finalizar);
		this.lista.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

	
		
		this.add(subPInfra);

	}
	/**
	 * Esta es la funcion setControlador, se encarga de permitir que algunos de los objetos que hemos introducido en el panel
	 * tengan una funcionalidad(es para objetos como botones, listas, etc)
	 * @param c controlador especifico en el que se encuentra la funcionalidad de los objetos de este panel
	 */
	public void setControlador(ControladorCrearProyectoInf c) {

		
		atras.addActionListener(c);
		finalizar.addActionListener(c);
		this.lista.addListSelectionListener(c);
		this.botonAbrirImg.addActionListener(c);
		this.botonAbrirCroquis.addActionListener(c);
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
	 * Esta funcion devuelve el nombre del archivo .png (foto) indicado en el proyecto
	 * @return the string textIntroduceElNombreArchivoPNG nombre completo foto
	 */
	public String getNombreArchivoPNG() {
		return this.textIntroduceElNombreArchivoPNG.getText();
	}
	/**
	 *  Esta funcion devuelve el nombre del archivo .png (foto) indicado en el proyecto
	 * @return the string textIntroduceElNombreArchivoPNG2 nombre completo foto
	 */
	public String getNombreArchivoPNG2() {
		return this.textIntroduceElNombreArchivoPNG2.getText();
	}
	

	public JFileChooser getf1() {
		return this.f1;
	}
	
	public JFileChooser getf2() {
		return this.f2;
	}
	
	
	public void setPathImagen(String s) {
		this.textIntroduceElNombreArchivoPNG.setText("OK");
	}
	
	public void setPathCroquis(String s) {
		this.textIntroduceElNombreArchivoPNG2.setText("OK");
	}
	
}
