package BP.Vista;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ProyectosPanel extends JPanel {
	
	private JLabel etiquetaNombre;
	private JLabel etiquetaNIF;
	private JLabel nombre;
	private JLabel nIF;

	private JButton goUsuario;
	private JButton goColectivos;
	private JButton crearProyecto;
	
	
	public ProyectosPanel() {
		this.setLayout(new BorderLayout());
		
		
			JPanel subP1 = new JPanel(new GridLayout(2,2));
		
		   this.goUsuario = new JButton("goUsuario");
		   this.goColectivos = new JButton("goColectivos");
		   this.crearProyecto = new JButton("crearProyecto");
		   
		   subP1.add(crearProyecto);
		   subP1.add(goUsuario);
		   subP1.add(goColectivos);
	
		   this.add(subP1);

	}

	public void setControlador(ActionListener c) {
	    goUsuario.addActionListener(c);
	    goColectivos.addActionListener(c);
	    crearProyecto.addActionListener(c);
	    
	}

	public void setNombre(JLabel nombre) {
	    this.nombre = nombre;
	}

	public void setNIF(JLabel nIF) {
	    this.nIF = nIF;
	}

}

