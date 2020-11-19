package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.ComidaModel;
import ar.edu.unlam.tallerweb1.modelo.EstadoReservaModel;
import ar.edu.unlam.tallerweb1.modelo.HorarioModel;
import ar.edu.unlam.tallerweb1.modelo.MesaModel;
import ar.edu.unlam.tallerweb1.modelo.ReservaModel;
import ar.edu.unlam.tallerweb1.modelo.RestauranteHorarioModel;
import ar.edu.unlam.tallerweb1.modelo.RestauranteModel;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioGeneracionReserva;
import ar.edu.unlam.tallerweb1.repositorios.RestauranteRepository;
import ar.edu.unlam.tallerweb1.servicios.ReservaService;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

public class ReservaTest extends SpringTest {

	@Autowired
	private ReservaService reservaService;
	
    @Test
    @Transactional @Rollback
    public void pruebaConexion(){
        assertThat(session().isConnected()).isTrue();
    }

    @Test
    @Transactional @Rollback
    public void testGeneracionNuevaReserva() {
    	
    	RestauranteModel restaurante = new RestauranteModel();
    	HorarioModel horario = new HorarioModel();
    	RestauranteHorarioModel restauranteHorarioModel = new RestauranteHorarioModel();
    	MesaModel mesa = new MesaModel();
    	EstadoReservaModel estado = new EstadoReservaModel();
    	
    	session().save(restaurante);
    	session().save(horario);
    	session().save(estado);
    	
    	restauranteHorarioModel.setHorarioModel(horario);
    	restauranteHorarioModel.setRestauranteModel(restaurante);
    	mesa.setRestaurante(restaurante);
    	
    	session().save(restauranteHorarioModel);
    	session().save(mesa);
    	
    	FormularioGeneracionReserva formularioGeneracionReserva = new FormularioGeneracionReserva();
    	formularioGeneracionReserva.setFechaReserva(new Date(System.currentTimeMillis()));
    	formularioGeneracionReserva.setIdMesa(mesa.getIdMesa());
    	formularioGeneracionReserva.setIdRestaurante(restaurante.getIdRestaurante());
    	formularioGeneracionReserva.setIdRestauranteHorario(restauranteHorarioModel.getIdRestauranteHorario());
    	
    	ReservaModel reserva = reservaService.procesarNuevaReserva(formularioGeneracionReserva);
    	
        session().save(reserva);

        assertThat(reservaService.getReservaByIdReserva(1L) != null);
    }

}
