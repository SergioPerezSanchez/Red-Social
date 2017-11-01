package modelo;

import java.util.ArrayList;

public class Publicacion {
	int id;
	String autor, titulo, mensaje;
	ArrayList<String> imagenes = new ArrayList<String>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public ArrayList<String> getImagenes() {
		return imagenes;
	}
	public void setImagenes(ArrayList<String> imagenes) {
		this.imagenes = imagenes;
	}
	
	@Override
	public String toString() {
		return "Publicacion [id=" + id + ", autor=" + autor + ", titulo=" + titulo + ", mensaje=" + mensaje
				+ ", imagenes=" + imagenes + "]";
	}
}
