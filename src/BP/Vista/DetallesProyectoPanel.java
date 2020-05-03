package BP.Vista;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import BP.Modelo.Proyecto;

import java.util.Date;

public class DetallesProyectoPanel extends JPanel {
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
	private JLabel adicionalSocial;
	
	public DetallesProyectoPanel() {
		this.setLayout(new BorderLayout());
		JPanel subPSocial = new JPanel(new GridLayout(2,8));
		JPanel subPInf = new JPanel(new GridLayout(2,8));
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
		this.adicionalSocial = new JLabel("");
		
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
		subPSocial.add(adicionalSocial);
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
	public void setDetallesSocial(Proyecto p) {
		this.nombre.setText(p.getNombre());
		this.desCorta.setText(p.getDescripcionCorta());
		this.desLarga.setText(p.getDescripcionLarga());
		this.fechaCre.setText(p.getFechaCreacion().toString());
		this.fechaUlt.setText(p.getFechaUltimoApoyo().toString());
		this.coste.setText(String.valueOf(p.getCoste()));
		this.adicionalSocial.setText(p.getExtraData());
		this.remove(subPInf);
		this.add(subPSocial);
	}
	public void setDetallesInf(Proyecto p) {
		
		this.nombre.setText(p.getNombre());
		this.desCorta.setText(p.getDescripcionCorta());
		this.desLarga.setText(p.getDescripcionLarga());
		this.fechaCre.setText(p.getFechaCreacion().toString());
		this.fechaUlt.setText(p.getFechaUltimoApoyo().toString());
		this.coste.setText(String.valueOf(p.getCoste()));
		this.remove(subPSocial);
		this.add(subPInf);
	}

	
}
