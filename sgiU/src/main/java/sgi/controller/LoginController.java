package sgi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sgi.modelo.entidades.Genero;
import sgi.modelo.entidades.Idioma;
import sgi.modelo.entidades.Modalidad;
import sgi.modelo.entidades.Nacionalidad;
import sgi.modelo.entidades.Nivel;
import sgi.modelo.entidades.TipoCurso;
import sgi.modelo.entidades.TipoPago;

import sgi.service.GeneroService;
import sgi.service.IdiomaService;
import sgi.service.ModalidadService;
import sgi.service.NacionalidadService;
import sgi.service.NivelService;
import sgi.service.TipoCursoService;
import sgi.service.TipoPagoService;


import sgi.service.UserDetailsServiceImpl;

@Controller
public class LoginController {

	@Autowired
	UserDetailsServiceImpl userDetailsImp;
	
	
	/*Implmentacion*/
	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private GeneroService generoService;
	
	@Autowired
	private NacionalidadService nacionalidadService;
	
	@Autowired
	private TipoPagoService tipoPagoService;
	
	
	@Autowired
	private IdiomaService idiomaService;
	
	@Autowired
	private TipoCursoService tipoCursoService;
	
	@Autowired
	private ModalidadService modalidadService;
	
	@Autowired
	private NivelService nivelService;
	
	
	
	
	@GetMapping("/login")
	public String login( @RequestParam(value = "usuario") String user, @RequestParam(value = "password") String pass)
	{
		try {
			userDetailsImp.loadUserByUsername(user);
			
			//List Genero
			List<Genero> lista = generoService.getListaGenero();
			List<String> listaGenero = new ArrayList<String>();
			for (Genero genero : lista) {
				listaGenero.add(genero.getNombre());
			}
			
			
			//Lista nacionalidad
			List<Nacionalidad> listaN = nacionalidadService.getListaNacionalidad();
			List<String> listaNacionalidad = new ArrayList<String>();
			for (Nacionalidad nacionalidad : listaN) {
				listaNacionalidad.add(nacionalidad.getNombre());
			}
			
			
			
			//Lista tipo pago
			List<TipoPago> listaTP = tipoPagoService.getListaTipoPago();
			List<String> listaTipoPago = new ArrayList<String>();
			for (TipoPago tipoPago : listaTP) {
				listaTipoPago.add(tipoPago.getNombre());
			}
			
			
			
			//Lista idioma
			List<Idioma> listaI = idiomaService.getListaIdioma();
			List<String> listaIdioma = new ArrayList<String>();
			for (Idioma idioma : listaI) {
				listaIdioma.add(idioma.getNombre());
			}
			
			
			//Lista TipoCurso
			List<TipoCurso> listaTC = tipoCursoService.getListaTipoCurso();
			List<String> listaTipoCurso = new ArrayList<String>();
			for (TipoCurso tipoCurso : listaTC) {
				listaTipoCurso.add(tipoCurso.getNombre());
			}
			
			//Lista Modalidad
			List<Modalidad> listaM = modalidadService.getListaModalidad();
			List<String> listaModalidad = new ArrayList<String>();
			for (Modalidad modalidad : listaM) {
				listaModalidad.add(modalidad.getNombre());
			}
			
			//Lista Nivel
			List<Nivel> listaNv = nivelService.getListaNivel();
			List<String> listaNivel = new ArrayList<String>();
			for (Nivel nivel : listaNv) {
				listaNivel.add(nivel.getNombre());
			}
			
			
			servletContext.setAttribute("generoList", listaGenero);
			servletContext.setAttribute("nacionalidadList", listaNacionalidad);
			servletContext.setAttribute("tipoPagoList", listaTipoPago);
			servletContext.setAttribute("idiomaList", listaIdioma);
			servletContext.setAttribute("tipoCursoList", listaTipoCurso);
			servletContext.setAttribute("modalidadList", listaModalidad);
			servletContext.setAttribute("nivelList", listaNivel);
			
			
			
			
			return "home";
		} catch (Exception e) {
			return "login";
		}
		
		
		
	}
	
	
	
	/*****Implementacion***************/
	
}
