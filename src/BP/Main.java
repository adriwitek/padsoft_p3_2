package BP;

import java.io.IOException;
import java.awt.EventQueue;

import BP.Modelo.*;
import BP.Vista.*;
import BP.Controlador.*;
 

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, IOException  {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {						
					Aplicacion modelo = Aplicacion.getInstancia("admin", "1234",1); //login del admin
					modelo.loadAplicacion(); 
					modelo = Aplicacion.getInstancia();
					   
					
					VentanaPrincipal frame = new VentanaPrincipal( modelo,"BP:Becoming a Project");

					Controlador controlador = new Controlador(frame, modelo);

					frame.setControlador(controlador);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}



 


