package ar.edu.unlam.tallerweb1.servicios;


public interface MailService {
	
	public void init();
	public Boolean enviarMail(String destinatario);
	
}