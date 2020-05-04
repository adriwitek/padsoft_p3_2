package BP.Vista;

import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;

import javax.swing.*;

import BP.Controlador.ControladorProyectos;
import BP.Modelo.Proyecto;

public class ProyectosPanel extends JPanel {
	private JPanel subP1;

	private JLabel labelProyectos;
	private JLabel labelProyectosAp;
	private JButton botonActualizar;
	private JButton crearProyecto;
	private JButton detallesP;
	private JButton detallesAp;
	@SuppressWarnings("rawtypes")
	private DefaultListModel proyectosM;
	@SuppressWarnings("rawtypes")
	private JList tusProyectos;
	private JScrollPane scrollP;
	
	@SuppressWarnings("rawtypes")
	private DefaultListModel proyectosApM;
	@SuppressWarnings("rawtypes")
	private JList proyectosAp;
	private JScrollPane scrollAp;
	private JButton informePopularidad;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ProyectosPanel() {
		this.setLayout(new BorderLayout());


		subP1 = new JPanel(new GridLayout(3,2));
		//tus proyectos
		this.botonActualizar = new JButton("Actualizar");
		this.crearProyecto = new JButton("crearProyecto");
		this.detallesP = new JButton("Detalles");
		JPanel pListaTusProyectos = new JPanel(new GridLayout(3,1));
		this.proyectosM = new DefaultListModel();
		this.tusProyectos = new JList(proyectosM);
		this.scrollP = new JScrollPane(this.tusProyectos);
		this.labelProyectos = new JLabel("Tus proyectos");
		this.tusProyectos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		pListaTusProyectos.add(labelProyectos);
		pListaTusProyectos.add(detallesP);
		pListaTusProyectos.add(crearProyecto);
		this.scrollP.setRowHeaderView(pListaTusProyectos);
		
		//proyectos que apoyas
		JPanel pListaProyectosAp = new JPanel(new GridLayout(3,1));
		this.detallesAp = new JButton("Detalles.");
		this.proyectosApM = new DefaultListModel();
		this.proyectosAp = new JList(proyectosApM);
		this.scrollAp = new JScrollPane(this.proyectosAp);
		this.labelProyectosAp = new JLabel("Apayando :");
		this.proyectosAp.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		pListaProyectosAp.add(labelProyectosAp);
		pListaProyectosAp.add(detallesAp);
		this.scrollAp.setRowHeaderView(pListaProyectosAp);
		subP1.add(botonActualizar);
		subP1.add(scrollP);
		subP1.add(scrollAp);
		this.add(subP1);

	}

	public void setControlador(ControladorProyectos c) {
		botonActualizar.addActionListener(c);
		crearProyecto.addActionListener(c);
		tusProyectos.addListSelectionListener(c.getControllerTusProyectos());
		proyectosAp.addListSelectionListener(c.getControllerProyectosAp());
		detallesP.addActionListener(c);
		detallesAp.addActionListener(c);
	}

	public void setTusProyectos(HashSet<Proyecto> proyectos) {
		proyectosM.clear();
		for(Proyecto p: proyectos) {
			proyectosM.addElement(p);
		}
	}
	public void setProyectosAp(HashSet<Proyecto> proyectos) {
		proyectosM.clear();
		for(Proyecto p: proyectos) {
			proyectosM.addElement(p);
		}
	}
	public JPanel getSubPanel() {
		return this.subP1;
	}
}

