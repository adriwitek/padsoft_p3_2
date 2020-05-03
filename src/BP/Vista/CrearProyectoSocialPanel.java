package BP.Vista;

import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;

import javax.swing.*;

import BP.Modelo.Aplicacion;



public class CrearProyectoSocialPanel extends JPanel{

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

	private JLabel grupoSocial;
	private JTextField textGrupoSocial;
	
	private JPanel subP1;
	private JPanel subPSocial; 
	private JRadioButton nacional;
	private JLabel aux;
	
	public CrearProyectoSocialPanel() {
		this.setLayout(new BorderLayout());
		this.nombreProyecto = new JLabel("Nombre del proyecto:");
		this.textNombreProyecto = new JTextField(30);
		this.descripcionCorta = new JLabel("Descripcion Corta: ");
		this.textDescripcionCorta = new JTextField(10);
		this.descripcionLarga = new JLabel("Descripcion Larga: ");
		this.textDescripcionLarga = new JTextField(10);
		
		this.financiacion = new JLabel("Financiacion necesaria: ");
		this.textFinanciacion = new JTextField(10);
		this.grupoSocial = new JLabel("Grupo Social: ");
		this.textGrupoSocial = new JTextField(10);
		this.nacional = new JRadioButton("Proyecto nacional");
		this.aux = new JLabel("");
		this.atras = new JButton("atras");
		this.finalizar = new JButton("finalizar");
		
		subPSocial = new JPanel(new GridLayout(10,1));
		subPSocial.add(nombreProyecto);
		subPSocial.add(textNombreProyecto);
		subPSocial.add(descripcionCorta);
		subPSocial.add(textDescripcionCorta);
		subPSocial.add(descripcionLarga);
		subPSocial.add(textDescripcionLarga);
		subPSocial.add(financiacion);
		subPSocial.add(textFinanciacion);
		subPSocial.add(grupoSocial);
		subPSocial.add(textGrupoSocial);
		subPSocial.add(nacional);
		subPSocial.add(aux);
		
		subPSocial.add(atras);
		subPSocial.add(finalizar);
		
		this.add(subPSocial);

	}
	
	
	public void setControlador(ActionListener c) {	
		atras.addActionListener(c);
		finalizar.addActionListener(c);
		
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
	
	public String getGrupoSocial() {
		return this.textGrupoSocial.getText();
	}
	
	public boolean getNacional() {
		return this.nacional.isSelected();
	}
}
