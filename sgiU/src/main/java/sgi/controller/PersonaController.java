package sgi.controller;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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

import sgi.forms.PersonaForm;

import sgi.modelo.entidades.Genero;
import sgi.modelo.entidades.Nacionalidad;
import sgi.modelo.entidades.Persona;

import sgi.service.GeneroService;
import sgi.service.NacionalidadService;
import sgi.service.PersonaService;

@Controller
@RequestMapping("/personas")
public class PersonaController {
	@Autowired
	private PersonaService personaService;
	
	@Autowired
	private GeneroService generoService;
	
	@Autowired
	private NacionalidadService nacionalidadService;	
	

	
	
	@ResponseBody
	@RequestMapping(value = {"/jsonPersona"})	
    public List<Persona> personaJson() {
		return personaService.cargaPersonas();
    }
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String cargaPersona(Model model) {
		model.addAttribute("personas", personaService.cargaPersonas());
		return "listaPersonas";
	}
	
	@RequestMapping("/personaForm")
    public String contactoForm(Model model) {
        model.addAttribute("persona", new PersonaForm());
        return "personaForm";
    }
	
	@RequestMapping(value = "/guardaPersona", method = RequestMethod.POST)
    public ModelAndView guardaPersona(@ModelAttribute("persona") @Valid PersonaForm personaForm, BindingResult result) {
		ModelAndView vista = new ModelAndView();
		if (result.hasErrors()) {
			System.out.println("Brenda ********************************* " + result);
			vista.addObject(personaForm);
			vista.setViewName("personaForm");
		} else {
			Persona persona = personaForm.getIdPersona() != null ? personaService.cargaPersona(personaForm.getIdPersona()) : new Persona();			
			persona.setNombre(personaForm.getNombre());
			persona.setEdad(personaForm.getEdad());
			persona.setCorreoElectronico(personaForm.getCorreoElectronico());
			persona.setRfc(personaForm.getRfc());
	        Genero genero = generoService.cargaPorNombre(personaForm.getIdGenero());
	        persona.setIdGenero(genero);
	        Nacionalidad nacionalidad= nacionalidadService.cargaPorNombre(personaForm.getIdNacionalidad());
	        persona.setIdNacionalidad(nacionalidad);
	    	persona.setPais(personaForm.getPais());
	    	persona.setEstado(personaForm.getEstado());
	    	persona.setLocalidad(personaForm.getLocalidad());
	    	persona.setCalle(personaForm.getCalle());
	    	persona.setCodigoPostal(personaForm.getCodigoPostal());
	    	persona.setNumExt(personaForm.getNumExt());
	    	persona.setNumInt(personaForm.getNumInt());
	    
	    	
	  
	        
	        
	        personaService.guardaPersona(persona);
	        
			vista.addObject("personas", personaService.cargaPersonas());
			vista.setViewName("listaPersonas");
		}
		return vista;
        
    }
	
	@RequestMapping("/actualizar/{idPersona}")
    public String showFormForUpdate(@PathVariable Integer idPersona, ModelMap model) {
		
		Persona persona = personaService.cargaPersona(idPersona);
		if (persona != null) {
			PersonaForm personaForm = new PersonaForm();
			personaForm.setIdPersona(idPersona);
			personaForm.setNombre(persona.getNombre());
			personaForm.setEdad(persona.getEdad());
			personaForm.setCorreoElectronico(persona.getCorreoElectronico());
			personaForm.setRfc(persona.getRfc());
			personaForm.setIdGenero(persona.getIdGenero().getNombre());
			personaForm.setIdNacionalidad(persona.getIdNacionalidad().getNombre());
			personaForm.setPais(persona.getPais());
			personaForm.setEstado(persona.getEstado());
	    	personaForm.setLocalidad(persona.getLocalidad());
	    	personaForm.setCalle(persona.getCalle());
	    	personaForm.setCodigoPostal(persona.getCodigoPostal());
	    	personaForm.setNumExt(persona.getNumExt());
	    	personaForm.setNumInt(persona.getNumInt());
			
			
			model.put("persona", personaForm);
		} else {
			model.put("persona", new PersonaForm());
		}
        return "personaFormActualiza";
    }
	
	@RequestMapping("eliminar")
	public String eliminaPersona(@RequestParam("idPersona") Integer idPersona) {
		personaService.eliminaPersona(idPersona);
		return "redirect:/personas/listar";
	}
	
	
	
}
