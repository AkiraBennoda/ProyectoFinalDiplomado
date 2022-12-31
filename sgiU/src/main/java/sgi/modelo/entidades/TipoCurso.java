package sgi.modelo.entidades;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //definir la entidad
@Table(name = "tipoCurso")
public class TipoCurso {
	
	private Integer idTipoCurso;
	private String nombre;
	
	
	@Id //indicar que la propiedad es una llave
	@Column(name = "idTipoCurso") //descripcion de la columna
	@GeneratedValue(strategy = GenerationType.IDENTITY) //estrategia de manejo de llave
	
	public Integer getIdTipoCurso() {
		return idTipoCurso;
	}
	public void setIdTipoCurso(Integer idTipoCurso) {
		this.idTipoCurso = idTipoCurso;
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
		return "TipoCurso [idTipoCurso=" + idTipoCurso + ", nombre=" + nombre + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(idTipoCurso, nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoCurso other = (TipoCurso) obj;
		return Objects.equals(idTipoCurso, other.idTipoCurso) && Objects.equals(nombre, other.nombre);
	}
	
	
	
	
}
