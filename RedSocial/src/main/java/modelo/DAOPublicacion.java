package modelo;

public class DAOPublicacion {
	
	DataBase db;
	
	public DAOPublicacion() {
		db = new DataBase();
	}
	
	public boolean crearPublicacion(Publicacion publicacion) {
		return db.create(publicacion);
	}
	
	public boolean existeTitulo(String titulo) {
		return db.existeTitulo(titulo);
	}
	
	public boolean existeUsername(String autor) {
		return db.existeUsername(autor);
	}
	
	public boolean delete(Publicacion publicacion) {
		return db.delete(publicacion);
	}
	
	public boolean deleteTitulo(String titulo) {
		return db.deleteEmail(titulo);
	}
	
	public boolean update(Publicacion publicacion) {
		return db.update(publicacion);
	}
	
	public Publicacion getPublicacion(String email) {
		return db.getPublicacion(email);
	}
}
