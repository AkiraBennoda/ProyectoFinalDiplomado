package sgi.service;

import java.util.List;

import sgi.modelo.entidades.Inscripcion;

public interface InscripcionService {
	List<Inscripcion> cargaInscripciones();
	void guardaInscripcion(Inscripcion inscripcion);
	Inscripcion cargaInscripcion(Integer idInscripcion);
	void eliminaInscripcion(Integer idInscripcion);
}
