package sgi.service;

import java.util.List;
import sgi.modelo.entidades.Nacionalidad;

public interface NacionalidadService {

	List<Nacionalidad> getListaNacionalidad();
	Nacionalidad cargaPorNombre(String nombre);

}
