package com.pis.redSocial;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import modelo.DAOLike;
import modelo.DAOPublicacion;
import modelo.Persona;
import modelo.Publicacion;

public class LikeController {
	
	private static final Logger logger = LoggerFactory.getLogger(LikeController.class);
	
	@RequestMapping(value = "like", method = RequestMethod.GET)
	public String like(HttpServletRequest request, Locale locale, Model model) {
		logger.info("Register page! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		DAOLike daoLike = new DAOLike();
		HttpSession session=request.getSession();
		Persona a=(Persona) session.getAttribute("persona");
		Publicacion p=(Publicacion) session.getAttribute("publicacion");
		boolean exito = daoLike.like(a.getUsername(), p.getUsername(), p.getFecha())
		
		return "menu";
	}
	
	@RequestMapping(value = "unlike", method = RequestMethod.GET)
	public String unlike(HttpServletRequest request, Locale locale, Model model) {
		logger.info("Register page! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		DAOLike daoLike = new DAOLike();
		HttpSession session=request.getSession();
		Persona a=(Persona) session.getAttribute("persona");
		Publicacion p=(Publicacion) session.getAttribute("publicacion");
		boolean exito = daoLike.unLike(a.getUsername(), p.getUsername(), p.getFecha())
		
		return "unlike";
	}
}
