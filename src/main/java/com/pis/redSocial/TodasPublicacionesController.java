package com.pis.redSocial;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
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

@Controller
public class TodasPublicacionesController {
private static final Logger logger = LoggerFactory.getLogger(TodasPublicacionesController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@RequestMapping(value = "todasPublicacionesAdmin", method = RequestMethod.GET)
	public String todasPublicacionesAdmin(Locale locale, Model model) {
		logger.info("Register page! The client locale is {}.", locale);
	
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
	
		String formattedDate = dateFormat.format(date);
	
		model.addAttribute("serverTime", formattedDate );
	
		DAOPublicacion daoPublicacion = new DAOPublicacion();
		LinkedList<Publicacion> publicaciones = daoPublicacion.leerTodasPublicaciones();
				model.addAllAttributes(publicaciones);
	
		return "todasPublicacionesAdmin";
	}

	@RequestMapping(value = "todasPublicaciones", method = RequestMethod.GET)
	public String todasPublicaciones(Locale locale, Model model) {
		logger.info("Register page! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		DAOPublicacion daoPublicacion = new DAOPublicacion();
		List<Publicacion> publicaciones = daoPublicacion.leerTodasPublicaciones();
		model.addAttribute("listPublicaciones", publicaciones );
		
		return "todasPublicaciones";
	}
	@RequestMapping(value = "eliminarPublicacion", method = RequestMethod.POST)
	public ModelAndView eliminar(HttpServletRequest request, HttpServletResponse response, Model model)throws Exception{
		// NOS TRAEMOS LA LISTA DE USUARIOS EXISTENTES
		ModelAndView miMAV = new ModelAndView("todasPublicaciones");
		List<Persona> usuarios =new ArrayList<Persona>();
		DAOPersona dao = new DAOPersona();
		usuarios=dao.getAllPersonas();
		model.addAttribute("listUsuarios", usuarios );
		DAOPublicacion daoPublicacion = new DAOPublicacion();
		
		// TRAIGO LA INFORMACION QUE NECESITO
		String username;
		username = request.getParameter("eliminarNombre");
		String mensaje;
		mensaje = request.getParameter("eliminarMensaje");
		String fecha;
		fecha = request.getParameter("eliminarFecha");
		
		// CREAMOS LA PUBLICACION QUE QUEREMOS BORRAR
		daoPublicacion.borrarPublicacionExacta(username, fecha);
		LinkedList<Publicacion> publicaciones = daoPublicacion.leerTodasPublicaciones();
		model.addAttribute("listPublicaciones",publicaciones);

		return miMAV;
	}
		
	}
