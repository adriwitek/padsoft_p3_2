package BP.Vista;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UsuarioPanel extends JPanel {
	private JLabel etiquetaNombre;
	private JLabel etiquetaNIF;
	private JLabel nombre;
	private JLabel nIF;
	
	private JButton goUsuario;
	private JButton goColectivos;
	private JButton goProyectos;
	
	private JList listaProyectos;
	private JList listaColectivos;
	
	public UsuarioPanel() {
		this.setLayout(new BorderLayout());
		//SubPanel Usuario
		JPanel subP1 = new JPanel(new GridLayout(3,3));

		this.etiquetaNombre = new JLabel("Usuario:");
		this.etiquetaNIF = new JLabel("NIF:");
		this.goUsuario = new JButton("Usuario");
		this.goColectivos = new JButton("Colectivos");
		this.goProyectos = new JButton("Proyectos");
		this.listaProyectos = new JList();
		this.listaColectivos = new JList();
		subP1.add(etiquetaNombre);
		subP1.add(etiquetaNIF);
		subP1.add(goUsuario);
		subP1.add(goColectivos);
		subP1.add(goProyectos);
		subP1.add(listaProyectos);
		subP1.add(listaColectivos);
		this.add(subP1);
		
	}
	public void setControlador(ActionListener c) {
		goUsuario.addActionListener(c);
		goColectivos.addActionListener(c);
		goProyectos.addActionListener(c);
	}
	
	public void setNombre(JLabel nombre) {
		this.nombre = nombre;
	}

	public void setNIF(JLabel nIF) {
		this.nIF = nIF;
	}
}
