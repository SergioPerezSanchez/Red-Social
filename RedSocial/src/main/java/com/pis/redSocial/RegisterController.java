package com.pis.redSocial;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
public class RegisterController {
private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String register(Locale locale, Model model) {
		logger.info("Register page! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "register";
	}
	/*@RequestMapping(value = "crearUsuario", method = RequestMethod.POST)
	public String crear(Locale locale, Model model) {*/
	
	@RequestMapping("crearUsuario")
	public ModelAndView registrar(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
	//logger.info("Register page! The client locale is {}.", locale);
	boolean flag=false;
	String nombre, apellidos, username, email, password, repitePassword, direccion, telefono, foto;
	username = request.getParameter("inputUsernameRegistro");
	email = request.getParameter("inputEmailRegistro");
	password = request.getParameter("inputPasswordRegistro");
	repitePassword = request.getParameter("inputRePasswordRegistro");
	DAOPersona dao = new DAOPersona();
	Persona p;
	if(username.equalsIgnoreCase("")||email.equalsIgnoreCase("")||password.equalsIgnoreCase("")||repitePassword.equalsIgnoreCase("")) {
	return new ModelAndView("register","mensaje","No se puede registrar. Los campos username, email, password y repetir password son obligatorios. No los puede dejar en blanco.");
	}
	else {
	if(dao.existeUsername(username)){
	//Mostrar Error Existe Usuario
	return new ModelAndView("register","mensaje","No se puede registrar. Hay una misma cuenta con ese username.");
	}else{
	if(dao.existeEmail(email)){
	//Mostrar Error Existe Email
	return new ModelAndView("register","mensaje","No se puede registrar. Hay una cuenta con el mismo email.");
	}else {
	if(!(password.equalsIgnoreCase(repitePassword))){
	return new ModelAndView("register","mensaje","No se puede registrar. Las contraseñas no coinciden.");
	}else {
	p = new Persona(password);
		if(!p.requisitosPassword()) {
		return new ModelAndView("register","mensaje","No se puede registrar. No se cumple los requisitos de la contraseña:"+
		"\n- Debe tener mínimo 8 caracteres"+
		"\n- Debe contener al menos un dígito, una letra mayúscula y una letra minúscula.");
		}else {
		//CREA USUARIO
			nombre=request.getParameter("inputNombreRegistro");
			apellidos=request.getParameter("inputApellidosRegistro");
			password=request.getParameter("inputPasswordRegistro");
			direccion=request.getParameter("inputDireccionRegistro");
			telefono=request.getParameter("inputTelefonoRegistro");
			p = new Persona(nombre, apellidos, username, email, password, direccion, telefono, "", false, "usuario");
			dao.crearPersona(p);
			flag=true;
			return new ModelAndView("home");
		}
	}
	}

	}
	}
	}
	
	/*
	@RequestMapping("crearUsuario")
	public ModelAndView registrar(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		//logger.info("Register page! The client locale is {}.", locale);
		boolean flag=false;
		String nombre, apellidos, username, email, password, direccion, telefono, foto;
		username = request.getParameter("inputUsernameRegistro");
		email = request.getParameter("inputEmailRegistro");
		DAOPersona dao = new DAOPersona();
		Persona p;
		if(dao.existeUsername(username)){
			//Mostrar Error Existe Usuario
		}else{
			if(dao.existeEmail(email)){
				//Mostrar Error Existe Email
			}else {
				//CREA USUARIO
				nombre=request.getParameter("inputNombreRegistro");
				apellidos=request.getParameter("inputApellidosRegistro");
				password=request.getParameter("inputPasswordRegistro");
				direccion=request.getParameter("inputDireccionRegistro");
				telefono=request.getParameter("inputTelefonoRegistro");
				p = new Persona(nombre, apellidos, username, email, password, direccion, telefono, "", false);
				dao.crearPersona(p);
				flag=true;
			}
			
		}
		
		if(flag){
			return "menu";
		}else{
			return "forgotPassword";
		}
		return new ModelAndView("home");
	}*/
}
