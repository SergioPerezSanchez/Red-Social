import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import modelo.DAOPersona;
import modelo.Persona;

public class RegisterTests {
	Persona p, s;
	DAOPersona dao;
	
	//SCENARIO: REGISTRAR A UN USUARIO
	
	@Given("^Un usuario se registra en el sistema$")
	public void Un_usuario_se_registra_en_el_sistema() throws Throwable {
		dao = new DAOPersona();
	    p=new Persona("Carlos", "Delgado", "carlitos93", "carlitos@mail.com", "a1Zs7s2DS", "Calle Jane Doe", "0", "photo", false, "usuario");
	    assert(true);
	}

	@When("^Cumple los requisitos$")
	public void Cumple_los_requisitos() throws Throwable {
		assert(p.requisitosPassword()&&(!(dao.existeEmail(p.getEmail())))&&(!(dao.existeUsername(p.getUsername()))));
	}

	@Then("^Usuario registrado$")
	public void Usuario_registrado() throws Throwable {
		System.out.println("Clave Encriptada: "+p.getPassword());
		assert(dao.crearPersona(p));
	}
	
	//SCENARIO: EL CORREO YA EXISTE
	
	@Given("^Un usuario ya esta registrado en el sistema$")
	public void Un_usuario_ya_esta_registrado_en_el_sistema() throws Throwable {
		dao = new DAOPersona();
	    p=new Persona("Carlos", "Delgado", "carlitos93", "carlitos@mail.com", "a1Zs7s2DS", "Calle Jane Doe", "0", "photo", false, "usuario");
	    assert(true);
	}

	@When("^No Cumple los Requisitos$")
	public void No_Cumple_los_Requisitos() throws Throwable {
	    assert((dao.existeEmail(p.getEmail()))||(dao.existeUsername(p.getUsername())));
	}

	@Then("^Muestra Mensaje de Error$")
	public void Muestra_Mensaje_de_Error() throws Throwable {
	    System.out.println("Existe un usuario registrado en el sistema, con ese email o username");
	    assert(true);
	}
	
	
	//SCENARIO: REQUISITOS DE CLAVE
	
	@Given("^Un usuario se va a registrar en el sistema$")
	public void Un_usuario_se_va_a_registrar_en_el_sistema() throws Throwable {
		dao = new DAOPersona();
	    s=new Persona("Felipe", "Delgado", "felipe5", "felipe@mail.com", "12", "Calle Jane Doe", "0", "photo", false, "usuario");
	    assert(true);
	}

	@When("^No Cumple los Requisitos de la clave$")
	public void No_Cumple_los_Requisitos_de_la_clave() throws Throwable {
		assert(!(s.requisitosPassword()));
	}

	@Then("^Muestra Mensaje de Error de la clave$")
	public void Muestra_Mensaje_de_Error_de_la_clave() throws Throwable {
		System.out.println("La clave no presenta alguno de estos requisitos: "+
		"\n - Tama�o minimo es de 8 caracteres"
		+ "\n - Debe contener al menos una letra may�scula"
		+ "\n - Debe contener al menos una letra min�scula"
		+ "\n - Debe contener al menos un n�mero."
		+ "\n\nRevise la clave, por favor.");
	    assert(true);
	}
}
