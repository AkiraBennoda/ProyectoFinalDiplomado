package sgi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import sgi.modelo.entidades.Curso;
import sgi.modelo.entidades.Persona;
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
	
	@Override
	public Curso cargaPorNombre(String nombre) {
		Curso encontrado = null;
		Curso cursoExample = new Curso();
		cursoExample.setCodigoCurso(nombre);
		Example<Curso> tCExample = Example.of(cursoExample);
		Iterable<Curso> it = cursoRepository.findAll(tCExample);
		for (Curso curso: it) {
			encontrado = curso;
		}
		return encontrado; 
	}


}
