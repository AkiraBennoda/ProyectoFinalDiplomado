package sgi.service;

import java.util.List;

import sgi.modelo.entidades.Alumno;
import sgi.modelo.entidades.Persona;


public interface AlumnoService {
	
	List<Persona> cargaAlumnos();
	void guardaAlumno(Persona alumno);
	Persona cargaAlumno(Integer idAlumno);
	void eliminaAlumno(Integer idAlumno);

}
