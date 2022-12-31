package sgi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import sgi.modelo.entidades.TipoPago;
import sgi.modelo.repository.TipoPagoRepository;

@Service
public class TipoPagoServiceImpl implements TipoPagoService{
	
	@Autowired
    private TipoPagoRepository tipoPagoRepository;

	@Override
	public List<TipoPago> getListaTipoPago() {
		return tipoPagoRepository.findAll();
	}

	@Override
	public TipoPago cargaPorNombre(String nombre) {
		TipoPago encontrado = null;
		TipoPago tipoPagoExample = new TipoPago();
		tipoPagoExample.setNombre(nombre);
		Example<TipoPago> tCExample = Example.of(tipoPagoExample);
		Iterable<TipoPago> it = tipoPagoRepository.findAll(tCExample);
		for (TipoPago tipoPago : it) {
			encontrado = tipoPago;
		}
		

		return encontrado; 
	}
	
	
	
	
	
}
