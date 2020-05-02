package BP.Vista;

import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;

import javax.swing.*;

import BP.Modelo.Aplicacion;



public class CrearProyectoSocialPanel extends JPanel{

	private JLabel descripcion;
	private JTextField textDescripcion;
	private JLabel financiacion;
	private JTextField textFinanciacion;
	private JButton atras;
	private JButton finalizar;

	private JLabel grupoSocial;
	private JTextField textGrupoSocial;
	
	private JPanel subP1;
	private JPanel subPSocial; 
	
	
	public CrearProyectoSocialPanel() {
		this.setLayout(new BorderLayout());
		
		this.descripcion = new JLabel("Descripcion: ");
		this.textDescripcion = new JTextField(10);
		this.financiacion = new JLabel("Financiacion necesaria: ");
		this.textFinanciacion = new JTextField(10);
		this.grupoSocial = new JLabel("Grupo Social: ");
		this.textGrupoSocial = new JTextField(10);
		this.atras = new JButton("Atras");
		this.finalizar = new JButton("Finalizar");
		
		subPSocial = new JPanel(new GridLayout(2,2));
		subPSocial.add(descripcion);
		subPSocial.add(textDescripcion);
		subPSocial.add(financiacion);
		subPSocial.add(textFinanciacion);
		subPSocial.add(grupoSocial);
		subPSocial.add(textGrupoSocial);
		subPSocial.add(atras);
		subPSocial.add(finalizar);
		
		this.add(subPSocial);

	}
	
	
	public void setControlador(ActionListener c) {	
		atras.addActionListener(c);
		finalizar.addActionListener(c);
		
	}

	
	
}
