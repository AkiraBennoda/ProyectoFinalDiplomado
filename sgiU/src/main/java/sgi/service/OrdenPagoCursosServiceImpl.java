package sgi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sgi.modelo.entidades.OrdenPagoCursos;
import sgi.modelo.repository.OrdenPagoCursosRepository;


@Service
public class OrdenPagoCursosServiceImpl implements OrdenPagoCursosService{

	@Autowired
	private OrdenPagoCursosRepository ordenPagoCursosRepository;
	
	@Override
	public List<OrdenPagoCursos> cargaOrdenPagoCursos() {
		return ordenPagoCursosRepository.findAll();
	}

	@Override
	public void guardaOrdenPagoCursos(OrdenPagoCursos ordenPagoCursos) {
		ordenPagoCursosRepository.save(ordenPagoCursos);
		
	}

	@Override
	public OrdenPagoCursos cargaOrdenPagoCursos(Integer idOrdenPagoCursos) {
		return ordenPagoCursosRepository.findById(idOrdenPagoCursos).orElse(null);
	}

	@Override
	public void eliminaOrdenPagoCursos(Integer idOrdenPagoCursos) {
		ordenPagoCursosRepository.deleteById(idOrdenPagoCursos);
		
	}

}
