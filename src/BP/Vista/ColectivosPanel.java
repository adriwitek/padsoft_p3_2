package BP.Vista;

import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;

import javax.swing.*;

import BP.Controlador.ControladorColectivos;
import BP.Controlador.ControladorUsuario;
import BP.Modelo.Colectivo;
import BP.Modelo.Proyecto;

public class ColectivosPanel extends JPanel{
	private JPanel subP1;
	private JButton crearColectivo;
	private JButton botonApoyarColec;
	private JButton crearSubcolectivo;
	private JButton botonActualizar;
	
	private DefaultListModel proyectosM;
	private JList listaProyectos;
	private JScrollPane scrollProyectos;
	
	private DefaultListModel colectivosM; 
	private JList listaColectivos;
	private JScrollPane scrollColectivos;
	
	public ColectivosPanel() {
		this.setLayout(new BorderLayout());
		
		subP1 = new JPanel(new GridLayout(4,3));
		
		this.botonApoyarColec = new JButton("Apoyar como representante de colectivo");
		this.crearSubcolectivo = new JButton("Crear nuevo subColectivo");
		this.crearColectivo = new JButton("crearColectivo");
		this.proyectosM = new DefaultListModel();
		this.listaProyectos = new JList(proyectosM);
		this.scrollProyectos = new JScrollPane(this.listaProyectos);
		this.colectivosM = new DefaultListModel();
		this.listaColectivos = new JList(colectivosM);
		this.scrollColectivos = new JScrollPane(this.listaColectivos);
		this.botonActualizar = new JButton("Actualizar");
		
		subP1.add(botonActualizar);
		subP1.add(crearColectivo);
		subP1.add(scrollProyectos);
		subP1.add(scrollColectivos);
		subP1.add(botonApoyarColec);
		this.add(subP1);
	}
	
	public void setControlador(ControladorColectivos c) {

		crearColectivo.addActionListener(c);
		this.listaProyectos.addListSelectionListener(c.getControllerProyectosApoyables());
		this.listaColectivos.addListSelectionListener(c.getControllerTusColectivos());
		this.botonApoyarColec.addActionListener(c);
		this.botonActualizar.addActionListener(c);
	}
	public JPanel getSubPanel() {
		return this.subP1;
	}
	
	public void setListaProyectos(HashSet<Proyecto> proyectosAp) {
		proyectosM.clear();
		for(Proyecto p: proyectosAp ) {
			this.proyectosM.addElement(p);
		}
	}
	
	public void setListaColectivos(HashSet<Colectivo> colectivos) {
		colectivosM.clear();
		for(Colectivo c: colectivos ) {
			this.colectivosM.addElement(c);
		}
	}
}
