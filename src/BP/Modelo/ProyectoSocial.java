package BP.Modelo;
import es.uam.eps.sadp.grants.GrantRequest;

public class ProyectoSocial extends Proyecto {
	private Boolean nacional;
	private String grupoSocial;
	
	 /**
	  * Constructor, con los datos a implementar
	  * @param p que asignar al proponente 
	  * @param uCreador para asignar al usuario que ha creado el proyecto
	  * @param nombre para asignar al proyecto
	  * @param descrL para asignar al proyecto
	  * @param descC para asignar al proyecto
	  * @param cost para asignar a la financiacón que se pretende obtener para crear el proyecto
	  * @param gSocial para asignar un grupo social al que va dirigido el proyecto
	  * @param nac para asignar si el proyecto sera nacional o no
	  */
	
	public ProyectoSocial(Proponente p, Usuario uCreador,String nombre, String descrL, String descC , double cost ,String gSocial, Boolean nac) {
		
		super(p, uCreador, nombre, descrL, descC, cost);
		this.grupoSocial = gSocial;
		this.nacional = nac;
		 
	}
	
	
	/**
	 * Esta funcion devolvera un string que contendra una lista de distritos del proyecto
	 * 
	 * @return cadena
	 */
	public String getExtraData() {
		String cadena = "";
		if(this.nacional) {
			cadena += "Nacional";
		}else {
			cadena += "NO Nacional ";
		}
		
		cadena += " _ " + this.grupoSocial;
		return cadena;
	}
	
	/**
	 * Esta funcion devuelve que tipo de proyecto es
	 */
	public GrantRequest.ProjectKind getProjectKind(){
		return GrantRequest.ProjectKind.Social;
	}
	
	@Override
	public String getTipoProyecto() {
		return new String("Social");
	}
	
}
