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

import sgi.forms.CursoForm;

import sgi.modelo.entidades.Curso;

import sgi.modelo.entidades.Idioma;
import sgi.modelo.entidades.Modalidad;

import sgi.modelo.entidades.Nivel;

import sgi.modelo.entidades.TipoCurso;
import sgi.service.CursoService;

import sgi.service.IdiomaService;
import sgi.service.ModalidadService;

import sgi.service.NivelService;

import sgi.service.TipoCursoService;

@Controller
@RequestMapping("/cursos")
public class CursoController {
	@Autowired
	private CursoService cursoService;
	
	@Autowired
	private IdiomaService idiomaService;
	
	@Autowired
	private TipoCursoService tipoCursoService;	
	
	@Autowired
	private ModalidadService modalidadService;	
	
	@Autowired
	private NivelService nivelService;	
	

	
	
	
	@ResponseBody
	@RequestMapping(value = {"/jsonCurso"})	
    public List<Curso> cursoJson() {
		return cursoService.cargaCursos();
    }
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String cargaCurso(Model model) {
		model.addAttribute("cursos", cursoService.cargaCursos());
		return "listaCursos";
	}
	
	@RequestMapping("/cursoForm")
    public String contactoForm(Model model) {
        model.addAttribute("curso", new CursoForm());
        return "cursoForm";
    }
	
	@RequestMapping(value = "/guardaCurso", method = RequestMethod.POST)
    public ModelAndView guardaCurso(@ModelAttribute("curso") @Valid CursoForm cursoForm, BindingResult result) {
		ModelAndView vista = new ModelAndView();
		if (result.hasErrors()) {
			vista.addObject(cursoForm);
			vista.setViewName("cursoForm");
		} else {
			Curso curso= cursoForm.getIdCurso() != null ? cursoService.cargaCurso(cursoForm.getIdCurso()) : new Curso();			
			curso.setCodigoCurso(cursoForm.getCodigoCurso());
			
	        Idioma idioma= idiomaService.cargaPorNombre(cursoForm.getIdIdioma());
	        curso.setIdIdioma(idioma);
	        
	        TipoCurso tipoCurso= tipoCursoService.cargaPorNombre(cursoForm.getIdTipoCurso());
	        curso.setIdTipoCurso(tipoCurso);
	        
	        Modalidad modalidad= modalidadService.cargaPorNombre(cursoForm.getIdModalidad());
	        curso.setIdModalidad(modalidad);
	        
	        
	        Nivel nivel= nivelService.cargaPorNombre(cursoForm.getIdNivel());
	        curso.setIdNivel(nivel);     
	        
	        
	        cursoService.guardaCurso(curso);
	        
			vista.addObject("cursos", cursoService.cargaCursos());
			vista.setViewName("listaCursos");
		}
		return vista;
        
    }
	
	@RequestMapping("/actualizar/{idCurso}")
    public String showFormForUpdate(@PathVariable Integer idCurso, ModelMap model) {
		
		Curso curso= cursoService.cargaCurso(idCurso);
		if (curso != null) {
			CursoForm cursoForm = new CursoForm();
			cursoForm.setIdCurso(idCurso);
			cursoForm.setCodigoCurso(curso.getCodigoCurso());
			cursoForm.setIdIdioma(curso.getIdIdioma().getNombre());
			cursoForm.setIdTipoCurso(curso.getIdTipoCurso().getNombre());
			cursoForm.setIdModalidad(curso.getIdModalidad().getNombre());
			cursoForm.setIdNivel(curso.getIdNivel().getNombre());
			
					
			
			
			model.put("curso", cursoForm);
		} else {
			model.put("curso", new CursoForm());
		}
        return "cursoFormActualiza";
    }
	
	@RequestMapping("eliminar")
	public String eliminaCurso(@RequestParam("idCurso") Integer idCurso) {
		cursoService.eliminaCurso(idCurso);
		return "redirect:/cursos/listar";
	}
	
	
	
}
