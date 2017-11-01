package modelo;

import java.util.LinkedList;

public class DAOPublicacion {
	DataBase db;
	public DAOPublicacion() {
		db = new DataBase();
	}
	public boolean crearPublicacion(Publicacion p) {
		return db.createPublicacion(p);
	}
	public Publicacion leerPublicacion(String username, String fecha) {
		return db.readPublicacion(username, fecha);
	}
	public LinkedList<Publicacion> leerPublicaciones(String username) {
		return db.readPublicaciones(username);
	}
	public LinkedList<Publicacion> leerTodasPublicaciones() {
		return db.readAllPublicaciones();
	}
	public boolean actualizaPublicacion(Publicacion antigua, Publicacion nueva) {
		return db.updatePublicacion(antigua, nueva);
	}
	public boolean borrarPublicacion(Publicacion pub) {
		return db.deletePublicacion(pub);
	}
	public boolean borrarPublicacionesUsuario(String username) {
		return db.deletePublicacionesUsuario(username);
	}
	public boolean borrarTodasPublicaciones() {
		return db.deleteAllPublicaciones();
	}
}