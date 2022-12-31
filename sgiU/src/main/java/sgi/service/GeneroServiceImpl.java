package sgi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import sgi.modelo.entidades.Genero;
import sgi.modelo.repository.GeneroRepository;

@Service
public class GeneroServiceImpl implements GeneroService{

	@Autowired
    private GeneroRepository generoRepository;
	
	
	@Override
	public List<Genero> getListaGenero() {
		return generoRepository.findAll();
	}

	@Override
	public Genero cargaPorNombre(String nombre) {
		Genero encontrado = null;
		Genero generoExample = new Genero();
		generoExample.setNombre(nombre);
		Example<Genero> tCExample = Example.of(generoExample);
		Iterable<Genero> it = generoRepository.findAll(tCExample);
		for (Genero genero : it) {
			encontrado = genero;
		}
		return encontrado; 
	}

	

}
