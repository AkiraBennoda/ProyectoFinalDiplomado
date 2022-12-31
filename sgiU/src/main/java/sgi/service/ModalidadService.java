package sgi.service;

import java.util.List;

import sgi.modelo.entidades.Modalidad;

public interface ModalidadService {
	List<Modalidad> getListaModalidad();

	Modalidad cargaPorNombre(String nombre);
}
