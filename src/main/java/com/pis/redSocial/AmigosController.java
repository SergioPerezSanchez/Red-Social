package com.pis.redSocial;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.DAOPersona;
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
	public String amigos(HttpServletRequest request, Locale locale, Model model) {
		logger.info("Register page! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		HttpSession session = request.getSession();
		Persona a = (Persona) session.getAttribute("persona");
		ArrayList<String> listAmigos = new ArrayList<String>();
		ArrayList<String> listPeticiones = new ArrayList<String>();

		try {
			listAmigos.addAll(a.getAmigos());
		} catch (Exception e) {
			System.out.print("Error al cargar amigos");
		}
		try {
			listPeticiones.addAll(a.getPeticiones());
			
		} catch (Exception e) {
			System.out.print("Error al cargar peticiones");
		}
		model.addAttribute("listAmigos", listAmigos);
		model.addAttribute("listPeticiones", listPeticiones);

		return "amigos";
	}

	@RequestMapping(value = "aceptarPeticion", method = RequestMethod.POST)
	public ModelAndView aceptar(HttpServletRequest request, HttpServletResponse response, Model model)
			throws Exception {
		// NOS TRAEMOS LA LISTA DE USUARIOS EXISTENTES
		ModelAndView miMAV = new ModelAndView("amigos");
		ArrayList<String> peticiones = new ArrayList<String>();
		ArrayList<String> amigos = new ArrayList<String>();
		DAOPersona dao = new DAOPersona();
		HttpSession session = request.getSession();
		Persona user = (Persona) session.getAttribute("persona");
		peticiones = user.getPeticiones();
		amigos = user.getAmigos();
		model.addAttribute("listPeticiones", peticiones);

		amigos.add(user.getUsername());
		peticiones.remove(0);
		user.setAmigos(amigos);
		user.setPeticiones(peticiones);
		dao.update(user);
		miMAV.addObject("mensaje", "Ha aceptado al usuario");
		return miMAV;

	}

	@RequestMapping(value = "eliminarPeticion", method = RequestMethod.POST)
	public ModelAndView eliminar(HttpServletRequest request, HttpServletResponse response, Model model)
			throws Exception {
		ModelAndView miMAV = new ModelAndView("amigos");
		ArrayList<String> peticiones = new ArrayList<String>();
		DAOPersona dao = new DAOPersona();
		HttpSession session = request.getSession();
		Persona user = (Persona) session.getAttribute("persona");
		peticiones = user.getPeticiones();
		model.addAttribute("listPeticiones", peticiones);

		peticiones.remove(0);
		user.setPeticiones(peticiones);
		dao.update(user);
		miMAV.addObject("mensaje", "No ha aceptado al usuario");
		return miMAV;
	}
}