package sgi.modelo.entidades;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="factura")
public class Factura {
	
	private Integer idFactura;
	private String folioFactura;
	private Integer fechaFactura;
	private String razonSocial;
	
	@JsonIgnore
	public Factura() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Factura(Integer idFactura) {
		super();
		this.idFactura = idFactura;
	}

	public Factura(String folioFactura, Integer fechaFactura, String razonSocial) {
		super();
		this.folioFactura = folioFactura;
		this.fechaFactura = fechaFactura;
		this.razonSocial = razonSocial;
	}

	
	@Id
	@Column(name = "idFactura")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(Integer idFactura) {
		this.idFactura = idFactura;
	}

	@Column(name = "folioFactura", length = 50)
	public String getFolioFactura() {
		return folioFactura;
	}

	public void setFolioFactura(String folioFactura) {
		this.folioFactura = folioFactura;
	}
	
	@Column(name = "fechaFactura")
	public Integer getFechaFactura() {
		return fechaFactura;
	}

	public void setFechaFactura(Integer fechaFactura) {
		this.fechaFactura = fechaFactura;
	}
	
	@Column(name = "razonSocial")
	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	@Override
	public String toString() {
		return "Factura [idFactura=" + idFactura + ", folioFactura=" + folioFactura + ", fechaFactura=" + fechaFactura
				+ ", razonSocial=" + razonSocial + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(fechaFactura, folioFactura, idFactura, razonSocial);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Factura other = (Factura) obj;
		return Objects.equals(fechaFactura, other.fechaFactura) && Objects.equals(folioFactura, other.folioFactura)
				&& Objects.equals(idFactura, other.idFactura) && Objects.equals(razonSocial, other.razonSocial);
	}
	
	
	
	
	
	

}
