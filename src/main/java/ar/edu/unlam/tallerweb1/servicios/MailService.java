package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.ComidaModel;

public interface MailService {
	
	public void init();
	public Boolean enviarMail(String destinatario, String asunto, String mensaje);
	public String getAsuntoConfirmacionRegistro();
	public String getMensajeRegistro(String nombreUsuario);
	public String getAsuntoConfirmacionPedido();
	public String getMensajePedido(List<ComidaModel> comidas);
	
}