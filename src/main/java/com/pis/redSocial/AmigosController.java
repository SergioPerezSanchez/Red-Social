package com.pis.redSocial;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import modelo.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AmigosController {
private static final Logger logger = LoggerFactory.getLogger(AmigosController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "amigos", method = RequestMethod.GET)
	public String amigos(HttpServletRequest request,Locale locale, Model model) {
		logger.info("Register page! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		HttpSession session=request.getSession();
		Persona a=(Persona) session.getAttribute("persona");
		List<Persona> listAmigos =new ArrayList<Persona>();
		List<Persona> listPeticiones =new ArrayList<Persona>();
		
		listAmigos.addAll(a.getAmigos());
		listPeticiones.addAll(a.getPeticiones());
		model.addAttribute("listAmigos", listAmigos );
		model.addAttribute("listPeticiones", listPeticiones );
		
		return "amigos";
	}
}