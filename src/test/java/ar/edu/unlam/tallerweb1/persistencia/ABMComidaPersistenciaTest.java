package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.ComidaModel;
import ar.edu.unlam.tallerweb1.repositorios.ComidaRepository;

public class ABMComidaPersistenciaTest extends SpringTest {
	
	@Inject
	private ComidaRepository repositorioComida;
	
    @Test
    @Transactional @Rollback
    public void pruebaConexion(){
        assertThat(session().isConnected()).isTrue();
    }

    @Test
    @Transactional @Rollback
    public void testQueGuardaComida() {
        ComidaModel comida = new ComidaModel("comida");

        repositorioComida.guardarComidaEnDB(comida);

        assertThat(comida.getIdComida()).isNotNull();
    }
    
    @Test
    @Transactional @Rollback
    public void testQueEditaComida() {
        ComidaModel comida = new ComidaModel("comida");
        comida.setPrecio(120.0);
        
        Double precioModificado = 200.0;

        repositorioComida.guardarComidaEnDB(comida);
        
        comida.setPrecio(precioModificado);
        
        repositorioComida.editarComida(comida);

        assertThat(session().get(ComidaModel.class, comida.getIdComida())
				        		.getPrecio()).isEqualTo(precioModificado);
    }
    
    @Test
    @Transactional @Rollback
    public void testQueEliminaComida() {
        ComidaModel comida = new ComidaModel("comida");

        repositorioComida.guardarComidaEnDB(comida);
        repositorioComida.eliminarComida(comida);

        assertThat(session().get(ComidaModel.class, comida.getIdComida())).isNull();
    }
}
