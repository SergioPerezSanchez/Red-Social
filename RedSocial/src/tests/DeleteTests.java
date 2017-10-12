package tests;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

public class DeleteTests {
	
	@Given("^El usuario se encuentra dentro del sistema$")
	public void El_usuario_se_encuentra_dentro_del_sistema() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    //throw new PendingException();
		assert(true);
	}

	@When("^Quiere eliminar la cuenta$")
	public void Quiere_eliminar_la_cuenta() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    //throw new PendingException();
		assert(true);
	}

	@Then("^Cuenta eliminada$")
	public void Cuenta_eliminada() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    //throw new PendingException();
		assert(true);
	}

	
}