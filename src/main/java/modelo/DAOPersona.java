package modelo;

import java.util.LinkedList;

public class DAOPersona {
	DataBase db;
	public DAOPersona() {
		db = new DataBase();
	}
	
	public boolean crearPersona(Persona p) throws Exception {
		p.encrypt();
		return db.create(p);
	}
	
	public boolean existeEmail(String email) {
		return db.existeEmail(email);
	}
	
	public boolean existeUsername(String username) {
		return db.existeUsername(username);
	}
	
	public boolean login(Persona p) throws Exception {
		p.encrypt();
		return db.login(p);
	}
	
	public boolean delete(Persona p) throws Exception {
		p.encrypt();
		return db.delete(p);
	}
	
	public boolean deleteByEmail(String email) {
		return db.deleteEmail(email);
	}
	
	public boolean update(Persona p) throws Exception {
		p.encrypt();
		return db.update(p);
	}
	
	public Persona getPersona(String username) throws Exception {
		Persona p= db.getPersona(username);
		p.decrypt();
		return p;
	}
	
	public Persona getPersonaByEmail(String email) throws Exception {
		Persona p= db.getPersonaByEmail(email);
		p.decrypt();
		return p;
	}
	
	public LinkedList<Persona> getAllPersonas() {
		return db.getAllPersonas();
	}
}
