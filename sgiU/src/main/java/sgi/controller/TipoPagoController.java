package sgi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import sgi.modelo.entidades.TipoPago;
import sgi.service.TipoPagoService;

@Controller
public class TipoPagoController {
	
	@Autowired
	private TipoPagoService service;
	
	@ResponseBody
	@RequestMapping(value = {"/jsonTipoPago"})	
    public List<TipoPago> tipoPagoJson() {
		return service.getListaTipoPago();
    }
}
