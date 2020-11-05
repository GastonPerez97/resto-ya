package ar.edu.unlam.tallerweb1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.RestauranteModel;
import ar.edu.unlam.tallerweb1.repositorios.RestauranteRepository;
import ar.edu.unlam.tallerweb1.servicios.RestauranteService;

public class ABMRestauranteTest extends SpringTest {
	
	@Inject
	private RestauranteService servicioRestaurante;
	
	@Inject
	private RestauranteRepository repositorioRestaurante;
	
    @Test
    @Transactional @Rollback
    public void pruebaConexion(){
        assertThat(session().isConnected()).isTrue();
    }
	
    @Test
    @Transactional @Rollback
    public void testQueValidaCorrectamenteDireccionDeRestaurante() {
        RestauranteModel restaurante1 = new RestauranteModel("restaurante1");
        RestauranteModel restaurante2 = new RestauranteModel("restaurante2");
        restaurante1.setDireccion("Florencio Varela 123");
        restaurante2.setDireccion("Las Bases 123");
        
        repositorioRestaurante.guardarRestaurante(restaurante2);
        
        Boolean validacion = servicioRestaurante.validarRestaurante(restaurante1);

        assertTrue(validacion);
    }
    
    @Test
    @Transactional @Rollback
    public void testQueValidaIncorrectamenteDireccionDeRestaurante() {
        RestauranteModel restaurante1 = new RestauranteModel("restaurante1");
        RestauranteModel restaurante2 = new RestauranteModel("restaurante2");
        restaurante1.setDireccion("Florencio Varela 123");
        restaurante2.setDireccion("Florencio Varela 123");
        
        repositorioRestaurante.guardarRestaurante(restaurante2);
        
        Boolean validacion = servicioRestaurante.validarRestaurante(restaurante1);
        
        assertFalse(validacion);
    }

}
