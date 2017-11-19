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
public class MenuController {
	private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
	@RequestMapping("modificarUsuario")
	public ModelAndView modificar(HttpServletRequest request, HttpServletResponse response)throws Exception{
		//logger.info("Register page! The client locale is {}.", locale);
		boolean flag=false;
		String nombre, apellidos, username, email, password, direccion, telefono, foto;
		ArrayList<String>amigos=new ArrayList<String>();
		ArrayList<String>peticiones=new ArrayList<String>();
		nombre = request.getParameter("inputNombre");
		apellidos = request.getParameter("inputApellidos");
		password = request.getParameter("inputPassword");
		direccion = request.getParameter("inputDireccion");
		telefono = request.getParameter("inputTelefono");
		username= request.getParameter("aUser");
		email=request.getParameter("aEmail");
		DAOPersona dao = new DAOPersona();
		Persona p= new Persona(nombre,apellidos, username,email, password, direccion, telefono, "", dao.getPersona(username).isEsAdmin(), amigos, peticiones);
		dao.update(p);
		return new ModelAndView("menu");
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@RequestMapping(value = "menu", method = RequestMethod.GET)
	public String menu(HttpServletRequest request, Locale locale, Model model) {
		logger.info("Register page! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		DAOPublicacion daoPublicacion = new DAOPublicacion();
		HttpSession session=request.getSession();
		Persona a=(Persona) session.getAttribute("persona");
		List<Publicacion> publicaciones = daoPublicacion.leerPublicaciones(a.getUsername());
		model.addAttribute("listPublicacionesPersona", publicaciones );
		
		return "menu";
	}

	
	@RequestMapping(value = "publicarMensaje", method = RequestMethod.POST)
	public ModelAndView publicar(HttpServletRequest request, HttpServletResponse response,Model model)throws Exception{
		String username, texto,privacidad;
		LinkedList<String> adjuntos= new LinkedList<String>();
		texto = request.getParameter("message");
		HttpSession session=request.getSession();
		Persona user=(Persona) session.getAttribute("persona");
		//username = request.getParameter("obtenerUsuario");
		username= user.getUsername();
		privacidad="publico";
		
		DAOPublicacion dao = new DAOPublicacion();
		Publicacion p,a;
		p = new Publicacion(username,texto,privacidad,adjuntos);
		if(dao.crearPublicacion(p)) {
			DAOPublicacion daoPublicacion = new DAOPublicacion();
			List<Publicacion> publicaciones = daoPublicacion.leerPublicaciones(username);
			model.addAttribute("listPublicacionesPersona", publicaciones );
			return new ModelAndView("menu", "publicacion", p);
		}else {
			return new ModelAndView("menu", "aviso", "Ha habido algún problema");
		}
		
	}
	

}
