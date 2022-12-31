package sgi.modelo.entidades;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="TipoPago")
public class TipoPago {
	
	
	private Integer idTipoPago;
	private String nombre;
	
	
	@Id //indicar que la propiedad es una llave
	@Column(name = "idTipoPago") //descripcion de la columna
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	public Integer getIdTipoPago() {
		return idTipoPago;
	}
	public void setIdTipoPago(Integer idTipoPago) {
		this.idTipoPago = idTipoPago;
	}
	
	@Column(name = "nombre")
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	@Override
	public String toString() {
		return "TipoPago [idTipoPago=" + idTipoPago + ", nombre=" + nombre + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(idTipoPago, nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoPago other = (TipoPago) obj;
		return Objects.equals(idTipoPago, other.idTipoPago) && Objects.equals(nombre, other.nombre);
	}
	
	
}
