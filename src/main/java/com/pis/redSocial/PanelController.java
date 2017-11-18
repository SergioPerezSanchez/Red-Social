package com.pis.redSocial;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class PanelController {
private static final Logger logger = LoggerFactory.getLogger(GenteController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "panel", method = RequestMethod.GET)
	public String panel(Locale locale, Model model) {
		logger.info("Register page! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		List<Persona> usuarios =new ArrayList<Persona>();
		DAOPersona dao = new DAOPersona();
		usuarios=dao.getAllPersonas();
		model.addAttribute("listUsuarios", usuarios );
		
		
		return "panel";
	}
	
	@RequestMapping(value = "promocionarUsuario", method = RequestMethod.POST)
	public ModelAndView promocionar(HttpServletRequest request, HttpServletResponse response, Model model)throws Exception{
		// NOS TRAEMOS LA LISTA DE USUARIOS EXISTENTES
		ModelAndView miMAV = new ModelAndView("panel");
		List<Persona> usuarios =new ArrayList<Persona>();
		DAOPersona dao = new DAOPersona();
		usuarios=dao.getAllPersonas();
		model.addAttribute("listUsuarios", usuarios );
		
		// TRAIGO LA INFORMACIÓN DE MI YO
		String yo;
		HttpSession session=request.getSession();
		Persona user=(Persona) session.getAttribute("persona");
		yo= user.getUsername();
		
		// TRAIGO LA PERSONA QUE QUIERO MODIFICAR
		String username;
		username = request.getParameter("promocionar");
		
		// SE UTILIZA EL DAO PARA TRAERTE LA INFORMACION
		Persona p = dao.getPersona(username);
		
		// SE COMPRUEBA QUE SEA ADMIN, SI NO ES, SE MODIFICA
		if(p.isEsAdmin() == true){
			miMAV.addObject("mensaje",
					"No se puede promocionar un Administrador");
			return miMAV;
		}else{
			p.setEsAdmin(true);
			dao.update(p);
			miMAV.addObject("mensaje",
					"El usuario ha sido promocionado a Administrador");
			return miMAV;
		}
	}
	
	@RequestMapping(value = "revocarUsuario", method = RequestMethod.POST)
	public ModelAndView revocar(HttpServletRequest request, HttpServletResponse response, Model model)throws Exception{
		// NOS TRAEMOS LA LISTA DE USUARIOS EXISTENTES
				ModelAndView miMAV = new ModelAndView("panel");
				List<Persona> usuarios =new ArrayList<Persona>();
				DAOPersona dao = new DAOPersona();
				usuarios=dao.getAllPersonas();
				model.addAttribute("listUsuarios", usuarios );
				
				// TRAIGO LA INFORMACIÓN DE MI YO
				String yo;
				HttpSession session=request.getSession();
				Persona user=(Persona) session.getAttribute("persona");
				yo= user.getUsername();
				
				// TRAIGO LA PERSONA QUE QUIERO MODIFICAR
				String username;
				username = request.getParameter("revocar");
				
				// SE UTILIZA EL DAO PARA TRAERTE LA INFORMACION
				Persona p = dao.getPersona(username);
				
				// SE COMPRUEBA QUE SEA ADMIN, SI NO ES, SE MODIFICA
				if(p.isEsAdmin() == false){
					miMAV.addObject("mensaje",
							"No se puede revocar los permisos a un Usuario");
					return miMAV;
				}else{
					if(p.getUsername().equals(yo)){
						miMAV.addObject("mensaje",
								"No te puedes revocar los permisos a ti mismo!");
						return miMAV;
					}else{
					p.setEsAdmin(false);
					dao.update(p);
					miMAV.addObject("mensaje",
							"Has revocado al usuario");
					return miMAV;
					}
				}

	}
	
	@RequestMapping(value = "eliminarUsuario", method = RequestMethod.POST)
	public ModelAndView eliminar(HttpServletRequest request, HttpServletResponse response, Model model)throws Exception{
		// NOS TRAEMOS LA LISTA DE USUARIOS EXISTENTES
		ModelAndView miMAV = new ModelAndView("panel");
		List<Persona> usuarios =new ArrayList<Persona>();
		DAOPersona dao = new DAOPersona();
		usuarios=dao.getAllPersonas();
		model.addAttribute("listUsuarios", usuarios );
		
		// TRAIGO LA INFORMACIÓN DE MI YO
		String yo;
		HttpSession session=request.getSession();
		Persona user=(Persona) session.getAttribute("persona");
		yo= user.getUsername();
		
		// TRAIGO LA PERSONA QUE QUIERO MODIFICAR
		String username;
		username = request.getParameter("eliminar");
		
		// SE UTILIZA EL DAO PARA TRAERTE LA INFORMACION
		Persona p = dao.getPersona(username);
		
		// SE COMPRUEBA QUE SEA ADMIN, SI NO ES, SE MODIFICA
		if(p.isEsAdmin() == true){
			miMAV.addObject("mensaje",
					"No se puede eliminar a un administrador");
			return miMAV;
		}else{
			DAOPublicacion daop= new DAOPublicacion();
			daop.borrarPublicacionesUsuario(username);
			dao.deleteByEmail(p.getEmail());
			usuarios=dao.getAllPersonas();
			model.addAttribute("listUsuarios", usuarios );
			miMAV.addObject("mensaje",
					"Has eliminado correctamente al usuario");
			return miMAV;
		}
		
	}
	
	
	
}