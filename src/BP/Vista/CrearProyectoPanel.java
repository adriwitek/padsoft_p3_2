package BP.Vista;

import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;

import javax.swing.*;

import BP.Modelo.Aplicacion;


public class CrearProyectoPanel extends JPanel{
	
	//Panel subP1
	private JButton cancelar;
	private JLabel nombreProyecto;
	private JTextField textNombreProyecto;
	private JButton PSocial;
	private JButton PInfraestructuras;
	
	private JPanel subP1;
	
	public CrearProyectoPanel() {
		this.setLayout(new BorderLayout());
		//subP1
		this.cancelar = new JButton("Cancelar");
		this.nombreProyecto = new JLabel("Nombre del proyecto:");
		this.textNombreProyecto = new JTextField(30);
		this.PSocial = new JButton("ProyectoSocial");
		this.PInfraestructuras = new JButton("ProyectoInfraestructuras");
		
		subP1 = new JPanel(new GridLayout(10,10));
		subP1.add(cancelar);
		subP1.add(textNombreProyecto);
		subP1.add(PSocial);
		subP1.add(PInfraestructuras);
		
		subP1.setVisible(true);
		this.add(subP1);

	}
	
	public void setControlador(ActionListener c) {
		cancelar.addActionListener(c);
		PSocial.addActionListener(c);
		PInfraestructuras.addActionListener(c);
		
		
	}
	
	

	 
}
