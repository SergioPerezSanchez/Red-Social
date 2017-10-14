package controlador;

import modelo.DAOPersona;
import modelo.Persona;

@Controller
public class PersonaServlet {
	
	String sourceNombre = "X",
	sourceApellidos = "X",
	sourceUsername = "X",
	sourceEmail = "X",
	sourcePassword = "X",
	sourceDireccion = "X",
	sourceTelefono = "X",
	sourceFoto = "X";

	Persona persona;
	boolean login = false;

	@Autwired
	DAOPersona daoPersona;
	
	@RequestMapping("crear.do")
	public void crear(HttpServletResponse response) throws Exception {
		
		crearPersona();

		if( !daoPersona.existeEmail(persona.getEmail) 
			&& !daoPersona.existeUsername(persona.getUsername) ){
			daoPersona.crearPersona(persona);
		}
		
	}
	
	@RequestMapping("borrar.do")
	public void borrar(HttpServletResponse response) throws Exception {

		crearPersona();

		if( daoPersona.existeEmail(persona.getEmail) 
			&& daoPersona.existeUsername(persona.getUsername) ){
			daoPersona.delete(persona);
		}
		
	}
	
	@RequestMapping("login.do")
	public void login(HttpServletResponse response) throws Exception {

		crearPersona();

		login = daoPersona.login(persona);
				
	}
	
	@RequestMapping("logout.do")
	public void logout(HttpServletResponse response) throws Exception {
		
		///////////////////////////////////////////////////////
		/////                  ToDo                       /////
		///////////////////////////////////////////////////////

	}
	
	@RequestMapping("userToAdmin.do")
	public void userToAdmin(HttpServletResponse response) throws Exception {

		///////////////////////////////////////////////////////
		/////                  ToDo                       /////
		///////////////////////////////////////////////////////		

	}
	
	@RequestMapping("adminToUser.do")
	public void adminToUser(HttpServletResponse response) throws Exception {

		///////////////////////////////////////////////////////
		/////                  ToDo                       /////
		///////////////////////////////////////////////////////		
			
	}

	private void crearPersona(){

		persona = new Persona();
		persona.setNombre(request.getParameter(sourceNombre));
		persona.setApellidos(request.getParameter(sourceApellidos));
		persona.setUsername(request.getParameter(sourceUsername));
		persona.setEmail(request.getParameter(sourceEmail));
		persona.setPassword(request.getParameter(sourcePassword));
		persona.setDireccion(request.getParameter(sourceDireccion));
		persona.setTelefono(request.getParameter(sourceTelefono));
		persona.setFoto(request.getParameter(sourceFoto));

	}
	
}
