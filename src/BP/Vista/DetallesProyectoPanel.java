package BP.Vista;


import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import BP.Controlador.ControladorDetallesProyecto;
import BP.Modelo.Proyecto;

import java.util.Date;
/** 
* 
* @author Adi�n Rubio adrian.rubiop@estudiante.uam.es, Guillermo Solla guillermo.solla@estudiante.uam.es 
* y Diego Tapia diego.tapias@estudiante.uam.es
*/
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
	private JLabel labelImg;
	private JLabel labelCroquis;
	private JPanel subP3;
	
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
		this.labelImg = new JLabel("");
		this.labelCroquis = new JLabel("");
		
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
		
		
		//infra
		subP1.add(labelDistritos);
		subP1.add(distritos);
		this.subP3 = new JPanel();

		subP3.add(labelImg);
		subP3.add(labelCroquis);

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
		this.add(subP3);
		

		
	}
	/**
	 *  Esta es la funcion setControlador, se encarga de permitir que algunos de los objetos que hemos introducido en el panel
	 * tengan una funcionalidad(es para objetos como botones, listas, etc)
	 * @param c es el controlador donde nosotros tenemos guardada la funcionalidad del boton volver
	 */
	public void setControlador(ControladorDetallesProyecto c) {
		this.botonVolver.addActionListener(c);
	}
	/**
	 * Esta funcioncion eliminara los elemento-objetos adicionales para proyectos de infraestructuras e introducira los datos especificos en los campos
	 * de proyecto social
	 * @param p proyecto del que se quiere ver detalles
	 */
	public void setDetallesSocial(Proyecto p) {

        subP1.remove(labelDistritos);
        subP1.remove(distritos);
        subP3.remove(labelImg);
        subP3.remove(labelCroquis);




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

	/**
	 * Esta funcion introduce detalles inraestructuras
	 * @param p proyecto
	 * @param imgPath foto 
	 * @param croquisPath foto
	 */
	public void setDetallesInf(Proyecto p,String imgPath,String croquisPath) {

        subP1.remove(labelNacional);
        subP1.remove(nacional);
        subP1.remove(labelGrupoSocial);
        subP1.remove(grupoSocial);
        subP3.remove(labelImg);
        subP3.remove(labelCroquis);

        try {
            BufferedImage img;
            img = ImageIO.read(new File(imgPath));
            BufferedImage croquis = ImageIO.read(new File(croquisPath));
            this.labelImg = new JLabel(new ImageIcon(img));
            this.labelCroquis =  new JLabel(new ImageIcon(croquis));
        } catch (IOException e) {
            e.printStackTrace();
        }



        subP1.add(labelDistritos);
        subP1.add(distritos);
        subP3.add(labelImg);
        subP3.add(labelCroquis);

        this.nombre.setText(p.getNombre());
        this.desCorta.setText(p.getDescripcionCorta());
        this.desLarga.setText(p.getDescripcionLarga());
        this.fechaCre.setText(p.getFechaCreacion().toString());
        this.fechaUlt.setText(p.getFechaUltimoApoyo().toString());
        this.coste.setText(String.valueOf(p.getCoste()));


        this.distritos.setText(p.getExtraData());
    }

}
