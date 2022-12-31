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

import sgi.forms.OrdenPagoCursosForm;
import sgi.forms.PersonaForm;
import sgi.modelo.entidades.Genero;
import sgi.modelo.entidades.Nacionalidad;
import sgi.modelo.entidades.OrdenPagoCursos;
import sgi.modelo.entidades.Persona;
import sgi.modelo.entidades.TipoPago;
import sgi.service.OrdenPagoCursosService;
import sgi.service.TipoPagoService;


@Controller
@RequestMapping("/pagoCursos")
public class OrdenPagoCursosController {
	
	@Autowired
	private OrdenPagoCursosService ordenPagoCursosService;
	
	@Autowired
	private TipoPagoService tipoPagoService;
	
	
	
	@ResponseBody
	@RequestMapping(value = {"/jsonOrdenPagoCursos"})	
    public List<OrdenPagoCursos> ordenPagoCursosJson() {
		return ordenPagoCursosService.cargaOrdenPagoCursos();
    }
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String cargaOrdenPagoCursos(Model model) {
		model.addAttribute("ordenPagoCursos", ordenPagoCursosService.cargaOrdenPagoCursos());
		return "listaOrdenPagoCursos";
	}
	
	@RequestMapping("/ordenPagoCursosForm")
    public String ordenPagoCursosForm(Model model) {
        model.addAttribute("ordenPagoCursos", new OrdenPagoCursosForm());
        return "ordenPagoCursosForm";
    }
	
	@RequestMapping(value = "/guardaOrdenPagoCursos", method = RequestMethod.POST)
    public ModelAndView guardaPersona(@ModelAttribute("ordenPagoCursos") @Valid OrdenPagoCursosForm ordenPagoCursosForm, BindingResult result) {
		ModelAndView vista = new ModelAndView();
		if (result.hasErrors()) {
			
			vista.addObject(ordenPagoCursosForm);
			vista.setViewName("ordenPagoCursosForm");
		} else {
			
			OrdenPagoCursos ordenPagoCursos = ordenPagoCursosForm.getIdOrdenPagoCursos() != null ? ordenPagoCursosService.cargaOrdenPagoCursos(ordenPagoCursosForm.getIdOrdenPagoCursos()) : new OrdenPagoCursos();			
			ordenPagoCursos.setFolioPago(ordenPagoCursosForm.getFolioPago());
			ordenPagoCursos.setDescripcion(ordenPagoCursosForm.getDescripcion());
			ordenPagoCursos.setFechaPago(ordenPagoCursosForm.getFechaPago());
			TipoPago tipoPago = tipoPagoService.cargaPorNombre(ordenPagoCursosForm.getIdTipoPago());
	        ordenPagoCursos.setIdTipoPago(tipoPago);

	        ordenPagoCursosService.guardaOrdenPagoCursos(ordenPagoCursos);
	        
			vista.addObject("ordenPagoCursos", ordenPagoCursosService.cargaOrdenPagoCursos());
			vista.setViewName("listaOrdenPagoCursos");
		}
		return vista;
        
    }
	
	@RequestMapping("/actualizar/{idOrdenPagoCursos}")
    public String showFormForUpdate(@PathVariable Integer idOrdenPagoCursos, ModelMap model) {
		
		OrdenPagoCursos ordenPagoCursos= ordenPagoCursosService.cargaOrdenPagoCursos(idOrdenPagoCursos);
		if (ordenPagoCursos != null) {
			OrdenPagoCursosForm ordenPagoCursosForm = new OrdenPagoCursosForm();
			ordenPagoCursosForm.setIdOrdenPagoCursos(idOrdenPagoCursos);
			ordenPagoCursosForm.setFolioPago(ordenPagoCursos.getFolioPago());
			ordenPagoCursosForm.setDescripcion(ordenPagoCursos.getDescripcion());
			ordenPagoCursosForm.setFechaPago(ordenPagoCursos.getFechaPago());
			ordenPagoCursosForm.setIdTipoPago(ordenPagoCursos.getIdTipoPago().getNombre());
			
			
			
			
			model.put("ordenPagoCursos", ordenPagoCursosForm);
		} else {
			model.put("ordenPagoCursos", new OrdenPagoCursosForm());
		}
        return "ordenPagoCursosFormActualiza";
    }
	
	@RequestMapping("eliminar")
	public String eliminaOrdenPagoCursos(@RequestParam("idOrdenPagoCursos") Integer idOrdenPagoCursos) {
		ordenPagoCursosService.eliminaOrdenPagoCursos(idOrdenPagoCursos);
		return "redirect:/pagoCursos/listar";
	}
	
}
