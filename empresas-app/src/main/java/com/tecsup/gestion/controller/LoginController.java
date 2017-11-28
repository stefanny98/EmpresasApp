package com.tecsup.gestion.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tecsup.gestion.model.Usuario;
import com.tecsup.gestion.services.ApiService;
import com.tecsup.gestion.services.ApiServiceGenerator;

import retrofit2.Call;
import retrofit2.Response;

@Controller
public class LoginController {
	
	
	public String vista = "login";


	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@GetMapping("/")
	public String main() {
		
		 logger.info("Devolviendo vista Login");
			
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String preLogin() {
		
		 logger.info("Devolviendo vista Login");
			
		return "login";
	}


	@PostMapping("/login")
	public String login(final Model model,final HttpSession httpSession,
				  @RequestParam(value = "username") String username,
				  @RequestParam(value = "password") String password) throws InterruptedException, IOException 
	{								
	
   
    logger.info("Entrando al flujo de APi");
	//Iniciando el API
	 ApiService service = ApiServiceGenerator.createService(ApiService.class);
     Call<Usuario> call = service.loginUser(username, password);
     logger.info("Culminó la creación del APi");			
	//Mensajes de error o bienvenida    
     
   
     
     Response<Usuario> response = call.execute();
     
     logger.info(String.valueOf(response.code()));
     try 
     {
         int statusCode = response.code();
         logger.info("HTTP status code: " + statusCode);    
         
         if (response.isSuccessful()) 
         {
             Usuario responseMessage = response.body();
             logger.info("responseMessage: " + responseMessage);
             logger.info("Login correcto");
             httpSession.setAttribute("id",responseMessage.getId());
             vista= "redirect:/main/home";
            
           
           
            
         } else 
         {
        	//progressDialog.dismiss();
        	 logger.info("Login incorrecto");
        	 logger.info("onError: " + response.errorBody().string());
        	 model.addAttribute("message", "Usuario y clave incorrectos");
             vista="login";
         }
     }catch (Throwable t) 
     {
         		try 
         		{
         			logger.info("Error tipo T");
         			logger.info("onThrowable: " + t.toString());
         			logger.info("onThrowable: " + t.toString(), t);
        	
         			model.addAttribute("message", t.getMessage());
         			 vista= "login";   	        	           	             
         		} catch (Throwable x) 
         		{}
     }
     
     
	logger.info("Retorna la vista");
 	logger.info(vista);
 	return vista;
	}
}
