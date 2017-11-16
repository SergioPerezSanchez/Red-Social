package modelo;

import java.util.LinkedList;

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
	
	public boolean login(Persona p) throws Exception {
		return db.login(p);
	}
	
	public boolean delete(Persona p) {
		return db.delete(p);
	}
	
	public boolean deleteByEmail(String email) {
		return db.deleteEmail(email);
	}
	
	public boolean update(Persona p) {
		return db.update(p);
	}
	
	public Persona getPersona(String username) {
		return db.getPersona(username);
	}
	
	public Persona getPersonaByEmail(String email) {
		return db.getPersonaByEmail(email);
	}
	
	public LinkedList<Persona> getAllPersonas() {
		return db.getAllPersonas();
	}
}
