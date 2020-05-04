package BP.Controlador;

import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;

import javax.swing.*;
import BP.Modelo.*;
import BP.Vista.*;


public class ControladorLogin implements ActionListener {

	private LoginPanel panel;
	private VentanaPrincipal frame;
	private Aplicacion modelo;
	
	/**
	 * Este es el controlador de ControladorLogin
	 * @param frame
	 * @param modelo
	 */
	public ControladorLogin(VentanaPrincipal frame ,Aplicacion modelo) {
		this.panel= frame.getPanelLogin();
		this.frame= frame;
		this.modelo=modelo;
	}
	
	
	/**
	 * Esta funcion se encargara de que al interactuar con el programa(dar a un boton, escribir en un texto, seleccionar un valor de una list, etc)
	 * se realice la accion correspondiente.
	 * @param e es el actionEvent
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
	
		
		if(e.getActionCommand().equals("LogIn")) {
			login();

		}else {
			frame.getPanelBienvenida().setVisible(true);
			this.panel.setVisible(false);
		}
		
	}
	
	
	/**
	 * Esta funcion se encarga de crear la funcionalidad del botom login
	 * de tal manera que la aplicacionse iria al panel de usuario si los valores de nombre y contraseña son los correctos
	 */
	private void login() {
		
		// validar valores en la vista
		String nombreUsuario = panel.getNombreUsuario();
		String password = panel.getPassword();
		if (nombreUsuario.equals("") || password.equals("") ) {
			JOptionPane.showMessageDialog(panel,
					"Debe introducir un nombre y una contraseña.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		
		
		// modificar modelo
		if( !modelo.loginAdmin(nombreUsuario, password) && !modelo.loginUser(nombreUsuario, password) ) {
			Usuario u1 = null;
            for(Usuario u : modelo.getUsuariosBloqueados()) {
                if(u.getNIF().equals(nombreUsuario) || u.getNombre().equals(nombreUsuario)) {
                    u1=u;
                    break;
                }
            }

            if(u1 !=null) {
                JOptionPane.showMessageDialog(panel,  u1.getnBloqueoDeAdmin().getDescripcion(), u1.getnBloqueoDeAdmin().getTitulo(), JOptionPane.ERROR_MESSAGE);
                return;
            }else {
                JOptionPane.showMessageDialog(panel,"Las credenciales son incorrectas. Intentalo de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
			
            
		}
		
		 
	
		// mostrar nueva vista 
		if(modelo.isModoAdmin()) {
			AdminPanel pAdmin = frame.getPanelAdmin();
			pAdmin.setModeloProyectosValidacion(modelo.getProyectosPendientesValidacion() );
			pAdmin.setVisible(true);
			this.panel.setVisible(false);
		}
		else {
			UsuarioPanel pUsuario = frame.getPanelUsuario();
			loadUserInfo();
			pUsuario.setVisible(true);
			this.panel.setVisible(false);
		}
	}

	
	/**
	 * Esta funcion se encarga de cargar toda la informacion de un usuario especificado
	 * @param pUsuario usuario del que se va a cargar la informacion
	 */
	public void loadUserInfo() {
		UsuarioPanel pUsuario = frame.getPanelUsuario();
        pUsuario.setNumeroNIF(modelo.getUsuarioConectado().getNIF());
        pUsuario.setNombreUsuario(modelo.getUsuarioConectado().getNombre());
        pUsuario.setListaProyectos(modelo.getProyectosApoyables(modelo.getUsuarioConectado()));
        pUsuario.setListaColectivos(modelo.getColectivosDisponibles(modelo.getUsuarioConectado()));
        frame.getPanelProyectos().setTusProyectos(modelo.getProyectosUsuario(modelo.getUsuarioConectado()));
        frame.getPanelColectivos().setListaProyectos(modelo.getProyectosApoyables(modelo.getUsuarioConectado()));
        frame.getPanelColectivos().setListaColectivos(modelo.getColectivosUsuario(modelo.getUsuarioConectado()));
        pUsuario.setModeloNotificaciones(modelo.getUsuarioConectado().getAllNotificaciones());
    }

	
}
