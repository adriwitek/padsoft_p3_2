package BP;


import java.awt.EventQueue;
import BP.Modelo.*;
import BP.Vista.*;
import BP.Controlador.*;


public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {						
					VentanaPrincipal frame = new VentanaPrincipal("BP:Becoming a Project");
					Aplicacion modeloApp = Aplicacion.getInstancia("admin", "1234",1); //login del admin
					modeloApp.loadAplicacion();


					Controlador controlador = new Controlador(frame, modeloApp);
					frame.setControlador(controlador);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}






