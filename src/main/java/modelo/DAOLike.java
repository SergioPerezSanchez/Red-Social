package modelo;

import java.util.LinkedList;

public class DAOLike {
	DataBase db;
	public DAOLike() {
		db = new DataBase();
	}
	
	public boolean like(String userLike, String userPubli, String publicacion) {
		if(!hayLike(userLike, userPubli, publicacion)) {
			return db.like(userLike, userPubli, publicacion);
		}
		return false;
	}
	
	public boolean hayLike(String userLike, String userPubli, String publicacion) {
		return db.hayLike(userLike, userPubli, publicacion);
	}
	
	public boolean unLike(String userLike, String userPubli, String publicacion) {
		if (hayLike(userLike, userPubli, publicacion)) {
			return db.unLike(userLike, userPubli, publicacion);
		}
		return false;
	}
}
