package com.pis.redSocial;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.DAOPersona;
import modelo.Persona;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home.jsp", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping(value = "loginUsuario", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response)throws Exception{
		String username, password;
		username = request.getParameter("inputEmail");
		password = request.getParameter("inputPassword");
		DAOPersona dao = new DAOPersona();
		Persona p,a;
		p = new Persona(username, password);
		
		if(dao.login(p)) {
			a = dao.getPersona(username);
			return new ModelAndView("menu", "persona", a);
		}else {
			return new ModelAndView("home", "aviso", "El usuario y/o clave son incorrectos.");
		}
		
		/*if(dao.existeUsername(username)){
			p=dao.getPersona(username);
			if(password.equals(p.getPassword())){
				if(dao.login(p)){
					cadena="menu";
					a = dao.getPersona(p.getUsername());
					return new ModelAndView(cadena, "persona", a);
				}else{
					cadena="home";
				}
			}else{
				cadena="home";
			}
		}else{
			cadena="home";
		}*/
		//return new ModelAndView(cadena);
	}
	
}

