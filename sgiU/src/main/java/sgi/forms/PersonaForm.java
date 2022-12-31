package sgi.forms;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;



public class PersonaForm {

	private Integer idPersona;
	
	@Size(min=5, max= 50)
	private String nombre;
	
	@NotNull
	private Integer edad;
	
	@NotNull
	private String correoElectronico;
	
	@Size(max= 20)
	@NotNull
	private String rfc;
	
	@NotNull
	private String idGenero;
	
	@NotNull
	private String idNacionalidad;
	
	
	@NotNull
	private String pais;
	
	
	@NotNull
	private String estado;
	
	@NotNull
	private String localidad;
	
	@NotNull
	private String calle;
	
	@NotNull
	private Integer codigoPostal;
	
	
	private Integer numExt;
	
	
	private Integer numInt;
	
	
	
	public Integer getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;	
	
	}	
	
	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	
	public String getIdGenero() {
		return idGenero;
	}


	public void setIdGenero(String idGenero) {
		this.idGenero = idGenero;
	}


	public String getIdNacionalidad(){
		return idNacionalidad;
	}

	public void setIdNacionalidad(String nacionalidad) {
		this.idNacionalidad = nacionalidad;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

		
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public Integer getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(Integer codigoPstal) {
		this.codigoPostal = codigoPstal;
	}
	public Integer getNumExt() {
		return numExt;
	}
	public void setNumExt(Integer numExt) {
		this.numExt = numExt;
	}
	public Integer getNumInt() {
		return numInt;
	}
	public void setNumInt(Integer numInt) {
		this.numInt = numInt;
	}



   
   
   
}
