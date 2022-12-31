package sgi.service;

import java.util.List;

import sgi.modelo.entidades.Alumno;


public interface AlumnoService {
	
	List<Alumno> cargaAlumnos();
	void guardaAlumno(Alumno alumno);
	Alumno cargaAlumno(Integer idAlumno);
	void eliminaAlumno(Integer idAlumno);

}
