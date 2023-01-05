package sgi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sgi.modelo.entidades.Inscripcion;
import sgi.modelo.repository.InscripcionRepository;

@Service
public class InscripcionServiceImpl implements InscripcionService {
	
	@Autowired
	private InscripcionRepository inscripcionRepository;

	@Override
	public List<Inscripcion> cargaInscripciones() {
		return inscripcionRepository.findAll();
	}

	@Override
	public void guardaInscripcion(Inscripcion inscripcion) {
		inscripcionRepository.save(inscripcion);
		
	}

	@Override
	public Inscripcion cargaInscripcion(Integer idInscripcion) {
		return inscripcionRepository.findById(idInscripcion).orElse(null);
	}

	@Override
	public void eliminaInscripcion(Integer idInscripcion) {
		inscripcionRepository.deleteById(idInscripcion);
		
	}
	
	
	
}
