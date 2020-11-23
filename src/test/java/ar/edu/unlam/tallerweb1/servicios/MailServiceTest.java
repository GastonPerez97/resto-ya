package ar.edu.unlam.tallerweb1.servicios;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.tallerweb1.modelo.ComidaModel;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Session;

public class MailServiceTest {

	private MailService mailService;
	
	@Before
	public void init() {
		mailService = new MailServiceImpl();
	}
	
	@Test
	public void testQueInicializaLasPropiedadesParaMandarUnMail() {
		Properties propertiesEsperadas = new Properties();
		propertiesEsperadas.put("mail.smtp.host", "smtp.gmail.com");
		propertiesEsperadas.put("mail.smtp.starttls.enable", "true");
		propertiesEsperadas.put("mail.smtp.port", 587);
		propertiesEsperadas.put("mail.smtp.mail.sender", "tallerweb1.proyecto@gmail.com");
		propertiesEsperadas.put("mail.smtp.user", "tallerweb1.proyecto@gmail.com");
		propertiesEsperadas.put("mail.smtp.auth", "true");
		
		Session sessionEsperada = Session.getDefaultInstance(propertiesEsperadas);
		
		mailService.init();
		
		assertThat(mailService.getProperties()).isEqualTo(propertiesEsperadas);
		assertThat(mailService.getSession()).isEqualTo(sessionEsperada);
	}
	
	@Test
	public void testQueEnviaUnMail() {
		String destinatario = "test@test";
		String asunto = "test asunto";
		String mensaje = "test body";
		
		Boolean resultado = mailService.enviarMail(destinatario, asunto, mensaje);
		
		assertThat(resultado).isTrue();
	}

	@Test
	public void testQueNoEnviaUnMailAlIngregarDestinatarioInvalido() {
		String destinatario = "mailInvalido";
		String asunto = "test asunto";
		String mensaje = "test body";
		
		Boolean resultado = mailService.enviarMail(destinatario, asunto, mensaje);
		
		assertThat(resultado).isFalse();
	}
	
	@Test
	public void testQueRecibeCorrectamenteAsuntoDeConfirmacionDeRegistro() {
		String resultado = mailService.getAsuntoConfirmacionRegistro();
		
		assertThat(resultado).isEqualTo("Registro exitoso");
	}
	
	@Test
	public void testQueRecibeCorrectamenteAsuntoDeConfirmacionDePedido() {
		String resultado = mailService.getAsuntoConfirmacionPedido();
		
		assertThat(resultado).isEqualTo("Confirmacion de pedido");
	}
	
	@Test
	public void testQueRecibeCorrectamenteMensajeDeRegistro() {
		String nombreUsuario = "nombreUsuarioTest";
		String resultadoEsperado = "Hola nombreUsuarioTest!\n\nTe registraste correctamente en [Nombre-Empresa]. "
								 + "Disfruta de nuestro servicio!";

		String resultadoActual = mailService.getMensajeRegistro(nombreUsuario);
		
		assertThat(resultadoActual).isEqualTo(resultadoEsperado);
	}
	
	@Test
	public void testQueRecibeCorrectamenteMensajeDePedido() {
		ComidaModel comida1 = new ComidaModel();
		comida1.setNombre("Milanesa");
		comida1.setPrecio(200D);
		
		ComidaModel comida2 = new ComidaModel();
		comida2.setNombre("Tiramisu");
		comida2.setPrecio(300D);
		
		List<ComidaModel> comidas = new ArrayList<ComidaModel>();
		comidas.add(comida1);
		comidas.add(comida2);
		
		String resultadoEsperado = "Hola! Tu pedido fue confirmado:\n\n"
								 + "Milanesa ------- $200.0\n"
								 + "Tiramisu ------- $300.0\n"
								 + "\n Podes pagar tu pedido con Mercado Pago en nuestro sitio o en efectivo";
		
		String resultadoActual = mailService.getMensajePedido(comidas);
		
		assertThat(resultadoActual).isEqualTo(resultadoEsperado);
	}
	
}
