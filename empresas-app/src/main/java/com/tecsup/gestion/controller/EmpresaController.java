package com.tecsup.gestion.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tecsup.gestion.model.Empresa;
import com.tecsup.gestion.services.EmpresaService;

@Controller
public class EmpresaController {

private static final Logger logger = LoggerFactory.getLogger(EmpresaController.class);
	
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

	@GetMapping("/main/rutas")
	public String rutas(@ModelAttribute("SpringWeb") Empresa empresa, ModelMap model) {

		try {
			model.addAttribute("empresas", empresaService.findAllNames());
		} catch (Exception e) {
			logger.info(e.getMessage());
			model.addAttribute("message", e.getMessage());
		}

		return "main/rutas";
	}
	
	
	@GetMapping("/main/prd")
	public String paraderos(@ModelAttribute("SpringWeb") Empresa empresa, ModelMap model) {

		try {
			model.addAttribute("paraderos", empresaService.findAllParaderos());
		} catch (Exception e) {
			logger.info(e.getMessage());
			model.addAttribute("message", e.getMessage());
		}

		return "main/prd";
	}
}
