package BP.Vista;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import BP.Controlador.ControladorDetallesProyecto;
import BP.Modelo.Proyecto;

import java.util.Date;

public class DetallesProyectoPanel extends JPanel {
	private JPanel subP1;
	
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
		subP1 = new JPanel(new GridLayout(9,2));
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
		
		subP1.add(etiquetaNombre);
		subP1.add(nombre);
		subP1.add(etiquetaDesCorta);
		subP1.add(desCorta);
		subP1.add(etiquetaDesLarga);
		subP1.add(desLarga);
		subP1.add(etiquetaFechaCre);
		subP1.add(fechaCre);
		subP1.add(etiquetaFechaUlt);
		subP1.add(fechaUlt);
		subP1.add(etiquetaCoste);
		subP1.add(coste);
		subP1.add(adicionalSocial);
		subP1.add(adicionalInf);
		subP1.add(botonVolver);
		
		this.add(subP1);
	}
	public void setControlador(ControladorDetallesProyecto c) {
		this.botonVolver.addActionListener(c);
	}
	public void setDetallesSocial(Proyecto p) {
		subP1.remove(adicionalInf);
		subP1.add(adicionalSocial);
		this.nombre.setText(p.getNombre());
		this.desCorta.setText(p.getDescripcionCorta());
		this.desLarga.setText(p.getDescripcionLarga());
		this.fechaCre.setText(p.getFechaCreacion().toString());
		this.fechaUlt.setText(p.getFechaUltimoApoyo().toString());
		this.coste.setText(String.valueOf(p.getCoste()));
		this.adicionalSocial.setText(p.getExtraData());
	}
	public void setDetallesInf(Proyecto p) {
		subP1.remove(adicionalSocial);
		subP1.add(adicionalInf);
		this.nombre.setText(p.getNombre());
		this.desCorta.setText(p.getDescripcionCorta());
		this.desLarga.setText(p.getDescripcionLarga());
		this.fechaCre.setText(p.getFechaCreacion().toString());
		this.fechaUlt.setText(p.getFechaUltimoApoyo().toString());
		this.coste.setText(String.valueOf(p.getCoste()));
		this.adicionalInf.setText(p.getExtraData());
	}

}
