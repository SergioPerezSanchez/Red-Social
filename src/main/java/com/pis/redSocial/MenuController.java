package com.pis.redSocial;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
	@RequestMapping("modificarUsuario")
	public ModelAndView modificar(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		//logger.info("Register page! The client locale is {}.", locale);
		boolean flag=false;
		String nombre, apellidos, username, email, password, repitePassword, direccion, telefono, foto;
		nombre = request.getParameter("inputNombre");
		apellidos = request.getParameter("inputApellidos");
		password = request.getParameter("inputPassword");
		direccion = request.getParameter("inputDireccion");
		telefono = request.getParameter("inputTelefono");
		username= request.getParameter("aUser");
		email=request.getParameter("aEmail");
		DAOPersona dao = new DAOPersona();
		Persona p= new Persona(nombre,apellidos, username,email, password, direccion, telefono, "", false, dao.getPersona(username).isEsAdmin());
		dao.update(p);
		return new ModelAndView("menu");
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@RequestMapping(value = "menu", method = RequestMethod.GET)
	public String menu(Locale locale, Model model) {
		logger.info("Register page! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		DAOPublicacion daoPublicacion = new DAOPublicacion();
		List<Publicacion> publicaciones = daoPublicacion.leerPublicaciones("pruebaprueba");
		model.addAttribute("listPublicacionesPersona", publicaciones );
		
		return "menu";
	}

	
	@RequestMapping(value = "publicarMensaje", method = RequestMethod.POST)
	public ModelAndView publicar(HttpServletRequest request, HttpServletResponse response,Model model)throws Exception{
		String username, texto,privacidad;
		LinkedList<String> adjuntos= new LinkedList<String>();
		texto = request.getParameter("message");
		//username = request.getParameter("obtenerUsuario");
		username= "pruebaprueba";
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
