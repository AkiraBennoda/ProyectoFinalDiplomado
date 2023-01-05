package sgi.service;

import java.util.List;

import sgi.modelo.entidades.Factura;
import sgi.modelo.entidades.Persona;

public interface FacturaService {
	List<Factura> cargaFacturas();
	void guardaFactura(Factura factura);
	Factura cargaFactura(Integer idFactura);
	void eliminaFactura(Integer idFactura);
	Factura cargaPorNombre(String nombre);
}
