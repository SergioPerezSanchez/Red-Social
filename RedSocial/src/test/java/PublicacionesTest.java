import java.util.LinkedList;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import modelo.DAOPersona;
import modelo.DAOPublicacion;
import modelo.Persona;
import modelo.Publicacion;

public class PublicacionesTest {
	DAOPersona dao;
	Persona person;
	DAOPublicacion daoP;
	Publicacion publi, publi2;
	@Given("^Un usuario logueado en el sistema$")
	public void un_usuario_logueado_en_el_sistema() throws Throwable {
		dao = new DAOPersona();
	    person=new Persona("Carlos", "Delgado", "carlitos93", "carlitos@mail.com", "a1Zs7s2DM", "Calle Jane Doe", "0", "photo", false);
	    assert(dao.login(person));
	}

	@When("^Quiere crear una publicacion$")
	public void quiere_crear_una_publicacion() throws Throwable {
	    daoP = new DAOPublicacion();
	    LinkedList<String>adj = new LinkedList<String>();
	    adj.add("adj1");
	    publi = new Publicacion(person.getUsername(),"prueba", "Privado", adj);
	    assert(daoP.crearPublicacion(publi));
	}

	@Then("^Se crea la publicacion$")
	public void se_crea_la_publicacion() throws Throwable {
		publi2 = daoP.leerPublicacion(publi.getUsername(), publi.getFecha().toString());
		assert((publi.getFecha().toString().equalsIgnoreCase(publi2.getFecha().toString()))&&(publi.getUsername().equalsIgnoreCase(publi2.getUsername())));
	}

	@When("^Quiere editar una publicacion$")
	public void quiere_editar_una_publicacion() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Then("^Se edita la publicacion$")
	public void se_edita_la_publicacion() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@When("^Quiere eliminar una publicacion$")
	public void quiere_eliminar_una_publicacion() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Then("^Se elimina la publicacion$")
	public void se_elimina_la_publicacion() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}
}
