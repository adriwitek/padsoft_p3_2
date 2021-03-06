package BP.Modelo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.stream.Stream;

import es.uam.eps.sadp.grants.CCGG;



public class Aplicacion implements java.io.Serializable {
	
	private static final long serialVersionUID = 1111;
	private static Aplicacion INSTANCE = null;
	private String ficheroCarga = "applicationBackup";
	private String distritosPath = "distritos/Distritos.txt";
	//Admin
	private String nombreAdmin;
	private String contraseñaAdmin;
	private Integer numMinApoyos;
	private Boolean modoAdmin;
	//Listados
	private HashSet<Proyecto> proyectos;
	private HashSet<Proponente> proponentes;
	private  int lastProjectUniqueID;
	private HashSet<String> distritosPermitidos;
	
	private Usuario usuarioConectado;//Usuario estandar que esta usando en este momento la apliacion
	
	 /**
	  * Constructor, con los datos a implementar
	  * @param nomAdmin que asignar a la aplicacion 
	  * @param contrasena para asignar a la aplicacion
	  * @param numMinApoyos para asignar a la aplicacion
	  */
	
	//Constructor
	private Aplicacion(String nomAdmin, String contrasena, Integer numMinApoyos) {
		
		if(nomAdmin.isEmpty()|| Objects.isNull(nomAdmin) ) {
			throw new IllegalArgumentException("Debes de introducir los datos validos");
		}
		
		this.nombreAdmin = nomAdmin;
		this.contraseñaAdmin = contrasena; 
		this.numMinApoyos = numMinApoyos;
		this.modoAdmin = false;
		
		this.proyectos = new HashSet<Proyecto>();
		this.proponentes = new HashSet<Proponente>();
		this.lastProjectUniqueID = 0;
		
		//Cargamos los distritos
		distritosPermitidos = new HashSet<String>();
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(distritosPath));
	           String d;
	           while((d = br.readLine()) != null){
	        	   this.distritosPermitidos.add(d);	               //Leer la siguiente línea
	           }
		}catch (FileNotFoundException e) {
	            System.out.println("Error: Fichero no encontrado");
	            System.out.println(e.getMessage());
	        
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		INSTANCE = this;
		
	}
	
	// **** CONSTRUCTOR SINGLETON ***/
	
	/**
	 * Esta funcion devuelve la instancia de la aplicacion
	 * 
	 * @param userAdmin	admin
	 * @param passwordAdmin pass
	 * @param numMinApoyos apoyos minimos
	 * @return the INSTANCE
	 */
	public static Aplicacion getInstancia(String userAdmin, String passwordAdmin,Integer numMinApoyos) {
		if (INSTANCE == null) {
			INSTANCE = new Aplicacion(userAdmin, passwordAdmin,numMinApoyos);
		}
		return INSTANCE;
	}
	
	
	
	
	
	
	/**
	 * Esta funcion devuelve la instancia ACTUAL de la aplicacion
	 * 
	 *
	 * @return Aplication
	 */
	public static Aplicacion getInstancia() {
		
		return INSTANCE;
	}
	
	
	
	
	/***** Funciones de Carga/Guardado ****/
	
	
	//Save
	
	/**
	 * Esta funcion se encarga de hacer save en la aplicacion, devolvera true en caso correcto
	 * 
	 * @return the true or false
	 */
	public boolean saveAplicacion() {
		try {
			this.logOut();
			ObjectOutputStream objectFile = new ObjectOutputStream(new FileOutputStream(ficheroCarga));
			objectFile.writeObject(getInstancia());
		}catch(Exception e) {
			
		}
		return true;
	}
	

	
	
	
	/**
	 * Esta funcion se encarga de cargar una aplicacion
	 * 
	 * @return the true or false
	 */
	public Boolean loadAplicacion() {
		//cargar app serializada
		
		try {
			
	        FileInputStream fileIn= new FileInputStream(ficheroCarga);
            ObjectInputStream entrada= new ObjectInputStream(fileIn);
            Aplicacion app = (Aplicacion)entrada.readObject();
            entrada.close();
            fileIn.close();
            if(app == null) {
            	return false;
            }else {
            	INSTANCE = app;
            	//Metodos de inicio y actuliazadion de datos de la App
    			INSTANCE.caducarProyectosAntiguos();
    			INSTANCE.actualizarProyectosFinanciados();
    			return true;
            }
		
		}catch(Exception e) {
			
			
		}
		
		return false;
	}
	
	
	/**
	 * Esta funcion cierra la aplicacion no sin antes hacer save de esta
	 * 
	 * @return the b
	 */
	public boolean exit() {
		this.logOut();
		Boolean b =  saveAplicacion();
		INSTANCE = null;
		return b ;
		
	}
	
	/**
	 * Esta funcion se encarga de caducar proyectos antiguos
	 */
	public void caducarProyectosAntiguos() {
		
		Date hoy = new Date();
		Date fecha;
		long days;
		for(Proyecto p: proyectos) {
			fecha = p.getFechaUltimoApoyo();
			days = ChronoUnit.DAYS.between(hoy.toInstant(),fecha.toInstant());
			if(days > 30) {
				p.caducarProyecto();
			}
		}
	}
	
	
	/**
	 * Esta funcion de encarga de actualizar los proyecto financiados
	 */
	public void actualizarProyectosFinanciados() {
		
		Double financiacion;
		for(Proyecto p: this.proyectos) {
			if(p.getEstadoProyecto()== EstadoProyecto.PENDIENTEFINANCIACION) {
				
				try {
					financiacion = CCGG.getGateway().getAmountGranted( p.getIdSeguimientoSistemaFinanciacion() );
					
					if(financiacion > 0) {
						p.financiarProyecto(financiacion);
					}else{
						p.rechazarProyecto("El sistema de financiacion ha denegado la financiacion del proyecto");
					}
					
				} catch ( NullPointerException e) {
					// TODO Auto-generated catch block
				
				
				} catch ( Exception e) {
				// TODO Auto-generated catch block
				}
				
				
			}
			
		}
	}
	
	
	
	
	
	

	
	//	***FUNCIONES LLAMADAS POR EL ADMIN***
	
	//loginAdmin
	/**
	 * Esta funcion se encarga de logear a un administrador
	 * 
	 * @param user user
	 * @param password pass
	 * @return the true or false
	 */
	public boolean loginAdmin(String user, String password) {
		//Inicio sesion administrador
		if(user.equals(this.nombreAdmin) && password.equals(this.contraseñaAdmin)) { 
			this.modoAdmin = true;
			return true;
		}
		return false;
	}
	
	/**
	 * Esta funcion devuelve un lista con los registros pendientes de aprobacion
	 * 
	 * @return the pendientes
	 */
	public HashSet<Usuario> getRegistrosPendientesDeAprobacion(){
		
		//if(!this.modoAdmin) return null;
		
		Usuario u;
		HashSet<Usuario> pendientes = new HashSet<Usuario>();
		for(Proponente p: this.proponentes) {
			if( p.getClass().getSimpleName().equals("Usuario")) {
				u = (Usuario)p;
				if(u.getEstado()== EstadoUsuario.PENDIENTE) {
					pendientes.add(u);
				}
				
			}
		}
		return pendientes;
	}
	
	
	
	
	
	/**
	 * Esta funcion devuelve un lista con los usuarios activos,necesaria para la gui
	 * 
	 * @return  the HashSet usuario
	 */
	public HashSet<Usuario> getUsuariosActivos(){
		
		//if(!this.modoAdmin) return null;
		
		Usuario u;
		HashSet<Usuario> usuarios = new HashSet<Usuario>();
		for(Proponente p: this.proponentes) {
			if( p.getClass().getSimpleName().equals("Usuario")) {
				u = (Usuario)p;
				if(u.getEstado()== EstadoUsuario.OPERATIVO) {
					usuarios.add(u);
				}
				
			}
		}
		return usuarios;
	}
	 
	
	
	
	
	
	
	/**
	 * Esta funcion devuelve un lista con los usuarios activos,necesaria para la gui
	 * 
	 * @return  the HashSet usuarios
	 */
	public HashSet<Usuario> getUsuariosBloqueados(){
		
		//if(!this.modoAdmin) return null;
		
		Usuario u;
		HashSet<Usuario> usuarios = new HashSet<Usuario>();
		for(Proponente p: this.proponentes) {
			if( p.getClass().getSimpleName().equals("Usuario")) {
				u = (Usuario)p;
				if(u.getEstado()== EstadoUsuario.BLOQUEADO) {
					usuarios.add(u);
				}
				
			}
		}
		return usuarios;
	}
	
	
	
	
	
	
	
	/**
	 * Esta funcion se encarga de validar un registro
	 * 
	 * @param u usuario
	 * @return the true or false
	 */
	public Boolean validarRegistro(Usuario u) {
		if(!this.modoAdmin) return false ;
		u.aprobar();
		return true;
	}
	
	
	/**
	 * Esta funcion se encarga de rechazar un registro
	 * 
	 * @param u usuario
	 * @param motivo motivo
	 * @return the true or false
	 */
	public Boolean rechazarRegistro(Usuario u,String motivo) {
		if(!this.modoAdmin) return false;
		u.rechazar(motivo);
		this.proponentes.remove(u);
		return true;
	}
	
	/**
	 * Esta funcion se encarga de devolver una lista con los proyectos que han solicitado financiacion
	 * 
	 * @return the listado
	 */
	public HashSet<Proyecto> getProyectosSolicitandoFinanciacion(){
		
		//if(!this.modoAdmin) return null;//fix para la gui
		HashSet<Proyecto> listado = new HashSet<Proyecto>();
		for(Proyecto p: this.proyectos) {
			if(p.getEstadoProyecto() == EstadoProyecto.PENDIENTEFINANCIACION) {
				listado.add(p);
			}
		}
		//return (HashSet<Proyecto>) Collections.unmodifiableSet(listado);
		//posteriormente hay que modificarlos, controlar la llamada a la fucnion
		return listado;
	} 
	
	
	
	/**
	 * Esta funcion se encarga de devolver una lista con los proyectos pendientes de validar por el admin
	 * 
	 * @return listado
	 */
	public HashSet<Proyecto> getProyectosPendientesValidacion(){
		
		//if(!this.modoAdmin) return null;//fix para la gui
		HashSet<Proyecto> listado = new HashSet<Proyecto>();
		for(Proyecto p: this.proyectos) {
			if(p.getEstadoProyecto() == EstadoProyecto.PENDIENTEVALIDACION) {
				listado.add(p);
			}
		}
		//return (HashSet<Proyecto>) Collections.unmodifiableSet(listado);
		//posteriormente hay que modificarlos, controlar la llamada a la fucnion
		return listado;
	} 
	
	
	
	
	
	
	
	public HashSet<Proyecto> getProyectosApoyables(Usuario user){
		 
		if(this.modoAdmin) return null;
		HashSet<Proyecto> listado = new HashSet<Proyecto>();
		for(Proyecto p: this.proyectos) {
			if(p.getEstadoProyecto() == EstadoProyecto.OPERATIVO && !p.getUsuariosApoyantes().contains(user) ) {
				listado.add(p);
			}
		}
		if(this.getUsuarioConectado()!=null) {
			
		}
		return listado;
	} 	
	
	public HashSet<Proyecto> getProyectosApoyables(Colectivo colectivo){
		 
		if(this.modoAdmin) return null;
		HashSet<Proyecto> listado = new HashSet<Proyecto>();
		for(Proyecto p: this.proyectos) {
			if(p.getEstadoProyecto() == EstadoProyecto.OPERATIVO ) {
				listado.add(p);
			}
		}
		if(this.getUsuarioConectado()!=null) {
			
		}
		return listado;
	} 	
	
	public HashSet<Colectivo> getColectivosDisponibles(Usuario user){
		HashSet<Colectivo> listado = new HashSet<Colectivo>();
		Colectivo c;
		for(Proponente p: this.proponentes) {
			if( p.getClass().getSimpleName().equals("Colectivo")) {
				c = (Colectivo)p;
				if(!c.getIsUsuarioEnColectivoSubcolectivo(user)) {
					listado.add((Colectivo)p);
				}
			}
		}
		
		return listado;
	}
	
	//	*** FUNCIONES LLAMADAS POR EL USUARIO LOGUEADO ***
	/**
	 * Esta funcion se encarga de sacarte de la aplicacion
	 */
	public void logOut() {
		this.modoAdmin = false;
		this.usuarioConectado = null;
	}
	
	
	

	
	/**
	 * Esta funcion se encarga de iniciar sesion a un usuario 
	 * 
	 * @param nombre name
	 * @param contraseña password
	 * @return the true or false
	 */
	public boolean loginUser(String nombre, String contraseña) {
		Usuario  aux;
		//Buscar usuario
		for(Proponente p: this.proponentes ) {
			if(p.getClass().getSimpleName().equals("Usuario")) {
				aux = (Usuario)p;
				//Coinciden creedenciales y el usuario está operativo
				if(aux.getEstado().equals(EstadoUsuario.OPERATIVO) && aux.getNombre().equals(nombre) && aux.getContraseña().equals(contraseña)) {
					usuarioConectado = aux;
					return true;

				}	
			}
		
		}
		return false;
	}
	
	/**
	 * Esta funcion se encarga de crear un proyecto social dentro de la aplicacion
	 * 
	 * @param p proyecto
	 * @param nombre name
	 * @param descrL descripcion larga
	 * @param descC descripcion corta
	 * @param cost coste 
	 * @param gSocial grupo social
	 * @param nac nacional
	 * @return the proyecto
	 */
	public ProyectoSocial crearProyectoSocial(Proponente p,String nombre, String descrL, String descC , double cost ,String gSocial, Boolean nac){
		
		ProyectoSocial proyecto;
		
		if(p.getClass().getSimpleName().equals("Colectivo")) {
			Colectivo c = (Colectivo) p;
			proyecto = new ProyectoSocial(p,c.getUsuarioRepresentanteDeColectivo() ,nombre,descrL, descC, cost,gSocial, nac);
			
		}else {//Usuario
			Usuario u = (Usuario) p;
			proyecto = new ProyectoSocial(u,u,nombre,descrL, descC, cost,gSocial, nac);
			
		}
		p.proponerProyecto(proyecto);
		
		this.proyectos.add(proyecto);
		this.lastProjectUniqueID++;
		return proyecto;
		
	}
	
	/**
	 * Esta funcion se encarga de crear un proyecto social dentro de la aplicacion
	 * 
	 * @param p proyecto
	 * @param nombre nombre proyecto
	 * @param descrL descripcion larga
	 * @param descC descripcion corta
	 * @param cost coste
	 * @param croquis croquis
	 * @param imagen imagen
	 * @param distritos los distritos de proyecto
	 * @return the proyecto
	 */
	public ProyectoInfraestructura crearProyectoInfraestructura(Proponente p,String nombre, String descrL, String descC , double cost,String croquis ,String imagen,HashSet<String> distritos){
		ProyectoInfraestructura proyecto;
		
		if(p.getClass().getSimpleName().equals("Colectivo")) {
			Colectivo c = (Colectivo) p;
			proyecto = new ProyectoInfraestructura(p,c.getUsuarioRepresentanteDeColectivo() , nombre,  descrL,  descC ,  cost , croquis , imagen,distritos);
			
		}else {//Usuario
			Usuario u = (Usuario) p;
			proyecto = new ProyectoInfraestructura(u,u , nombre,  descrL,  descC ,  cost , croquis , imagen,distritos);			
		}
		p.proponerProyecto(proyecto);
		
		this.proyectos.add(proyecto);
		this.lastProjectUniqueID++;
		return proyecto;
		
	}
	
	public Colectivo crearColectivo(Usuario uRepresentante, String nombre, String descripcion,Colectivo colectivoPadre) {
		Colectivo newC = new Colectivo(uRepresentante, nombre, descripcion, colectivoPadre);
		this.proponentes.add(newC);
		return newC;
	}
	
	public Colectivo crearSubcolectivo(String nombre,String descripcion, Colectivo colectivoPadre) {
		Colectivo newSubC = colectivoPadre.crearSubcolectivo(nombre, descripcion);
		this.proponentes.add(newSubC);
		return newSubC;
		
	}
	
	
	
	
	
	
	//	***FUNCIONES VARIAS INTERNAS***

	//nuevo registro usuario hecho por GSOLLA el 27/03/2020
	
	/** 
	 * Esta funcion se encarga de solicitar el registro de un nuevo usuario en la aplicacion
	 * 
	 * @param nif nif
	 * @param nombre nombre usuario
	 * @param contraseña password
	 * @return the newUser
	 */
	public Usuario solicitarRegistro(String nif, String nombre, String contraseña) {
		
		Usuario newUser, aux;
		for(Proponente p: this.proponentes ) {
			if(p.getClass().getSimpleName().equals("Usuario") ) {
				aux = (Usuario)p;
				if(aux.getNombre().equals(nombre) || aux.getNIF().equals(nif)) {
					return null;
				}	
			}
		}
		newUser = new Usuario(nif, nombre, contraseña);
		this.proponentes.add(newUser);
		return newUser;
	}
	
	
	
	/**
	 * Esta funcion se encarga de devolver la id de un proyecto
	 * 
	 * @return the lastProjectUniqueID +1
	 */
	public  int getNewProjectUniqueId() {
		return  lastProjectUniqueID +1;
	}
	
	/**
	 * Esta funcions e encarga de activar el modo admin
	 * 
	 * @return the modoAdmin
	 */
	public Boolean isModoAdmin() {
		return this.modoAdmin;
	}
	
	/**
	 * Esta funcion se encarga de devolver el numero minimo de apoyos necesarios en un proyecto
	 * 
	 * @return the numMinApoyos
	 */
	public Integer getNumeroMinimimoApoyos() {
		return numMinApoyos;
	}
	
	/**
	 * Esta funcion se encarga de devolver los distritos que contiene la aplicacion
	 * 
	 * @return the getDistritos
	 */
	public HashSet<String> getDistritos(){
		//return (HashSet<String>) Collections.unmodifiableSet(this.distritosPermitidos);
		return this.distritosPermitidos;
	}

	/**
	 * Esta funcion se encarga de devolver si un usuario esta conectado
	 * 
	 * @return the usuarioConectado
	 */
	public Usuario getUsuarioConectado() {
		return this.usuarioConectado;
	}
	
	/**
	 * Devuelve los proyectos creados por un usuario.
	 * @param u El usuario.
	 * @return the HashSet con los proyectos.
	 */
	public HashSet<Proyecto> getProyectosUsuario(Usuario u){
		HashSet<Proyecto> listado = new HashSet<Proyecto>();
		for(Proyecto p: this.proyectos) {
			if(p.getProponente().equals(u)) {
				listado.add(p);
			}
		}
	return listado;
	}
	
	/**
	 * Devuelve los colectivos creados por un usuario.
	 * @param u El usuario.
	 * @return the HashSet con los colectivos.
	 */
	public HashSet<Colectivo> getColectivosUsuario(Usuario u){
		HashSet<Colectivo> listado = new HashSet<Colectivo>();
		Colectivo c;
		for(Proponente p: this.proponentes) {
			if( p.getClass().getSimpleName().equals("Colectivo")) {
				c = (Colectivo)p;
				if(c.getUsuarioRepresentanteDeColectivo().equals(u)){
					listado.add(c);
				}
			}
		}
	return listado;
	}
	
	/**
	 * Devuelve los proyectos creados por un usuario.
	 * @param c colectivo.
	 * @return listado con los proyectos.
	 */
	public HashSet<Proyecto> getProyectosColectivo(Colectivo c){
		HashSet<Proyecto> listado = new HashSet<Proyecto>();
		for(Proyecto p: this.proyectos) {
			if(p.getProponente().equals(c)) {
				listado.add(p);
			}
		}
	return listado;
	}
	/**
	 * Devuelve los proyectos apoyados por un usuario.
	 * @param u El usuario.
	 * @return HashSet con los proyectos.
	 */
	public HashSet<Proyecto> getProyectosApoyadosPor(Usuario u){
		HashSet<Proyecto> listado = new HashSet<Proyecto>();
		for(Proyecto p: this.proyectos) {
			if(p.getUsuariosApoyantes().contains(u)) {
				listado.add(p);
			}
		}
		return listado;
	}
	/**
	 * Devuelve los proyectos apoyados por un colectivo.
	 * @param c Colectivo
	 * @return listado  con los proyectos.
	 */
	public HashSet<Proyecto> getProyectosApoyadosPor(Colectivo c){
		HashSet<Proyecto> listado = new HashSet<Proyecto>();
		for(Proyecto p: this.proyectos) {
			if(p.getColectivosApoyantes().contains(c)) {
				listado.add(p);
			}
		}
		return listado;
	}
}



