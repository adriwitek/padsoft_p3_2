package BP.Vista;

import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;

import javax.swing.*;

import BP.Modelo.Aplicacion;

public class CrearProyectoInfPanel extends JPanel{
	private JLabel descripcion;
	private JTextField textDescripcion;
	private JLabel financiacion;
	private JTextField textFinanciacion;
	private JButton atras;
	private JButton finalizar;
	
	public HashSet<String> distritos;
	private JList lista; 
	
	private JPanel subPInfra;
	
	
	public CrearProyectoInfPanel() {
		
		this.setLayout(new BorderLayout());
		this.descripcion = new JLabel("Descripcion: ");
		this.textDescripcion = new JTextField(10);
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
		subPInfra.add(descripcion);
		subPInfra.add(textDescripcion);
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



	
}
