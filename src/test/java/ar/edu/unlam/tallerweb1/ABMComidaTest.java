package ar.edu.unlam.tallerweb1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.annotation.Rollback;

import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.ComidaModel;
import ar.edu.unlam.tallerweb1.repositorios.ComidaRepository;
import ar.edu.unlam.tallerweb1.servicios.ComidaService;

public class ABMComidaTest extends SpringTest {
	
	@Inject
	private ComidaService servicioComida;
	
	@Inject
	private ComidaRepository repositorioComida;
	
    @Test
    @Transactional @Rollback
    public void pruebaConexion(){
        assertThat(session().isConnected()).isTrue();
    }
    
    @Test
	@Transactional @Rollback
	public void testQueValidaCorrectamenteExtensionDeImagenJPG() {
	    MockMultipartFile imagenJpg = new MockMultipartFile(
	    		"test", 
	    		"test.jpg",
	    		MediaType.IMAGE_JPEG_VALUE, 
	    		"Hola Mundo".getBytes()
	    	);
	    
	    Boolean verificacion = servicioComida.verificarExtensionDeImagen(imagenJpg);
	    
	    assertTrue(verificacion);
	}
    
    @Test
	@Transactional @Rollback
	public void testQueValidaCorrectamenteExtensionDeImagenPNG() {
	    MockMultipartFile imagenJpg = new MockMultipartFile(
	    		"test", 
	    		"test.png",
	    		MediaType.IMAGE_PNG_VALUE, 
	    		"Hola Mundo".getBytes()
	    	);
	    
	    Boolean verificacion = servicioComida.verificarExtensionDeImagen(imagenJpg);
	    
	    assertTrue(verificacion);
	}
    
    @Test
	@Transactional @Rollback
	public void testQueValidaIncorrectamenteExtensionDeImagen() {
	    MockMultipartFile imagenJpg = new MockMultipartFile(
	    		"test", 
	    		"test.txt",
	    		MediaType.TEXT_PLAIN_VALUE, 
	    		"Hola Mundo".getBytes()
	    	);
	    
	    Boolean verificacion = servicioComida.verificarExtensionDeImagen(imagenJpg);
	    
	    assertFalse(verificacion);
	}

}
