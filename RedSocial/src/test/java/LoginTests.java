import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import modelo.DAOPersona;
import modelo.Persona;

public class LoginTests {
	
	//SCENARIO 1: USUARIO REGISTRADO
	
	Persona p, s;
	DAOPersona dao;
	
	@Given("^El usuario accede al sistema$")
	public void El_usuario_accede_al_sistema() throws Throwable {
		dao = new DAOPersona();
	    p=new Persona("Carlos", "Delgado", "carlitos93", "carlitos@mail.com", "a1Zs7s2DS", "Calle Jane Doe", "0", "photo", false,"usuario");
	    assert(true);
	}

	@When("^Coincide email y password$")
	public void Coincide_email_y_password() throws Throwable {
	   assert(dao.login(p));
	}

	@Then("^Accedera al sistema$")
	public void Accedera_al_sistema() throws Throwable {
	    assert(true);
	}
	
	//SCENARIO 2: USUARIO NO REGISTRADO
	
	@Given("^El usuario va a acceder al sistema$")
	public void El_usuario_va_a_acceder_al_sistema() throws Throwable {
		dao = new DAOPersona();
	    p=new Persona("Carlos", "Delgado", "carlitos93", "carlitos@hotmail.com", "a1Zs7s2DS", "Calle Jane Doe", "0", "photo", false, "usuario");
	    assert(true);
	}

	@When("^No esta registrado$")
	public void No_esta_registrado() throws Throwable {
	assert(!dao.login(p));
	}
	
	//SCENARIO 3: PASSWORD INCORRECTO
	
	@Given("^El usuario quiere acceder al sistema$")
	public void El_usuario_quiere_acceder_al_sistema() throws Throwable {
		dao = new DAOPersona();
	    p=new Persona("Carlos", "Delgado", "carlitos93", "carlitos@mail.com", "a1Zs7s2DM", "Calle Jane Doe", "0", "photo", false, "usuario");
	    assert(true);
	}

	@When("^No coincide la password del usuario$")
	public void No_coincide_la_password_del_usuario() throws Throwable {
		assert(!dao.login(p));
	}

	//WHEN - SCENARIO 2 Y 3
	
	@Then("^Mostrara mensaje de error$")
	public void Mostrara_mensaje_de_error() throws Throwable {
	    System.out.println("El email o la contrase�a es erronea");
	    assert(true);
	}
	
}
