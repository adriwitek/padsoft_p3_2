package BP.Demo;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;

import BP.*;
import BP.Modelo.*;
import es.uam.eps.sadp.grants.CCGG;


public class main {
	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
		Aplicacion app = Aplicacion.getInstancia("admin", "1234",1); //login del admin
		if (!app.loginUser("Guillermo", "1234")) System.out.println("OK, no se ha podido iniciar sesion");

		
		
		
		// USUARIOS
		Usuario u1 = app.solicitarRegistro("1234456789A", "Guillermo", "1234");
		Usuario u2 =app.solicitarRegistro("98726543321A", "Adrian", "1234");
		Usuario u3 =app.solicitarRegistro("12344567893A", "Tapia", "1234");
		Usuario u4 =app.solicitarRegistro("123424563337893A", "U4", "1234");
		Usuario u5 =app.solicitarRegistro("12344567423893A", "U5", "1234");
		Usuario u7 = app.solicitarRegistro("u7", "u7", "u7");
		if(u1 == null ||u2 == null || u3 == null || u4 == null || u5 == null   ) System.out.println("Los u devueltos son nulos");
		
		
		
		
		//COLECTIVOS Y SUBCOLECTIVOS 
		Colectivo c1 = app.crearColectivo(u1,"Colectivo 1","Desc",null);
		Colectivo c2 = app.crearColectivo(u2,"Colectivo 2","Desc",null);
		Colectivo subC2 = c2.crearSubcolectivo("Sucolectivo 2,hijo de colectivo 2", "DescHijo");
		subC2.suscribirseColectivo(u4);
		
		
		 
		
		//VALIDAMOS LOS REGISTROS
		app.loginAdmin("admin", "1234");
		
		if (app.getRegistrosPendientesDeAprobacion().size() !=6) System.out.println("Error, el numero de usuairo pendientes de aprobacion no coincide: " + app.getRegistrosPendientesDeAprobacion().size());

		 
		app.validarRegistro(u1);
		app.validarRegistro(u2);
		app.validarRegistro(u3);
		app.validarRegistro(u7);
		   
		//NOTIFICACIONES
		Notificacion not= new Notificacion("TitulooNotificacion","Esto es una descrp.DeNotificacion");
		u7.anniadirNotificacionDeProyecto(not);
		System.out.println("Las notificaciones del U7 son: " + u7.getAllNotificaciones().size() + " :  " 
				+ u7.getAllNotificaciones());


		if (app.getUsuariosActivos().size() !=4) System.out.println("Error, el numero de usuairo OPERATIVOS   no coincide: " + app.getUsuariosActivos().size());
		//System.out.print(app.getUsuariosActivos());
		u2.bloquear("bloqueoado");
		if (app.getUsuariosBloqueados().size() !=1) System.out.println("Error, el numero de usuairo BLOQUEADOS   no coincide: " + app.getUsuariosBloqueados().size());
		//System.out.print(app.getUsuariosBloqueados());
		u2.desbloquear();

		//app.validarRegistro(u4);
		//app.validarRegistro(u5);
		app.logOut();
		app.loginUser("Guillermo", "1234");
		System.out.println("Usuario logueado: " + app.getUsuarioConectado());

	
		
		
		
		//SAVE Y LOAD (IMPORTANTE)
		app.exit();
		app = Aplicacion.getInstancia("admin", "1234",1); //login del admin CREAMOS UNA APP
		 if (!app.loginUser("Guillermo", "1234")) System.out.println("OK, no se ha podido iniciar sesion");
		if(!app.loadAplicacion()) System.out.println("-----No se ha podido cargar el backup");//CARGAMOS LOS DATOS EN INSTACIA
		app = Aplicacion.getInstancia();
		if (app.loginUser("Guillermo", "1234")) System.out.println("OK,  ahora si se ha podido iniciar sesion");

		
		
		
		System.out.println("Usuario logueado: " + app.getUsuarioConectado());

		
		
		
		
		//CREACION PROYECTOS
        System.out.println("-------CREACION PROYECTOS --------------" );

		ProyectoSocial pSocial1 = app.crearProyectoSocial( u1, "Proyecto Social 1", "Descrip Laaarga", "Description corta" ,  10000.0 ,"Grupo 1",  true); //debe acpetarse la financiacion en el
		ProyectoSocial pSocial2 = app.crearProyectoSocial( u2, "Proyecto Social 2", "Descrip Laaarga", "Description corta" ,  500.0 ,"Grupo 2",  false); //debe acpetarse la financiacion en el
		ProyectoSocial pSocial3 = app.crearProyectoSocial( u2, "Proyecto Social 3", "Descrip Laaarga", "Description corta" ,  1000000.0 ,"Grupo 3",  true); //debe acpetarse la financiacion en el
		ProyectoSocial pSocial4 = app.crearProyectoSocial( u2, "Proyecto Social 4", "Descrip Laaaarga", "Description corta" ,  10000.0 ,"Grupo 4",  true); //debe acpetarse la financiacion en el

		
		
		String pathImg1 = "testImages/img1.png";
		String pathImg2 = "testImages/img2.png";
		String pathCroquis1 = "testImages/croquis1.png";
		String pathCroquis2 = "testImages/croquis2.png";
		HashSet<String> setDistritos1 = new HashSet<String>();
		HashSet<String> setDistritos2 = new HashSet<String>();
		setDistritos1.add("Usera");
		setDistritos2.add("Salamanca");
		setDistritos2.add("Latina");

		ProyectoInfraestructura pInfraestructura1 =  app.crearProyectoInfraestructura(u1 ,"P. Infra 1",  "Descrip Laaarga", "Description corta",  100000,pathCroquis1  , pathImg1,setDistritos1);
		ProyectoInfraestructura pInfraestructura2 =  app.crearProyectoInfraestructura(u1 ,"P. Infra 2",  "Descrip Laaarga", "Description corta",  100000, pathCroquis2 , pathImg2,setDistritos2);
		ProyectoInfraestructura pInfraestructura3 =  app.crearProyectoInfraestructura(u1 ,"P. Infra 3",  "Descrip Laaarga", "Description corta",  100000, pathCroquis2 , pathImg2,setDistritos2);

		
		
		
		//PROPOSICION DE PROYECTOS
		u2.proponerProyecto(pSocial1);
		u2.proponerProyecto(pInfraestructura1);
		
		c1.proponerProyecto(pSocial2);
		
		c2.proponerProyecto(pSocial3);
		subC2.proponerProyecto(pInfraestructura2);
		
		
		//Proyectos que van a quedar pendientes de aprobacion por el admin		
		u2.proponerProyecto(pSocial4);
		c1.proponerProyecto(pSocial3);

			
		
		//APOYOS Y VALIDACION
        System.out.println("-------APOYOS --------------" );

		pSocial1.validarProyecto();
		pSocial2.validarProyecto();
		pSocial3.validarProyecto();
		pInfraestructura1.validarProyecto();
		pInfraestructura2.validarProyecto();
		
		//Apoyo de un usuario
		System.out.println("BEFORE:Apoyos del pSocial1:" + pSocial1.getNumeroApoyosActualesValidos() );
		pSocial1.apoyarProyecto(u3);
		System.out.println("AFTER:Apoyos del pSocial1:" + pSocial1.getNumeroApoyosActualesValidos() );

		//Apoyando como subcolectivo, y luego con el colectivo padre, deberia dar el mismo numero de votos
		System.out.println("BEFORE:Apoyos del pInfraestructura2:" + pInfraestructura2.getNumeroApoyosActualesValidos() );
		pInfraestructura2.apoyarProyectoComoColectivo(subC2);
		System.out.println("AFTER:Apoyos del pInfraestructura2:" + pInfraestructura2.getNumeroApoyosActualesValidos() );
		c2.suscribirseColectivo(u4);
		System.out.println("Mismo numero de apoyos al apoyar en colectivo que contiene al subcoletivo=:" + pInfraestructura2.getNumeroApoyosActualesValidos() );

		
		
		
		
		//CADUCIDAD
		//			---> OJO: Se retrasa artificialmente la fecha del ultimo voto para comprobar que el metodo(que no se modifica) funciona correctamente, dado que la clase auxiliar proporcionada
		// 						requeriria de mas ajustes para su integracion con nuestra implementacion
		System.out.println("BEFORE:El estado de pSocial1 es: " +pSocial1.getEstadoProyecto() + " y la fecha de su ultimo apoyo es: " + pSocial1.getFechaUltimoApoyo());

		@SuppressWarnings("deprecation")
		Date dateAtrasada = new Date(2020,1,1);
		pSocial1.setFechaUltimoApoyo(dateAtrasada);
		app.caducarProyectosAntiguos();//Importante la llamada a esta funcion, para actualizar los estados de los proyectos
		System.out.println("AFTER: El estado de pSocial1 es: " + pSocial1.getEstadoProyecto() + " y la fecha de su ultimo apoyo es: " + pSocial1.getFechaUltimoApoyo());
		
		
		
		
		
		//FINANCIACION
        System.out.println("-------FINANCIACION --------------" );

		pSocial2.apoyarProyecto(u3);
		pSocial3.apoyarProyecto(u4);
		
		if(!pSocial2.solicitarFinanciacion()) System.out.println("NO HA SIDO POSIBLE LA SOLICITUD DE FINANCIACION DE pSocial2");
		if(!pSocial3.solicitarFinanciacion()) System.out.println("NO HA SIDO POSIBLE LA SOLICITUD DE FINANCIACION DE pSocial3");

		FechaSimulada f = new FechaSimulada();
		CCGG.getGateway().setDate(f.fijarFecha(1, 1, 2050) );
	    /*
		Date dateAdelantada = new Date(2020,04,14);
		pSocial2.setFechaUltimoApoyo(dateAdelantada);
		pSocial3.setFechaUltimoApoyo(dateAdelantada);
		*/
		
		
		
        app.actualizarProyectosFinanciados();
		
   
        //proyecto 2 no deberia recibirla y proyecto 3 si
        System.out.println("pSocial2 :  " + pSocial2.getEstadoProyecto());
        if(pSocial2.getEstadoProyecto() == EstadoProyecto.FINANCIACIONACEPTADA) System.out.println("pSocial2 ha sido financiado con " + pSocial2.getFinanciacionRecibida() + " del coste inicial de : " +  pSocial2.getCoste());
        if(pSocial2.getEstadoProyecto() == EstadoProyecto.FINANCIACIONRECHAZADO) System.out.println(" OK:La financiacion de pSocial2 ha sido rechazada " + pSocial2.getFinanciacionRecibida() + " del coste inicial de : " +  pSocial2.getCoste());

        System.out.println("pSocial3 :  " + pSocial3.getEstadoProyecto());
        if(pSocial3.getEstadoProyecto() == EstadoProyecto.FINANCIACIONACEPTADA) System.out.println("OK:pSocial3 ha sido financiado con " + pSocial3.getFinanciacionRecibida() + " del coste inicial de : " +  pSocial3.getCoste());
        if(pSocial3.getEstadoProyecto() == EstadoProyecto.FINANCIACIONRECHAZADO) System.out.println("La financiacion de pSocial2 ha sido rechazada " + pSocial3.getFinanciacionRecibida() + " del coste inicial de : " +  pSocial3.getCoste());

		
        //MAS PRUEBAS
      	Usuario u6 =app.solicitarRegistro("12384567893A", "U6", "1234");
      		


    
		
		
		
		//SAVE Y LOAD (IMPORTANTE) 2/*
		app.exit();
		app = Aplicacion.getInstancia("admin", "1234",1);
		if(!app.loadAplicacion()) System.out.println("-------------No se ha podido cargar el backup");


		app.loginUser("7", "7");
		//System.out.println(app.getUsuarioConectado().getNombre());

		//System.out.println(app.getUsuarioConectado().getAllNotificaciones());

		app = app.getInstancia();
		
		if (!app.loginUser("u7", "u7")) System.out.println("ERROR, no se ha podido iniciar sesion");
		System.out.println(app.getUsuarioConectado().getAllNotificaciones());

		
		System.out.println("FIN DE LA DEMO");
	}
	

	
}