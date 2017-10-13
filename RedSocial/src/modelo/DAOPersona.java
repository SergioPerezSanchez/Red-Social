package modelo;

public class DAOPersona {
	DataBase db;
	public DAOPersona() {
		db = new DataBase();
	}
	
	public boolean crearPersona(Persona p) {
		return db.create(p);
	}
	
	public boolean existeEmail(String email) {
		return db.existeEmail(email);
	}
	
	public boolean existeUsername(String username) {
		return db.existeUsername(username);
	}
}
