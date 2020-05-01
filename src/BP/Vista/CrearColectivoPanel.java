package BP.Vista;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CrearColectivoPanel extends JPanel {

	private JLabel nombreColectivo;
	private JTextField textNombreColectivo;
	private JLabel nombreDescripcion;
	private JTextField textNombreDescripcion;
	private JButton cancelar;
	private JButton finalizar;
	
	//paneles
	private JPanel subP1;
	
	
	public CrearColectivoPanel() {
		this.setLayout(new BorderLayout());
		
		this.nombreColectivo = new JLabel("Nombre colectivo: ");
		this.textNombreColectivo = new JTextField(30);
		
		this.nombreDescripcion = new JLabel("Descripcion: ");
		this.textNombreDescripcion = new JTextField(500);
		
		this.cancelar = new JButton("Cancelar");
		this.finalizar = new JButton("Finalizar");
		
		subP1 = new JPanel(new GridLayout(2,2));
		
		subP1.add(nombreColectivo);
		subP1.add(textNombreColectivo);
		subP1.add(nombreDescripcion);
		subP1.add(textNombreDescripcion);
		subP1.add(cancelar);
		subP1.add(finalizar);
		
		this.add(subP1);
	}
	
	public void setControlador(ActionListener c) {
		cancelar.addActionListener(c);
		finalizar.addActionListener(c);
	}
}
