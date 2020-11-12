package ar.edu.unlam.tallerweb1.servicios;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("mailService")
@Transactional
public class MailServiceImpl implements MailService {
	
	private final Properties properties = new Properties();
	private Session session;
 
	@Override
	public void init() {
		
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.port", 587);
		properties.put("mail.smtp.mail.sender", "tallerweb1.proyecto@gmail.com");
		properties.put("mail.smtp.user", "tallerweb1.proyecto@gmail.com");
		properties.put("mail.smtp.auth", "true");
 
		session = Session.getDefaultInstance(properties);
	}
 
	@Override
	public Boolean enviarMail(String destinatario) {
 
		init();
		
		try{
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress((String)properties.get("mail.smtp.mail.sender")));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
			message.setSubject("Prueba");
			message.setText("Texto");
			
			javax.mail.Transport t = session.getTransport("smtp");
			t.connect((String)properties.get("mail.smtp.user"), "didimope");
			t.sendMessage(message, message.getAllRecipients());
			t.close();
			
			return true;
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
}
