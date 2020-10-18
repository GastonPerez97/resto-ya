package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.ComidaModel;
import ar.edu.unlam.tallerweb1.modelo.RestauranteModel;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RestauranteRepository;
import ar.edu.unlam.tallerweb1.servicios.RestauranteService;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

// Clase que prueba la conexion a la base de datos. Hereda de SpringTest por lo que corre dentro del contexto
// de spring
public class MenuDeRestauranteTest extends SpringTest {

	@Inject
	private RestauranteRepository repositorioRestaurante;
	
	@Inject
	private RestauranteService servicioRestaurante;
	
	public void crearComidas() {
        ComidaModel comida1 = new ComidaModel();
        ComidaModel comida2 = new ComidaModel();
        ComidaModel comida3 = new ComidaModel();
        ComidaModel comida4 = new ComidaModel();
        
        comida1.setNombre("comida1");
        comida2.setNombre("comida2");
        comida3.setNombre("comida3");
        comida4.setNombre("comida4");
        
        comida1.setIdComida(1L);
        comida2.setIdComida(2L);
        comida3.setIdComida(3L);
        comida4.setIdComida(4L);
        
        session().save(comida1);
        session().save(comida2);
        session().save(comida3);
        session().save(comida4);
	}
	
	public void crearRestaurantes() {
        RestauranteModel restaurante1 = new RestauranteModel();
        RestauranteModel restaurante2 = new RestauranteModel();
        RestauranteModel restaurante3 = new RestauranteModel();
        RestauranteModel restaurante4 = new RestauranteModel();
        
        restaurante1.setNombre("restaurante1");
        restaurante2.setNombre("restaurante2");
        restaurante3.setNombre("restaurante3");
        restaurante4.setNombre("restaurante4");
        
        restaurante1.setIdRestaurante(1L);
        restaurante2.setIdRestaurante(2L);
        restaurante3.setIdRestaurante(3L);
        restaurante4.setIdRestaurante(4L);
        
        session().save(restaurante1);
        session().save(restaurante2);
        session().save(restaurante3);
        session().save(restaurante4);
	}
	
    @Test
    @Transactional @Rollback
    public void pruebaConexion(){
        assertThat(session().isConnected()).isTrue();
    }

    @Test
    @Transactional @Rollback
    public void testQueBuscaMenuPorRestaurante() {
        RestauranteModel restaurante1 = new RestauranteModel("restaurante1", 10L);
		ComidaModel comida1 = new ComidaModel("comida1", 10L);
		ComidaModel comida2 = new ComidaModel("comida2", 1337L);
		
        comida1.setRestaurante(restaurante1);
        comida2.setRestaurante(restaurante1);
        
        session().save(restaurante1);
        session().save(comida1);
        session().save(comida2);
        
    	List<ComidaModel> menuEsperado = new LinkedList<ComidaModel>();
    	menuEsperado.add(comida1);
    	menuEsperado.add(comida2);
    	
        List<ComidaModel> menuActual = repositorioRestaurante.buscarMenuPorRestaurante(restaurante1);

        assertEquals(menuEsperado, menuActual);
    }

}
