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
Persona p= new Persona(nombre,apellidos, username,email, password, direccion, telefono, "", false, "usuario");
dao.update(p);
return new ModelAndView("menu");
}

}
