package com.pis.redSocial;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.DAOPersona;
import modelo.Persona;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UpdateUserController {

	@RequestMapping("modificarUsuario")
	public ModelAndView updateUser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		//logger.info("Register page! The client locale is {}.", locale);
		String nombre, apellidos, username, email, password, direccion, telefono;
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
				p = new Persona(nombre, apellidos, username, email, password, direccion, telefono, "", false,"usuario");
				
				dao.update(p);
			}	
		}
		return new ModelAndView("home");
	}
}
