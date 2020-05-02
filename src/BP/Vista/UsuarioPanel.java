package BP.Vista;

import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;

import javax.swing.*;

import BP.Modelo.*;
public class UsuarioPanel extends JPanel {
	
	private JButton goUsuario;
	private JButton goColectivos;
	private JButton goProyectos;
	private JButton botonApoyarProyecto;
	private JButton botonSuscribirseColectivo;
	private JButton verDetallesProyecto;
	private JButton verDetallesColectivo;
	
	private JLabel etiquetaUsuario;
	private JLabel nombreUsuario;
	private JLabel etiquetaNIF;
	private JLabel numeroNIF;
	
	private JList listaProyectos;
	private JList listaColectivos;
	private DefaultListModel proyectosM;
	private DefaultListModel colectivosM; 
	
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
		this.goUsuario = new JButton("Usuario");
		this.goColectivos = new JButton("Colectivos");
		this.goProyectos = new JButton("Proyectos");
		this.listaProyectos = new JList(proyectosM);
		this.listaColectivos = new JList(colectivosM);
		this.botonApoyarProyecto = new JButton("Apoyar");
		this.botonSuscribirseColectivo = new JButton("Suscribirse");
		this.verDetallesProyecto = new JButton("DetallesP");
		this.verDetallesColectivo= new JButton("DetallesC");
		subP1.add(etiquetaUsuario);
		subP1.add(nombreUsuario);
		subP1.add(etiquetaNIF);
		subP1.add(numeroNIF);
		subP1.add(goUsuario);
		subP1.add(goColectivos);
		subP1.add(goProyectos);
		subP1.add(goProyectos);
		subP1.add(listaProyectos);
		subP1.add(listaColectivos);
		this.add(subP1);
		
	}
	public void setControlador(ActionListener c) {
		goUsuario.addActionListener(c);
		goColectivos.addActionListener(c);
		goProyectos.addActionListener(c);
		botonApoyarProyecto.addActionListener(c);
		botonSuscribirseColectivo.addActionListener(c);
		verDetallesProyecto.addActionListener(c);
		verDetallesColectivo.addActionListener(c);
	}
	
	public void setNumeroNIF(String texto) {
		this.numeroNIF.setText(texto);
	}
	public void setNombreUsuario(String texto) {
		this.nombreUsuario.setText(texto);
	}
	public void setListaProyectos(Aplicacion app) {
		for(Proyecto p: app.getProyectosApoyables()) {
			this.proyectosM.addElement(p.getNombre());
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
