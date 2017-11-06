package modelo;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
	String email, username, password;
	
		
	public Email(String email, String username, String password) {
		setEmail(email);
		setUsername(username);
		setPassword(password);
	}
	
	
	public boolean enviarEmail() {
		boolean enviado = false;
		
		final String username = "equipo03pis@gmail.com";
		final String password = "pis03equipo";
		

		try {
			Properties mailServerProperties = System.getProperties();
			mailServerProperties.put("mail.smtp.port", "587");
			mailServerProperties.put("mail.smtp.auth", "true");
			mailServerProperties.put("mail.smtp.starttls.enable", "true");
			mailServerProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
	 
			Session getMailSession = Session.getDefaultInstance(mailServerProperties, null);
			MimeMessage generateMailMessage = new MimeMessage(getMailSession);
			generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(getEmail()));
			generateMailMessage.setSubject("[Intravita] Recuperación de Credenciales (Usuario y Password)");
			String emailBody = "Hola " + "\r\nUsted ha solicitado la recuperación de usuario y password para la Red Social Intravita,"+" \r\n\r\nUsuario: "+getUsername()+" \r\nPassword: "+getPassword()+" \r\n\r\nUn saludo, Intravita.";
			//String emailBody = "Hola " + "<br><br> Usted ha solicitado la recuperación de usuario y password para la Red Social Intravita,"+" <br> Usuario: "+getUsername()+" <br> Password: "+getPassword()+" <br><br> Un saludo, Intravita.";
			generateMailMessage.setContent(emailBody, "text/plain");
	 
			Transport transport = getMailSession.getTransport("smtp");
			transport.connect("smtp.gmail.com", username, password);
			transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
			transport.close();
			enviado = true;
		}catch(Exception ex) {
			enviado = false;
			ex.printStackTrace();
		}
		
		
		return enviado;
	}
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
