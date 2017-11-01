import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import modelo.DAOPersona;
import modelo.Persona;

public class DeleteTests {
	Persona p;
	DAOPersona dao;
	@Given("^El usuario se encuentra dentro del sistema$")
	public void El_usuario_se_encuentra_dentro_del_sistema() throws Throwable {
	    p=new Persona("Carlos", "Delgado", "carlitos93", "carlitos@mail.com", "a1Zs7s2DM", "Calle Jane Doe", "0", "photo", false, "usuario");
	    dao = new DAOPersona();
	    System.out.println("Mostrar Clave Encriptada: "+p.getPassword());
	    assert(dao.login(p));
	}

	@When("^Quiere eliminar la cuenta$")
	public void Quiere_eliminar_la_cuenta() throws Throwable {
		assert(dao.delete(p));
	}

	@Then("^Cuenta eliminada$")
	public void Cuenta_eliminada() throws Throwable {
		assert(!(dao.login(p)));
	}
	
}