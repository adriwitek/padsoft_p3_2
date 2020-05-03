package BP.Vista;

import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;

import javax.swing.*;

import BP.Controlador.ControladorUsuario;
import BP.Modelo.*;
public class UsuarioPanel extends JPanel {
	
	private JButton goColectivos;
	private JButton goProyectos;
	private JButton botonApoyarProyecto;
	private JButton botonSuscribirseColectivo;
	private JButton verDetallesProyecto;
	private JButton verDetallesColectivo;
	private JButton botonActualizar;
	
	private JLabel etiquetaUsuario;
	private JLabel nombreUsuario;
	private JLabel etiquetaNIF;
	private JLabel numeroNIF;
	
	private DefaultListModel proyectosM;
	private JList listaProyectos;
	private JScrollPane scrollProyectos;
	
	private DefaultListModel colectivosM; 
	private JList listaColectivos;
	private JScrollPane scrollColectivos;
	
	
	public UsuarioPanel() {
		this.setLayout(new BorderLayout());
		//SubPanel Usuario
		
		JPanel subP1 = new JPanel(new GridLayout(5,5));
		this.proyectosM  = new DefaultListModel ();
		this.colectivosM  = new DefaultListModel ();
		this.etiquetaNIF = new JLabel("NIF:");
		this.nombreUsuario = new JLabel("");
		this.etiquetaUsuario = new JLabel("Usuario:");
		this.numeroNIF = new JLabel("");
		this.goColectivos = new JButton("Colectivos");
		this.goProyectos = new JButton("Proyectos");
		this.botonActualizar = new JButton("Actualizar");
		this.listaProyectos = new JList(proyectosM);
		this.scrollProyectos = new JScrollPane(this.listaProyectos);
		this.listaProyectos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.botonApoyarProyecto = new JButton("Apoyar");
		this.verDetallesProyecto = new JButton("DetallesP");
		
		this.listaColectivos = new JList(colectivosM);
		this.scrollColectivos = new JScrollPane(this.listaColectivos);
		this.botonSuscribirseColectivo = new JButton("Suscribirse");
		this.listaColectivos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.verDetallesColectivo = new JButton("DetallesC");

		subP1.add(etiquetaUsuario);
		subP1.add(nombreUsuario);
		subP1.add(etiquetaNIF);
		subP1.add(numeroNIF);
		subP1.add(goColectivos);
		subP1.add(goProyectos);
		subP1.add(scrollProyectos);
		subP1.add(scrollColectivos);
		subP1.add(botonApoyarProyecto);
		subP1.add(botonSuscribirseColectivo);
		subP1.add(botonActualizar);
		this.add(subP1);
		
	}

	public void setControlador(ActionListener c) {
		goColectivos.addActionListener(c);
		goProyectos.addActionListener(c);
		this.listaProyectos.addListSelectionListener(((ControladorUsuario) c).getControllerProyectosApoyables());
		this.listaColectivos.addListSelectionListener(((ControladorUsuario) c).getControllerColectivosDisponibles());
		botonApoyarProyecto.addActionListener(c);
		verDetallesProyecto.addActionListener(c);
		botonActualizar.addActionListener(c);
		botonSuscribirseColectivo.addActionListener(c);
		verDetallesColectivo.addActionListener(c);
	}
	
	public void setNumeroNIF(String texto) {
		this.numeroNIF.setText(texto);
	}
	public void setNombreUsuario(String texto) {
		this.nombreUsuario.setText(texto);
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
	public DefaultListModel getListaProyectos() {
		return this.proyectosM;
	}
	public DefaultListModel getListaColectivos() {
		return this.colectivosM;
	}
	public String getSelectedProject() {
		return (String)this.listaProyectos.getSelectedValue();
	}
}
