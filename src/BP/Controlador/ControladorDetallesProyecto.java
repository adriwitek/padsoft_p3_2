package BP.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import BP.Modelo.Aplicacion;
import BP.Vista.ColectivosPanel;
import BP.Vista.UsuarioPanel;
import BP.Vista.VentanaPrincipal;

public class ControladorDetallesProyecto implements ActionListener {
	private UsuarioPanel panel;
    private VentanaPrincipal frame;
    private Aplicacion modelo; 
	public ControladorDetallesProyecto(VentanaPrincipal frame, Aplicacion modelo) {
	        this.panel = frame.getPanelUsuario();
	        this.frame = frame;
	        this.modelo = modelo;
	    }
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Volver")) {
			volverToUsuario();
		}
		
	}
	private void volverToUsuario() {
        UsuarioPanel pUser = frame.getPanelUsuario();
        pUser.setVisible(true);
        this.panel.setVisible(false);
    }
}
