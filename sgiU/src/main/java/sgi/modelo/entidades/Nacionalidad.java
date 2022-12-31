package sgi.modelo.entidades;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //definir la entidad
@Table(name = "nacionalidad")
public class Nacionalidad {
	
	private Integer idNacionalidad;
	private String nombre;
	
	
	@Id //indicar que la propiedad es una llave
	@Column(name = "idNacionalidad") //descripcion de la columna
	public Integer getIdNacionalidad() {
		return idNacionalidad;
	}
	public void setIdNacionalidad(Integer idNacionalidad) {
		this.idNacionalidad = idNacionalidad;
	}
	
	@Column(name = "nombre", length = 50)
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Nacionalidad [idNacionalidad=" + idNacionalidad + ", nombre=" + nombre + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idNacionalidad, nombre);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nacionalidad other = (Nacionalidad) obj;
		return Objects.equals(idNacionalidad, other.idNacionalidad) && Objects.equals(nombre, other.nombre);
	}
	
	
	
	
}
