package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.ComidaModel;
import ar.edu.unlam.tallerweb1.modelo.PedidoComidaModel;


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
	public Boolean enviarMail(String destinatario, String asunto, String mensaje) {
		init();
		
		try{
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress((String)properties.get("mail.smtp.mail.sender")));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
			message.setSubject(asunto);
			message.setText(mensaje);
			
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
	
	@Override
	public String getAsuntoConfirmacionRegistro() {
		return "Registro exitoso";
	}
	
	@Override
	public String getAsuntoConfirmacionPedido() {
		return "Confirmacion de pedido";
	}
	
	@Override
	public String getMensajeRegistro(String nombreUsuario) {
		return "Hola " + nombreUsuario + "!\n\nTe registraste correctamente en RestoYa!. Disfruta de nuestro servicio!";
	}
	
	@Override
	public String getMensajePedido(List<PedidoComidaModel> comidas) {
		String mensaje = "Hola! Tu pedido fue confirmado:\n\n";
		Double total = 0d;
		
		for (PedidoComidaModel pedidoComida : comidas) {
			total += pedidoComida.getComidaModel().getPrecio() * pedidoComida.getCantidad();
			mensaje += pedidoComida.getComidaModel().getNombre() 
					+ " ------- Cantidad: " + pedidoComida.getCantidad()
					+ " ------- $" 
					+ pedidoComida.getComidaModel().getPrecio() * pedidoComida.getCantidad() + "\n";
		}
		
		mensaje += "\nEl total de tu pedido es: $" + total;
		mensaje += "\nPodes pagar tu pedido con Mercado Pago en nuestro sitio o en efectivo";
		
		return mensaje;
	}

	public Session getSession() {
		return session;
	}

	public Properties getProperties() {
		return properties;
	}
	
}
