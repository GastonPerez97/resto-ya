package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;
import javax.inject.Inject;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.ComidaModel;
import ar.edu.unlam.tallerweb1.servicios.ComidaService;

public class ComidaTest extends SpringTest{
	
	@Inject
	ComidaService comidaService;
	
	private ComidaModel comida1 = new ComidaModel("Hamburguesa", 10L);
	private ComidaModel comida2 = new ComidaModel("Pizza", 25L);
	private ComidaModel comida3 = new ComidaModel("Empanada de pollo", 30L);
	private ComidaModel comida4 = new ComidaModel("Empanada de carne", 40L);
	private ComidaModel comida5 = new ComidaModel("Pescado", 45L);
	
	@Test
    @Transactional @Rollback
    public void pruebaConexion(){
        assertThat(session().isConnected()).isTrue();
    }	
	
	
	@Test
    @Transactional @Rollback
    public void testQueConsultaComidaPorId(){
		session().save(comida1);
		session().save(comida2);
		session().save(comida3);
		
		ComidaModel valorEsperado = comida2;
		ComidaModel valorObtenido = comidaService.mostrarComidaModel(comida2.getIdComida());
		
		assertEquals(valorEsperado, valorObtenido);      
    }
	
	
	@Test
    @Transactional @Rollback
    public void testQueBuscaTodasLasComidas(){
		session().save(comida1);
		session().save(comida2);
		session().save(comida3);
		
				
		List<ComidaModel> listaComidasEsperada = new LinkedList<ComidaModel>();
		listaComidasEsperada.add(comida1);
		listaComidasEsperada.add(comida2);
		listaComidasEsperada.add(comida3);
		
		List<ComidaModel> listaComidasObtenida = comidaService.buscarComida();
		
		assertEquals(listaComidasEsperada, listaComidasObtenida);      
    }
	
	
	@Test
    @Transactional @Rollback
    public void testQueBuscaUnaComidaDeseada(){
		session().save(comida1);
		session().save(comida2);
		session().save(comida3);
		session().save(comida4);
		session().save(comida5);
		String comidaDeseada = "Empanada";		
		
		List<ComidaModel> listaComidasEsperada = new LinkedList<ComidaModel>();
		listaComidasEsperada.add(comida3);
		listaComidasEsperada.add(comida4);
		
		List<ComidaModel> listaComidasObtenida = comidaService.buscarComidaDeseada(comidaDeseada);
		
		assertEquals(listaComidasEsperada, listaComidasObtenida);      
    }
	
	
	
	
}
