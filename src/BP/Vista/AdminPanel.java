package BP.Vista;

import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;

import javax.swing.*;
import  javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import BP.Controlador.ControladorAdmin;
import BP.Modelo.Notificacion;
import BP.Modelo.Proyecto;
import BP.Modelo.Usuario;


/** 
* 
* @author Adián Rubio adrian.rubiop@estudiante.uam.es, Guillermo Solla guillermo.solla@estudiante.uam.es 
* y Diego Tapia diego.tapias@estudiante.uam.es
*/
public class AdminPanel extends JPanel {
	

	private HashSet<Usuario> registrosPendientesAprobacion;
	private HashSet<Usuario> usuariosActivos;
	private HashSet<Usuario> usuariosBloqueados;
	private HashSet<Proyecto> proyectosSolicitandoFinanciacion;
	private DefaultListModel solicitudesReg ;
	private DefaultListModel usuariosActivosModelo ;
	private DefaultListModel usuariosBloqueadosModelo ;

	
	
	
	private JTabbedPane pestanias;
	private JList listaSolicitudesReg;
	private JLabel etiquetaNIF;
	private JTextField campoNIF;
	private JLabel etiquetaUsuario;
	private JTextField campoUsuario;
	private JButton botonValidarRegistro;
	private JButton botonRechazarRegistro;
	private JLabel etiquetaRechazoRegistro;
	private JTextField campoMotivoRechazo;

	private JScrollPane scroll;
	private JList listaUsuariosActivos;
	private JScrollPane scrollUsuariosActivos;
	private JList listaUsuariosBloqueados;
	private JScrollPane scrollUsuariosBloqueados;
	private JButton botonBloquearUsuario;
	private JButton botonDesBloquearUsuario;
	private JTextField campoMotivoBloqueo;
	private JButton botonValidarProyecto;
	private JButton botonRechazarValidarProyecto;
	private JTable tabla;
	private DefaultTableModel modeloDatos;
	private JTextField campoMotivoRechazoValidacionProyecto;
	private JButton botonCerrarSesion;


	 
	/**
	 * Este es el controlador de AdminPanel, contiene todos los subpaneles de AdminPanel, ademas de la creacion y la introduccion todos los objetos 
	 * en sus respectivos paneles (botones, layouts, etc)
	 * 
	 * @param registrosPendientesAprobacion los registros pendientes
	 * @param usuariosActivos los usuarios activos
	 * @param usuariosBloqueados los usuarios bloqueados
	 * @param proyectosSolicitandoFinanciacion proyectos solicitando financiacion
	 */
	public AdminPanel(HashSet<Usuario> registrosPendientesAprobacion,HashSet<Usuario> usuariosActivos,HashSet<Usuario> usuariosBloqueados,HashSet<Proyecto> proyectosSolicitandoFinanciacion) {
		
		
		this.registrosPendientesAprobacion = registrosPendientesAprobacion;
		this.usuariosActivos = usuariosActivos;
		this.usuariosBloqueados = usuariosBloqueados;
		this.proyectosSolicitandoFinanciacion = proyectosSolicitandoFinanciacion;
		
		
		
		//Layout de todo el panel
		this.setLayout(new FlowLayout());
				
				
		
		
		this.pestanias = new JTabbedPane();
		  
		
		// ***SUBPANEL1 *** - Usuarios pendientes de aprobacion
		
		JPanel subP1 = new JPanel();
		JLabel label1 = new JLabel("Solicitudes:");
		subP1.add(label1);
	
		//Lista
		this.solicitudesReg = new DefaultListModel(); 
		for(Usuario u: this.registrosPendientesAprobacion) {
			solicitudesReg.addElement(u);
			
		}
		this.listaSolicitudesReg = new JList(solicitudesReg);
		this.listaSolicitudesReg.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    //	System.out.println(this.listaSolicitudesReg.getName());
		
		this.scroll = new JScrollPane(this.listaSolicitudesReg);
		subP1.add(scroll);
		
		
		this.etiquetaUsuario = new JLabel("Nombre de Usuario");
		this.campoUsuario = new JTextField(20);
		this.campoUsuario.setEditable(false);
		this.etiquetaNIF = new JLabel("NIF:");
		this.campoNIF =  new JTextField(9);
		this.campoNIF.setEditable(false);
		subP1.add(this.etiquetaUsuario);
		subP1.add(this.campoUsuario);
		subP1.add(this.etiquetaNIF);
		subP1.add(this.campoNIF);
		
		botonValidarRegistro = new JButton("Validar Registro");
		botonRechazarRegistro = new JButton("Rechazar Registro");
		etiquetaRechazoRegistro = new JLabel("Motivo del rechazo");
		campoMotivoRechazo = new JTextField(20);
		subP1.add(this.botonValidarRegistro);
		subP1.add(this.botonRechazarRegistro);
		subP1.add(this.etiquetaRechazoRegistro);
		subP1.add(this.campoMotivoRechazo);
	
		this.pestanias.add("Registros",subP1);
		
		
		
		
		
		
		
		
		
		// ********   SUBPANEL 2 - BLOQUEO DE USUARIOS  ******
		JPanel subP2 = new JPanel();
		
		
		//Lista1 - Usuarios Activos
		JLabel label2 = new JLabel("Usuarios Activos");
		subP2.add(label2); 
		this.usuariosActivosModelo = new DefaultListModel(); 
		for(Usuario u: this.usuariosActivos) {
			usuariosActivosModelo.addElement(u);
			
		}
		this.listaUsuariosActivos = new JList(usuariosActivosModelo);
		this.listaUsuariosActivos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.scrollUsuariosActivos = new JScrollPane(this.listaUsuariosActivos);
		subP2.add(scrollUsuariosActivos);
		
		JLabel labelBloqueoUsuario = new JLabel("Motivo de Bloqueo");
		subP2.add(labelBloqueoUsuario);
		this.campoMotivoBloqueo = new JTextField(20);
		subP2.add(campoMotivoBloqueo);
		botonBloquearUsuario = new JButton("Bloquear Usuario");
		subP2.add(botonBloquearUsuario);


		
		//Lista2 - Usuarios Bloqueados
		JLabel label3 = new JLabel("Usuarios Bloqueados");
		subP2.add(label3); 
		
		this.usuariosBloqueadosModelo = new DefaultListModel(); 
		for(Usuario u: this.usuariosBloqueados) {
			usuariosBloqueadosModelo.addElement(u);
			
		}
		this.listaUsuariosBloqueados = new JList(usuariosBloqueadosModelo);
		this.listaUsuariosBloqueados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.scrollUsuariosBloqueados = new JScrollPane(this.listaUsuariosBloqueados);
		subP2.add(scrollUsuariosBloqueados);
		
		botonDesBloquearUsuario = new JButton("Desbloquear Usuario");
		subP2.add(botonDesBloquearUsuario);

		
		this.pestanias.add("Usuarios",subP2);
		
		
		
		

		
		
		
		
		// ********   SUBPANEL 3 - APROBACION PROYECTOS  ******
		JPanel subP3 = new JPanel();
		JLabel label4 = new JLabel("Proyectos pendientes de aprobacion");
		subP3.add(label4); 
		
		
		//TABLA
		String[] titulos = {"Nombre Proyecto","Tipo Proyecto", "Financiacion solicitada", "Fecha creacion", "Descripcion breve","ID"};
		
		
		Object[][] filas;
		/*if(proyectosSolicitandoFinanciacion.size() == 0 ) {*/
		filas = new Object [0][6];
		/*}else {
			filas = new Object [proyectosSolicitandoFinanciacion.size()][6];
			int i=0;
			for(Proyecto p: proyectosSolicitandoFinanciacion) {
				filas[i][0] = p.getNombre() ;
				filas[i][1] = p.getTipoProyecto();
				filas[i][2] = new Double(p.getCoste());
				filas[i][3] = p.getFechaCreacion();
				filas[i][4] = p.getDescripcionCorta();
				filas[i][5] = p.getUniqueID();
				i++;
			}
		}*/
		
		
		
		this.modeloDatos = new DefaultTableModel(filas, titulos);
		this.tabla = new JTable(modeloDatos);
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabla.setPreferredScrollableViewportSize(new Dimension(500, 100));
		JScrollPane scroll = new JScrollPane(tabla);
		subP3.add(scroll);
		
		//Validar
		this.botonValidarProyecto = new JButton("Validar Proyecto");
		subP3.add(botonValidarProyecto);
		//Rechazar
		JLabel labelRechazoProyecto = new JLabel("Motivo de Rechazo Proyecto");
		subP3.add(labelRechazoProyecto);
		this.campoMotivoRechazoValidacionProyecto = new JTextField(20);
		subP3.add(campoMotivoRechazoValidacionProyecto);
		this.botonRechazarValidarProyecto = new JButton("Rechazar Proyecto");
		subP3.add(botonRechazarValidarProyecto);
		
		this.pestanias.add("Proyectos",subP3);
		this.pestanias.setSelectedIndex(0);
		
		
		
		
		
		//Boton cerrar sesión
		botonCerrarSesion = new JButton("Cerrar Sesion");
		
		
		this.add(this.botonCerrarSesion);
		this.add(this.pestanias);
	}
	
	
	/**
	 * Esta es la funcion setControlador, se encarga de permitir que algunos de los objetos que hemos introducido en los subpaneles
	 * tengan una funcionalidad(es para objetos como botones, listas, etc)
	 * @param c llama al controlador del administrador, para así poder vincular los objetos con su funcionalidad especificada en este controlador.
	 */
	public void setControlador(ControladorAdmin c) {
		//Del panel1
		this.listaSolicitudesReg.addListSelectionListener(c);
		this.botonValidarRegistro.addActionListener(c);
		this.botonRechazarRegistro.addActionListener(c); 
		
		//del Panel2
		this.botonBloquearUsuario.addActionListener(c);
		this.botonDesBloquearUsuario.addActionListener(c);
		this.listaUsuariosActivos.addListSelectionListener(c.getControllerUsuariosActivos());
		this.listaUsuariosBloqueados.addListSelectionListener(c.getControllerUsuariosBloqueados());
		
		//del Panel3
		botonValidarProyecto.addActionListener(c); 
		botonRechazarValidarProyecto.addActionListener(c); 

		
		//cierre sesion
		botonCerrarSesion.addActionListener(c); 
	}
	
	
	
	
	//Metodo para el controlador del panel
	/**
	 * Esta funcion se encargara de actualizar los credenciales de registro de una persona que ha solicitado un registro
	 * @param nombre el nombre del posible usuario
	 * @param nif el NIF del posible usuario
	 */
	public void updateSolicitudRegitroSeleccionada(String nombre,String nif) {
		this.campoUsuario.setText(nombre);
		this.campoNIF.setText(nif);

	}
	
	
	
	//metodo para el controlador
	/**
	 * Esta funcion permite al administrador eliminar un usuario de la lista de usuarios
	 * @param u es el usuario que el administrador pretende eliminar
	 */
	public void borraDeListaUsuarios(Usuario u) {
		this.solicitudesReg.removeElement(u);
	}
	
	/**
	 * Esta funcion se encaragara de mostrarnos un string con el motivo de rechazo a un usuario
	 * 
	 * @return the contenido de campoMotivoRechazo
	 */
	public String getMotivoRechazo() {
		return this.campoMotivoRechazo.getText();
	}
	
	/**
	 * Permite que el boton de campoMotivo de bloqueo se desbloquee o bloquee
	 * @param b un boolean que nos dira si queremos que el setEnabled este a true o a false (Para bloquear o desbloquear el boton)
	 */
	public void setVisibilidadCampoMotivoBloqueo(Boolean b) {
		//this.campoMotivoBloqueo.setVisible(b);
		this.campoMotivoBloqueo.setEnabled(b);

	}
	
	/**
	 * Permite que el boton de botonBloquearUsuario de bloqueo se desbloquee o bloquee
	 * @param b un boolean que nos dira si queremos que el setEnabled este a true o a false (Para bloquear o desbloquear el boton)
	 */
	public void setVisibilidadBotonBloquearUsuario(Boolean b) {
		//this.botonBloquearUsuario.setVisible(b);
		this.botonBloquearUsuario.setEnabled(b);
		if(!b) this.listaUsuariosActivos.clearSelection();

	}
	/**
	 * Permite que en el boton para desbloquear a un usuario se active o se desactive su funcionamiento
	 * @param b un boolean que nos dira si queremos que el setEnabled este a true o a false (Para bloquear o desbloquear el boton)
	 */
	public void setVisibilidadBotonDesBloquearUsuario(Boolean b) {
		//this.botonDesBloquearUsuario.setVisible(b);
		this.botonDesBloquearUsuario.setEnabled(b);
		if(!b) this.listaUsuariosBloqueados.clearSelection();
	}
	
	/**
	 * Esta funcion nos muestra la razon  por la que se ha bloqueado a un usuario
	 * @return the String campoMotivoBloqueo
	 */
	public String getMotivoBloqueo() {
		return this.campoMotivoBloqueo.getText();
	}



	/**
	 * Esta funcion añade un usuario a la lista de usuarios activos
	 * 
	 * @param u usuario que se quere introducir en la lista de usuarios activos
	 */
	public void addListaUsuariosActivos(Usuario u) {
		this.usuariosActivosModelo.addElement(u);
	}
	
	/**
	 * Esta funcion añade un usuario a la lista de usuarios bloqueados
	 * @param u usuario que se quere introducir en la lista de usuarios bloqueados
	 */
	public void addListaUsuariosBloqueados(Usuario u) {
		usuariosBloqueadosModelo.addElement(u);
	}
	
	/**
	 * Esta funcion permite eliminar a un usuario seleccionado de la lista de usuarios activos
	 * @param u usuario que se quiere eliminar de la lista de usuarios activos
	 */
	public void borrarListaUsuariosActivos(Usuario u) {
		this.usuariosActivosModelo.removeElement(u);
	}
	/**
	 * Esta funcion permite eliminar a un usuario seleccionado de la lista de usuarios bloqueados
	 * @param u usuario que se quiere eliminar de la lista de usuarios bloqueados
	 */
	public void borrarListaUsuariosBloqueados(Usuario u) {
		this.usuariosBloqueadosModelo.removeElement(u);
	}
	
	/**
	 * Esta funcion crea una solicitud de registro para un usuario especificado
	 * @param u usuario del que se va ha realizar la solicitud de regisro
	 */
	public void addSolicitudRegistro(Usuario u) {
		this.solicitudesReg.addElement(u);
	}
	 
	/**
	 * Esta funcion devuelve una tabla con todos los proyectos pendientes de validacion
	 * @return the tabla del panel en el que se encuentra
	 */
	public JTable getTablaProyectosValidacion() {
		return this.tabla;
	}
	
	/**
	 * Esta funcion devuelve una DefaultTableModel con todos los proyectos pendientes de validacion
	 * @return the modeloDatos
	 */
	public DefaultTableModel getModeloTablaProyectosValidacion() {
		return this.modeloDatos;
	}
	/**
	 * Esta funcion devuelve el motivo por el cual se ha rechazado la validacion de un proyecto
	 * @return the String campoMotivoRechazoValidacionProyecto
	 */
	public String getMotivoRechazoValidacionProyecto() {
		return campoMotivoRechazoValidacionProyecto.getText();
	}
	
	
	public void setModeloProyectosValidacion(HashSet<Proyecto> pr) {
		

		
		for(int j =0 ;j< modeloDatos.getRowCount();j++) {
			modeloDatos.removeRow(j);
			
		}
		modeloDatos.fireTableDataChanged();


		Object[][] filas;
		if(pr.size() == 0 ) {
			filas = new Object [0][6];
		}else {
			filas = new Object [pr.size()][6];
			int i=0;
			for(Proyecto p: pr) {
				filas[i][0] = p.getNombre() ;
				filas[i][1] = p.getTipoProyecto();
				filas[i][2] = new Double(p.getCoste());
				filas[i][3] = p.getFechaCreacion();
				filas[i][4] = p.getDescripcionCorta();
				filas[i][5] = p.getUniqueID();
				this.modeloDatos.addRow(filas[i]);
				i++;
			}
		}


		modeloDatos.fireTableDataChanged();

		this.tabla.repaint();
    }
	
}
