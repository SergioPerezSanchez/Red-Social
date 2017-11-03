/*package com.pis.redSocial;

import org.springframework.stereotype.Controller;

import modelo.DAOPersona;
import modelo.Persona;

@Controller
public class PersonaServlet {
	
	String sourceNombre = "X", // Falta a�adir el nombre del recurso cuando exista.
	sourceApellidos = "X",
	sourceUsername = "inputNombre",
	sourceEmail = "inputEmail",
	sourcePassword = "inputPassword",
	sourceDireccion = "X",
	sourceTelefono = "X",
	sourceFoto = "X";

	Persona persona;
	boolean login = false;

	@Autwired
	DAOPersona daoPersona;
	
	@RequestMapping("crear.jsp")
	public void crear(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		crearPersona(request, persona);

		if( !daoPersona.existeEmail(persona.getEmail) 
			&& !daoPersona.existeUsername(persona.getUsername) ){
			daoPersona.crearPersona(persona);
		}
		
	}
	
	@RequestMapping("borrar.jsp")
	public void borrar(HttpServletRequest request, HttpServletResponse response) throws Exception {

		crearPersona(request, persona);

		if( daoPersona.existeEmail(persona.getEmail) 
			&& daoPersona.existeUsername(persona.getUsername) ){
			daoPersona.delete(persona);
		}
		
	}
	
	@RequestMapping("actualizar.jsp")
	public void actualizar(HttpServletRequest request, HttpServletResponse response) throws Exception {

		crearPersona(request, persona);

		if( daoPersona.existeEmail(persona.getEmail) ){
			daoPersona.update(persona);
		}
		
	}
	
	@RequestMapping("login.jsp")
	public void login(HttpServletRequest request, HttpServletResponse response) throws Exception {

		crearPersona(request, persona);

		login = daoPersona.login(persona);
				
	}
	
	@RequestMapping("logout.jsp")
	public void logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		///////////////////////////////////////////////////////
		/////                  ToDo                       /////
		///////////////////////////////////////////////////////

	}
	
	@RequestMapping("userToAdmin.jsp")
	public void userToAdmin(HttpServletRequest request, HttpServletResponse response) throws Exception {

		///////////////////////////////////////////////////////
		/////                  ToDo                       /////
		///////////////////////////////////////////////////////		

	}
	
	@RequestMapping("adminToUser.jsp")
	public void adminToUser(HttpServletRequest request, HttpServletResponse response) throws Exception {

		///////////////////////////////////////////////////////
		/////                  ToDo                       /////
		///////////////////////////////////////////////////////		
			
	}

	private void crearPersona(HttpServletRequest request, Persona persona){

		persona = new Persona();
		//persona.setNombre(request.getParameter(sourceNombre));
		//persona.setApellidos(request.getParameter(sourceApellidos));
		persona.setUsername(request.getParameter(sourceUsername));
		persona.setEmail(request.getParameter(sourceEmail));
		persona.setPassword(request.getParameter(sourcePassword));
		//persona.setDireccion(request.getParameter(sourceDireccion));
		//persona.setTelefono(request.getParameter(sourceTelefono));
		//persona.setFoto(request.getParameter(sourceFoto));

	}
	
}*/
