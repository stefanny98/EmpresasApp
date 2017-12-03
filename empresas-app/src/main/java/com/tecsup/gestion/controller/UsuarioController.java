package com.tecsup.gestion.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tecsup.gestion.model.Usuario;
import com.tecsup.gestion.services.ApiService;
import com.tecsup.gestion.services.ApiServiceGenerator;
import com.tecsup.gestion.services.UsuarioService;

import retrofit2.Call;
import retrofit2.Response;

@Controller
public class UsuarioController {
	
	
	public String vista = "login";

	private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);
	
	@Autowired
	UsuarioService userService;

	@GetMapping("/register")
	public String preRegister() {
		
		 logger.info("Devolviendo vista Registro");
			
		return "register";
	}

	@PostMapping("/register")
	public String register(final Model model,final HttpSession httpSession,
				  @RequestParam(value = "username") String username,
				  @RequestParam(value = "password") String password,
				  @RequestParam(value = "fullname") String fullname,
				  @RequestParam(value = "email") String email) throws InterruptedException, IOException 
	{								
	
   
    logger.info("Entrando al flujo de APi");
	//Iniciando el API
	 ApiService service = ApiServiceGenerator.createService(ApiService.class);
     Call<Usuario> call = service.createUsuario(username, password,fullname,email);
     logger.info("Culminó la creación del APi");			
	//Mensajes de error o bienvenida     
     Response<Usuario> response = call.execute();
     try 
     {
         int statusCode = response.code();
         logger.info("HTTP status code: " + statusCode);    
         
         if (response.isSuccessful()) 
         {
             Usuario responseMessage = response.body();
             logger.info("responseMessage: " + responseMessage);
             logger.info("registro correcto");
             httpSession.setAttribute("usuario",responseMessage.getUsername());
             vista= "redirect:/login";
            
           
           
            
         } else 
         {
        	//progressDialog.dismiss();
        	 logger.info("Registro incorrecto");
        	 logger.info("onError: " + response.errorBody().string());
        	 model.addAttribute("message", "Registro incorrecto");
             vista="register";
         }
     }catch (Throwable t) 
     {
         		try 
         		{
         			logger.info("Error tipo T");
         			logger.info("onThrowable: " + t.toString());
         			logger.info("onThrowable: " + t.toString(), t);
        	
         			model.addAttribute("message", t.getMessage());
         			 vista= "register";   	        	           	             
         		} catch (Throwable x) 
         		{}
     }
    
     
     
	logger.info("Retorna la vista");
 	logger.info(vista);
 	return vista;
	}
	@GetMapping("/main/perfil")
	public String prePerfil() {
		
		 logger.info("Perfil");
			
		return "main/perfil";
	}
	@GetMapping("/main/perfil/{id}")
	public ModelAndView perfil(@PathVariable long id, ModelMap model) {

		
		ModelAndView modelAndView = null;

		try {
			Usuario user = userService.find(id);
			logger.info(user.toString());
			modelAndView = new ModelAndView("main/perfil", "usuario", user);
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			modelAndView = new ModelAndView("main/perfil", "usuario", new Usuario());
		}

		return modelAndView;
	}
	@PostMapping("/main/perfil")
	public ModelAndView editsave(@ModelAttribute("usuario") Usuario usuario, BindingResult result,
			ModelMap model) {

		ModelAndView modelAndView = null;

		if (result.hasErrors()) {
			modelAndView = new ModelAndView("main/perfil", "usuario", usuario);
		} else {
			try {
			
				userService.update(usuario.getUsername(),usuario.getFullname(),usuario.getEmail(),usuario.getId());
				modelAndView = new ModelAndView("redirect:/main/home");

			} catch (Exception e) {
				model.addAttribute("message", e.getMessage());
				logger.info("error"+e.getMessage());
				modelAndView = new ModelAndView("/main/perfil/", "usuario", usuario);
			}

		}

		return modelAndView;
	}


}