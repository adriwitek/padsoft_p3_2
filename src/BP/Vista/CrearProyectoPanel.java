package BP.Vista;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class CrearProyectoPanel extends JPanel{
	
	//Panel subP1
	private JButton cancelar;
	private JLabel nombreProyecto;
	private JTextField textNombreProyecto;
	private JButton PSocial;
	private JButton PInfraestructuras;
	
	//Panel subPSocial y subPinfra
	private JLabel descripcion;
	private JTextField textDescripcion;
	private JLabel financiacion;
	private JTextField textFinanciacion;
	private JButton atras;
	private JButton finalizar;
	
	//Panel subPSocial
	private JLabel grupoSocial;
	private JTextField textGrupoSocial;
	
	//Panel subPInfra
	/*----->INCLUIR LISTA DISTRITOS<----*/
	/*----->INCLUIR IMAGEN<----*/
	
	
	public CrearProyectoPanel() {
		this.setLayout(new BorderLayout());
		//subP1
		this.cancelar = new JButton("Cancelar");
		this.nombreProyecto = new JLabel("Nombre del proyecto:");
		this.textNombreProyecto = new JTextField(30);
		this.PSocial = new JButton("ProyectoSocial");
		this.PInfraestructuras = new JButton("ProyectoInfraestructuras");
		
		JPanel subP1 = new JPanel(new GridLayout(2,2));
		subP1.add(cancelar);
		subP1.add(textNombreProyecto);
		subP1.add(PSocial);
		subP1.add(PInfraestructuras);
		
		
		//subPSocial y subPInfra
		this.descripcion = new JLabel("Descripcion: ");
		this.textDescripcion = new JTextField(50);
		this.financiacion = new JLabel("Financiacion necesaria: ");
		this.textFinanciacion = new JTextField(10);
		this.atras = new JButton("Atras");
		this.finalizar = new JButton("Finalizar");
		
		JPanel subPSocial = new JPanel(new GridLayout(2,2));
		subPSocial.add(descripcion);
		subPSocial.add(textDescripcion);
		subPSocial.add(financiacion);
		subPSocial.add(textFinanciacion);
		subPSocial.add(atras);
		subPSocial.add(finalizar);
		
		
		JPanel subPInfra = new JPanel(new GridLayout(2,2));
		subPInfra.add(descripcion);
		subPInfra.add(textDescripcion);
		subPInfra.add(financiacion);
		subPInfra.add(textFinanciacion);
		subPInfra.add(atras);
		subPInfra.add(finalizar);
		
		
		//subPSocial
		this.grupoSocial = new JLabel("Grupo Social: ");
		this.textGrupoSocial = new JTextField(10);
		this.add(subPSocial);
		
		//subPInfra
		this.add(subPInfra);
		
		//subP1 
		this.add(subP1);

	}
	
	public void setControlador(ActionListener c) {
		cancelar.addActionListener(c);
		PSocial.addActionListener(c);
		PInfraestructuras.addActionListener(c);
		
		atras.addActionListener(c);
		finalizar.addActionListener(c);
		
	}
	


	
}
