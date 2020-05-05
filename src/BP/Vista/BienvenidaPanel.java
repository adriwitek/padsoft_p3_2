package BP.Vista;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/** 
* 
* @author Adián Rubio adrian.rubiop@estudiante.uam.es, Guillermo Solla guillermo.solla@estudiante.uam.es 
* y Diego Tapia diego.tapias@estudiante.uam.es
*/

public class BienvenidaPanel extends JPanel{

	
	private JLabel labelBienvenida;
	private JButton botonLogin;
	private JButton botonRegistro;
	
	/**
	 * Este es el controlador de BienvenidaPanel, contiene lod panel de BienvenidaPanel, ademas contiene la creacion e introduccion de los objetos
	 * de BienvenidaPanel en su correspondiente subpanel (subP1 y subP2)
	 */
	public BienvenidaPanel() {
		
		this.setLayout(new FlowLayout());

		
		//Subpanel 1
		JPanel subP1 = new JPanel(new FlowLayout());
		this.labelBienvenida = new JLabel("¡Bienvenido a BP: Becoming a Project!");
		subP1.add(labelBienvenida);
		this.add(subP1);

		
		//Subpanel2
		JPanel subP2 = new JPanel();
		this.botonRegistro = new JButton("Registro");
		this.botonLogin = new JButton("LogIn");
		subP2.add(botonRegistro);
		subP2.add(botonLogin);
		this.add(subP2);
	}
	
	
	
	//Metodos para el controlador
	/**
	 * Esta es la funcion setControlador, se encarga de permitir que algunos de los objetos que hemos introducido en los subpaneles
	 * tengan una funcionalidad(es para objetos como botones, listas, etc)
	 * @param c llama a la fncion actionListener correspondiente para este panel
	 */
	public void setControlador(ActionListener c) {
		botonLogin.addActionListener(c);
		botonRegistro.addActionListener(c);
	}
	
	
}
