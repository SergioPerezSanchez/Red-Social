package modelo;

import java.util.LinkedList;

public class DAOAmistad {
	
	DataBase db;
	public DAOAmistad() {
		db = new DataBase();
	}
	
	public boolean createAmistad(Amistad amistad){
		return db.createAmistad(amistad);
	}
	
	public boolean sonAmigos(String amigoA, String amigoB) {
		return db.sonAmigos(amigoA, amigoB);
	}
	
	public LinkedList<Amistad> readAmistades(String username){
		return db.readAmistades(username);
	}
	
	public Amistad readAmistad(String amigoA, String amigoB) {
		return db.readAmistad(amigoA, amigoB);
	}
	
	public boolean deleteAmistad(Amistad amistad) {
		return db.deleteAmistad(amistad);
	}
}
