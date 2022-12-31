package sgi.modelo.entidades;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //definir la entidad
@Table(name = "idioma")
public class Idioma {
	
	private Integer idIdioma;
	private String nombre;
	
	
	@Id //indicar que la propiedad es una llave
	@Column(name = "idIdioma") //descripcion de la columna
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdIdioma() {
		return idIdioma;
	}
	public void setIdIdioma(Integer idIdioma) {
		this.idIdioma = idIdioma;
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
		return "Idioma [idIdioma=" + idIdioma + ", nombre=" + nombre + "]";
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(idIdioma, nombre);
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Idioma other = (Idioma) obj;
		return Objects.equals(idIdioma, other.idIdioma) && Objects.equals(nombre, other.nombre);
	}
	
	
	
	

}
