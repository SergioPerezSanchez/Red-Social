package com.pis.redSocial;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import modelo.DAOPersona;
import modelo.Email;
import modelo.Persona;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ForgotUsernamePasswordController {
	
	private static final Logger logger = LoggerFactory.getLogger(ForgotUsernamePasswordController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "forgotPassword", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "forgotPassword";
	}
	
	
	@RequestMapping(value = "recuperaUsernameClave", method = RequestMethod.POST)
	public ModelAndView recuperaCredenciales(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		String email;
		email=request.getParameter("inputEmail");
		DAOPersona dao = new DAOPersona();
		if(dao.existeEmail(email)){
			Persona p = dao.getPersonaByEmail(email);
			Email em = new Email(email, p.getUsername(), p.getPassword());
			if(em.enviarEmail()) {
				return new ModelAndView("home", "aviso", "Le hemos enviado un correo con las credenciales (usuario y password) de Intravita.");
			}else {
				return new ModelAndView("forgotPassword", "aviso", "Hay un fallo en la red. Por favor, vuelva a intentarlo.");
			}
		}else {
			return new ModelAndView("forgotPassword", "aviso", "El email introducido, no esta asociado a ninguna cuenta.");
		}		
	}
	
	
	
}
