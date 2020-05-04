package BP.Vista;

import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;

import BP.Controlador.ControladorCrearProyectoInf;
import BP.Controlador.ControladorUsuario;
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
	private JLabel textIntroduceElNombreArchivoPNG;
	private JLabel introduceElNombreArchivoPNG2;
	private JLabel textIntroduceElNombreArchivoPNG2;
	private JButton atras;
	private JButton finalizar;
	
	public HashSet<String> distritos;
	private DefaultListModel distritosModelo;
	private JList lista; 
	private JScrollPane scroll;
	
	private JPanel subPInfra;
	private JButton botonAbrirImg;
	private JButton botonAbrirCroquis;

	private JFileChooser f1;
	private JFileChooser f2 ;
	
	public CrearProyectoInfPanel() {
		
		this.setLayout(new GridLayout(2,8));
		this.nombreProyecto = new JLabel("Nombre del proyecto:");
		this.textNombreProyecto = new JTextField(10);
		this.descripcionCorta = new JLabel("Descripcion Corta: ");
		this.textDescripcionCorta = new JTextField(10);
		this.descripcionLarga = new JLabel("Descripcion Larga: ");
		this.textDescripcionLarga = new JTextField(10);
		this.financiacion = new JLabel("Financiacion necesaria: ");
		this.textFinanciacion = new JTextField(10);
		
		this.introduceElNombreArchivoPNG = new JLabel("Introduce la Imagen");
		this.textIntroduceElNombreArchivoPNG =  new JLabel("");
		
		this.introduceElNombreArchivoPNG2 = new JLabel("Introduce el Croquis");
		this.textIntroduceElNombreArchivoPNG2 = new JLabel("");
		this.atras = new JButton("Atras");
		this.finalizar = new JButton("Finalizar");
		this.botonAbrirImg = new JButton("Abrir Imagen");
	    this.botonAbrirCroquis =  new JButton("Abrir Coquis");
		
	  
        this.f1 = new JFileChooser();
        this.f2 = new JFileChooser();
	    
		distritos = Aplicacion.getInstancia().getDistritos();
		distritosModelo = new DefaultListModel(); 
		for(String d : distritos) {
			distritosModelo.addElement(d);
		}
		this.lista = new JList(distritosModelo);
		this.scroll = new JScrollPane(this.lista);
		
		subPInfra = new JPanel(new GridLayout(3,3));
		subPInfra.add(nombreProyecto);
		subPInfra.add(textNombreProyecto);
		subPInfra.add(descripcionCorta);
		subPInfra.add(textDescripcionCorta);
		subPInfra.add(descripcionLarga);
		subPInfra.add(textDescripcionLarga);
		subPInfra.add(financiacion);
		subPInfra.add(textFinanciacion);
		
		//imagen
		subPInfra.add(introduceElNombreArchivoPNG);
		subPInfra.add(textIntroduceElNombreArchivoPNG);
		subPInfra.add(this.botonAbrirImg);
		//croquis
		subPInfra.add(introduceElNombreArchivoPNG2);
		subPInfra.add(textIntroduceElNombreArchivoPNG2);
		subPInfra.add(this.botonAbrirCroquis);
		
		subPInfra.add(lista);
		subPInfra.add(atras);
		subPInfra.add(finalizar);
		this.lista.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

	
		
		this.add(subPInfra);

	}
	
	public void setControlador(ControladorCrearProyectoInf c) {

		
		atras.addActionListener(c);
		finalizar.addActionListener(c);
		this.lista.addListSelectionListener(c);
		this.botonAbrirImg.addActionListener(c);
		this.botonAbrirCroquis.addActionListener(c);
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
	

	public JFileChooser getf1() {
		return this.f1;
	}
	
	public JFileChooser getf2() {
		return this.f2;
	}
	
	
	public void setPathImagen(String s) {
		this.textIntroduceElNombreArchivoPNG.setText(s);
	}
	
	public void setPathCroquis(String s) {
		this.textIntroduceElNombreArchivoPNG2.setText(s);
	}
	
}
