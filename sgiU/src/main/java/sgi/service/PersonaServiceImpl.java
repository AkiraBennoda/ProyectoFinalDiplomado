package sgi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sgi.modelo.entidades.Persona;
import sgi.modelo.repository.PersonaRepository;

@Service
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	private PersonaRepository personaRepository;
	
	@Override
	public List<Persona> cargaPersonas() {
		return personaRepository.findAll();
	}

	@Override
	public void guardaPersona(Persona persona) {
		personaRepository.save(persona);
		
	}

	@Override
	public Persona cargaPersona(Integer idPersona) {
		return personaRepository.findById(idPersona).orElse(null);
	}

	@Override
	public void eliminaPersona(Integer idPersona) {
		personaRepository.deleteById(idPersona);
		
	}

}
