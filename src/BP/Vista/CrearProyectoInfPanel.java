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
	private JLabel introduceElNombreArchivoPNG;
	private JTextField textIntroduceElNombreArchivoPNG;
	private JLabel introduceElNombreArchivoPNG2;
	private JTextField textIntroduceElNombreArchivoPNG2;
	private JButton infoFoto;
	private JButton atras;
	private JButton finalizar;
	
	public HashSet<String> distritos;
	private JList lista; 
	
	private JPanel subPInfra;
	
	
	public CrearProyectoInfPanel() {
		
		this.setLayout(new BorderLayout());
		this.nombreProyecto = new JLabel("Nombre del proyecto:");
		this.textNombreProyecto = new JTextField(10);
		this.descripcionCorta = new JLabel("Descripcion: ");
		this.textDescripcionCorta = new JTextField(10);
		this.descripcionLarga = new JLabel("Descripcion: ");
		this.textDescripcionLarga = new JTextField(10);
		this.financiacion = new JLabel("Financiacion necesaria: ");
		this.textFinanciacion = new JTextField(10);
		this.introduceElNombreArchivoPNG = new JLabel("Introduce el nombre del archivo (.png) Croquis");
		this.textIntroduceElNombreArchivoPNG = new JTextField(10);
		this.introduceElNombreArchivoPNG2 = new JLabel("Introduce el nombre del archivo (.png) Foto");
		this.textIntroduceElNombreArchivoPNG2 = new JTextField(10);
		this.infoFoto = new JButton("infoFoto");
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
		subPInfra.add(introduceElNombreArchivoPNG);
		subPInfra.add(textIntroduceElNombreArchivoPNG);
		subPInfra.add(introduceElNombreArchivoPNG2);
		subPInfra.add(textIntroduceElNombreArchivoPNG2);
		subPInfra.add(infoFoto);
		subPInfra.add(lista);
		subPInfra.add(atras);
		subPInfra.add(finalizar);
		

	
		
		this.add(subPInfra);

	}
	
	public void setControlador(ActionListener c) {

		
		atras.addActionListener(c);
		finalizar.addActionListener(c);
		infoFoto.addActionListener(c);
		
	}

	public String getNombre() {
		return this.textNombreProyecto.getText();
	}
	
	public String getDescripcionC() {
		return this.textDescripcionCorta.getText();
	}

	public String getDescripcionL() {
		return this.textDescripcionLarga.getText();
	}
	
	public String getFinanciacion() {
		return this.textFinanciacion.getText();
	}
	
	public String getNombreArchivoPNG() {
		return this.textIntroduceElNombreArchivoPNG.getText();
	}
	
	public String getNombreArchivoPNG2() {
		return this.textIntroduceElNombreArchivoPNG2.getText();
	}
	
	/*public String getDistrito() {
		
	}*/
	
}
