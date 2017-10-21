package modelo;

public class Persona {
	private String nombre, apellidos, username, email, password, direccion, telefono, foto;
	public Persona(String n, String ap, String us, String e, String pass, String dir, String tlfn, String photo) {
		this.nombre=n;
		this.apellidos=ap;
		this.username=us;
		this.email=e;
		this.password=pass;
		this.direccion=dir;
		this.telefono=tlfn;
		this.foto=photo;
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
		if(this.password.length()>=8) {
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
