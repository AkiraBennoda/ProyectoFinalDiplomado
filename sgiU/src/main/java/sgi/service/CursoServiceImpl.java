package sgi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sgi.modelo.entidades.Curso;
import sgi.modelo.repository.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService {

	@Autowired
	private CursoRepository cursoRepository;
	
	@Override
	public List<Curso> cargaCursos() {
		return cursoRepository.findAll();
	}

	@Override
	public void guardaCurso(Curso curso) {
		cursoRepository.save(curso);
		
	}

	@Override
	public Curso cargaCurso(Integer idCurso) {
		return cursoRepository.findById(idCurso).orElse(null);
	}

	@Override
	public void eliminaCurso(Integer idCurso) {
		cursoRepository.deleteById(idCurso);
		
	}

}
