package com.pis.redSocial;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.DAOPersona;
import modelo.DAOPeticion;
import modelo.Persona;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AmigosController {
private static final Logger logger = LoggerFactory.getLogger(AmigosController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "amigos", method = RequestMethod.GET)
	public String amigos(Locale locale, Model model) {
		logger.info("Register page! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "amigos";
	}
	
	@RequestMapping(value = "rechazarPeticion", method = RequestMethod.POST)
	public ModelAndView rechazarPeticion(HttpServletRequest request, HttpServletResponse response) {
		
		/*logger.info("Register page! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );*/
		
		String id1 = request.getParameter("id1");
		String id2 = request.getParameter("id2");
		DAOPeticion daoPeticion = new DAOPeticion();
		daoPeticion.rechazarPeticion(id1, id2);
		
		
		return new ModelAndView("amigos", "aviso", "Peticion rechazada correctamente.");
	}
	
	@RequestMapping(value = "aceptarPeticion", method = RequestMethod.POST)
	public ModelAndView aceptarPeticion(HttpServletRequest request, HttpServletResponse response) {
		
		/*logger.info("Register page! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );*/
		
		String id1 = request.getParameter("id1");
		String id2 = request.getParameter("id2");
		DAOPeticion daoPeticion = new DAOPeticion();
		daoPeticion.aceptarPeticion(id1, id2);
		
		
		return new ModelAndView("amigos", "aviso", "Peticion aceptada correctamente.");
	}
}