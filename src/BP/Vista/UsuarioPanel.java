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

		subP1.add(scrollProyectos);
		subP1.add(scrollColectivos);
		subP1.add(botonApoyarProyecto);
		subP1.add(botonSuscribirseColectivo);
		subP1.add(botonActualizar);
		subP1.add(verDetallesProyecto);
		this.add(subP1);
		this.pestanias.add("Usuario",subP1);
		this.pestanias.add("Colectivos",frame.getPanelColectivos().getSubPanel() );
		this.pestanias.add("Proyectos",frame.getPanelProyectos().getSubPanel()  );
		this.pestanias.setSelectedIndex(0);
		this.add(this.pestanias);
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
	public JTabbedPane getPestanias() {
		return this.pestanias;
	}
	public void setModeloNotificaciones(HashSet<Notificacion> notificaciones) {
        modeloNotificaciones.clear();
        for(Notificacion n: notificaciones  ) {
            this.modeloNotificaciones.addElement(n);

        }
    }


    public void setCampoTituloNotificacion(String t) {
        this.campoTituloNotificacion.setText(t);
    }

    public void setCampoDescripcionNotificacion(String t) {
        this.campoDescripcionNotificacion.setText(t);
    }
}
