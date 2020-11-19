package ar.edu.unlam.tallerweb1.controladores;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.servicios.MailService;

public class ControladorMailTest extends SpringTest {
	
    @Test
    @Transactional @Rollback
    public void pruebaConexion(){
        assertThat(session().isConnected()).isTrue();
    }
    
    @Test
	@Transactional @Rollback
	public void testQueEnviaCorrectamenteUnMailCuandoSeIngresaUnEmailEnlaVista() {
    	MailService mailServiceMock = mock(MailService.class);
	    String destinatario = "test@test.com";
	    MailController mailController = new MailController(mailServiceMock);
	    
	    when(mailServiceMock.enviarMail(destinatario)).thenReturn(true);
	    
	    ModelAndView mav = mailController.enviarMail(destinatario);
	    
	    verify(mailServiceMock, times(1)).enviarMail(destinatario);
	    
	    assertThat(mav.getModel().get("resultadoMail")).isEqualTo("El mail fue enviado exitosamente");
	}
	
    @Test
	@Transactional @Rollback
	public void testQueNoEnviaMailCuandoSeIngresaUnEmailEnlaVista() {
    	MailService mailServiceMock = mock(MailService.class);
	    String destinatario = "test@test.com";
	    MailController mailController = new MailController(mailServiceMock);
	    
	    when(mailServiceMock.enviarMail(destinatario)).thenReturn(false);
	    
	    ModelAndView mav = mailController.enviarMail(destinatario);
	    
	    verify(mailServiceMock, times(1)).enviarMail(destinatario);
	    
	    assertThat(mav.getModel().get("resultadoMail")).isEqualTo("Ocurrio un error al enviar el mail. Intente nuevamente.");
	}
    
}
