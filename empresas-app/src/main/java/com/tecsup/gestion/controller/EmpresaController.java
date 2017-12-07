package com.tecsup.gestion.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.model.Empresa;
import com.tecsup.gestion.services.EmpresaService;

@Controller
public class EmpresaController {
	private static final Logger logger = LoggerFactory.getLogger(EmpresaController.class);
	
	@Autowired
	private ApplicationContext context;
	@Autowired
	EmpresaService empresaService;

	@GetMapping("/admin/emp/list")
	public String list(@ModelAttribute("empresas") Empresa empresa, ModelMap model) {

		try {
			model.addAttribute("empresas", empresaService.findAll());
		} catch (Exception e) {
			logger.info(e.getMessage());
			model.addAttribute("message", e.getMessage());
		}

		return "admin/emp/list";
	}

	@GetMapping("/{id_empresa}")
	public ModelAndView empresa(@PathVariable int id_empresa, ModelMap model) {

		ModelAndView modelAndView = null;
		Empresa emp = new Empresa();
		try {
			emp = empresaService.findEmpresa(id_empresa);
			logger.info(emp.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		modelAndView = new ModelAndView("home", "command", emp);

		return modelAndView;
	}

	@GetMapping("/admin/menu")
	public String menu() {

		return "/admin/menu";
	}


	@GetMapping("/admin/emp/{action}/{id_empresa}")
	public ModelAndView form(@PathVariable String action, @PathVariable int id_empresa, ModelMap model) {

		// action = {"editform","deleteform"}
		logger.info("action = " + action);
		ModelAndView modelAndView = null;

		try {
			Empresa emp = empresaService.findEmpresa(id_empresa);
			logger.info(emp.toString());
			modelAndView = new ModelAndView("admin/emp/" + action, "empresa", emp);
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			modelAndView = new ModelAndView("admin/emp/" + action, "empresa", new Empresa());
		}

		return modelAndView;
	}

	//////////////////////////////////////////////////////////////////////////////////////
	// UPDATE //
	//////////////////////////////////////////////////////////////////////////////////////

	@PostMapping("/admin/emp/editsave")
	public ModelAndView editsave(@ModelAttribute("empresa") @Validated Empresa emp, BindingResult result,
			ModelMap model) {

		// logger.info("emp = " + emp);

		ModelAndView modelAndView = null;

		if (result.hasErrors()) {
			modelAndView = new ModelAndView("admin/emp/editform", "empresa", emp);
		} else {
			try {
				
				empresaService.update(emp.getNombre(),emp.getDescripcion(),emp.getId());
				modelAndView = new ModelAndView("redirect:/admin/emp/list");

			} catch (Exception e) {
				// model.addAttribute("message", e.getMessage());
				// modelAndView = new ModelAndView("redirect:/admin/emp/list");
				model.addAttribute("message", e.getMessage());
				modelAndView = new ModelAndView("admin/emp/editform", "employee", emp);
			}

		}

		return modelAndView;
	}

	//////////////////////////////////////////////////////////////////////////////////////
	// DELETE //
	//////////////////////////////////////////////////////////////////////////////////////

	@PostMapping("/admin/emp/delete")
	public ModelAndView delete(@ModelAttribute("employee") @Validated Empresa emp, BindingResult result, ModelMap model) {

		ModelAndView modelAndView = null;

		if (result.hasErrors()) {
			modelAndView = new ModelAndView("admin/emp/deleteform/" + emp.getId(), "empresa", emp);
		} else {
			try {
				empresaService.delete(emp.getNombre());
				modelAndView = new ModelAndView("redirect:/admin/emp/list");
			} catch (Exception e) {
				// model.addAttribute("message", e.getMessage());
				// modelAndView = new ModelAndView("redirect:/admin/emp/list");
				model.addAttribute("message", e.getMessage());
				modelAndView = new ModelAndView("admin/emp/deleteform", "empresa", emp);
			}
		}

		return modelAndView;
	}

	//////////////////////////////////////////////////////////////////////////////////////
	// CREATION //
	//////////////////////////////////////////////////////////////////////////////////////

	@GetMapping("/admin/emp/createform")
	public ModelAndView createform() {

		Empresa emp = new Empresa();

		ModelAndView modelAndView = new ModelAndView("admin/emp/createform", "empresa", emp);

		return modelAndView;
	}

	@PostMapping("/admin/emp/create")
	public ModelAndView create(@ModelAttribute("empresa") @Validated Empresa emp, BindingResult result, ModelMap model) {

		ModelAndView modelAndView = null;

		if (result.hasErrors()) {

			logger.info("result.getAllErrors();= " + result.getAllErrors());

			for (ObjectError error : result.getAllErrors()) {
				String theMessage = context.getMessage(error.getCode(), error.getArguments(), Locale.US);
				logger.info(error.getCode() + " = " + theMessage);
			}

			modelAndView = new ModelAndView("admin/emp/createform", "empresa", emp);

		} else {
			try {
				empresaService.create(emp.getNombre(),emp.getDescripcion());
				logger.info("new Empresa NOmbre = " + emp.getNombre());
				modelAndView = new ModelAndView("redirect:/admin/emp/list");

			} catch (DAOException e) {
				logger.error(e.getMessage());
				model.addAttribute("message", e.getMessage());
				modelAndView = new ModelAndView("admin/emp/createform", "empresa", emp);
			}
		}
		//
		return modelAndView;
	}

}