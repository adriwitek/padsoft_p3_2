package BP.Vista;

import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;

import javax.swing.*;

import BP.Modelo.Aplicacion;
import BP.Modelo.Colectivo;

/** 
* 
* @author Adián Rubio adrian.rubiop@estudiante.uam.es, Guillermo Solla guillermo.solla@estudiante.uam.es 
* y Diego Tapia diego.tapias@estudiante.uam.es
*/
public class CrearProyectoPanel extends JPanel{

    //Panel subP1
    private JButton cancelar;

    private JButton PSocial;
    private JButton PInfraestructuras;

    private JPanel subP1;
    /**
     * Este es el constructor de CrearProyectoPanel, contiene el panel subP1, ademas contiene la creacion e introduccion de todos los 
     * elementos-objetos en el panel subP1
     */
    public CrearProyectoPanel() {
        this.setLayout(new BorderLayout());
        //subP1
        this.cancelar = new JButton("Cancelar");
        this.PSocial = new JButton("ProyectoSocial");
        this.PInfraestructuras = new JButton("ProyectoInfraestructuras");

        subP1 = new JPanel(new GridLayout(10,10));
        subP1.add(cancelar);
        subP1.add(PSocial);
        subP1.add(PInfraestructuras);

        subP1.setVisible(true);
        this.add(subP1);

    }
    /**
     * Esta es la funcion setControlador, se encarga de permitir que algunos de los objetos que hemos introducido en el panel
	 * tengan una funcionalidad(es para objetos como botones, listas, etc)
     * @param c es el campo actionListener que nos permitira utilizar la funcionalidad correcta del controlador que le corresponda a este panel
     */
    public void setControlador(ActionListener c) {
        cancelar.addActionListener(c);
        PSocial.addActionListener(c);
        PInfraestructuras.addActionListener(c);

    }
}

