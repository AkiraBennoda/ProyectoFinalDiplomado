package sgi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import sgi.modelo.entidades.Nacionalidad;
import sgi.modelo.repository.NacionalidadRepository;

@Service
public class NacionalidadServiceImpl implements NacionalidadService{

	@Autowired
	private NacionalidadRepository nacionalidadRepository;
	
	@Override
	public List<Nacionalidad> getListaNacionalidad() {
		return nacionalidadRepository.findAll();
	}
	
	@Override
	public Nacionalidad cargaPorNombre(String nombre) {
		Nacionalidad encontrado = null;
		Nacionalidad nacionalidadExample = new Nacionalidad();
		nacionalidadExample.setNombre(nombre);
		Example<Nacionalidad> tCExample = Example.of(nacionalidadExample);
		Iterable<Nacionalidad> it = nacionalidadRepository.findAll(tCExample);
		for (Nacionalidad nacionalidad : it) {
			encontrado = nacionalidad;
		}
		return encontrado; 
	}

}
