package modelo;

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
	public boolean actualizaPublicacion(Publicacion antigua, Publicacion nueva) {
		return db.updatePublicacion(antigua, nueva);
	}
	public boolean borrarPublicacion(Publicacion pub) {
		return db.deletePublicacion(pub);
	}
}