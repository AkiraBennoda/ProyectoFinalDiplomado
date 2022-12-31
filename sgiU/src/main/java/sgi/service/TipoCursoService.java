package sgi.service;

import java.util.List;

import sgi.modelo.entidades.TipoCurso;

public interface TipoCursoService {
	List<TipoCurso> getListaTipoCurso();

	TipoCurso cargaPorNombre(String nombre);
}
