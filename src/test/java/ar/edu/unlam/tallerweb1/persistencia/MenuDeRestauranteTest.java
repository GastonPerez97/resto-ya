package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.ComidaModel;
import ar.edu.unlam.tallerweb1.modelo.RestauranteModel;
import ar.edu.unlam.tallerweb1.repositorios.RestauranteRepository;

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
