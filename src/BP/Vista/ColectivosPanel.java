package BP.Vista;

import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;

import javax.swing.*;

import BP.Controlador.ControladorColectivos;
import BP.Controlador.ControladorUsuario;
import BP.Modelo.Colectivo;
import BP.Modelo.Proyecto;
/** 
* 
* @author Adián Rubio adrian.rubiop@estudiante.uam.es, Guillermo Solla guillermo.solla@estudiante.uam.es 
* y Diego Tapia diego.tapias@estudiante.uam.es
*/
public class ColectivosPanel extends JPanel{
	private JPanel subP1;
	private JButton crearColectivo;
	private JButton botonApoyarColec;
	private JButton crearSubcolectivo;
	private JButton botonActualizar;
	private JButton botonCrearProColec;
	private JButton detallesP;
	private JButton detallesPC;
	private JLabel labelProyectos;
	private JLabel labelColectivos;
	private DefaultListModel proyectosM;
	private JList listaProyectos;
	private JScrollPane scrollProyectos;
	private JLabel labelProyectosCol;
	private DefaultListModel colectivosM; 
	private JList listaColectivos;
	private JScrollPane scrollColectivos;
	private DefaultListModel proyectosCol; 
	private JList listaProyectosCol;
	private JScrollPane scrollProyectosCol;
	private JButton pedirFinanciacion;
	private JButton informePopularidad;
	/**
	 * Este es el constructor de ColectivoPanel, aqui se encuentra el panel correspondiente, ademas esta la creacion y introduccion 
	 * de los objetos en el panel correspondiente
	 */
	public ColectivosPanel() {
		this.setLayout(new BorderLayout());
		this.informePopularidad = new JButton("Pedir informe de popularidad");
		subP1 = new JPanel(new GridLayout(4,3));
		this.labelProyectos = new JLabel("Proyectos disponibles");
		this.labelColectivos = new JLabel("Tus colectivos");
		this.crearSubcolectivo = new JButton("Crear nuevo subColectivo");
		this.crearColectivo = new JButton("crearColectivo");
		//lista de proyectos apoyables
		
		JPanel pListaProAp = new JPanel(new GridLayout(3 ,1));
		this.detallesP = new JButton("DetallesPD");
		this.proyectosM = new DefaultListModel();
		this.listaProyectos = new JList(proyectosM);
		this.scrollProyectos = new JScrollPane(this.listaProyectos);
		this.botonApoyarColec = new JButton("Apoyar como representante de colectivo");
		pListaProAp.add(detallesP);
		pListaProAp.add(labelProyectos);
		pListaProAp.add(botonApoyarColec);
		this.scrollProyectos.setRowHeaderView(pListaProAp);
		
		//lista de tus colectivos
		JPanel pListaCol = new JPanel(new GridLayout(2 ,1));
		this.botonCrearProColec = new JButton("Crear proyecto como representante de colectivo");
		this.colectivosM = new DefaultListModel();
		this.listaColectivos = new JList(colectivosM);
		this.scrollColectivos = new JScrollPane(this.listaColectivos);
		pListaCol.add(labelColectivos);
		pListaCol.add(crearColectivo);
		this.scrollColectivos.setRowHeaderView(pListaCol);
		
		//lista de tus proyectos como representante
		this.pedirFinanciacion = new JButton("Pedir Financiacion");
		JPanel pListaProCol = new JPanel(new GridLayout(5 ,1));
		this.detallesPC = new JButton("DetallesPC");
		this.labelProyectosCol = new JLabel("Proyectos de: ");
		this.proyectosCol = new DefaultListModel();
		this.listaProyectosCol = new JList(proyectosCol);
		this.scrollProyectosCol = new JScrollPane(this.listaProyectosCol);
		this.botonActualizar = new JButton("Actualizar");
		pListaProCol.add(labelProyectosCol);
		pListaProCol.add(pedirFinanciacion);
		pListaProCol.add(botonCrearProColec);
		pListaProCol.add(detallesPC);
		pListaProCol.add(informePopularidad);
		this.scrollProyectosCol.setRowHeaderView(pListaProCol);
		
		subP1.add(botonActualizar);
		subP1.add(scrollProyectos);
		subP1.add(scrollColectivos);
		subP1.add(scrollProyectosCol);
		this.add(subP1);
	}
	/**
	 * Esta es la funcion setControlador, se encarga de permitir que algunos de los objetos que hemos introducido en el panel
	 * tengan una funcionalidad(es para objetos como botones, listas, etc)
	 * @param c es el controlador de colectivos, se le llama para especificar en que controlador esta la funcionalidad de los objetos
	 */
	public void setControlador(ControladorColectivos c) {

		crearColectivo.addActionListener(c);
		this.listaProyectos.addListSelectionListener(c.getControllerProyectosApoyables());
		this.listaColectivos.addListSelectionListener(c.getControllerTusColectivos());
		this.listaProyectosCol.addListSelectionListener(c.getControllerTusProyectos());
		this.botonApoyarColec.addActionListener(c);
		this.botonActualizar.addActionListener(c);
		this.botonCrearProColec.addActionListener(c);
		this.detallesP.addActionListener(c);
		this.detallesPC.addActionListener(c);
		pedirFinanciacion.addActionListener(c);
		informePopularidad.addActionListener(c);
	}
	
	/**
	 * Esta funcion nos devuelve el panel de colectivos
	 * @return the subP1 es el panel de colectivos
	 */
	public JPanel getSubPanel() {
		return this.subP1;
	}
	/**
	 * Esta funcion introducira una lista de proyectos en el panel de colectivo
	 * @param proyectosAp proyectoap
	 */
	public void setListaProyectos(HashSet<Proyecto> proyectosAp) {
		proyectosM.clear();
		for(Proyecto p: proyectosAp ) {
			this.proyectosM.addElement(p);
		}
	}
	/**
	 * Esta funcion introducira una lista de colectivos en el panel de colectivos
	 * @param colectivos lista de colectivos que se pretende introducir 
	 */
	public void setListaColectivos(HashSet<Colectivo> colectivos) {
		colectivosM.clear();
		for(Colectivo c: colectivos ) {
			this.colectivosM.addElement(c);
		}
	}
	
	public void setListaProyectosCol(HashSet<Proyecto> proyectos) {
		proyectosCol.clear();
		for(Proyecto p: proyectos) {
			this.proyectosCol.addElement(p);
		}
	}
	public void setLabelProyectosCol(String cad) {
		this.labelProyectosCol.setText(cad);
	}
}
