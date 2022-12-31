package sgi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import sgi.modelo.entidades.Modalidad;
import sgi.modelo.repository.ModalidadRepository;

@Service
public class ModalidadServiceImpl implements ModalidadService{

	@Autowired
    private ModalidadRepository modalidadRepository;
	
	
	@Override
	public List<Modalidad> getListaModalidad() {
		return modalidadRepository.findAll();
	}

	@Override
	public Modalidad cargaPorNombre(String nombre) {
		Modalidad encontrado = null;
		Modalidad modalidadExample = new Modalidad();
		modalidadExample.setNombre(nombre);
		Example<Modalidad> tCExample = Example.of(modalidadExample);
		Iterable<Modalidad> it = modalidadRepository.findAll(tCExample);
		for (Modalidad modalidad : it) {
			encontrado = modalidad;
		}
		return encontrado; 
	}

	

}
