package sgi.service;

import java.util.List;

import sgi.modelo.entidades.OrdenPagoCursos;


public interface OrdenPagoCursosService {
	List<OrdenPagoCursos> cargaOrdenPagoCursos();
	void guardaOrdenPagoCursos(OrdenPagoCursos ordenPagoCursos);
	OrdenPagoCursos cargaOrdenPagoCursos(Integer idOrdenPagoCursos);
	void eliminaOrdenPagoCursos(Integer idOrdenPagoCursos);
}
