package Sending;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.logging.FileHandler;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Header;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Mail {
	public static void send(int id, String Notify) {

		String link = "<a href=https://media.tenor.com/sWQwKN-b5voAAAAM/hacked-you-have-been-hacked.gif>click here</a>";
		final String username = "besanttech62@gmail.com";
		final String pass = "qbwscqdakfrmqfcv";
		String receive=Notify;
		String subject="HI";
		
		System.out.println("start");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.starttls.enable", "true");

		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "587");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, pass);
			}
		});

		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(username));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(receive));
			message.setSubject(subject);
			BodyPart part = new MimeBodyPart();
			part.setText("This our first mail page");

			Multipart multipart = new MimeMultipart();

			multipart.addBodyPart(part);

			part = new MimeBodyPart();

			String file = "F:\\Java\\Jiramodel\\sudhar.docx";
			DataSource dataSource = new FileDataSource(file);

			part.setDataHandler(new DataHandler(dataSource));
			part.setFileName("Resume");

			multipart.addBodyPart(part);

			//message.setContent(multipart);

			message.setContent(link, "text/html");

			Transport.send(message);
			System.out.println("success");
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}
}
	