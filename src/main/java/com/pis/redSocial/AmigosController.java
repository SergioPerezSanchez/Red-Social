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
	public String amigos(HttpServletRequest request, Model model) {
		

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
		
		ArrayList<Persona> amigosUser = new ArrayList<Persona>();
		ArrayList<Persona>  peticionesUser= new ArrayList<Persona>();
		DAOPersona dao = new DAOPersona();
		
		for(int i =0;i<listAmigos.size();i++) {
			try {
				amigosUser.add(dao.getPersona(listAmigos.get(i)));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for(int i =0;i<listPeticiones.size();i++) {
			try {
				peticionesUser.add(dao.getPersona(listPeticiones.get(i)));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		model.addAttribute("listAmigos", amigosUser);
		model.addAttribute("listPeticiones", peticionesUser);

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

		
		String usernameAceptado = request.getParameter("aceptar");
		Persona usuarioAceptado = dao.getPersona(usernameAceptado);
		
		ArrayList<String> amigosamigosUsuarioAceptado=usuarioAceptado.getAmigos();
		ArrayList<String> peticionesEnviadasUsuarioAcep=usuarioAceptado.getPeticionesenviadas();
		
		amigosamigosUsuarioAceptado.add(user.getUsername());
		amigos.add(usernameAceptado);
		
		user.setAmigos(amigos);
		usuarioAceptado.setAmigos(amigosamigosUsuarioAceptado);
		
		peticiones.remove(usernameAceptado);
		peticionesEnviadasUsuarioAcep.remove(user.getUsername());
		
		user.setPeticiones(peticiones);
		usuarioAceptado.setPeticionesenviadas(peticionesEnviadasUsuarioAcep);
		dao.update(user);
		dao.update(usuarioAceptado);
		user.decrypt();
		usuarioAceptado.decrypt();
		miMAV.addObject("mensaje", "Ha aceptado al usuario");
		amigos(request, model);
		return miMAV;

	}

	@RequestMapping(value = "rechazarPeticion", method = RequestMethod.POST)
	public ModelAndView rechazar(HttpServletRequest request, HttpServletResponse response, Model model)
			throws Exception {
		ModelAndView miMAV = new ModelAndView("amigos");
		ArrayList<String> peticiones = new ArrayList<String>();
		DAOPersona dao = new DAOPersona();
		HttpSession session = request.getSession();
		Persona user = (Persona) session.getAttribute("persona");
		peticiones = user.getPeticiones();
		model.addAttribute("listPeticiones", peticiones);
		
		
		String usernameRechazado = request.getParameter("rechazar");
		Persona usuarioRechazado = dao.getPersona(usernameRechazado);

		ArrayList<String> peticionesUserRechazado= usuarioRechazado.getPeticionesenviadas();
		
		peticionesUserRechazado.remove(user.getUsername());
		peticiones.remove(usernameRechazado);
		
		usuarioRechazado.setPeticionesenviadas(peticionesUserRechazado);
		user.setPeticiones(peticiones);
		
		dao.update(usuarioRechazado);
		dao.update(user);
		user.decrypt();
		usuarioRechazado.decrypt();
		miMAV.addObject("mensaje", "No ha aceptado al usuario");
		amigos(request, model);
		return miMAV;
	}
	
	@RequestMapping(value = "eliminarAmigo", method = RequestMethod.POST)
	public ModelAndView eliminar(HttpServletRequest request, HttpServletResponse response, Model model)
			throws Exception {
		ModelAndView miMAV = new ModelAndView("amigos");
		ArrayList<String> amigos = new ArrayList<String>();
		DAOPersona dao = new DAOPersona();
		HttpSession session = request.getSession();
		Persona user = (Persona) session.getAttribute("persona");
		amigos = user.getAmigos();
		model.addAttribute("listAmigos", amigos);
		
		
		String usernameEliminado = request.getParameter("eliminar");
		Persona usuarioEliminado = dao.getPersona(usernameEliminado);

		ArrayList<String> amigosUserEliminado= usuarioEliminado.getAmigos();
		
		amigos.remove(usernameEliminado);
		amigosUserEliminado.remove(user.getUsername());
		
		user.setAmigos(amigos);
		usuarioEliminado.setAmigos(amigosUserEliminado);
		
		dao.update(usuarioEliminado);
		dao.update(user);
		user.decrypt();
		usuarioEliminado.decrypt();
		miMAV.addObject("mensaje", "No ha aceptado al usuario");
		amigos(request, model);
		return miMAV;
	}
	
}