package sgi.modelo.entidades;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import javax.persistence.Table;

@Entity
@Table(name="alumno")
@DiscriminatorValue(value = "ALUMNO")
public class Alumno extends Persona{
	
	//private Integer idAlumno;
	private String matricula;
	private double calificacion;
	
	public Alumno() {
		super();
	}


	public Alumno(String matricula, double calificacion) {
		super();
		this.matricula = matricula;
		this.calificacion = calificacion;
		
	}

	
	@Column(name = "matricula", length = 50)
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	@Column(name = "calificacion")
	public double getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}
	
	
	

	@Override
	public String toString() {
		return "Alumno [matricula=" + matricula + ", calificacion=" + calificacion + "]";
	}






	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(calificacion, matricula);
		return result;
	}






	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Double.doubleToLongBits(calificacion) == Double.doubleToLongBits(other.calificacion)
				 && Objects.equals(matricula, other.matricula);
	}







	
	
	
	
}
