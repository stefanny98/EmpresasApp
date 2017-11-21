package com.tecsup.gestion.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tecsup.gestion.model.Empresa;
import com.tecsup.gestion.model.Paradero;
import com.tecsup.gestion.services.EmpresaService;
import com.tecsup.gestion.utils.ParaderosFiltro;

@Controller
public class HomeController {

private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private EmpresaService empresaService;

	@GetMapping("/main/emp")
	public String list(@ModelAttribute("SpringWeb") Empresa empresa, ModelMap model) {

		try {
			model.addAttribute("empresas", empresaService.findAll());
		} catch (Exception e) {
			logger.info(e.getMessage());
			model.addAttribute("message", e.getMessage());
		}

		return "main/emp";
	}
	
	
	@GetMapping("/main/home")
	public String home(@ModelAttribute("SpringWeb") Empresa empresa, ModelMap model) {

		return "main/home";
	}
	
	@GetMapping("/main/emp/{empresa_id}")
	public ModelAndView form(@PathVariable int empresa_id, ModelMap model) {

		ModelAndView modelAndView = null;

		try {
			Empresa emp = empresaService.findEmpresa(empresa_id);
			model.addAttribute("empresa", emp);
			model.addAttribute("paraderos", empresaService.findParaderosByEmpresa(emp.getNombre()));
			List<Paradero> paraderos = empresaService.findParaderosByEmpresa(emp.getNombre());
			
			ParaderosFiltro.filtrar(paraderos);
	
			model.addAttribute("listas", ParaderosFiltro.getNombres());
			model.addAttribute("latitudes", ParaderosFiltro.getLatitudes());
			model.addAttribute("longitudes", ParaderosFiltro.getLongitudes());
		
			modelAndView = new ModelAndView("main/detalle", "command", emp);
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
		
		}

		return modelAndView;
	}
	

	@GetMapping("/main/rutas")
	public ModelAndView rutas(@ModelAttribute("SpringWeb") Empresa empresa, ModelMap model) {
		ModelAndView modelAndView = null; 
		String nombre = empresa.getNombre();
		nombre = "El Rapido S.A.";
		try {
			modelAndView = new ModelAndView("main/rutas", "command", empresa);
			model.addAttribute("nombres", empresaService.findAllNames());
			model.addAttribute("paraderos", empresaService.findParaderosByEmpresa(nombre));
			
			List<Paradero> paraderos = empresaService.findParaderosByEmpresa(nombre);
			
			ParaderosFiltro.filtrar(paraderos);
	
			model.addAttribute("listas", ParaderosFiltro.getNombres());
			model.addAttribute("latitudes", ParaderosFiltro.getLatitudes());
			model.addAttribute("longitudes", ParaderosFiltro.getLongitudes());
			
		} catch (Exception e) {
			logger.info(e.getMessage());
			model.addAttribute("message", e.getMessage());
		}

		return modelAndView;
	}
	
	@PostMapping("/main/rutas")
	public ModelAndView mapa(@ModelAttribute("SpringWeb") Empresa emp, ModelMap model) {

		ModelAndView modelAndView = null;
		
		try {
			
			modelAndView = new ModelAndView("main/rutas", "command", emp);
			
			model.addAttribute("nombres", empresaService.findAllNames());
			model.addAttribute("paraderos", empresaService.findParaderosByEmpresa(emp.getNombre()));
			
			List<Paradero> paraderos = empresaService.findParaderosByEmpresa(emp.getNombre());
			
			ParaderosFiltro.filtrar(paraderos);
	
			model.addAttribute("listas", ParaderosFiltro.getNombres());
			model.addAttribute("latitudes", ParaderosFiltro.getLatitudes());
			model.addAttribute("longitudes", ParaderosFiltro.getLongitudes());
			
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
		}

		return modelAndView;
	}
	
	
	@GetMapping("/main/prd")
	public ModelAndView paraderos(@ModelAttribute("SpringWeb") Empresa empresa, ModelMap model) {
			
			ModelAndView modelAndView = null;
			
			String nombre = empresa.getNombre();
			nombre = "El Rapido S.A.";
		
		try {
			modelAndView = new ModelAndView("main/prd", "command", empresa);
			model.addAttribute("nombres", empresaService.findAllNames());
			model.addAttribute("paraderos", empresaService.findParaderosByEmpresa(nombre));
		} catch (Exception e) {
			logger.info(e.getMessage());
			model.addAttribute("message", e.getMessage());
		}

		return modelAndView;
	}
	@PostMapping("/main/prd")
	public ModelAndView filtroParaderos(@ModelAttribute("SpringWeb") Empresa emp, ModelMap model) {

		ModelAndView modelAndView = null;
		
		try {
			
			modelAndView = new ModelAndView("main/prd", "command", emp);
			model.addAttribute("nombres", empresaService.findAllNames());
			model.addAttribute("paraderos", empresaService.findParaderosByEmpresa(emp.getNombre()));
			
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
		}

		return modelAndView;
	}
}
