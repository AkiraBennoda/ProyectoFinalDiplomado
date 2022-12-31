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

import sgi.forms.AlumnoForm;
import sgi.forms.PersonaForm;
import sgi.modelo.entidades.Alumno;
import sgi.modelo.entidades.Genero;
import sgi.modelo.entidades.Nacionalidad;
import sgi.modelo.entidades.Persona;
import sgi.service.AlumnoService;
import sgi.service.GeneroService;
import sgi.service.NacionalidadService;
import sgi.service.PersonaService;

@Controller
@RequestMapping("/alumnos")
public class AlumnoController {
	@Autowired
	private PersonaService personaService;
	
	@Autowired
	private GeneroService generoService;
	
	@Autowired
	private NacionalidadService nacionalidadService;	
	
	@Autowired
	private AlumnoService alumnoService;	

	
	
	@ResponseBody
	@RequestMapping(value = {"/jsonAlumno"})	
    public List<Alumno> alumnoJson() {
		return alumnoService.cargaAlumnos();
    }
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String cargaAlumno(Model model) {
		model.addAttribute("alumnos", alumnoService.cargaAlumnos());
		return "listaAlumnos";
	}
	
	@RequestMapping("/alumnoForm")
    public String alumnoForm(Model model) {
        model.addAttribute("alumno", new AlumnoForm());
        return "alumnoForm";
    }
	
	@RequestMapping(value = "/guardaAlumno", method = RequestMethod.POST)
    public ModelAndView guardaAlumno(@ModelAttribute("alumno") @Valid AlumnoForm alumnoForm, BindingResult result) {
		ModelAndView vista = new ModelAndView();
		if (result.hasErrors()) {
			
			vista.addObject(alumnoForm);
			vista.setViewName("alumnoForm");
		} else {
			
			Persona persona = new Persona();			
			persona.setNombre(alumnoForm.getNombre());
			persona.setEdad(alumnoForm.getEdad());
			persona.setCorreoElectronico(alumnoForm.getCorreoElectronico());
			persona.setRfc(alumnoForm.getRfc());
	        Genero genero = generoService.cargaPorNombre(alumnoForm.getIdGenero());
	        persona.setIdGenero(genero);
	        Nacionalidad nacionalidad= nacionalidadService.cargaPorNombre(alumnoForm.getIdNacionalidad());
	        persona.setIdNacionalidad(nacionalidad);
	    	persona.setPais(alumnoForm.getPais());
	    	persona.setEstado(alumnoForm.getEstado());
	    	persona.setLocalidad(alumnoForm.getLocalidad());
	    	persona.setCalle(alumnoForm.getCalle());
	    	persona.setCodigoPostal(alumnoForm.getCodigoPostal());
	    	persona.setNumExt(alumnoForm.getNumExt());
	    	persona.setNumInt(alumnoForm.getNumInt());
			
	    	personaService.guardaPersona(persona);
	    	
			Alumno alumno = alumnoForm.getIdAlumno() != null ? alumnoService.cargaAlumno(alumnoForm.getIdAlumno()) : new Alumno();			
			alumno.setMatricula(alumnoForm.getMatricula());
			alumno.setCalificacion(alumnoForm.getCalificacion());
			
			

	        alumnoService.guardaAlumno(alumno);
	     
	        
			vista.addObject("alumnos", alumnoService.cargaAlumnos());
			vista.setViewName("listaAlumnos");
		}
		return vista;
        
    }
	
	
	
	@RequestMapping("/actualizar/{idAlumno}")
    public String showFormForUpdate(@PathVariable Integer idAlumno, ModelMap model) {
		
		Alumno alumno= alumnoService.cargaAlumno(idAlumno);
		if (alumno != null) {
			AlumnoForm alumnoForm = new AlumnoForm();
			
			alumnoForm.setIdAlumno(idAlumno);
			alumnoForm.setIdPersona(alumno.getIdPersona());
			alumnoForm.setNombre(alumno.getNombre());
			alumnoForm.setEdad(alumno.getEdad());
			alumnoForm.setCorreoElectronico(alumno.getCorreoElectronico());
			alumnoForm.setRfc(alumno.getRfc());
			alumnoForm.setIdGenero(alumno.getIdGenero().getNombre());
			alumnoForm.setIdNacionalidad(alumno.getIdNacionalidad().getNombre());
			alumnoForm.setPais(alumno.getPais());
			alumnoForm.setEstado(alumno.getEstado());
			alumnoForm.setLocalidad(alumno.getLocalidad());
	    	alumnoForm.setCalle(alumno.getCalle());
	    	alumnoForm.setCodigoPostal(alumno.getCodigoPostal());
	    	alumnoForm.setNumExt(alumno.getNumExt());
	    	alumnoForm.setNumInt(alumno.getNumInt());
	    	
	    	alumnoForm.setMatricula(alumno.getMatricula());
	    	alumnoForm.setCalificacion(alumno.getCalificacion());
	    	
	    	
	    	
			
			
			model.put("alumno", alumnoForm);
		} else {
			model.put("alumno", new AlumnoForm());
		}
        return "alumnoFormActualiza";
    }
	
	@RequestMapping("eliminar")
	public String eliminaAlumno(@RequestParam("idAlumno") Integer idAlumno) {
		alumnoService.eliminaAlumno(idAlumno);
		return "redirect:/alumnos/listar";
	}
	
	
	
}
