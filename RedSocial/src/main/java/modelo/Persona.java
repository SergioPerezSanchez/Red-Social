package modelo;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import static org.apache.commons.codec.binary.Base64.decodeBase64;
import static org.apache.commons.codec.binary.Base64.encodeBase64;

public class Persona {
	private String nombre, apellidos, username, email, password, direccion, telefono, foto, original;
	
	//https://bit502.wordpress.com/2014/06/27/codigo-java-encriptar-y-desencriptar-texto-usando-el-algoritmo-aes-con-cifrado-por-bloques-cbc-de-128-bits/
	// Definición del tipo de algoritmo a utilizar (AES, DES, RSA)
    private final static String alg = "AES";
    // Definición del modo de cifrado a utilizar
    private final static String cI = "AES/CBC/PKCS5Padding";
    //key es la llave en tipo String a utilizar
    private final static String key="92AE31A79FEEB2A3";
    //iv el vector de inicialización a utilizar
    private final static String iv="0123456789ABCDEF"; 
    
    
	public Persona(String n, String ap, String us, String e, String pass, String dir, String tlfn, String photo, boolean esEncriptado) {
		try {
			this.nombre=n;
			this.apellidos=ap;
			this.username=us;
			this.email=e;
			this.password=pass;
			this.original=pass;
			this.direccion=dir;
			this.telefono=tlfn;
			this.foto=photo;
			if(esEncriptado) {
				decrypt();
			}else {
				encrypt();
			}
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
		if(this.original.length()>=8) {
			size=true;
		}
		for(int j=0; j<this.original.length(); j++) {
			if(esNumero(this.original.charAt(j)))numeros=true;
		}
		for(int j=0; j<this.original.length(); j++) {
			if(esMayuscula(this.original.charAt(j)))mayuscula=true;
		}
		for(int j=0; j<this.original.length(); j++) {
			if(esMinuscula(this.original.charAt(j)))minuscula=true;
		}
		return size&&numeros&&mayuscula&&minuscula;
	}
	
	protected String getNombre() {
		return nombre;
	}
	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}
	protected String getApellidos() {
		return apellidos;
	}
	protected void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getUsername() {
		return username;
	}
	protected void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	protected void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	protected String getDireccion() {
		return direccion;
	}
	protected void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	protected String getTelefono() {
		return telefono;
	}
	protected void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	protected String getFoto() {
		return foto;
	}
	protected void setFoto(String foto) {
		this.foto = foto;
	}
}
