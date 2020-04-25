package BP.Vista;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class BienvenidaPanel extends JPanel{

	
	private JLabel labelBienvenida;
	private JButton botonLogin;
	private JButton botonRegistro;
	
	public BienvenidaPanel() {
		
		this.setLayout(new BorderLayout());

		
		//Subpanel 1
		JPanel subP1 = new JPanel(new GridLayout(2,2));
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
	public void setControladorBotonLogin(ActionListener c) {
		botonLogin.addActionListener(c);
	}
	
	public void setControladorBotonREgistro(ActionListener c) {
		botonRegistro.addActionListener(c);
	}
	
}
