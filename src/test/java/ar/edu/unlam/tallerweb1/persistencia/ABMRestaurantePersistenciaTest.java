package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.RestauranteModel;
import ar.edu.unlam.tallerweb1.repositorios.RestauranteRepository;

public class ABMRestaurantePersistenciaTest extends SpringTest {
	
	@Inject
	private RestauranteRepository repositorioRestaurante;
	
    @Test
    @Transactional @Rollback
    public void pruebaConexion(){
        assertThat(session().isConnected()).isTrue();
    }

    @Test
    @Transactional @Rollback
    public void testQueGuardaRestaurante() {
        RestauranteModel restaurante = new RestauranteModel("restaurante");

        repositorioRestaurante.guardarRestaurante(restaurante);

        assertThat(restaurante.getIdRestaurante()).isNotNull();
    }
    
    @Test
    @Transactional @Rollback
    public void testQueEditaRestaurante() {
        RestauranteModel restaurante = new RestauranteModel("restaurante");
        restaurante.setDireccion("Florencio Varela 123");
        
        String direccionModificada = "Rivadavia 123";

        repositorioRestaurante.guardarRestaurante(restaurante);
        
        restaurante.setDireccion(direccionModificada);
        
        repositorioRestaurante.editarRestaurante(restaurante);

        assertThat(session().get(RestauranteModel.class, restaurante.getIdRestaurante())
				        		.getDireccion()).isEqualTo(direccionModificada);
    }
    
    @Test
    @Transactional @Rollback
    public void testQueEliminaRestaurante() {
        RestauranteModel restaurante = new RestauranteModel("restaurante");

        repositorioRestaurante.guardarRestaurante(restaurante);
        repositorioRestaurante.eliminarRestaurante(restaurante);

        assertThat(session().get(RestauranteModel.class, restaurante.getIdRestaurante())).isNull();
    }
}
