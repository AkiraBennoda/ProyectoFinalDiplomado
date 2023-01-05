package sgi.modelo.entidades;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="inscripcion")
public class Inscripcion {
	
	private Integer idInscripcion;
	private Integer fechaInscripcion;
	private Integer reinscripcion; 	 	
	private Integer pagado;
	
	private Persona idAlumno;
	
	private TipoPago idTipoPago;
	private Factura idFactura;
	private Curso idCurso;
	
	
	@JsonIgnore
	public Inscripcion() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Inscripcion(Integer idInscripcion) {
		super();
		this.idInscripcion = idInscripcion;
	}


	public Inscripcion(Integer fechaInscripcion, Integer reinscripcion, Integer pagado, Alumno idAlumno, Curso idCurso,
			TipoPago idTipoPago, Factura idFactura) {
		super();
		this.fechaInscripcion = fechaInscripcion;
		this.reinscripcion = reinscripcion;
		this.pagado = pagado;
		this.idAlumno = idAlumno;
		this.idCurso= idCurso;
		this.idTipoPago = idTipoPago;
		this.idFactura = idFactura;
	}

	@Id
	@Column(name = "idInscripcion")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdInscripcion() {
		return idInscripcion;
	}


	public void setIdInscripcion(Integer idInscripcion) {
		this.idInscripcion = idInscripcion;
	}

	@Column(name = "fechaInscripcion")
	public Integer getFechaInscripcion() {
		return fechaInscripcion;
	}


	public void setFechaInscripcion(Integer fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}

	@Column(name = "reinscripcion")
	public Integer getReinscripcion() {
		return reinscripcion;
	}


	public void setReinscripcion(Integer reinscripcion) {
		this.reinscripcion = reinscripcion;
	}

	@Column(name = "pagado")
	public Integer getPagado() {
		return pagado;
	}


	public void setPagado(Integer pagado) {
		this.pagado = pagado;
	}

	@OneToOne(targetEntity = Persona.class, optional = false, fetch = FetchType.LAZY) //indica el tipo de clase
	@JoinColumn(name = "idPersona", nullable = false)//indicar la columna de la relacion de B
	@Fetch(FetchMode.JOIN)
	public Persona getIdAlumno() {
		return idAlumno;
	}


	public void setIdAlumno(Persona idAlumno) {
		this.idAlumno = idAlumno;
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

	@OneToOne(targetEntity = Factura.class, optional = false, fetch = FetchType.LAZY) //indica el tipo de clase
	@JoinColumn(name = "idFactura", nullable = false)//indicar la columna de la relacion de B
	@Fetch(FetchMode.JOIN)
	public Factura getIdFactura() {
		return idFactura;
	}


	public void setIdFactura(Factura idFactura) {
		this.idFactura = idFactura;
	}

	
	@OneToOne(targetEntity = Curso.class, optional = false, fetch = FetchType.LAZY) //indica el tipo de clase
	@JoinColumn(name = "idCurso", nullable = false)//indicar la columna de la relacion de B
	@Fetch(FetchMode.JOIN)
	public Curso getIdCurso() {
		return idCurso;
	}


	public void setIdCurso(Curso idCurso) {
		this.idCurso = idCurso;
	}


	
	@Override
	public String toString() {
		return "Inscripcion [idInscripcion=" + idInscripcion + ", fechaInscripcion=" + fechaInscripcion
				+ ", reinscripcion=" + reinscripcion + ", pagado=" + pagado + ", idAlumno=" + idAlumno + ", idTipoPago="
				+ idTipoPago + ", idFactura=" + idFactura + ", idCurso=" + idCurso + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(fechaInscripcion, idAlumno, idCurso, idFactura, idInscripcion, idTipoPago, pagado,
				reinscripcion);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inscripcion other = (Inscripcion) obj;
		return Objects.equals(fechaInscripcion, other.fechaInscripcion) && Objects.equals(idAlumno, other.idAlumno)
				&& Objects.equals(idCurso, other.idCurso) && Objects.equals(idFactura, other.idFactura)
				&& Objects.equals(idInscripcion, other.idInscripcion) && Objects.equals(idTipoPago, other.idTipoPago)
				&& Objects.equals(pagado, other.pagado) && Objects.equals(reinscripcion, other.reinscripcion);
	}



	
	
	
}
