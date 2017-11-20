package modelo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Peticion {

	private String id1, id2, mensaje;
	private Date fechaPeticion;
	private int flag; // -1 rechazada, 0 no atendida, 1 aceptada.
	
	public Peticion(String id1, String id2, String mensaje, Date fechaPeticion, int flag) {
		setId1(id1);
		setId2(id2);
		setMensaje(mensaje);
		setFechaPeticion(fechaPeticion);
		setFlag(flag);
	}
	
	public Peticion(String id1, String id2, String mensaje, String fechaPeticion, String flag) {
		setId1(id1);
		setId2(id2);
		setMensaje(mensaje);
		setFechaPeticion(fechaPeticion);
		setFlag(Integer.parseInt(flag));
	}
	
	public String getId1() {
		return id1;
	}
	
	public void setId1(String id1) {
		this.id1 = id1;
	}
	
	public String getId2() {
		return id2;
	}
	
	public void setId2(String id2) {
		this.id2 = id2;
	}
	
	public String getMensaje() {
		return mensaje;
	}
	
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public Date getFechaPeticion() {
		return fechaPeticion;
	}
	
	public void setFechaPeticion(Date fechaPeticion) {
		this.fechaPeticion = fechaPeticion;
	}
	
	public void setFechaPeticion(String fechaPeticion) {
		try {
			DateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
			this.fechaPeticion= format.parse(fechaPeticion);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	@Override
	public String toString() {
		return "Petición [id1=" + id1 + ", id2=" + id2 + ", mensaje=" + mensaje + ", fechaPeticion=" + fechaPeticion
				+ "]";
	}
	
	
}
