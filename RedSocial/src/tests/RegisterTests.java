package tests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.PendingException;
import modelo.DAOPersona;
import modelo.Persona;

public class RegisterTests {
	Persona p;
	DAOPersona dao;
	
	//SCENARIO: REGISTRAR A UN USUARIO
	
	@Given("^Un usuario se registra en el sistema$")
	public void Un_usuario_se_registra_en_el_sistema() throws Throwable {
		dao = new DAOPersona();
	    p=new Persona("Carlos", "Delgado", "carlitos93", "carlitos@mail.com", "a1Zs7s2DS", "Calle Jane Doe", "0", "photo");
	    assert(true);
	}

	@When("^Cumple los requisitos$")
	public void Cumple_los_requisitos() throws Throwable {
		if(p.requisitosPassword()&&(!(dao.existeEmail(p.getEmail())))&&(!(dao.existeUsername(p.getUsername())))) {
			dao.crearPersona(p);
		    assert(true);
		}else {
			assert(false);
		}
	}

	@Then("^Usuario registrado$")
	public void Usuario_registrado() throws Throwable {
		assert(true);
	}
	
	//SCENARIO: EL CORREO YA EXISTE
	
	@Given("^Un usuario ya esta registrado en el sistema$")
	public void Un_usuario_ya_esta_registrado_en_el_sistema() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@When("^No Cumple los Requisitos$")
	public void No_Cumple_los_Requisitos() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@Then("^Muestra Mensaje de Error$")
	public void Muestra_Mensaje_de_Error() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}
	
	
	//SCENARIO: REQUISITOS DE CONTRASEÑA
	
	@Given("^Un usuario se va a registrar en el sistema$")
	public void Un_usuario_se_va_a_registrar_en_el_sistema() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@When("^No Cumple los Requisitos de la contrase?a$")
	public void No_Cumple_los_Requisitos_de_la_contrase_a() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@Then("^Muestra Mensaje de Error de la contrase?a$")
	public void Muestra_Mensaje_de_Error_de_la_contrase_a() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}
}
