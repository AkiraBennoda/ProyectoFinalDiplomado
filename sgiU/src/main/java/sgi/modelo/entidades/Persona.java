/*
 * Clase que desribe los atributos que tendra la PERSONA junto con los m�todos CRUD para poder 
 * dar de ALTA, BAJA, ACTUALIZACION, CONSULTA de Persona 
 * */


package sgi.modelo.entidades;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name="persona")
@DiscriminatorColumn(name = "tipo_persona", 
					 discriminatorType = DiscriminatorType.STRING )
@NamedQueries(
	   {@NamedQuery(name = "personasAll", query = "FROM Persona"),
		@NamedQuery(name = "personaById", query = "SELECT p FROM Persona p WHERE p.idPersona = :idPersona"),
		@NamedQuery(name ="personasByGenero", query = "SELECT p FROM Persona p WHERE p.idGenero.id = :idGenero"),
		@NamedQuery(name ="personasByNacionalidad", query = "SELECT p FROM Persona p WHERE p.idNacionalidad.id = :idNacionalidad"),
		@NamedQuery(name ="personasByNombre", query = "SELECT p FROM Persona p WHERE p.nombre = :nombre"),
		@NamedQuery(name ="personasByEdad", query = "SELECT p FROM Persona p WHERE p.edad = :edad"),
		@NamedQuery(name ="personasByCorreoElectronico", query = "SELECT p FROM Persona p WHERE p.correoElectronico = :correoElectronico"),
		@NamedQuery(name ="personasByRfc", query = "SELECT p FROM Persona p WHERE p.rfc= :rfc")
		})

public class Persona {

	private Integer idPersona;
	private String nombre;
	private Integer edad;
	private String correoElectronico;
	private String rfc;
	private Genero idGenero;
	private Nacionalidad idNacionalidad;
	private String pais;
	private String estado;
	private String localidad;
	private String calle;
	private Integer codigoPostal;
	private Integer numExt;
	private Integer numInt;
	
	//Constructores
	@JsonIgnore
	public Persona()
	{
		super();
	}

	public Persona(Integer idPersona) {
		super();
		this.idPersona = idPersona;
	}


	

	
	public Persona(String nombre, Integer edad, String correoElectronico, String rfc, Genero idGenero,
			Nacionalidad idNacionalidad, String pais, String estado, String localidad, String calle,
			Integer codigoPostal, Integer numExt, Integer numInt) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.correoElectronico = correoElectronico;
		this.rfc = rfc;
		this.idGenero = idGenero;
		this.idNacionalidad = idNacionalidad;
		this.pais = pais;
		this.estado = estado;
		this.localidad = localidad;
		this.calle = calle;
		this.codigoPostal = codigoPostal;
		this.numExt = numExt;
		this.numInt = numInt;
	}

	
	
	
	@Id
	@Column(name = "idPersona")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdPersona() {
		return idPersona;
	}



	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	@Column(name = "nombre", length = 50)
	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "edad")
	public Integer getEdad() {
		return edad;
	}



	public void setEdad(Integer edad) {
		if (edad>15)
		{
			this.edad = edad;	
		}
		
	}

	@Column(name = "correoElectronico", length = 50)
	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		//Validando que sea un correo v�lido
		 Pattern pattern = Pattern
	                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		 
		 Matcher mather = pattern.matcher(correoElectronico);
		 
		 if (mather.find() == true) {
				this.correoElectronico = correoElectronico;
	            //System.out.println("Email valido");
	        } else {
	            //System.out.println("Email no valido");
	        }
		 
	
	}
	
	

	@OneToOne(targetEntity = Genero.class, optional = false, fetch = FetchType.LAZY) //indica el tipo de clase
	@JoinColumn(name = "idGenero", nullable = false)//indicar la columna de la relacion de B
	@Fetch(FetchMode.JOIN)
	public Genero getIdGenero() {
		return idGenero;
	}


	public void setIdGenero(Genero idGenero) {
		this.idGenero = idGenero;
	}


	@OneToOne(targetEntity = Nacionalidad.class, optional = false, fetch = FetchType.LAZY) //indica el tipo de clase
	@JoinColumn(name = "idNacionalidad", nullable = false)//indicar la columna de la relacion de B
	@Fetch(FetchMode.JOIN)
	public Nacionalidad getIdNacionalidad() {
		return idNacionalidad;
	}



	public void setIdNacionalidad(Nacionalidad idNacionalidad) {
		this.idNacionalidad = idNacionalidad;
	}


	@Column(name = "rfc", length = 50)
	public String getRfc() {
		return rfc;
	}



	public void setRfc(String rfc) {
		this.rfc = rfc;
	}


	@Column(name = "pais", length = 50)
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

	public void setCodigoPostal(Integer codigoPostal) {
		this.codigoPostal = codigoPostal;
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

	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", nombre=" + nombre + ", edad=" + edad + ", correoElectronico="
				+ correoElectronico + ", rfc=" + rfc + ", idGenero=" + idGenero + ", idNacionalidad=" + idNacionalidad
				+ ", pais=" + pais + ", estado=" + estado + ", localidad=" + localidad + ", calle=" + calle
				+ ", codigoPostal=" + codigoPostal + ", numExt=" + numExt + ", numInt=" + numInt + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(calle, codigoPostal, correoElectronico, edad, estado, idGenero, idNacionalidad, idPersona,
				localidad, nombre, numExt, numInt, pais, rfc);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(calle, other.calle) && Objects.equals(codigoPostal, other.codigoPostal)
				&& Objects.equals(correoElectronico, other.correoElectronico) && Objects.equals(edad, other.edad)
				&& Objects.equals(estado, other.estado) && Objects.equals(idGenero, other.idGenero)
				&& Objects.equals(idNacionalidad, other.idNacionalidad) && Objects.equals(idPersona, other.idPersona)
				&& Objects.equals(localidad, other.localidad) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(numExt, other.numExt) && Objects.equals(numInt, other.numInt)
				&& Objects.equals(pais, other.pais) && Objects.equals(rfc, other.rfc);
	}

	

}
