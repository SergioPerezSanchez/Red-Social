package modelo;

import java.util.LinkedList;

public class DAOPeticion {

	DataBase db;
	public DAOPeticion() {
		db = new DataBase();
	}
	
	public boolean createPeticion(Peticion peticion) {
		return db.createPeticion(peticion);
	}
	
	public boolean hayPeticion(String amigoA, String amigoB) {
		return db.hayPeticion(amigoA, amigoB);
	}
	
	public LinkedList<Peticion> readPeticionesDe(String username){
		return db.readPeticionesDe(username);
	}
	
	public LinkedList<Peticion> readPeticionesA(String username){
		return db.readPeticionesA(username);
	}
	
	public Peticion readPeticion(String amigoA, String amigoB) {
		if (hayPeticion(amigoA, amigoB)) {
			return db.readPeticion(amigoA, amigoB);
		}
		return null;
	}
	
	public void rechazarPeticion(String amigoA, String amigoB) {
		if (db.hayPeticion(amigoA, amigoB)) {
			db.rechazarPeticion(amigoA, amigoB);
		}
	}
	
	public void aceptarPeticion(String amigoA, String amigoB) {
		if (db.hayPeticion(amigoA, amigoB)) {
			db.aceptarPeticion(amigoA, amigoB);
		}
	}
}
