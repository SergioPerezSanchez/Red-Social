package modelo;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import static org.apache.commons.codec.binary.Base64.decodeBase64;
import static org.apache.commons.codec.binary.Base64.encodeBase64;

import java.util.ArrayList;

public class Persona {
	private String nombre, apellidos, username, email, password, direccion, telefono, foto;
	private boolean esAdmin;
	private ArrayList<String> amigos =new ArrayList<String>();
	private ArrayList<String> peticiones=new ArrayList<String>();
	private ArrayList<String> peticionesenviadas=new ArrayList<String>();
	
	//https://bit502.wordpress.com/2014/06/27/codigo-java-encriptar-y-desencriptar-texto-usando-el-algoritmo-aes-con-cifrado-por-bloques-cbc-de-128-bits/
	// Definición del tipo de algoritmo a utilizar (AES, DES, RSA)
    private final static String alg = "AES";
    // Definición del modo de cifrado a utilizar
    private final static String cI = "AES/CBC/PKCS5Padding";
    //key es la llave en tipo String a utilizar
    private final static String key="92AE31A79FEEB2A3";
    //iv el vector de inicialización a utilizar
    private final static String iv="0123456789ABCDEF"; 
    
    /*public Persona(){
    	
    }*/
    
    public Persona (String username, String password) {
    	this.username=username;
    	this.password=password;
    }

    public Persona(String n, String ap, String us, String e, String pass, String dir, String tlfn, String photo, boolean esAdmin,ArrayList<String>amigos,ArrayList<String>peticiones,ArrayList<String>peticionesenviadas) {
    	try {
	    	this.nombre=n;
	    	this.apellidos=ap;
	    	this.username=us;
	    	this.email=e;
	    	this.password=pass;
	    	this.direccion=dir;
	    	this.telefono=tlfn;
	    	this.foto=photo;
	    	this.esAdmin=esAdmin;
	    	this.amigos=amigos;
	    	this.peticiones=peticiones;
	    	this.setPeticionesenviadas(peticionesenviadas);
    	} catch (Exception e1) {
    		e1.printStackTrace();
    	}
    }
	
	public void encrypt() throws Exception {
        Cipher cipher = Cipher.getInstance(cI);
        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), alg);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivParameterSpec);
        byte[] encrypted = cipher.doFinal(getPassword().getBytes());
        setPassword(new String(encodeBase64(encrypted)));
	}
	
	public void decrypt() throws Exception {
        Cipher cipher = Cipher.getInstance(cI);
        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), alg);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
        byte[] enc = decodeBase64(getPassword());
        cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivParameterSpec);
        byte[] decrypted = cipher.doFinal(enc);
        setPassword(new String(decrypted));
	}
	
	private boolean esNumero(char n) {
		if(n>='0'&&n<='9')return true;
		else return false;
	}
	
	private boolean esMayuscula(char n) {
		if(n>='A'&&n<='Z')return true;
		else return false;
	}
	
	private boolean esMinuscula(char n) {
		if(n>='a'&&n<='z')return true;
		else return false;
	}
	
	public boolean requisitosPassword() {
		boolean size=false, numeros=false, minuscula=false, mayuscula=false;
		if(getPassword().length()>=8) {
			size=true;
		}
		for(int j=0; j<getPassword().length(); j++) {
			if(esNumero(getPassword().charAt(j)))numeros=true;
		}
		for(int j=0; j<getPassword().length(); j++) {
			if(esMayuscula(getPassword().charAt(j)))mayuscula=true;
		}
		for(int j=0; j<getPassword().length(); j++) {
			if(esMinuscula(getPassword().charAt(j)))minuscula=true;
		}
		return size&&numeros&&mayuscula&&minuscula;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public boolean isEsAdmin() {
		return esAdmin;
	}
	public void setEsAdmin(boolean esAdmin) {
		this.esAdmin = esAdmin;
	}

	public ArrayList<String> getAmigos() {
		return amigos;
	}

	public void setAmigos(ArrayList<String> amigos) {
		this.amigos = amigos;
	}

	public ArrayList<String> getPeticiones() {
		return peticiones;
	}

	public void setPeticiones(ArrayList<String> peticiones) {
		this.peticiones = peticiones;
	}

	public ArrayList<String> getPeticionesenviadas() {
		return peticionesenviadas;
	}

	public void setPeticionesenviadas(ArrayList<String> peticionesenviadas) {
		this.peticionesenviadas = peticionesenviadas;
	}
	
}
