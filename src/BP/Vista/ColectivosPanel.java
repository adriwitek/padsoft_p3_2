package BP.Vista;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ColectivosPanel extends JPanel{
	private JButton goUsuario;
	private JButton goColectivos;
	private JButton goProyectos;
	
	public ColectivosPanel() {
		this.setLayout(new BorderLayout());
		
		JPanel subP1 = new JPanel(new GridLayout(3,3));
		this.goUsuario = new JButton("Usuario");
		this.goProyectos = new JButton("Proyectos");
		
		subP1.add(goUsuario);
		subP1.add(goProyectos);
		this.add(subP1);
	}
	
	public void setControlador(ActionListener c) {
		goUsuario.addActionListener(c);
		goProyectos.addActionListener(c);
	}
}
