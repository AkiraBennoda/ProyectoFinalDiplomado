package sgi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import sgi.modelo.entidades.Persona;
import sgi.service.PersonaService;


@Controller
@RequestMapping("/formatos")
public class ReportesController {
	
	@Autowired
	private PersonaService service;
	
	@ModelAttribute("personasList")
    public List<Persona> getProductosList() {
		return service.cargaPersonas();
    }
	
	@RequestMapping("/pdf")
    public String generarPdf(Model model) {
        return "pdfView";
    }
	
	@RequestMapping("/xls")
    public String generarXls(Model model) {
        return "xlsView";
    }

}
