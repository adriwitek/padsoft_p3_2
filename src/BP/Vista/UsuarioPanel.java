package BP.Vista;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UsuarioPanel extends JPanel {
	
	private JButton goColectivos;
	private JButton goProyectos;
	
	private JLabel etiquetaUsuario;
	private JLabel nombreUsuario;
	private JLabel etiquetaNIF;
	private JLabel numeroNIF;
	
	private JList listaProyectos;
	private JList listaColectivos;
	
	
	public UsuarioPanel() {
		this.setLayout(new BorderLayout());
		//SubPanel Usuario
		JPanel subP1 = new JPanel(new GridLayout(3,3));

		this.etiquetaNIF = new JLabel("NIF");
		this.nombreUsuario = new JLabel("");
		this.etiquetaUsuario = new JLabel("Usuario");
		this.numeroNIF = new JLabel("");
		this.goColectivos = new JButton("goColectivos");
		this.goProyectos = new JButton("goProyectos");
		this.listaProyectos = new JList();
		this.listaColectivos = new JList();

		
		subP1.add(goColectivos);
		subP1.add(goProyectos);
		subP1.add(listaProyectos);
		subP1.add(listaColectivos);
		this.add(subP1);
		
	}
	public void setControlador(ActionListener c) {
		goColectivos.addActionListener(c);
		goProyectos.addActionListener(c);
	}
	public void setNumeroNIF(String texto) {
		this.numeroNIF.setText(texto);
	}
	public void setNombreUsuario(String texto) {
		this.nombreUsuario.setText(texto);
	}

}
