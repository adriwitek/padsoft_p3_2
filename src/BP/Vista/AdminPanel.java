package BP.Vista;

import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;

import javax.swing.*;
import  javax.swing.event.ListSelectionListener;

import BP.Controlador.ControladorAdmin;
import BP.Modelo.Usuario;



public class AdminPanel extends JPanel {
	

	private HashSet<Usuario> registrosPendientesAprobacion;
	private HashSet<Usuario> usuariosActivos;
	private HashSet<Usuario> usuariosBloqueados;
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

	
	 
	
	public AdminPanel(HashSet<Usuario> registrosPendientesAprobacion,HashSet<Usuario> usuariosActivos,HashSet<Usuario> usuariosBloqueados) {
		
		
		this.registrosPendientesAprobacion = registrosPendientesAprobacion;
		this.usuariosActivos = usuariosActivos;
		this.usuariosBloqueados = usuariosBloqueados;

		
		
		
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
		
		
		
		
		
		
		
		//SUBPANEL 3
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		this.pestanias.setSelectedIndex(0);
		this.add(this.pestanias);
	}
	
	
	
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
	}
	
	
	
	
	//Metodo para el controlador del panel
	public void updateSolicitudRegitroSeleccionada(String nombre,String nif) {
		this.campoUsuario.setText(nombre);
		this.campoNIF.setText(nif);

	}
	
	
	
	//metodo para el controlador
	public void borraDeListaUsuarios(Usuario u) {
		this.solicitudesReg.removeElement(u);
	}
	
	
	public String getMotivoRechazo() {
		return this.campoMotivoRechazo.getText();
	}
	
	
	public void setVisibilidadCampoMotivoBloqueo(Boolean b) {
		//this.campoMotivoBloqueo.setVisible(b);
		this.campoMotivoBloqueo.setEnabled(b);

	}
	
	
	public void setVisibilidadBotonBloquearUsuario(Boolean b) {
		//this.botonBloquearUsuario.setVisible(b);
		this.botonBloquearUsuario.setEnabled(b);
		if(!b) this.listaUsuariosActivos.clearSelection();

	}
	
	public void setVisibilidadBotonDesBloquearUsuario(Boolean b) {
		//this.botonDesBloquearUsuario.setVisible(b);
		this.botonDesBloquearUsuario.setEnabled(b);
		if(!b) this.listaUsuariosBloqueados.clearSelection();
	}
	
	
	public String getMotivoBloqueo() {
		return this.campoMotivoBloqueo.getText();
	}



	
	public void addListaUsuariosActivos(Usuario u) {
		this.usuariosActivosModelo.addElement(u);
	}
	
	public void addListaUsuariosBloqueados(Usuario u) {
		usuariosBloqueadosModelo.addElement(u);
	}
	
	
	public void borrarListaUsuariosActivos(Usuario u) {
		this.usuariosActivosModelo.removeElement(u);
	}
	
	public void borrarListaUsuariosBloqueados(Usuario u) {
		this.usuariosBloqueadosModelo.removeElement(u);
	}
	
	public void addSolicitudRegistro(Usuario u) {
		this.solicitudesReg.addElement(u);
	}
	
}
