package BP.Vista;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DetallesProyectoPanel extends JFrame {
	private JPanel subPInf;
	private JPanel subPSocial;
	
	private JButton botonVolver;
	
	private JLabel etiquetaNombre;
	private JLabel nombre;
	
	private JLabel etiquetaDesCorta;
	private JLabel desCorta;
	
	private JLabel etiquetaDesLarga;
	private JLabel desLarga;
	
	private JLabel etiquetaFechaCre;
	private JLabel fechaCre;
	
	private JLabel etiquetaFechaUlt;
	private JLabel fechaUlt;
	
	private JLabel etiquetaCoste;
	private JLabel coste;
	
	//proyectos sociales
	private JLabel etiquetagSocial;
	private JLabel gSocial;
	

	private JLabel nacional;
	public DetallesProyectoPanel() {
		JPanel subPSocial = new JPanel();
		JPanel subPInf = new JPanel();
		this.botonVolver = new JButton("Volver");
		this.etiquetaNombre = new JLabel("Nombre:");
		this.nombre = new JLabel("");
		this.etiquetaDesCorta = new JLabel("Descripcion Corta:");
		this.desCorta = new JLabel("");
		this.etiquetaDesLarga = new JLabel("Descripcion Larga:");
		this.desLarga = new JLabel("");
		this.etiquetaFechaCre = new JLabel("Creado en:");
		this.fechaCre = new JLabel("");
		this.etiquetaFechaUlt = new JLabel("Ultimo apoyo en:");
		this.fechaUlt = new JLabel("");
		this.etiquetaCoste = new JLabel("Financiacion:");
		this.coste = new JLabel("");
		this.etiquetagSocial = new JLabel("Grupo Social:");
		this.gSocial = new JLabel("");
		this.nacional = new JLabel("");
		
		subPSocial.add(botonVolver);
		subPSocial.add(etiquetaNombre);
		subPSocial.add(nombre);
		subPSocial.add(etiquetaDesCorta);
		subPSocial.add(desCorta);
		subPSocial.add(etiquetaDesLarga);
		subPSocial.add(desLarga);
		subPSocial.add(etiquetaFechaCre);
		subPSocial.add(fechaCre);
		subPSocial.add(etiquetaFechaUlt);
		subPSocial.add(fechaUlt);
		subPSocial.add(etiquetaCoste);
		subPSocial.add(coste);
		subPSocial.add(etiquetagSocial);
		subPSocial.add(gSocial);
		subPSocial.add(nacional);
		subPSocial.add(botonVolver);
		
		subPInf.add(etiquetaNombre);
		subPInf.add(nombre);
		subPInf.add(etiquetaDesCorta);
		subPInf.add(desCorta);
		subPInf.add(etiquetaDesLarga);
		subPInf.add(desLarga);
		subPInf.add(etiquetaFechaCre);
		subPInf.add(fechaCre);
		subPInf.add(etiquetaFechaUlt);
		subPInf.add(fechaUlt);
		subPInf.add(etiquetaCoste);
		subPInf.add(coste);
	}
	public void setControlador(ActionListener c) {
		this.botonVolver.addActionListener(c);
	}
}
