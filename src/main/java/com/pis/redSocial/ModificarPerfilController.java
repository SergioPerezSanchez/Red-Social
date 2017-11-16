package com.pis.redSocial;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Controller
public class ModificarPerfilController {
private static final Logger logger = LoggerFactory.getLogger(ModificarPerfilController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "modificarPerfil", method = RequestMethod.GET)
	public String modificarPerfil(Locale locale, Model model) {
		logger.info("Register page! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "modificarPerfil";
	}
	
	@RequestMapping(value = "borrarUsuario", method = RequestMethod.POST)
	public ModelAndView borrar(HttpServletRequest request, HttpServletResponse response,Model model)throws Exception{
		String username;
		HttpSession session=request.getSession();
		Persona user=(Persona) session.getAttribute("persona");
		username= user.getUsername();
		DAOPersona dao= new DAOPersona();
		DAOPublicacion daop= new DAOPublicacion();
		daop.borrarPublicacionesUsuario(username);
		
		dao.deleteByEmail(user.getEmail());
		
		if(dao.login(user)) {
			
			return new ModelAndView("modificarPerfil", "aviso", "Ha habido algun problema");
		}else {
			return new ModelAndView("home", "aviso", "Cuenta Eliminada!");
		}
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
    public ModelAndView guardaFichero(HttpServletRequest request, HttpServletResponse response,Model model, @ModelAttribute FileFormBean fileFormBean)throws Exception {
		String username;
		HttpSession session=request.getSession();
		Persona user=(Persona) session.getAttribute("persona");
		username= user.getUsername();
		try {
			String urlfoto= grabarFicheroALocal(fileFormBean,username);
			String urlCut = urlfoto.substring(10);
			urlCut= urlCut.substring(0,urlCut.length()-3);
			user.setFoto(urlCut);
			user.encrypt();
			DAOPersona daoPersona = new DAOPersona();
			daoPersona.update(user);
			return new ModelAndView("modificarPerfil", "aviso", "Foto de perfil cambiada");
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("modificarPerfil", "aviso", "Ha habido algun problema");
		}
    }
	
	
	private String grabarFicheroALocal(FileFormBean fileFormBean, String username) throws Exception {
		CommonsMultipartFile uploaded = fileFormBean.getFichero();
		   	
    	//Cloudinary
    	Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
    			  "cloud_name", "dtajtzcgw",
    			  "api_key", "942888456823941",
    			  "api_secret", "FefbhNW6ZnniBf4wFH0d6JUcn84"));
    	
    	cloudinary.uploader().rename(username, username+"_old", ObjectUtils.asMap("overwrite", true));
    	Map upload = cloudinary.uploader().upload(uploaded.getBytes(), ObjectUtils.asMap(
    			"public_id", username));
    	
    	String url= cloudinary.url().imageTag(username+".jpg");
    	return url;

	}
}