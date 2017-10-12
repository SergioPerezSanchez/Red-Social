package tests;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.api.PendingException;

public class LoginTests {
	
	//SCENARIO 1: USUARIO REGISTRADO
	
	@Given("^El usuario accede al sistema$")
	public void El_usuario_accede_al_sistema() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@When("^Coincide email y password$")
	public void Coincide_email_y_password() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@Then("^Accedera al sistema$")
	public void Accedera_al_sistema() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}
	
	//SCENARIO 2: USUARIO NO REGISTRADO
	
	@Given("^El usuario va a acceder al sistema$")
	public void El_usuario_va_a_acceder_al_sistema() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@When("^No esta registrado$")
	public void No_esta_registrado() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}
	
	//SCENARIO 3: PASSWORD INCORRECTO
	
	@Given("^El usuario quiere acceder al sistema$")
	public void El_usuario_quiere_acceder_al_sistema() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@When("^No coincide la password del usuario$")
	public void No_coincide_la_password_del_usuario() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	//WHEN - SCENARIO 2 Y 3
	
	@Then("^Mostrara mensaje de error$")
	public void Mostrara_mensaje_de_error() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}
	
}
