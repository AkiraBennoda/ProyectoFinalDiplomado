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

import sgi.forms.FacturaForm;
import sgi.modelo.entidades.Factura;
import sgi.service.FacturaService;


@Controller
@RequestMapping("/facturas")
public class FacturaController {
	@Autowired
	private FacturaService facturaService;
	
	

	
	
	@ResponseBody
	@RequestMapping(value = {"/jsonFactura"})	
    public List<Factura> facturaJson() {
		return facturaService.cargaFacturas();
    }
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String cargaFactura(Model model) {
		model.addAttribute("facturas", facturaService.cargaFacturas());
		return "listaFacturas";
	}
	
	@RequestMapping("/facturaForm")
    public String contactoForm(Model model) {
        model.addAttribute("factura", new FacturaForm());
        return "facturaForm";
    }
	
	@RequestMapping(value = "/guardaFactura", method = RequestMethod.POST)
    public ModelAndView guardaFactura(@ModelAttribute("factura") @Valid FacturaForm facturaForm, BindingResult result) {
		ModelAndView vista = new ModelAndView();
		if (result.hasErrors()) {
			
			vista.addObject(facturaForm);
			vista.setViewName("facturaForm");
		} else {
			Factura factura = facturaForm.getIdFactura() != null ? facturaService.cargaFactura(facturaForm.getIdFactura()) : new Factura();			
			factura.setFolioFactura(facturaForm.getFolioFactura());
			factura.setFechaFactura(facturaForm.getFechaFactura());
			factura.setRazonSocial(facturaForm.getRazonSocial());
		
	        
	        
	        facturaService.guardaFactura(factura);
	        
			vista.addObject("facturas", facturaService.cargaFacturas());
			vista.setViewName("listaFacturas");
		}
		return vista;
        
    }
	
	@RequestMapping("/actualizar/{idFactura}")
    public String showFormForUpdate(@PathVariable Integer idFactura, ModelMap model) {
		
		Factura factura= facturaService.cargaFactura(idFactura);
		if (factura != null) {
			FacturaForm facturaForm = new FacturaForm();
			facturaForm.setIdFactura(idFactura);
			facturaForm.setFolioFactura(factura.getFolioFactura());
			facturaForm.setFechaFactura(factura.getFechaFactura());
			facturaForm.setRazonSocial(factura.getRazonSocial());
			
			
			model.put("factura", facturaForm);
		} else {
			model.put("factura", new FacturaForm());
		}
        return "facturaFormActualiza";
    }
	
	@RequestMapping("eliminar")
	public String eliminaFactura(@RequestParam("idFactura") Integer idFactura) {
		facturaService.eliminaFactura(idFactura);
		return "redirect:/facturas/listar";
	}
	
	
	
}
