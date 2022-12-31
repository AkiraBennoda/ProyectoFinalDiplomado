package sgi.service;

import java.util.List;

import sgi.modelo.entidades.Genero;


public interface GeneroService {

	List<Genero> getListaGenero();

	Genero cargaPorNombre(String nombre);
	

}
