package sgi.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;




public class InscripcionForm {
	
	private Integer idInscripcion;
	
	@NotNull
	private Integer fechaInscripcion;
	
	@NotNull
	private Integer reinscripcion;
	
	@NotNull
	private Integer pagado;
	
	@NotNull
	private String idAlumno;
	
	
	@NotNull
	private String idTipoPago;
	
	@NotNull
	private String idFactura;
	
	@NotNull
	private String idCurso;
	

	public Integer getIdInscripcion() {
		return idInscripcion;
	}

	public void setIdInscripcion(Integer idInscripcion) {
		this.idInscripcion = idInscripcion;
	}

	public Integer getFechaInscripcion() {
		return fechaInscripcion;
	}

	public void setFechaInscripcion(Integer fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}

	public Integer getReinscripcion() {
		return reinscripcion;
	}

	public void setReinscripcion(Integer reinscripcion) {
		this.reinscripcion = reinscripcion;
	}

	public Integer getPagado() {
		return pagado;
	}

	public void setPagado(Integer pagado) {
		this.pagado = pagado;
	}

	public String getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(String idAlumno) {
		this.idAlumno = idAlumno;
	}

	

	public String getIdTipoPago() {
		return idTipoPago;
	}

	public void setIdTipoPago(String idTipoPago) {
		this.idTipoPago = idTipoPago;
	}

	public String getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(String idFactura) {
		this.idFactura = idFactura;
	}

	public String getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(String idCurso) {
		this.idCurso = idCurso;
	}
	
	
	
}
