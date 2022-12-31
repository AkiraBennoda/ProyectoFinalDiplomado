package sgi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sgi.modelo.entidades.Genero;
import sgi.service.GeneroService;

@Controller
public class GeneroController {
	
	@Autowired
	private GeneroService service;
	
	@ResponseBody
	@RequestMapping(value = {"/jsonGenero"})	
    public List<Genero> generoJson() {
		return service.getListaGenero();
    }
}
