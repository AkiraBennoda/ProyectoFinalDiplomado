package sgi.modelo.entidades;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //definir la entidad
@Table(name = "modalidad")
public class Modalidad {
	
	private Integer idModalidad;
	private String nombre;
	
	
	@Id //indicar que la propiedad es una llave
	@Column(name = "idModalidad") //descripcion de la columna
	@GeneratedValue(strategy = GenerationType.IDENTITY) //estrategia de manejo de llave
	public Integer getIdModalidad() {
		return idModalidad;
	}
	public void setIdModalidad(Integer idModalidad) {
		this.idModalidad = idModalidad;
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
		return "Modalidad [idModalidad=" + idModalidad + ", nombre=" + nombre + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(idModalidad, nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Modalidad other = (Modalidad) obj;
		return Objects.equals(idModalidad, other.idModalidad) && Objects.equals(nombre, other.nombre);
	}
	
	
	
	
}
