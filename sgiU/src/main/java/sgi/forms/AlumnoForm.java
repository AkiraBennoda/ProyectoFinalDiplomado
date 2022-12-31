package sgi.forms;

import javax.validation.constraints.NotNull;

public class AlumnoForm extends PersonaForm{
	
	
	
	private Integer idAlumno;
	
	@NotNull
	private String matricula;
	
	@NotNull
	private double calificacion;
	

	
	

	public Integer getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Integer idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}


	
	
	

}
