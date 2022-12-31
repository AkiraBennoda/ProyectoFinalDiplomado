package sgi.service;

import java.util.List;

import sgi.modelo.entidades.TipoPago;



public interface TipoPagoService {
	List<TipoPago> getListaTipoPago();

	TipoPago cargaPorNombre(String nombre);
}
