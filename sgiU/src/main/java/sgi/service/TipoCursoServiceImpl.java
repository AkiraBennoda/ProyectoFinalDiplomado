package sgi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import sgi.modelo.entidades.TipoCurso;
import sgi.modelo.repository.TipoCursoRepository;

@Service
public class TipoCursoServiceImpl implements TipoCursoService{

	@Autowired
    private TipoCursoRepository tipoCursoRepository;
	
	
	@Override
	public List<TipoCurso> getListaTipoCurso() {
		return tipoCursoRepository.findAll();
	}

	@Override
	public TipoCurso cargaPorNombre(String nombre) {
		TipoCurso encontrado = null;
		TipoCurso tipoCursoExample = new TipoCurso();
		tipoCursoExample.setNombre(nombre);
		Example<TipoCurso> tCExample = Example.of(tipoCursoExample);
		Iterable<TipoCurso> it = tipoCursoRepository.findAll(tCExample);
		for (TipoCurso tipoCurso: it) {
			encontrado = tipoCurso;
		}
		return encontrado; 
	}

	

}
