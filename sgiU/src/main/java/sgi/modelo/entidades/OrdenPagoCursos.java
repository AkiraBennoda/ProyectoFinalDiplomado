package sgi.modelo.entidades;

import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@Table(name="ordenPagoCursos")
@NamedQueries(
		{@NamedQuery(name = "ordenPagoCursosAll", query = "FROM OrdenPagoCursos"),
		@NamedQuery(name = "ordenPagoCursosById", query = "SELECT c FROM OrdenPagoCursos c WHERE c.idOrdenPagoCursos = :idOrdenPagoCursos"),
		@NamedQuery(name ="ordenPagoCursosByTipoPago", query = "SELECT c FROM OrdenPagoCursos c WHERE c.idTipoPago.id = :idTipoPago")
		})

public class OrdenPagoCursos {
	
	
	private Integer idOrdenPagoCursos;
	private String folioPago;
	private String descripcion;
	private String fechaPago;
	private TipoPago idTipoPago;
	
	
	
	public OrdenPagoCursos() {
		super();
		// TODO Auto-generated constructor stub
	}



	public OrdenPagoCursos(Integer idOrdenPagoCursos) {
		super();
		this.idOrdenPagoCursos = idOrdenPagoCursos;
	}



	public OrdenPagoCursos(String folioPago, String descripcion, String fechaPago, TipoPago idTipoPago) {
		super();
		this.folioPago = folioPago;
		this.descripcion = descripcion;
		this.fechaPago = fechaPago;
		this.idTipoPago = idTipoPago;
	}



	
	@Id
	@Column(name = "idOrdenPagoCursos")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdOrdenPagoCursos() {
		return idOrdenPagoCursos;
	}



	public void setIdOrdenPagoCursos(Integer idOrdenPagoCursos) {
		this.idOrdenPagoCursos = idOrdenPagoCursos;
	}


	@Column(name = "folioPago", length = 50)
	public String getFolioPago() {
		return folioPago;
	}



	public void setFolioPago(String folioPago) {
		this.folioPago = folioPago;
	}


	@Column(name = "descripcion", length = 100)
	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@Column(name = "fechaPago", length = 8)
	public String getFechaPago() {
		return fechaPago;
	}



	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}


	@OneToOne(targetEntity = TipoPago.class, optional = false, fetch = FetchType.LAZY) //indica el tipo de clase
	@JoinColumn(name = "idTipoPago", nullable = false)//indicar la columna de la relacion de B
	@Fetch(FetchMode.JOIN)
	public TipoPago getIdTipoPago() {
		return idTipoPago;
	}



	public void setIdTipoPago(TipoPago idTipoPago) {
		this.idTipoPago = idTipoPago;
	}



	@Override
	public String toString() {
		return "OrdenPagoCursos [idOrdenPagoCursos=" + idOrdenPagoCursos + ", folioPago=" + folioPago + ", descripcion="
				+ descripcion + ", fechaPago=" + fechaPago + ", idTipoPago=" + idTipoPago + "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(descripcion, fechaPago, folioPago, idOrdenPagoCursos, idTipoPago);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdenPagoCursos other = (OrdenPagoCursos) obj;
		return Objects.equals(descripcion, other.descripcion) && Objects.equals(fechaPago, other.fechaPago)
				&& Objects.equals(folioPago, other.folioPago)
				&& Objects.equals(idOrdenPagoCursos, other.idOrdenPagoCursos)
				&& Objects.equals(idTipoPago, other.idTipoPago);
	}
	
	
	
	
	
}
