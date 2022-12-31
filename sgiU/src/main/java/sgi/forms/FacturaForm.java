package sgi.forms;

import javax.validation.constraints.NotNull;


public class FacturaForm {
	
	private Integer idFactura;
	
	@NotNull
	private String folioFactura;
	
	
	@NotNull
	private Integer fechaFactura;
	
	@NotNull
	private String razonSocial;

	public Integer getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(Integer idFactura) {
		this.idFactura = idFactura;
	}

	public String getFolioFactura() {
		return folioFactura;
	}

	public void setFolioFactura(String folioFactura) {
		this.folioFactura = folioFactura;
	}

	public Integer getFechaFactura() {
		return fechaFactura;
	}

	public void setFechaFactura(Integer fechaFactura) {
		this.fechaFactura = fechaFactura;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	
	
	
}
