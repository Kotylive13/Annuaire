/**
 * Classe permettant d'envoyer des emails
 * @author Jonathan, Philippe, Marcel
 * @version 1.0
 */

package springapp.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
	
	/**
	 * Expéditeur
	 */
	// Sender's email ID needs to be mentioned
	private final String FROM;
	
	/**
	 * Nom de l'expéditeur
	 */
	private final String USERNAME;
	
	/**
	 * Mot de passe de l'expéditeur
	 */
	private final String PASSWORD;
	
	/**
	 * Host smtp de l'adresse mail
	 */
	private final String HOST;
	
	public Email() {
		FROM = "annuaire.m2isl@gmail.com";
		USERNAME = "annuaire.m2isl";
		PASSWORD = "Annuaire";
		HOST = "smtp.gmail.com";
	}
	
	/**
	 * Méthode permettant d'envoyer un email
	 * @param String to
	 * @param String subject
	 * @param String text
	 */
	public void send (String to, String subject, String text) {
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", HOST);
		props.put("mail.smtp.port", "587");

		// Get the Session object.
		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(USERNAME, PASSWORD);
					}
				});

		try {
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(FROM));

			// Set To: header field of the header.
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));

			// Set Subject: header field
			message.setSubject(subject);

			// Now set the actual message
			message.setText(text);

			// Send message
			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
