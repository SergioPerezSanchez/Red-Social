package modelo;

public class Like {
	String user, publicacion;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPublicacion() {
		return publicacion;
	}

	public void setPublicacion(String publicacion) {
		this.publicacion = publicacion;
	}

	public Like(String user, String publicacion) {
		super();
		this.user = user;
		this.publicacion = publicacion;
	}
}
