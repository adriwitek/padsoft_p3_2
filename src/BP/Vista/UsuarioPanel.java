package BP.Vista;

import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;

import javax.swing.*;

import BP.Controlador.ControladorUsuario;
import BP.Modelo.*;
public class UsuarioPanel extends JPanel {
	private VentanaPrincipal frame;
	private JTabbedPane pestanias;

	private JButton botonApoyarProyecto;
	private JButton botonSuscribirseColectivo;
	private JButton verDetallesProyecto;
	private JButton verDetallesColectivo;
	private JButton botonActualizar;
	private JLabel labelListaProyectos;
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

	//Notificaciones
	private DefaultListModel modeloNotificaciones ;
	private JList listaNotificaciones;
	private JScrollPane scrollNotificaciones;
	private JTextField campoTituloNotificacion;
	private JTextField campoDescripcionNotificacion;
	private JButton botonBorrarNotificacion;
	private JButton botonCerrarSesion;

	
	/**
	 * Este es el constructor de UsuarioPanel, en el se encuentran los subpaneles subP1 y subP2, ademas de la 
	 * creacion e introduccion de los elementos-objetos en ssu respectivo subpanel 
	 * @param frame
	 */

	public UsuarioPanel(VentanaPrincipal frame) {
		this.frame = frame;
		this.setLayout(new FlowLayout());
		//SubPanel Usuario
		// Boton cierre Sesion
		this.botonCerrarSesion = new JButton("Cerrar Sesion");
		this.add(botonCerrarSesion);
		this.pestanias = new JTabbedPane();
		JPanel subP1 = new JPanel(new GridLayout(5,5));
		this.proyectosM  = new DefaultListModel ();
		this.colectivosM  = new DefaultListModel ();
		this.etiquetaNIF = new JLabel("NIF:");
		this.nombreUsuario = new JLabel("");
		this.etiquetaUsuario = new JLabel("Usuario:");
		this.numeroNIF = new JLabel("");

		this.botonActualizar = new JButton("Actualizar");
		this.listaProyectos = new JList(proyectosM);
		this.scrollProyectos = new JScrollPane(this.listaProyectos);

		this.listaColectivos = new JList(colectivosM);
		this.scrollColectivos = new JScrollPane(this.listaColectivos);
		this.botonSuscribirseColectivo = new JButton("Suscribirse");
		this.listaColectivos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.verDetallesColectivo = new JButton("DetallesC");

		subP1.add(etiquetaUsuario);
		subP1.add(nombreUsuario);
		subP1.add(etiquetaNIF);
		subP1.add(numeroNIF);

		subP1.add(scrollProyectos);
		subP1.add(scrollColectivos);
		subP1.add(botonSuscribirseColectivo);
		subP1.add(botonActualizar);
		this.add(subP1);
		this.pestanias.add("Usuario",subP1);
		this.pestanias.add("Colectivos",frame.getPanelColectivos().getSubPanel() );
		this.pestanias.add("Proyectos",frame.getPanelProyectos().getSubPanel()  );
		this.pestanias.setSelectedIndex(0);
		this.add(this.pestanias);
		//Configurando LISTA PROYECTOS
		JPanel panelListaProyectos = new JPanel(new GridLayout(3,1));
		this.labelListaProyectos = new JLabel("Proyectos Disponibles");
		this.botonApoyarProyecto = new JButton("Apoyar");
		this.verDetallesProyecto = new JButton("DetallesP");
		panelListaProyectos.add(labelListaProyectos);
		panelListaProyectos.add(botonApoyarProyecto);
		panelListaProyectos.add(verDetallesProyecto);
		this.scrollProyectos.setRowHeaderView(panelListaProyectos);
		
		
		JPanel subP2 = new JPanel(new FlowLayout());
		
		JLabel label1 = new JLabel("Notificaciones:");
		subP2.add(label1);

		//Lista
		this.modeloNotificaciones = new DefaultListModel(); 
		this.listaNotificaciones = new JList(modeloNotificaciones);
		this.scrollNotificaciones = new JScrollPane(this.listaNotificaciones);
		this.listaNotificaciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		subP2.add(scrollNotificaciones);


		JLabel label2 = new JLabel("Titulo:");
		this.campoTituloNotificacion =    new JTextField(20);
		this.campoTituloNotificacion.setEditable(false);
		JLabel label3 = new JLabel("Mensaje:");
		this.campoDescripcionNotificacion= new JTextField(50);
		this.campoDescripcionNotificacion.setEditable(false);
		this.botonBorrarNotificacion = new JButton("Borrar Notificacion");


		subP2.add(label2);
		subP2.add(campoTituloNotificacion);
		subP2.add(label3);
		subP2.add(campoDescripcionNotificacion);
		subP2.add(botonBorrarNotificacion);

		this.pestanias.add("Notificaciones",subP2);

	}
	/**
	 * Esta es la funcion setControlador, se encarga de permitir que algunos de los objetos que hemos introducido en el panel
	 * tengan una funcionalidad(es para objetos como botones, listas, etc)
	 * @param c es el controlador especifico donde se encuentra la funcionalidad de los objetos que se encuentran dentro de esta funcion
	 */
	public void setControlador(ControladorUsuario c) {

		this.listaProyectos.addListSelectionListener(c.getControllerProyectosApoyables());
		this.listaColectivos.addListSelectionListener(c.getControllerColectivosDisponibles());
		botonApoyarProyecto.addActionListener(c);
		verDetallesProyecto.addActionListener(c);
		botonActualizar.addActionListener(c);
		botonSuscribirseColectivo.addActionListener(c);
		verDetallesColectivo.addActionListener(c);
		this.botonBorrarNotificacion.addActionListener(c);
		this.listaNotificaciones.addListSelectionListener(c.getControllerNotificaciones());
		this.botonCerrarSesion.addActionListener(c);
	}

	
	/**
	 * Esta funcion introducira un numero nif al usuario
	 * @param texto es el nif que queremos introducir
	 */
	public void setNumeroNIF(String texto) {
		this.numeroNIF.setText(texto);
	}
	
	/**
	 * Esta funcion introducira el nombre de usuario a un usuario
	 * @param texto el el nombre de usuario que se pretende introducir
	 */
	public void setNombreUsuario(String texto) {
		this.nombreUsuario.setText(texto);
	}
	
	/**
	 * Esta funcion introducira un HashSet<Proyecto> en la lista de proyectos 
	 * @param proyectosAp HashSet<Proyecto> lista de preoyectos a introducir
	 */
	public void setListaProyectos(HashSet<Proyecto> proyectosAp) {
		proyectosM.clear();
		for(Proyecto p: proyectosAp ) {
			this.proyectosM.addElement(p);
		}
	}
	/**
	 * Esta funcion introducira un HashSet<Colectivo> en la lista de colectivos 
	 * @param colectivos HashSet<Colectivo> lista de colectivos a introducir
	 */
	public void setListaColectivos(HashSet<Colectivo> colectivos) {
		colectivosM.clear();
		for(Colectivo c: colectivos ) {
			this.colectivosM.addElement(c);
		}
	}
	
	/**
	 * Esta funcion devuelve la lista de proyectos
	 * @return the proyectosM
	 */
	public DefaultListModel getListaProyectos() {
		return this.proyectosM;
	}
	/**
	 * Esta funcion devuelve la lista de colectivos
	 * @return the colectivosM
	 */
	public DefaultListModel getListaColectivos() {
		return this.colectivosM;
	}
	
	/**
	 * Esta funcion devuelve  un string el proyecto seleccionado
	 * @return the string listaProyectos proyecto seleccionado
	 */
	public String getSelectedProject() {
		return (String)this.listaProyectos.getSelectedValue();
	}
	/**
	 * Esta funcion devuelve las pestañas del panel
	 * @return the pestanias pestanias del panel
	 */
	public JTabbedPane getPestanias() {
		return this.pestanias;
	}
	
	/**
	 * Esta funcion introduce un HashSet<Notificacion> de notificaciones 
	 * @param notificaciones HashSet de notificaciones
	 */
	public void setModeloNotificaciones(HashSet<Notificacion> notificaciones) {
		modeloNotificaciones.clear();
		for(Notificacion n: notificaciones  ) {
			this.modeloNotificaciones.addElement(n);

		}
	}


	/**
	 * Esta funcion introduce un string en el campo campoTituloNotificacion
	 * @param t es el string que se quiere introducir
	 */
    public void setCampoTituloNotificacion(String t) {
        this.campoTituloNotificacion.setText(t);
    }
    /**
     * Esta funcion introduce un string en el campo campoDescripcionNotificacion
     * @param t es el string que se quiere introducir
     */
    public void setCampoDescripcionNotificacion(String t) {
        this.campoDescripcionNotificacion.setText(t);
    }






}
