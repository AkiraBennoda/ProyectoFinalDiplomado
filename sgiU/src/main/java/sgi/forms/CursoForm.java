package sgi.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CursoForm {
	
	private Integer idCurso;
	
	@Size(min=5, max= 50)
	private String codigoCurso;
	
	@NotNull
	private String idIdioma;
	
	@NotNull
	private String idTipoCurso;
	
	@NotNull
	private String idModalidad;
	
	@NotNull
	private String idNivel;

	
	public Integer getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}

	public String getCodigoCurso() {
		return codigoCurso;
	}

	public void setCodigoCurso(String codigoCurso) {
		this.codigoCurso = codigoCurso;
	}

	public String getIdIdioma() {
		return idIdioma;
	}

	public void setIdIdioma(String idIdioma) {
		this.idIdioma = idIdioma;
	}

	public String getIdTipoCurso() {
		return idTipoCurso;
	}

	public void setIdTipoCurso(String idTipoCurso) {
		this.idTipoCurso = idTipoCurso;
	}

	public String getIdModalidad() {
		return idModalidad;
	}

	public void setIdModalidad(String idModalidad) {
		this.idModalidad = idModalidad;
	}

	public String getIdNivel() {
		return idNivel;
	}

	public void setIdNivel(String idNivel) {
		this.idNivel = idNivel;
	}
	
	
	
	
	
}
