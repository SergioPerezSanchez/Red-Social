package com.pis.redSocial;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.DAOPersona;
import modelo.DAOPublicacion;
import modelo.Persona;
import modelo.Publicacion;

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
	
	@RequestMapping(value = "/home.jsp", method = RequestMethod.GET)
		public String home(Locale locale, Model model) {
			logger.info("Welcome home! The client locale is {}.", locale);
			
			Date date = new Date();
			DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
			String formattedDate = dateFormat.format(date);
			
			model.addAttribute("serverTime", formattedDate );
			return "home";
	}
	
	@RequestMapping(value = "init", method = RequestMethod.GET)
	public ModelAndView init(HttpServletRequest request, HttpServletResponse response, Model model)throws Exception{
		HttpSession misession= request.getSession();
		Persona p= (Persona)misession.getAttribute("persona");
		if(p!=null) {
			System.out.println(p.getUsername());
			return new ModelAndView("menu");
		}
		return new ModelAndView("home");
		
	}
	
	@RequestMapping(value = "exit", method = RequestMethod.GET)
	public ModelAndView exit(HttpServletRequest request, HttpServletResponse response, Model model)throws Exception{
		HttpSession session = request.getSession(false); 
		if(session!=null) { 
			session.invalidate(); 
		} 
		return new ModelAndView("home");
	}
	
	@RequestMapping(value = "loginUsuario", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response, Model model)throws Exception{
		String username, password;
		username = request.getParameter("inputEmail");
		password = request.getParameter("inputPassword");
		DAOPersona dao = new DAOPersona();
		Persona p,a;
	    Date date1;
	    Date date2 = new Date();
		p = new Persona(username, password);
		if(dao.login(p)) {
			a = dao.getPersona(username);
			HttpSession misession= request.getSession(true);
			misession.setAttribute("persona",a);
			DAOPublicacion daoPublicacion = new DAOPublicacion();
			List<Publicacion> publicaciones = daoPublicacion.leerPublicaciones(username);
			model.addAttribute("listPublicacionesPersona", publicaciones );
			request.getSession().setAttribute("usernombre", a.getNombre());
			a.setFecha_ultimo_login(new Date());
			dao.update(a);
			
			try {
				date1 = a.getFecha();
			    long diff = date2.getTime() - date1.getTime();
			    int dias = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
			    System.out.println ("Days: " + dias);
			    if (dias > 1) 
					return new ModelAndView("passtresmeses", "persona", a);
			} catch (Exception e) {
			    System.out.println("Cuenta antigua");
			}
			if(a.isEsAdmin()) {
				return new ModelAndView("menu", "persona", a);
			}else {
				return new ModelAndView("menu", "persona", a);
			}
		}else {
			return new ModelAndView("home", "aviso", "El usuario y/o clave son incorrectos.");
		}

	}
	
}

