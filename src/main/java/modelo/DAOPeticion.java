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
		return db.readPeticion(amigoA, amigoB);
	}
	
	
}
