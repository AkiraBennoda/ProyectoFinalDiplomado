package sgi.service;

import java.util.List;

import sgi.modelo.entidades.Curso;

	

public interface CursoService {

	List<Curso> cargaCursos();
	void guardaCurso(Curso curso);
	Curso cargaCurso(Integer idCurso);
	void eliminaCurso(Integer idCurso);
	Curso cargaPorNombre(String nombre);
}
