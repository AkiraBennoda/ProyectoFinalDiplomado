package sgi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sgi.modelo.entidades.Alumno;
import sgi.modelo.entidades.Persona;
import sgi.modelo.repository.AlumnoRepository;

@Service
public class AlumnoServiceImpl implements AlumnoService {

	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@Override
	public List<Persona> cargaAlumnos() {
		return alumnoRepository.findAll();
	}

	@Override
	public void guardaAlumno(Persona alumno) {
		alumnoRepository.save(alumno);
		
	}

	@Override
	public Persona cargaAlumno(Integer idAlumno) {
		return alumnoRepository.findById(idAlumno).orElse(null);
	}

	@Override
	public void eliminaAlumno(Integer idAlumno) {
		alumnoRepository.deleteById(idAlumno);
		
	}

}
