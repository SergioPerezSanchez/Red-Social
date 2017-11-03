/*package com.pis.redSocial;

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
public class DeleteUserController {

	@RequestMapping("borrarUsuario")
	public ModelAndView borrarUser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		//logger.info("Register page! The client locale is {}.", locale);
		String email;
		email = request.getParameter("inputEmailRegistro");
		DAOPersona dao = new DAOPersona();
		if(!dao.existeEmail(email)){
			//Mostrar Error NO Existe Mail
		}else{
				
				dao.deleteEmail(email);
		}
		return new ModelAndView("home");
	}
}
*/