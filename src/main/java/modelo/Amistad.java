package modelo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Amistad {
	
	private String amigo1, amigo2;
	Date fechaAmistad;
	
	public Amistad(String amigo1, String amigo2) {
		setAmigo1(amigo1);
		setAmigo2(amigo2);
		creaFecha();
	}
	
	public Amistad(String amigo1, String amigo2, String fechaAmistad) {
		setAmigo1(amigo1);
		setAmigo2(amigo2);
		setFechaAmistad(fechaAmistad);
	}
	
	public String getAmigo1() {
		return amigo1;
	}
	
	public void setAmigo1(String amigo1) {
		this.amigo1 = amigo1;
	}
	
	public String getAmigo2() {
		return amigo2;
	}
	
	public void setAmigo2(String amigo2) {
		this.amigo2 = amigo2;
	}
	
	public Date getFechaAmistad() {
		return fechaAmistad;
	}

	public void setFechaAmistad(String fechaAmistad) {
		try {
			DateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
			this.fechaAmistad= format.parse(fechaAmistad);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	protected void creaFecha() {
		this.fechaAmistad=new Date();
	}
	
	@Override
	public String toString() {
		return "Amistad [id1=" + amigo1 + ", id2=" + amigo2 + ", fechaAmistad=" + fechaAmistad + "]";
	}
	
}
