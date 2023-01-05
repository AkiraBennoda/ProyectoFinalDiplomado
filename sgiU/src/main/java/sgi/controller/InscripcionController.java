package sgi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import sgi.forms.InscripcionForm;
import sgi.modelo.entidades.Curso;
import sgi.modelo.entidades.Factura;
import sgi.modelo.entidades.Inscripcion;
import sgi.modelo.entidades.Persona;
import sgi.modelo.entidades.TipoPago;
import sgi.service.PersonaService;
import sgi.service.TipoPagoService;
import sgi.service.CursoService;
import sgi.service.FacturaService;
import sgi.service.InscripcionService;

@Controller
@RequestMapping("/inscripciones")
public class InscripcionController {
	
	
	@Autowired
	private InscripcionService inscripcionService;
	
	
	@Autowired
	private PersonaService personaService;
	

	@Autowired
	private TipoPagoService tipoPagoService;
	
	@Autowired
	private FacturaService facturaService;
	
	@Autowired 
	private CursoService cursoService;
	
	
	
	@ResponseBody
	@RequestMapping(value = {"/jsonInscripcion"})	
    public List<Inscripcion> personaJson() {
		return inscripcionService.cargaInscripciones();
    }
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String cargaPersona(Model model) {
		model.addAttribute("inscripciones", inscripcionService.cargaInscripciones());
		return "listaInscripciones";
	}
	
	@RequestMapping("/inscripcionForm")
    public String inscripcionForm(Model model) {
        model.addAttribute("inscripcion", new InscripcionForm());
        return "inscripcionForm";
    }
	
	@RequestMapping(value = "/guardaInscripcion", method = RequestMethod.POST)
    public ModelAndView guardaInscripcion(@ModelAttribute("inscripcion") @Valid InscripcionForm inscripcionForm, BindingResult result) {
		ModelAndView vista = new ModelAndView();
		if (result.hasErrors()) {
			System.out.println("Brenda ********************************* " + result);
			vista.addObject(inscripcionForm);
			vista.setViewName("inscripcionForm");
		} else {
			Inscripcion inscripcion = inscripcionForm.getIdInscripcion() != null ? inscripcionService.cargaInscripcion(inscripcionForm.getIdInscripcion()) : new Inscripcion();			
			inscripcion.setFechaInscripcion(inscripcionForm.getFechaInscripcion());
			inscripcion.setReinscripcion(inscripcionForm.getReinscripcion());
			inscripcion.setPagado(inscripcionForm.getPagado());
			
			Persona alumno= personaService.cargaPorNombre(inscripcionForm.getIdAlumno());
	        inscripcion.setIdAlumno(alumno);
			
	               
	        TipoPago tipoPago = tipoPagoService.cargaPorNombre(inscripcionForm.getIdTipoPago());
	        inscripcion.setIdTipoPago(tipoPago);
	    	
	        Factura factura = facturaService.cargaPorNombre(inscripcionForm.getIdFactura());
	        inscripcion.setIdFactura(factura);
	        
	        Curso curso= cursoService.cargaPorNombre(inscripcionForm.getIdCurso());
	        inscripcion.setIdCurso(curso);
	        
	        inscripcionService.guardaInscripcion(inscripcion);
	        
			vista.addObject("inscripciones", inscripcionService.cargaInscripciones());
			vista.setViewName("listaInscripciones");
		}
		return vista;
        
    }
	
	@RequestMapping("/actualizar/{idInscripcion}")
    public String showFormForUpdate(@PathVariable Integer idInscripcion, ModelMap model) {
		
		Inscripcion inscripcion= inscripcionService.cargaInscripcion(idInscripcion);
		if (inscripcion != null) {
			InscripcionForm inscripcionForm = new InscripcionForm();
			inscripcionForm.setIdInscripcion(idInscripcion);
			inscripcionForm.setFechaInscripcion(inscripcion.getFechaInscripcion());
			inscripcionForm.setReinscripcion(inscripcion.getReinscripcion());
			inscripcionForm.setPagado(inscripcion.getPagado());
			inscripcionForm.setIdAlumno(inscripcion.getIdAlumno().getNombre());
			inscripcionForm.setIdTipoPago(inscripcion.getIdTipoPago().getNombre());
			inscripcionForm.setIdFactura(inscripcion.getIdFactura().getFolioFactura());
			inscripcionForm.setIdCurso(inscripcion.getIdCurso().getCodigoCurso());
			
			
			
			model.put("inscripcion", inscripcionForm);
		} else {
			model.put("inscripcion", new InscripcionForm());
		}
        return "inscripcionFormActualiza";
    }
	
	@RequestMapping("eliminar")
	public String eliminaInscripcion(@RequestParam("idInscripcion") Integer idInscripcion) {
		inscripcionService.eliminaInscripcion(idInscripcion);
		return "redirect:/inscripciones/listar";
	}	

}
