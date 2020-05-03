package BP.Vista;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import BP.Controlador.ControladorDetallesProyecto;
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
	private JLabel adicionalInf;
	
	public DetallesProyectoPanel() {
		this.setLayout(new BorderLayout());
		subPSocial = new JPanel(new GridLayout(8,2));
		subPInf = new JPanel(new GridLayout(8,2));
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
		this.adicionalInf = new JLabel("");
		
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
		subPInf.add(adicionalInf);
		subPInf.add(botonVolver);
		this.add(subPSocial);
	}
	public void setControlador(ControladorDetallesProyecto c) {
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
	}
	public void setDetallesInf(Proyecto p) {
		
		this.nombre.setText(p.getNombre());
		this.desCorta.setText(p.getDescripcionCorta());
		this.desLarga.setText(p.getDescripcionLarga());
		this.fechaCre.setText(p.getFechaCreacion().toString());
		this.fechaUlt.setText(p.getFechaUltimoApoyo().toString());
		this.coste.setText(String.valueOf(p.getCoste()));
		this.adicionalInf.setText(p.getExtraData());
		this.add(subPInf);
		this.remove(subPSocial);
	}

	
}
