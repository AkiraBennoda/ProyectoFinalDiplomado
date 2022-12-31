package sgi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import sgi.modelo.entidades.Idioma;
import sgi.modelo.repository.IdiomaRepository;

@Service
public class IdiomaServiceImpl implements IdiomaService{

	@Autowired
    private IdiomaRepository idiomaRepository;
	
	
	@Override
	public List<Idioma> getListaIdioma() {
		return idiomaRepository.findAll();
	}

	@Override
	public Idioma cargaPorNombre(String nombre) {
		Idioma encontrado = null;
		Idioma idiomaExample = new Idioma();
		idiomaExample.setNombre(nombre);
		Example<Idioma> tCExample = Example.of(idiomaExample);
		Iterable<Idioma> it = idiomaRepository.findAll(tCExample);
		for (Idioma idioma : it) {
			encontrado = idioma;
		}
		return encontrado; 
	}

	

}
