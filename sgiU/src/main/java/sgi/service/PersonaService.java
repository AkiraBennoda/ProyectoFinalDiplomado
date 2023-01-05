package sgi.service;

import java.util.List;


import sgi.modelo.entidades.Persona;

public interface PersonaService {

	List<Persona> cargaPersonas();
	void guardaPersona(Persona persona);
	Persona cargaPersona(Integer idPersona);
	void eliminaPersona(Integer idPersona);
	Persona cargaPorNombre(String nombre);
}
