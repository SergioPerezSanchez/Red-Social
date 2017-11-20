package com.pis.redSocial;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {
	private static final Logger logger = LoggerFactory
			.getLogger(RegisterController.class);

	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String register(Locale locale, Model model) {
		logger.info("Register page! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "register";
	}

	@RequestMapping(value = "crearUsuario", method = RequestMethod.POST)
	public ModelAndView registrar(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute FileFormBean fileFormBean ) throws Exception {
		String nombre, apellidos, username, email, password, repitePassword, direccion, telefono, foto;
		nombre = request.getParameter("inputNombreRegistro");
		apellidos = request.getParameter("inputApellidosRegistro");
		username = request.getParameter("inputUsernameRegistro");
		email = request.getParameter("inputEmailRegistro");
		password = request.getParameter("inputPasswordRegistro");
		repitePassword = request.getParameter("inputRePasswordRegistro");
		direccion = request.getParameter("inputDireccionRegistro");
		telefono = request.getParameter("inputTelefonoRegistro");
		//foto = request.getParameter("inputFotoRegistro");
		foto = "https://n6-img-fp.akamaized.net/iconos-gratis/la-imagen-del-usuario-con-el-fondo-negro_318-34564.jpg?size=338&ext=jpg";
		ArrayList<String>amigos=new ArrayList<String>();
		ArrayList<String>peticiones=new ArrayList<String>();
		ArrayList<String>peticionesenviadas=new ArrayList<String>();
		ModelAndView miMAV = new ModelAndView("register");
		DAOPersona dao = new DAOPersona();
		Persona p=new Persona(username, password);
		if (dao.existeUsername(username)) {
			miMAV.addObject("nombre", nombre);
			miMAV.addObject("apellidos", apellidos);
			miMAV.addObject("email", email);
			miMAV.addObject("password", password);
			miMAV.addObject("repassword", repitePassword);
			miMAV.addObject("direccion", direccion);
			miMAV.addObject("telefono", telefono);
			miMAV.addObject("foto", foto);
			miMAV.addObject("mensaje",
					"No se puede registrar. Hay una misma cuenta con ese username.");
			return miMAV;
		} else {
			if (dao.existeEmail(email)) {
				miMAV.addObject("nombre", nombre);
				miMAV.addObject("apellidos", apellidos);
				miMAV.addObject("usuario", username);
				miMAV.addObject("password", password);
				miMAV.addObject("repassword", repitePassword);
				miMAV.addObject("direccion", direccion);
				miMAV.addObject("telefono", telefono);
				miMAV.addObject("foto", foto);
				miMAV.addObject("mensaje",
						"No se puede registrar. Hay una cuenta con el mismo email.");
				return miMAV;
			} else {
				if (!(password.equalsIgnoreCase(repitePassword))) {
					miMAV.addObject("nombre", nombre);
					miMAV.addObject("apellidos", apellidos);
					miMAV.addObject("usuario", username);
					miMAV.addObject("email", email);
					miMAV.addObject("direccion", direccion);
					miMAV.addObject("telefono", telefono);
					miMAV.addObject("foto", foto);
					miMAV.addObject("mensaje",
							"No se puede registrar. Las contraseñas no coinciden.");
					return miMAV;
				} else {
					if (!p.requisitosPassword()) {
						miMAV.addObject("nombre", nombre);
						miMAV.addObject("apellidos", apellidos);
						miMAV.addObject("usuario", username);
						miMAV.addObject("email", email);
						miMAV.addObject("direccion", direccion);
						miMAV.addObject("telefono", telefono);
						miMAV.addObject("foto", foto);
						miMAV.addObject("mensaje",
								"No se puede registrar. No se cumple los requisitos de la contraseña.");
						return miMAV;
					}else{
							//CREA USUARIO
							p = new Persona(nombre, apellidos, username, email, password, direccion, telefono, foto, false, amigos,peticiones,peticionesenviadas);
							dao.crearPersona(p);
							return new ModelAndView("home", "aviso", "Cuenta creada correctamente");
					}
				}
			}
		}
	}
}
