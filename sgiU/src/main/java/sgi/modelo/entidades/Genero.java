package sgi.modelo.entidades;


import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //definir la entidad
@Table(name = "genero")
public class Genero {
	private Integer idGenero;
	private String nombre;
	
	
	@Id //indicar que la propiedad es una llave
	@Column(name = "idGenero") //descripcion de la columna
	@GeneratedValue(strategy = GenerationType.IDENTITY) //estrategia de manejo de llave
	public Integer getIdGenero() {
		return idGenero;
	}
	public void setIdGenero(Integer idGenero) {
		this.idGenero = idGenero;
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
		return "Genero [idGenero=" + idGenero + ", nombre=" + nombre + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(idGenero, nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Genero other = (Genero) obj;
		return Objects.equals(idGenero, other.idGenero) && Objects.equals(nombre, other.nombre);
	}
	
	
	
	
}
