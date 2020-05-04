package BP.Vista;

import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;

import javax.swing.*;

import BP.Controlador.ControladorProyectos;
import BP.Modelo.Proyecto;

public class ProyectosPanel extends JPanel {
	private JPanel subP1;
	
	private JLabel etiquetaNombre;
	private JLabel etiquetaNIF;
	private JLabel nombre;
	private JLabel nIF;

	private JButton botonActualizar;
	private JButton crearProyecto;
	private JButton detallesP;
	
	@SuppressWarnings("rawtypes")
	private DefaultListModel proyectosM;
	@SuppressWarnings("rawtypes")
	private JList tusProyectos;
	private JScrollPane scrollP;
	
	private JButton informePopularidad;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ProyectosPanel() {
		this.setLayout(new BorderLayout());
		
		
			 subP1 = new JPanel(new GridLayout(3,2));
		
		   this.botonActualizar = new JButton("Actualizar");
		   this.crearProyecto = new JButton("crearProyecto");
		   this.detallesP = new JButton("Detalles");
		   
		   this.proyectosM = new DefaultListModel();
		   this.tusProyectos = new JList(proyectosM);
		   this.scrollP = new JScrollPane(this.tusProyectos);
		   this.tusProyectos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		   subP1.add(crearProyecto);
		   subP1.add(botonActualizar);
		   subP1.add(scrollP);
		   subP1.add(detallesP);
		   this.add(subP1);

	}
	
	public void setControlador(ControladorProyectos c) {
		botonActualizar.addActionListener(c);
	    crearProyecto.addActionListener(c);
	    tusProyectos.addListSelectionListener(c);
	    detallesP.addActionListener(c);
	}

	public void setNombre(JLabel nombre) {
	    this.nombre = nombre;
	}

	public void setNIF(JLabel nIF) {
	    this.nIF = nIF;
	}
	public void setTusProyectos(HashSet<Proyecto> proyectos) {
		proyectosM.clear();
		for(Proyecto p: proyectos) {
			proyectosM.addElement(p);
		}
	}
	public JPanel getSubPanel() {
		return this.subP1;
	}
}

