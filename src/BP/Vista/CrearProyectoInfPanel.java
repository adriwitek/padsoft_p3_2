package BP.Vista;

import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;

import javax.swing.*;

import BP.Modelo.Aplicacion;

public class CrearProyectoInfPanel extends JPanel{
	
	private JLabel nombreProyecto;
	private JTextField textNombreProyecto;
	private JLabel descripcionCorta;
	private JTextField textDescripcionCorta;
	private JLabel descripcionLarga;
	private JTextField textDescripcionLarga;
	private JLabel financiacion;
	private JTextField textFinanciacion;
	private JButton atras;
	private JButton finalizar;
	
	public HashSet<String> distritos;
	private JList lista; 
	
	private JPanel subPInfra;
	
	
	public CrearProyectoInfPanel() {
		
		this.setLayout(new BorderLayout());
		this.nombreProyecto = new JLabel("Nombre del proyecto:");
		this.textNombreProyecto = new JTextField(30);
		this.descripcionCorta = new JLabel("Descripcion: ");
		this.textDescripcionCorta = new JTextField(10);
		this.descripcionLarga = new JLabel("Descripcion: ");
		this.textDescripcionLarga = new JTextField(10);
		this.financiacion = new JLabel("Financiacion necesaria: ");
		this.textFinanciacion = new JTextField(10);
		this.atras = new JButton("Atras");
		this.finalizar = new JButton("Finalizar");
		
		
		distritos = Aplicacion.getInstancia().getDistritos();
		DefaultListModel distritosModelo = new DefaultListModel(); 
		for(String d : distritos) {
			distritosModelo.addElement(d);
		}
		this.lista = new JList(distritosModelo);
		
		
		subPInfra = new JPanel(new GridLayout(3,3));
		subPInfra.add(nombreProyecto);
		subPInfra.add(textNombreProyecto);
		subPInfra.add(descripcionCorta);
		subPInfra.add(textDescripcionCorta);
		subPInfra.add(descripcionLarga);
		subPInfra.add(textDescripcionLarga);
		subPInfra.add(financiacion);
		subPInfra.add(textFinanciacion);
		subPInfra.add(lista);
		subPInfra.add(atras);
		subPInfra.add(finalizar);
		

	
		
		this.add(subPInfra);

	}
	
	public void setControlador(ActionListener c) {

		
		atras.addActionListener(c);
		finalizar.addActionListener(c);
		
	}

	public void getNombre() {
		this.textNombreProyecto.getText();
	}
	
	public void getDescripcionC() {
		this.textDescripcionCorta.getText();
	}

	public void getDescripcionL() {
		this.textDescripcionLarga.getText();
	}
	
	public void getFinanciacion() {
		this.textFinanciacion.getText();
	}

	
}
