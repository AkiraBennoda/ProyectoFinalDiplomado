package sgi.service;

import java.util.List;


import sgi.modelo.entidades.Nivel;

public interface NivelService {
	List<Nivel> getListaNivel();

	Nivel cargaPorNombre(String nombre);
}
