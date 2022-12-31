package sgi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import sgi.modelo.entidades.Nivel;
import sgi.modelo.repository.NivelRepository;

@Service
public class NivelServiceImpl implements NivelService{

	@Autowired
    private NivelRepository nivelRepository;
	
	
	@Override
	public List<Nivel> getListaNivel() {
		return nivelRepository.findAll();
	}

	@Override
	public Nivel cargaPorNombre(String nombre) {
		Nivel encontrado = null;
		Nivel nivelExample = new Nivel();
		nivelExample.setNombre(nombre);
		Example<Nivel> tCExample = Example.of(nivelExample);
		Iterable<Nivel> it = nivelRepository.findAll(tCExample);
		for (Nivel nivel : it) {
			encontrado = nivel;
		}
		return encontrado; 
	}

	

}
