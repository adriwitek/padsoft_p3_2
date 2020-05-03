package BP.Vista;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ColectivosPanel extends JPanel{
	private JButton goUsuario;
	private JButton goColectivos;
	private JButton goProyectos;
	private JButton crearColectivo;
	public ColectivosPanel() {
		this.setLayout(new BorderLayout());
		
		JPanel subP1 = new JPanel(new GridLayout(3,3));
		this.goUsuario = new JButton("goUsuario");
		this.goProyectos = new JButton("goProyectos");
		this.crearColectivo = new JButton("crearColectivo");
		
		subP1.add(goUsuario);
		subP1.add(goProyectos);
		subP1.add(crearColectivo);
		this.add(subP1);
	}
	
	public void setControlador(ActionListener c) {
		goUsuario.addActionListener(c);
		goProyectos.addActionListener(c);
		crearColectivo.addActionListener(c);
	}
}
