package BP.Vista;

import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;

import javax.swing.*;
import  javax.swing.event.ListSelectionListener;
import BP.Modelo.Usuario;



public class AdminPanel extends JPanel {
	

	private HashSet<Usuario> registrosPendientesAprobacion;
	private JList listaSolicitudesReg;
	private JLabel etiquetaNIF;
	private JTextField campoNIF;
	private JLabel etiquetaUsuario;
	private JTextField campoUsuario;
	
	public AdminPanel(HashSet<Usuario> registrosPendientesAprobacion) {
		
		
		this.registrosPendientesAprobacion = registrosPendientesAprobacion;
		
		
		
		
		//Layout de todo el panel
		this.setLayout(new FlowLayout());
				
				
		// ***SUBPANEL1 *** - Usuarios pendientes de aprobacion

		JPanel subP1 = new JPanel(new FlowLayout());
		JLabel label1 = new JLabel("Solicitudes de registro en el sistema pendientes de aprobacion:");
		DefaultListModel solicitudesReg = new DefaultListModel(); 
		for(Usuario u: this.registrosPendientesAprobacion) {
			solicitudesReg.addElement(u);
			
		}
	
		this.listaSolicitudesReg = new JList(solicitudesReg);
		this.listaSolicitudesReg.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JScrollPane scroll = new JScrollPane(this.listaSolicitudesReg);
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
		
		
		
		this.add(subP1);
		
		
		
		// SUBPANEL 2 - 
		
		
		
		
		
		
		
	}
	
	
	
	public void setControlador(ActionListener c,ListSelectionListener l) {
		this.listaSolicitudesReg.addListSelectionListener(l);
	
	}
	
	
	
	
	//Metodo para el controlador del panel
	public void updateSolicitudRegitroSeleccionada(String nombre,String nif) {
		this.campoUsuario.setText(nombre);
		this.campoNIF.setText(nif);

	}
	
}
