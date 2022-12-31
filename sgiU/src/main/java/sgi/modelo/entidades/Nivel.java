package sgi.modelo.entidades;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //definir la entidad
@Table(name = "nivel")
public class Nivel {
	
	private Integer idNivel;
	private String nombre;
	
	@Id //indicar que la propiedad es una llave
	@Column(name = "idNivel") //descripcion de la columna
	@GeneratedValue(strategy = GenerationType.IDENTITY) //estrategia de manejo de llave
	public Integer getIdNivel() {
		return idNivel;
	}
	public void setIdNivel(Integer idNivel) {
		this.idNivel = idNivel;
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
		return "Nivel [idNivel=" + idNivel + ", nombre=" + nombre + "]";
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(idNivel, nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nivel other = (Nivel) obj;
		return Objects.equals(idNivel, other.idNivel) && Objects.equals(nombre, other.nombre);
	}
	
	
	
	
}
