import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import modelo.DAOPersona;
import modelo.Persona;

public class UpdateTests {
	
	Persona p, s;
	DAOPersona dao;
	@Given("^El usuario esta dentro del sistema$")
	public void El_usuario_esta_dentro_del_sistema() throws Throwable {
		dao = new DAOPersona();
	    p=new Persona("Carlos", "Delgado", "carlitos93", "carlitos@mail.com", "a1Zs7s2DS", "Calle Jane Doe", "0", "photo", false, "usuario");   
	  assert(dao.login(p));
	}

	@When("^Quiere cambiar la clave$")
	public void Quiere_cambiar_la_clave() throws Throwable {
		p.setPassword("a1Zs7s2DM");
		p.encrypt();
		assert(true);
	}

	@Then("^La clave se cambia$")
	public void La_clave_se_cambia() throws Throwable {
	  assert(dao.update(p));
	}
	
}
