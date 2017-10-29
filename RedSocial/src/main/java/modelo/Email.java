package modelo;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
	String email;
	DAOPersona persona;
	Persona p;
	public Email(String correo) {
		this.email = correo;
	}
	public boolean restablecerClave() {
		try {
			persona = new DAOPersona();
			p = persona.getPersona(getEmail());
			
			Properties props = new Properties();
			props.setProperty("mail.smtp.host", "smtp.gmail.com");
			props.setProperty("mail.smtp.starttls.enable", "true");
			props.setProperty("mail.smtp.port","587");
			props.setProperty("mail.smtp.user", "ejemplo@gmail.com");
			props.setProperty("mail.smtp.auth", "true");

			Session session = Session.getDefaultInstance(props);
			session.setDebug(true);
			
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("ejemplo@gmail.com"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(p.getEmail()));
			message.setSubject("[Recuperacion de la Clave]");
			message.setText("Texto del mensaje");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	public String getEmail() {
		return this.email;
	}
}
