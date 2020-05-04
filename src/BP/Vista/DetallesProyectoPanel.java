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
	
	//Poryecto Infraestructura
	private JLabel distritos;

	private JLabel labelDistritos;

	private JLabel labelNacional;

	private JLabel nacional;

	private JLabel labelGrupoSocial;

	private JLabel grupoSocial;
	
	
	public DetallesProyectoPanel() {
		this.setLayout(new FlowLayout());
		subP1 = new JPanel(new GridLayout(11,2));
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
		//infra
		this.labelDistritos = new JLabel("Distritos");
		this.distritos = new JLabel("");
		//sociales
		this.labelNacional = new JLabel("Nacional");
		this.nacional = new JLabel("Nacional");
		this.labelGrupoSocial =new JLabel("Grupo Social");
		this.grupoSocial =new JLabel("");


		
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
		//subP1.add(adicionalSocial);
		//subP1.add(adicionalInf);
		
		//infra
		subP1.add(labelDistritos);
		subP1.add(distritos);
		//social
		subP1.add(labelNacional);
		subP1.add(nacional);
		subP1.add(labelGrupoSocial);
		subP1.add(grupoSocial);
		
		
		
		//SubP2
		JPanel subP2 = new JPanel();
		subP2.add(botonVolver);

		
		
		this.add(subP2);
		this.add(subP1);
		

		
	}
	public void setControlador(ControladorDetallesProyecto c) {
		this.botonVolver.addActionListener(c);
	}
	public void setDetallesSocial(Proyecto p) {
		
		subP1.remove(labelDistritos);
		subP1.remove(distritos);
		
		subP1.add(labelNacional);
		subP1.add(nacional);
		subP1.add(labelGrupoSocial);
		subP1.add(grupoSocial);
		
		this.nombre.setText(p.getNombre());
		this.desCorta.setText(p.getDescripcionCorta());
		this.desLarga.setText(p.getDescripcionLarga());
		this.fechaCre.setText(p.getFechaCreacion().toString());
		this.fechaUlt.setText(p.getFechaUltimoApoyo().toString());
		this.coste.setText(String.valueOf(p.getCoste()));
		String[] parts = p.getExtraData().split("_");
		
		this.nacional.setText(parts[0]);
		this.grupoSocial.setText(parts[1]);
		
	}
	public void setDetallesInf(Proyecto p) {
		
		subP1.remove(labelNacional);
		subP1.remove(nacional);
		subP1.remove(labelGrupoSocial);
		subP1.remove(grupoSocial);
		
		subP1.add(labelDistritos);
		subP1.add(distritos);

		
		this.nombre.setText(p.getNombre());
		this.desCorta.setText(p.getDescripcionCorta());
		this.desLarga.setText(p.getDescripcionLarga());
		this.fechaCre.setText(p.getFechaCreacion().toString());
		this.fechaUlt.setText(p.getFechaUltimoApoyo().toString());
		this.coste.setText(String.valueOf(p.getCoste()));
		
		
		this.distritos.setText(p.getExtraData());
	}

}
