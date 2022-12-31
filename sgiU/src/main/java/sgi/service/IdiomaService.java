package sgi.service;

import java.util.List;

import sgi.modelo.entidades.Idioma;

public interface IdiomaService {
	List<Idioma> getListaIdioma();

	Idioma cargaPorNombre(String nombre);
}
