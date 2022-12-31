package sgi.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class OrdenPagoCursosForm {
	
	private Integer idOrdenPagoCursos;
	
	@Size(min=5, max= 50)
	private String folioPago;
	
	@Size(min=5, max= 100)
	@NotNull
	private String descripcion;
	
	@Size(max=8)
	@NotNull
	private String fechaPago;
	
	@NotNull
	private String idTipoPago;

	public Integer getIdOrdenPagoCursos() {
		return idOrdenPagoCursos;
	}

	public void setIdOrdenPagoCursos(Integer idOrdenPagoCursos) {
		this.idOrdenPagoCursos = idOrdenPagoCursos;
	}

	public String getFolioPago() {
		return folioPago;
	}

	public void setFolioPago(String folioPago) {
		this.folioPago = folioPago;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}

	public String getIdTipoPago() {
		return idTipoPago;
	}

	public void setIdTipoPago(String idTipoPago) {
		this.idTipoPago = idTipoPago;
	}
	
	
	
	
	
}
