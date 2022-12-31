package sgi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sgi.modelo.entidades.Factura;
import sgi.modelo.repository.FacturaRepository;

@Service
public class FacturaServiceImpl implements FacturaService {

	@Autowired
	private FacturaRepository facturaRepository;
	
	@Override
	public List<Factura> cargaFacturas() {
		return facturaRepository.findAll();
	}

	@Override
	public void guardaFactura(Factura factura) {
		facturaRepository.save(factura);
		
	}

	@Override
	public Factura cargaFactura(Integer idFactura) {
		return facturaRepository.findById(idFactura).orElse(null);
	}

	@Override
	public void eliminaFactura(Integer idFactura) {
		facturaRepository.deleteById(idFactura);
		
	}

}
